package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class mj5 {
    public static /* synthetic */ Interceptable $ic;
    public static mj5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public mj5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static mj5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (mj5.class) {
                if (a == null) {
                    a = new mj5();
                }
            }
            return a;
        }
        return (mj5) invokeV.objValue;
    }

    public boolean a(px4 px4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, px4Var)) == null) {
            SQLiteDatabase b = oj5.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b != null && px4Var != null && !TextUtils.isEmpty(currentAccount)) {
                try {
                    ContentValues c = c(px4Var);
                    if (b.update("table_" + currentAccount, c, "id = ?", new String[]{String.valueOf(px4Var.d())}) == 0) {
                        b.insert("table_" + currentAccount, null, c);
                    }
                    return true;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItem", new Object[0]);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean b(hj5 hj5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hj5Var)) == null) {
            synchronized (this) {
                SQLiteDatabase b = oj5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (b != null && hj5Var != null && !TextUtils.isEmpty(currentAccount)) {
                    b.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
                    b.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
                    b.beginTransaction();
                    try {
                        for (lj5 lj5Var : hj5Var.a()) {
                            for (px4 px4Var : lj5Var.a()) {
                                ContentValues c = c(px4Var);
                                b.insert("table_" + currentAccount, null, c);
                            }
                        }
                        b.setTransactionSuccessful();
                        b.endTransaction();
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                        b.endTransaction();
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final ContentValues c(px4 px4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, px4Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", px4Var.e());
            contentValues.put("id", Long.valueOf(px4Var.d()));
            contentValues.put("user_type", Integer.valueOf(px4Var.h()));
            contentValues.put("portrait", px4Var.g());
            contentValues.put("quanpin", px4Var.c());
            contentValues.put("first_letter", px4Var.a());
            contentValues.put("name_show", px4Var.f());
            if (px4Var.b() != null) {
                contentValues.put("location_hide", Integer.valueOf(px4Var.b().b()));
                contentValues.put("location_distance", px4Var.b().a());
                contentValues.put("location_time", Long.valueOf(px4Var.b().c()));
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            SQLiteDatabase b = oj5.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b != null && j >= 0 && !TextUtils.isEmpty(currentAccount)) {
                try {
                    b.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
                    return true;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public synchronized List<px4> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = oj5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList arrayList = new ArrayList();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = rx4.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            px4 px4Var = new px4();
                            px4Var.j(str);
                            arrayList2.add(px4Var);
                            String[] strArr2 = new String[1];
                            strArr2[c] = str;
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    px4 px4Var2 = new px4();
                                    px4Var2.j(str);
                                    px4Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    px4Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    px4Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    px4Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    px4Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    px4Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    px4Var2.k(new qx4(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(px4Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            mi.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        mi.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                        mi.a(cursor);
                    }
                    b.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized ArrayList<px4> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = oj5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList<px4> arrayList = new ArrayList<>();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = rx4.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            px4 px4Var = new px4();
                            px4Var.j(str);
                            arrayList2.add(px4Var);
                            String[] strArr2 = new String[2];
                            strArr2[c] = str;
                            strArr2[1] = "1";
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    px4 px4Var2 = new px4();
                                    px4Var2.j(str);
                                    px4Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    px4Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    px4Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    px4Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    px4Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    px4Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    px4Var2.k(new qx4(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(px4Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            mi.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        mi.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                        mi.a(cursor);
                    }
                    b.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (ArrayList) invokeV.objValue;
    }
}
