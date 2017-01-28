package com.example.toon.boardgamerandomizer.Persistency.Database;

import android.content.Context;

import com.example.toon.boardgamerandomizer.Model.Boardgame;
import com.example.toon.boardgamerandomizer.Model.BoardgameDao;
import com.example.toon.boardgamerandomizer.Model.DaoMaster;
import com.example.toon.boardgamerandomizer.Model.DaoSession;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toon on 28/01/2017.
 */

public class MyDB {
    private final String DBNAME = "Boardgames";
    private DaoSession session;
    private Context context;
    private BoardgameDao gameDao;
    private Database db;

    public MyDB(Context context){
        this.context = context;
    }

    public void startDatabase(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,DBNAME);
        db = helper.getWritableDb();
        session =  new DaoMaster(db).newSession();
        gameDao = session.getBoardgameDao();
    }

    public DaoSession getDaoSession(){
        return session;
    }

    public void seeding(Boardgame[] list){
        for(Boardgame item : list){
            gameDao.insert(item);
        }
    }

    public void deleteDaoTable(){
        DaoMaster.dropAllTables(db,true);
        DaoMaster.createAllTables(db, true);
    }

    public List<Boardgame> getData(){
        List<Boardgame> list = new ArrayList<>();

        list = gameDao.queryBuilder().list();

        return list;
    }
}
