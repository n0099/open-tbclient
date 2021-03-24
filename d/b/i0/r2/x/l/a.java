package d.b.i0.r2.x.l;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TiebaDatabase;
import d.b.b.e.p.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.b.i0.r2.x.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1514a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f59935a = new a();
    }

    public static a e() {
        return C1514a.f59935a;
    }

    public final ContentValues a(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f59936a)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_key", bVar.f59936a);
        contentValues.put("package_name", bVar.f59937b);
        contentValues.put("finish_download_time", String.valueOf(bVar.f59938c));
        contentValues.put("show_times", String.valueOf(bVar.f59939d));
        contentValues.put("last_show_time", String.valueOf(bVar.f59940e));
        contentValues.put("ad_string", bVar.f59941f);
        contentValues.put("cmatch", bVar.f59942g);
        contentValues.put("install_status", Integer.valueOf(bVar.f59943h));
        contentValues.put("ad_extension_info1", bVar.i);
        contentValues.put("ad_extension_info2", bVar.j);
        contentValues.put("ad_extension_info3", bVar.k);
        return contentValues;
    }

    public final b b(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                b bVar = new b();
                bVar.f59936a = cursor.getString(cursor.getColumnIndex("download_key"));
                bVar.f59937b = cursor.getString(cursor.getColumnIndex("package_name"));
                bVar.f59938c = Long.parseLong(cursor.getString(cursor.getColumnIndex("finish_download_time")));
                bVar.f59939d = Integer.parseInt(cursor.getString(cursor.getColumnIndex("show_times")));
                bVar.f59940e = Long.parseLong(cursor.getString(cursor.getColumnIndex("last_show_time")));
                bVar.f59941f = cursor.getString(cursor.getColumnIndex("ad_string"));
                bVar.f59942g = cursor.getString(cursor.getColumnIndex("cmatch"));
                bVar.f59943h = Integer.parseInt(cursor.getString(cursor.getColumnIndex("install_status")));
                bVar.i = cursor.getString(cursor.getColumnIndex("ad_extension_info1"));
                bVar.j = cursor.getString(cursor.getColumnIndex("ad_extension_info2"));
                bVar.k = cursor.getString(cursor.getColumnIndex("ad_extension_info3"));
                return bVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public synchronized void c(Integer num, Integer num2) {
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        f2.delete("ad_follow_up_info_table", "finish_download_time < ? and show_times >= ?", new String[]{String.valueOf(System.currentTimeMillis() - ((((num.intValue() * 24) * 60) * 60) * 1000)), String.valueOf(num2)});
        f2.setTransactionSuccessful();
        f2.endTransaction();
    }

    public synchronized void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        f2.delete("ad_follow_up_info_table", "download_key = ?", new String[]{str});
        f2.setTransactionSuccessful();
        f2.endTransaction();
    }

    public synchronized List<b> f(Integer num, Integer num2) {
        ArrayList arrayList;
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        long currentTimeMillis = System.currentTimeMillis() - ((((num.intValue() * 24) * 60) * 60) * 1000);
        arrayList = new ArrayList();
        Cursor rawQuery = f2.rawQuery("SELECT * FROM ad_follow_up_info_table where finish_download_time > ? and show_times < ? and install_status = ? order by finish_download_time desc", new String[]{String.valueOf(currentTimeMillis), String.valueOf(num2), String.valueOf(1)});
        while (rawQuery.moveToNext()) {
            b b2 = b(rawQuery);
            if (b2 != null && !arrayList.contains(b2)) {
                arrayList.add(b2);
            }
        }
        f2.setTransactionSuccessful();
        m.a(rawQuery);
        f2.endTransaction();
        return arrayList;
    }

    public synchronized void g(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.f59936a) && !TextUtils.isEmpty(bVar.f59937b)) {
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                f2.replace("ad_follow_up_info_table", null, a(bVar));
                f2.setTransactionSuccessful();
                f2.endTransaction();
            }
        }
    }
}
