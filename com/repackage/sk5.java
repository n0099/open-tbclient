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
/* loaded from: classes7.dex */
public class sk5 {
    public static /* synthetic */ Interceptable $ic;
    public static sk5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public sk5() {
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

    public static sk5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (sk5.class) {
                if (a == null) {
                    a = new sk5();
                }
            }
            return a;
        }
        return (sk5) invokeV.objValue;
    }

    public boolean a(iy4 iy4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iy4Var)) == null) {
            SQLiteDatabase b = uk5.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b != null && iy4Var != null && !TextUtils.isEmpty(currentAccount)) {
                try {
                    ContentValues c = c(iy4Var);
                    if (b.update("table_" + currentAccount, c, "id = ?", new String[]{String.valueOf(iy4Var.e())}) == 0) {
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

    public synchronized boolean b(nk5 nk5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nk5Var)) == null) {
            synchronized (this) {
                SQLiteDatabase b = uk5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (b != null && nk5Var != null && !TextUtils.isEmpty(currentAccount)) {
                    b.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
                    b.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
                    b.beginTransaction();
                    try {
                        for (rk5 rk5Var : nk5Var.a()) {
                            for (iy4 iy4Var : rk5Var.a()) {
                                ContentValues c = c(iy4Var);
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

    public final ContentValues c(iy4 iy4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iy4Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", iy4Var.f());
            contentValues.put("id", Long.valueOf(iy4Var.e()));
            contentValues.put("user_type", Integer.valueOf(iy4Var.i()));
            contentValues.put("portrait", iy4Var.h());
            contentValues.put("quanpin", iy4Var.d());
            contentValues.put("first_letter", iy4Var.a());
            contentValues.put("name_show", iy4Var.g());
            if (iy4Var.b() != null) {
                contentValues.put("location_hide", Integer.valueOf(iy4Var.b().b()));
                contentValues.put("location_distance", iy4Var.b().a());
                contentValues.put("location_time", Long.valueOf(iy4Var.b().c()));
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            SQLiteDatabase b = uk5.b();
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

    public synchronized List<iy4> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = uk5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList arrayList = new ArrayList();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = ky4.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            iy4 iy4Var = new iy4();
                            iy4Var.k(str);
                            arrayList2.add(iy4Var);
                            String[] strArr2 = new String[1];
                            strArr2[c] = str;
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    iy4 iy4Var2 = new iy4();
                                    iy4Var2.k(str);
                                    iy4Var2.o(cursor.getString(cursor.getColumnIndex("name")));
                                    iy4Var2.p(cursor.getString(cursor.getColumnIndex("name_show")));
                                    iy4Var2.n(cursor.getLong(cursor.getColumnIndex("id")));
                                    iy4Var2.r(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    iy4Var2.q(cursor.getString(cursor.getColumnIndex("portrait")));
                                    iy4Var2.m(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    iy4Var2.l(new jy4(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(iy4Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            pi.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        pi.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                        pi.a(cursor);
                    }
                    b.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized ArrayList<iy4> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = uk5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList<iy4> arrayList = new ArrayList<>();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = ky4.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            iy4 iy4Var = new iy4();
                            iy4Var.k(str);
                            arrayList2.add(iy4Var);
                            String[] strArr2 = new String[2];
                            strArr2[c] = str;
                            strArr2[1] = "1";
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    iy4 iy4Var2 = new iy4();
                                    iy4Var2.k(str);
                                    iy4Var2.o(cursor.getString(cursor.getColumnIndex("name")));
                                    iy4Var2.p(cursor.getString(cursor.getColumnIndex("name_show")));
                                    iy4Var2.n(cursor.getLong(cursor.getColumnIndex("id")));
                                    iy4Var2.r(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    iy4Var2.q(cursor.getString(cursor.getColumnIndex("portrait")));
                                    iy4Var2.m(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    iy4Var2.l(new jy4(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(iy4Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            pi.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        pi.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                        pi.a(cursor);
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
