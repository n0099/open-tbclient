package d.a.i0.a.l2.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43230c = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public a f43231a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43232b;

    public synchronized void a(d.a.i0.a.l2.a aVar) {
        if (aVar != null) {
            if (!TextUtils.isEmpty(aVar.f43205a) && !TextUtils.isEmpty(aVar.f43207c) && !TextUtils.isEmpty(aVar.f43206b)) {
                if (aVar.f43209e == -1) {
                    return;
                }
                SQLiteDatabase f2 = f();
                if (f2 == null) {
                    return;
                }
                if (f43230c) {
                    Log.d("SwanCookieDatabase", "addCookie cookie=" + aVar.toString());
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("domain", aVar.f43205a);
                contentValues.put("path", aVar.f43206b);
                contentValues.put("name", aVar.f43207c);
                contentValues.put("value", aVar.f43208d);
                contentValues.put("expires", Long.valueOf(aVar.f43209e));
                contentValues.put(ClientCookie.SECURE_ATTR, Boolean.valueOf(aVar.f43210f));
                f2.insert("cookies", null, contentValues);
            }
        }
    }

    public synchronized void b() {
        SQLiteDatabase f2 = f();
        if (f2 == null) {
            return;
        }
        if (f43230c) {
            Log.d("SwanCookieDatabase", "clearExpiredCookies");
        }
        f2.delete("cookies", "expires <= ?", new String[]{Long.toString(System.currentTimeMillis())});
    }

    public synchronized void c() {
        if (this.f43231a == null) {
            return;
        }
        try {
            if (f43230c) {
                Log.d("SwanCookieDatabase", IntentConfig.CLOSE);
            }
            this.f43231a.close();
            this.f43231a = null;
            this.f43232b = true;
        } catch (Exception e2) {
            d.h("SwanCookieDatabase", "close fail:" + Log.getStackTraceString(e2));
        }
    }

    public synchronized void d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase f2 = f();
        if (f2 == null) {
            return;
        }
        if (f43230c) {
            Log.d("SwanCookieDatabase", "deleteCookies domain=" + str + ";path=" + str2 + ";name=" + str3);
        }
        f2.delete("cookies", "(domain == ?) AND (path == ?) AND (name == ?)", new String[]{str, str2, str3});
    }

    public synchronized ArrayList<d.a.i0.a.l2.a> e(String str) {
        if (f43230c) {
            Log.d("SwanCookieDatabase", "getCookiesForDomain baseDomain=" + str);
        }
        ArrayList<d.a.i0.a.l2.a> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        SQLiteDatabase f2 = f();
        if (f2 == null) {
            return arrayList;
        }
        Cursor query = f2.query("cookies", new String[]{"_id", "domain", "path", "name", "value", "expires", ClientCookie.SECURE_ATTR}, "(domain GLOB '*' || ?)", new String[]{str}, null, null, null);
        if (query == null) {
            return arrayList;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (query.moveToFirst()) {
            int columnIndex = query.getColumnIndex("domain");
            int columnIndex2 = query.getColumnIndex("path");
            int columnIndex3 = query.getColumnIndex("name");
            int columnIndex4 = query.getColumnIndex("value");
            int columnIndex5 = query.getColumnIndex("expires");
            int columnIndex6 = query.getColumnIndex(ClientCookie.SECURE_ATTR);
            do {
                d.a.i0.a.l2.a aVar = new d.a.i0.a.l2.a();
                aVar.f43205a = query.getString(columnIndex);
                aVar.f43206b = query.getString(columnIndex2);
                aVar.f43207c = query.getString(columnIndex3);
                aVar.f43208d = query.getString(columnIndex4);
                if (query.isNull(columnIndex5)) {
                    aVar.f43209e = -1L;
                } else {
                    aVar.f43209e = query.getLong(columnIndex5);
                }
                aVar.f43210f = query.getShort(columnIndex6) != 0;
                aVar.f43213i = 1;
                if (aVar.f43209e > currentTimeMillis) {
                    arrayList.add(aVar);
                    if (f43230c) {
                        Log.d("SwanCookieDatabase", "getCookiesForDomain cookie=" + aVar.toString());
                    }
                }
            } while (query.moveToNext());
            d.a.i0.a.i1.e.a.a(query);
            return arrayList;
        }
        d.a.i0.a.i1.e.a.a(query);
        return arrayList;
    }

    public final SQLiteDatabase f() {
        if (this.f43232b) {
            return null;
        }
        a aVar = this.f43231a;
        if (aVar != null) {
            return aVar.getWritableDatabase();
        }
        String appId = d.a.i0.a.a2.d.g().getAppId();
        if (!d.a.i0.a.a2.d.g().C()) {
            d.h("SwanCookieDatabase", "getSQLiteDatabase currentAppId =" + appId);
            return null;
        }
        String t = d.a.i0.a.k2.b.t(d.a.i0.a.a2.d.g().r());
        d.h("SwanCookieDatabase", "initDbHelper name =" + t);
        a aVar2 = new a(d.a.i0.a.c1.a.b(), t);
        this.f43231a = aVar2;
        return aVar2.getWritableDatabase();
    }

    public synchronized void g(Runnable runnable) {
        String str;
        String stackTraceString;
        SQLiteDatabase f2 = f();
        if (f2 == null) {
            return;
        }
        try {
            f2.beginTransaction();
            runnable.run();
            f2.setTransactionSuccessful();
            try {
                f2.endTransaction();
            } catch (Exception e2) {
                str = "SwanCookieDatabase";
                stackTraceString = Log.getStackTraceString(e2);
                d.h(str, stackTraceString);
            }
        } catch (Exception e3) {
            d.h("SwanCookieDatabase", Log.getStackTraceString(e3));
            try {
                f2.endTransaction();
            } catch (Exception e4) {
                str = "SwanCookieDatabase";
                stackTraceString = Log.getStackTraceString(e4);
                d.h(str, stackTraceString);
            }
        }
    }

    public synchronized void h() {
        f();
    }
}
