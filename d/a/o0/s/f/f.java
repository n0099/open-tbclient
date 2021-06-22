package d.a.o0.s.f;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f64188a;

    public static f f() {
        synchronized (f.class) {
            if (f64188a == null) {
                f64188a = new f();
            }
        }
        return f64188a;
    }

    public boolean a(d.a.n0.s.f.a aVar) {
        SQLiteDatabase b2 = h.b();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (b2 != null && aVar != null && !TextUtils.isEmpty(currentAccount)) {
            try {
                ContentValues c2 = c(aVar);
                if (b2.update("table_" + currentAccount, c2, "id = ?", new String[]{String.valueOf(aVar.e())}) == 0) {
                    b2.insert("table_" + currentAccount, null, c2);
                }
                return true;
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.addContactItem", new Object[0]);
            }
        }
        return false;
    }

    public synchronized boolean b(a aVar) {
        SQLiteDatabase b2 = h.b();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (b2 != null && aVar != null && !TextUtils.isEmpty(currentAccount)) {
            b2.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            b2.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
            b2.beginTransaction();
            try {
                for (e eVar : aVar.a()) {
                    for (d.a.n0.s.f.a aVar2 : eVar.a()) {
                        ContentValues c2 = c(aVar2);
                        b2.insert("table_" + currentAccount, null, c2);
                    }
                }
                b2.setTransactionSuccessful();
                b2.endTransaction();
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.addContactItems", new Object[0]);
                b2.endTransaction();
                return false;
            }
        }
        return false;
    }

    public final ContentValues c(d.a.n0.s.f.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", aVar.f());
        contentValues.put("id", Long.valueOf(aVar.e()));
        contentValues.put("user_type", Integer.valueOf(aVar.i()));
        contentValues.put("portrait", aVar.h());
        contentValues.put("quanpin", aVar.d());
        contentValues.put("first_letter", aVar.a());
        contentValues.put("name_show", aVar.g());
        if (aVar.b() != null) {
            contentValues.put("location_hide", Integer.valueOf(aVar.b().b()));
            contentValues.put("location_distance", aVar.b().a());
            contentValues.put("location_time", Long.valueOf(aVar.b().c()));
        }
        return contentValues;
    }

    public boolean d(long j) {
        SQLiteDatabase b2 = h.b();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (b2 != null && j >= 0 && !TextUtils.isEmpty(currentAccount)) {
            try {
                b2.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
                return true;
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.deleteContactItem", new Object[0]);
            }
        }
        return false;
    }

    public synchronized List<d.a.n0.s.f.a> e() {
        SQLiteDatabase b2 = h.b();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        if (b2 != null && !TextUtils.isEmpty(currentAccount)) {
            b2.beginTransaction();
            char c2 = 0;
            try {
                String[] strArr = d.a.n0.s.f.c.f54448a;
                int length = strArr.length;
                int i2 = 0;
                while (i2 < length) {
                    String str = strArr[i2];
                    ArrayList arrayList2 = new ArrayList();
                    d.a.n0.s.f.a aVar = new d.a.n0.s.f.a();
                    aVar.k(str);
                    arrayList2.add(aVar);
                    String[] strArr2 = new String[1];
                    strArr2[c2] = str;
                    cursor = b2.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", strArr2);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            d.a.n0.s.f.a aVar2 = new d.a.n0.s.f.a();
                            aVar2.k(str);
                            aVar2.o(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.p(cursor.getString(cursor.getColumnIndex("name_show")));
                            aVar2.n(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.r(cursor.getInt(cursor.getColumnIndex("user_type")));
                            aVar2.q(cursor.getString(cursor.getColumnIndex("portrait")));
                            aVar2.m(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.l(new d.a.n0.s.f.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    m.a(cursor);
                    i2++;
                    c2 = 0;
                }
                b2.setTransactionSuccessful();
                m.a(cursor);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.getContactList", new Object[0]);
                m.a(cursor);
            }
            b2.endTransaction();
            return arrayList;
        }
        return arrayList;
    }

    public synchronized ArrayList<d.a.n0.s.f.a> g() {
        SQLiteDatabase b2 = h.b();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        ArrayList<d.a.n0.s.f.a> arrayList = new ArrayList<>();
        if (b2 != null && !TextUtils.isEmpty(currentAccount)) {
            b2.beginTransaction();
            char c2 = 0;
            try {
                String[] strArr = d.a.n0.s.f.c.f54448a;
                int length = strArr.length;
                int i2 = 0;
                while (i2 < length) {
                    String str = strArr[i2];
                    ArrayList arrayList2 = new ArrayList();
                    d.a.n0.s.f.a aVar = new d.a.n0.s.f.a();
                    aVar.k(str);
                    arrayList2.add(aVar);
                    String[] strArr2 = new String[2];
                    strArr2[c2] = str;
                    strArr2[1] = "1";
                    cursor = b2.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", strArr2);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            d.a.n0.s.f.a aVar2 = new d.a.n0.s.f.a();
                            aVar2.k(str);
                            aVar2.o(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.p(cursor.getString(cursor.getColumnIndex("name_show")));
                            aVar2.n(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.r(cursor.getInt(cursor.getColumnIndex("user_type")));
                            aVar2.q(cursor.getString(cursor.getColumnIndex("portrait")));
                            aVar2.m(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.l(new d.a.n0.s.f.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    m.a(cursor);
                    i2++;
                    c2 = 0;
                }
                b2.setTransactionSuccessful();
                m.a(cursor);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.getOfficialAccountList", new Object[0]);
                m.a(cursor);
            }
            b2.endTransaction();
            return arrayList;
        }
        return arrayList;
    }
}
