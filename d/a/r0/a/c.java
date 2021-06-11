package d.a.r0.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.a.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f68104a;

    /* renamed from: b  reason: collision with root package name */
    public String f68105b;

    /* renamed from: c  reason: collision with root package name */
    public String f68106c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68107d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f68108e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, com.baidu.ubs.analytics.a.g> f68109f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f68110a = new c((byte) 0);
    }

    /* loaded from: classes5.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public C1858c f68111a = new C1858c();

        public final List<com.baidu.ubs.analytics.a.a> a() {
            return this.f68111a.a();
        }

        public final void b(int i2) {
            this.f68111a.b(i2);
        }

        public final void c(com.baidu.ubs.analytics.a.a aVar) {
            this.f68111a.c(aVar);
        }
    }

    /* renamed from: d.a.r0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C1858c {

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f68112a = f.a().c();

        public final List<com.baidu.ubs.analytics.a.a> a() {
            Cursor rawQuery = this.f68112a.rawQuery("SELECT * FROM tb_ab_click_log order by _id ", null);
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
                aVar.v(rawQuery.getString(rawQuery.getColumnIndex("_eventId")));
                aVar.w(rawQuery.getString(rawQuery.getColumnIndex("_parameter")));
                aVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                aVar.u(rawQuery.getString(rawQuery.getColumnIndex("_timeStamp")));
                aVar.t(rawQuery.getString(rawQuery.getColumnIndex("_pagerName")));
                aVar.s(rawQuery.getString(rawQuery.getColumnIndex("_productLine")));
                aVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
                arrayList.add(aVar);
            }
            rawQuery.close();
            return arrayList;
        }

        public final void b(int i2) {
            this.f68112a.execSQL("delete from tb_ab_click_log where _id <= " + i2);
        }

        public final void c(com.baidu.ubs.analytics.a.a aVar) {
            this.f68112a.execSQL("INSERT INTO tb_ab_click_log(_eventId,_parameter,_sessionId,_timeStamp,_pagerName,_productLine) VALUES (?,?,?,?,?,?);", new String[]{aVar.G(), aVar.H(), aVar.I(), aVar.F(), aVar.E(), aVar.D()});
        }
    }

    /* loaded from: classes5.dex */
    public final class d extends SQLiteOpenHelper {
        public d(Context context) {
            super(context, "BaiDuAb.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            int i2 = 0;
            while (true) {
                String[] strArr = e.f68113a;
                if (i2 >= strArr.length) {
                    return;
                }
                sQLiteDatabase.execSQL(strArr[i2]);
                i2++;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f68113a = {"CREATE TABLE if not exists tb_ab_click_log (\n  _eventId varchar,\n  _id integer PRIMARY KEY AUTOINCREMENT,\n  _parameter varchar,\n  _timeStamp varchar,\n  _sessionId varchar,\n  _productLine varchar,\n  _pagerName varchar\n);", "CREATE TABLE if not exists tb_ab_netlog (\n  _id integer PRIMARY KEY AUTOINCREMENT,\n  _parameters varchar,\n  _timeStamp varchar,\n  _type varchar,\n  _url varchar,\n  _sessionId varchar\n);", "CREATE TABLE if not exists tb_ab_page_log (\n  _endTime varchar,\n  _id integer PRIMARY KEY AUTOINCREMENT,\n  _pagerName varchar,\n  _path varchar,\n  _startTime varchar,\n  _sessionId varchar\n);", "CREATE TABLE if not exists tb_ab_sessionlog (\n  _endTime varchar,\n  _id integer PRIMARY KEY AUTOINCREMENT,\n  _keepTime varchar,\n  _sessionId varchar,\n  _startTime varchar\n);"};
    }

    /* loaded from: classes5.dex */
    public final class f {

        /* renamed from: c  reason: collision with root package name */
        public static f f68114c;

        /* renamed from: d  reason: collision with root package name */
        public static SQLiteOpenHelper f68115d;

        /* renamed from: a  reason: collision with root package name */
        public AtomicInteger f68116a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        public SQLiteDatabase f68117b;

        public static synchronized f a() {
            f fVar;
            synchronized (f.class) {
                if (f68114c == null) {
                    b(c.i().g());
                }
                fVar = f68114c;
            }
            return fVar;
        }

        public static synchronized void b(Context context) {
            synchronized (f.class) {
                if (f68114c == null) {
                    f68114c = new f();
                    f68115d = new d(context);
                }
            }
        }

        public final synchronized SQLiteDatabase c() {
            if (this.f68116a.incrementAndGet() == 1) {
                d.a.r0.a.f.a.a("***************新建立了 一个数据库的实例****************");
                this.f68117b = f68115d.getWritableDatabase();
            }
            return this.f68117b;
        }
    }

    /* loaded from: classes5.dex */
    public final class g {

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f68118a = f.a().c();

        public final List<com.baidu.ubs.analytics.a.i> a() {
            Cursor rawQuery = this.f68118a.rawQuery("SELECT * FROM tb_ab_netlog order by _id ", null);
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.ubs.analytics.a.i iVar = new com.baidu.ubs.analytics.a.i();
                iVar.setUrl(rawQuery.getString(rawQuery.getColumnIndex("_url")));
                iVar.setType(rawQuery.getString(rawQuery.getColumnIndex("_type")));
                iVar.u(rawQuery.getString(rawQuery.getColumnIndex("_timeStamp")));
                iVar.setParameters(rawQuery.getString(rawQuery.getColumnIndex("_parameters")));
                iVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                iVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
                arrayList.add(iVar);
            }
            rawQuery.close();
            return arrayList;
        }

        public final void b(int i2) {
            this.f68118a.execSQL("delete from tb_ab_netlog where _id <= " + i2);
        }
    }

    /* loaded from: classes5.dex */
    public final class h {

        /* renamed from: a  reason: collision with root package name */
        public g f68119a = new g();

        public final List<com.baidu.ubs.analytics.a.i> a() {
            return this.f68119a.a();
        }

        public final void b(int i2) {
            this.f68119a.b(i2);
        }
    }

    /* loaded from: classes5.dex */
    public final class i {

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f68120a = f.a().c();

        public final List<com.baidu.ubs.analytics.a.l> a() {
            Cursor rawQuery = this.f68120a.rawQuery("SELECT * FROM  tb_ab_page_log order by _id ", null);
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
                lVar.t(rawQuery.getString(rawQuery.getColumnIndex("_pagerName")));
                lVar.setPath(rawQuery.getString(rawQuery.getColumnIndex("_path")));
                lVar.z(rawQuery.getString(rawQuery.getColumnIndex("_endTime")));
                lVar.setStartTime(rawQuery.getString(rawQuery.getColumnIndex("_startTime")));
                lVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                lVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
                arrayList.add(lVar);
            }
            rawQuery.close();
            return arrayList;
        }

        public final void b(int i2) {
            this.f68120a.execSQL("delete from tb_ab_page_log where _id <= " + i2);
        }

        public final void c(com.baidu.ubs.analytics.a.l lVar) {
            this.f68120a.execSQL("INSERT INTO tb_ab_page_log(_startTime,_endTime,_pagerName,_path,_sessionId) VALUES (?,?,?,?,?);", new String[]{lVar.N(), lVar.O(), lVar.E(), lVar.getPath(), lVar.I()});
        }
    }

    /* loaded from: classes5.dex */
    public final class j {

        /* renamed from: a  reason: collision with root package name */
        public i f68121a = new i();

        public final List<com.baidu.ubs.analytics.a.l> a() {
            return this.f68121a.a();
        }

        public final void b(int i2) {
            this.f68121a.b(i2);
        }

        public final void c(com.baidu.ubs.analytics.a.l lVar) {
            this.f68121a.c(lVar);
        }
    }

    /* loaded from: classes5.dex */
    public final class k {

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f68122a = f.a().c();

        public final void a(String str) {
            this.f68122a.execSQL("delete from tb_ab_sessionlog where not ( _sessionId = ? )", new String[]{str});
        }

        public final boolean b(String str) {
            Cursor rawQuery = this.f68122a.rawQuery("select * from tb_ab_sessionlog where _sessionId = ? ", new String[]{str});
            int count = rawQuery.getCount();
            rawQuery.close();
            return count > 0;
        }

        public final List<n> c() {
            Cursor rawQuery = this.f68122a.rawQuery("SELECT * FROM  tb_ab_sessionlog", null);
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                n nVar = new n();
                nVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                nVar.setStartTime(rawQuery.getString(rawQuery.getColumnIndex("_startTime")));
                nVar.A(rawQuery.getString(rawQuery.getColumnIndex("_keepTime")));
                nVar.z(rawQuery.getString(rawQuery.getColumnIndex("_endTime")));
                arrayList.add(nVar);
            }
            rawQuery.close();
            return arrayList;
        }

        public final void d(n nVar) {
            this.f68122a.execSQL("INSERT INTO tb_ab_sessionlog(_startTime,_keepTime,_endTime,_sessionId) VALUES (?,?,?,?);", new String[]{nVar.N(), nVar.P(), nVar.O(), nVar.I()});
        }

        public final void e(n nVar) {
            this.f68122a.execSQL("UPDATE tb_ab_sessionlog SET _keepTime= ? , _endTime = ? WHERE _sessionId= ?", new String[]{nVar.P(), nVar.O(), nVar.I()});
        }
    }

    /* loaded from: classes5.dex */
    public final class l {

        /* renamed from: a  reason: collision with root package name */
        public k f68123a = new k();

        public final void a(String str) {
            this.f68123a.a(str);
        }

        public final boolean b(String str) {
            return this.f68123a.b(str);
        }

        public final void c(String str) {
            this.f68123a.a(str);
        }

        public final List<n> d() {
            return this.f68123a.c();
        }

        public final void e(n nVar) {
            this.f68123a.e(nVar);
        }

        public final void f(n nVar) {
            this.f68123a.d(nVar);
        }
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static c i() {
        return a.f68110a;
    }

    public final void a(Context context) {
        this.f68104a = context;
    }

    public final void b(String str) {
        this.f68105b = str;
    }

    public final synchronized void c(List<com.baidu.ubs.analytics.a.g> list) {
        this.f68109f = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) != null) {
                this.f68109f.put(list.get(i2).getId(), list.get(i2));
            }
        }
    }

    public final synchronized void d(boolean z) {
        this.f68107d = z;
    }

    public final void e(String str) {
        this.f68106c = str;
    }

    public final SampleResult f(String str) {
        Map<String, com.baidu.ubs.analytics.a.g> map;
        if (this.f68108e == null) {
            if (str != null && (map = this.f68109f) != null) {
                if (map.containsKey(str)) {
                    return d.a.r0.a.f.h.a(this.f68109f.get(str).getGroup());
                }
                return SampleResult.OTHERE;
            }
            return SampleResult.OTHERE;
        }
        for (int i2 = 0; i2 < this.f68108e.length(); i2++) {
            JSONObject optJSONObject = this.f68108e.optJSONObject(i2);
            if (optJSONObject != null && str.equals(optJSONObject.optString("exid"))) {
                return d.a.r0.a.f.h.a(optJSONObject.optString("group"));
            }
        }
        return SampleResult.OTHERE;
    }

    public final Context g() {
        return this.f68104a;
    }

    public final boolean h() {
        return this.f68107d;
    }

    public final String j() {
        return this.f68105b;
    }

    public final String k() {
        return this.f68106c;
    }

    public final Map<String, com.baidu.ubs.analytics.a.g> l() {
        return this.f68109f;
    }

    public c() {
        this.f68107d = true;
    }
}
