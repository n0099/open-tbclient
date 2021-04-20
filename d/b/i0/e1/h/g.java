package d.b.i0.e1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f55319a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SQLiteDatabase f55320b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, SQLiteDatabase> f55321c = new HashMap<>();

    public static void a(String str) {
        try {
            try {
                if (!TextUtils.isEmpty(str)) {
                    h.e().i();
                    Iterator<String> it = b().iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next != null) {
                            if (next.equals("tb_message_center")) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("is_hidden", (Integer) 1);
                                h.e().j("tb_message_center", contentValues, null, null);
                            } else if (!next.equals("tb_new_friends")) {
                                h.e().b(next, null, null);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseManager.deleteImDb", new Object[0]);
                e2.printStackTrace();
            }
        } finally {
            h.e().c();
        }
    }

    public static LinkedList<String> b() {
        SQLiteDatabase c2 = c();
        LinkedList<String> linkedList = new LinkedList<>();
        Cursor cursor = null;
        if (c2 != null) {
            try {
                try {
                    cursor = c2.rawQuery("select * from sqlite_master where type='table'", null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        while (cursor.moveToNext()) {
                            linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                        }
                    }
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "ImDatabaseManager.getAllTables", new Object[0]);
                    e2.printStackTrace();
                }
            } finally {
                d.b.c.e.p.m.a(cursor);
            }
        }
        return linkedList;
    }

    public static synchronized SQLiteDatabase c() {
        synchronized (g.class) {
            try {
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "ImDatabaseHelper.getImDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return null;
            }
            String str = TbadkCoreApplication.getCurrentAccount() + ".db";
            if (f55321c.containsKey(str)) {
                return f55321c.get(str);
            } else if (f55320b != null && str.equals(f55319a) && f55320b.isOpen()) {
                return f55320b;
            } else {
                if (f55320b != null) {
                    d.b.c.e.p.m.b(f55320b);
                }
                f fVar = new f(TbadkCoreApplication.getInst().getApp(), str);
                f55319a = str;
                f55320b = fVar.getWritableDatabase();
                return f55320b;
            }
        }
    }
}
