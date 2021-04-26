package d.a.j0.s2.b0.l;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TiebaDatabase;
import d.a.c.e.p.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.j0.s2.b0.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1543a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f60139a = new a();
    }

    public static a e() {
        return C1543a.f60139a;
    }

    public final ContentValues a(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f60140a)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_key", bVar.f60140a);
        contentValues.put("package_name", bVar.f60141b);
        contentValues.put("finish_download_time", String.valueOf(bVar.f60142c));
        contentValues.put("show_times", String.valueOf(bVar.f60143d));
        contentValues.put("last_show_time", String.valueOf(bVar.f60144e));
        contentValues.put("ad_string", bVar.f60145f);
        contentValues.put("cmatch", bVar.f60146g);
        contentValues.put("install_status", Integer.valueOf(bVar.f60147h));
        contentValues.put("ad_extension_info1", bVar.f60148i);
        contentValues.put("ad_extension_info2", bVar.j);
        contentValues.put("ad_extension_info3", bVar.k);
        return contentValues;
    }

    public final b b(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                b bVar = new b();
                bVar.f60140a = cursor.getString(cursor.getColumnIndex("download_key"));
                bVar.f60141b = cursor.getString(cursor.getColumnIndex("package_name"));
                bVar.f60142c = Long.parseLong(cursor.getString(cursor.getColumnIndex("finish_download_time")));
                bVar.f60143d = Integer.parseInt(cursor.getString(cursor.getColumnIndex("show_times")));
                bVar.f60144e = Long.parseLong(cursor.getString(cursor.getColumnIndex("last_show_time")));
                bVar.f60145f = cursor.getString(cursor.getColumnIndex("ad_string"));
                bVar.f60146g = cursor.getString(cursor.getColumnIndex("cmatch"));
                bVar.f60147h = Integer.parseInt(cursor.getString(cursor.getColumnIndex("install_status")));
                bVar.f60148i = cursor.getString(cursor.getColumnIndex("ad_extension_info1"));
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
            if (!TextUtils.isEmpty(bVar.f60140a) && !TextUtils.isEmpty(bVar.f60141b)) {
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                f2.replace("ad_follow_up_info_table", null, a(bVar));
                f2.setTransactionSuccessful();
                f2.endTransaction();
            }
        }
    }
}
