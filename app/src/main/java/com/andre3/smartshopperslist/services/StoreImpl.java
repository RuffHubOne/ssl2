package com.andre3.smartshopperslist.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.andre3.smartshopperslist.dao.DBManager;
import com.andre3.smartshopperslist.enums.DBClmns;
import com.andre3.smartshopperslist.enums.DBTables;
import com.andre3.smartshopperslist.model.Store;

import java.util.ArrayList;

/**
 * Created by ODBBROW on 10/14/2016.
 */

public class StoreImpl {

    Store store;
    DBManager db;
    Context context;

    public StoreImpl(Store store, Context context) {
        this.store = store;
        this.context = context;
    }

    public long save(){

        SQLiteDatabase sql = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBClmns.name.toString(),store.getName());
        values.put(DBClmns.location.toString(),store.getLocation());

       long rowid = sql.insert(DBTables.store.toString(), null, values);

        sql.close();
        return rowid;
    }

    public long update(){

        SQLiteDatabase sql = db.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBClmns.name.toString(), store.getName());
        values.put(DBClmns.location.toString(), store.getLocation());

        long rowid = sql.update(DBTables.store.toString(), values, "id=" + store.getId(), null);

        sql.close();
        return rowid;
    }

    public ArrayList<Store> readById(int id){

        String SELECT = "SELECT * FROM " +DBTables.store+ " WHERE id =" + id;
        ArrayList<Store> stores = new ArrayList<Store>();
        SQLiteDatabase sql = db.getReadableDatabase();

        Cursor c = sql.rawQuery(SELECT, null);
        if(c.moveToFirst())
        {
            do{
                store.setId(c.getInt(c.getColumnIndex(DBClmns.id.toString())));
                store.setName(c.getString(c.getColumnIndex(DBClmns.name.toString())));
                store.setLocation(c.getString(c.getColumnIndex(DBClmns.location.toString())));

                stores.add(store);
            }while(c.moveToNext());
        }
        return stores;
    }

    public ArrayList<Store> readAll(){

        String SELECT = "SELECT * FROM " +DBTables.store;
        ArrayList<Store> stores = new ArrayList<Store>();
        SQLiteDatabase sql = db.getReadableDatabase();

        Cursor c = sql.rawQuery(SELECT, null);
        if(c.moveToFirst())
        {
            do{
                store.setId(c.getInt(c.getColumnIndex(DBClmns.id.toString())));
                store.setName(c.getString(c.getColumnIndex(DBClmns.name.toString())));
                store.setLocation(c.getString(c.getColumnIndex(DBClmns.location.toString())));

                stores.add(store);
            }while(c.moveToNext());
        }
        return stores;
    }

    public long delete(int id){

        SQLiteDatabase sql = db.getReadableDatabase();

        long rowid = sql.delete(DBTables.store.toString(), DBClmns.id.toString() +"= ?", new String[] {Integer.toString(id)});

        return rowid;
    }
}
