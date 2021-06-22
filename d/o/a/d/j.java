package d.o.a.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.a.r;
import d.o.a.a.a.d.d;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.d.g;
import d.o.a.d.i;
import d.o.a.d.n.f;
import d.o.a.e.b.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j implements d.o.a.a.a.b {

    /* loaded from: classes7.dex */
    public class a implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.a.b f70834a;

        public a(j jVar, d.o.a.a.a.a.b bVar) {
            this.f70834a = bVar;
        }

        @Override // d.o.a.e.b.a.a.d
        public boolean a() {
            return this.f70834a.a();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.o.a.e.b.f.i {
        public b(j jVar) {
        }

        @Override // d.o.a.e.b.f.i
        public boolean a(DownloadInfo downloadInfo) {
            d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(downloadInfo.c0());
            if (d2.m("notification_opt_2") == 1) {
                if (downloadInfo.H0() == -2) {
                    DownloadHandlerService.a(n.a(), downloadInfo, d.o.a.e.a.e.F().t(), d.o.a.e.b.g.a.l(n.a()).i(downloadInfo.c0()));
                }
                return true;
            }
            boolean d3 = d(downloadInfo);
            if (d2.b("disable_delete_dialog", 0) == 1) {
                return true;
            }
            return d3;
        }

        @Override // d.o.a.e.b.f.i
        public boolean b(DownloadInfo downloadInfo) {
            return false;
        }

        @Override // d.o.a.e.b.f.i
        public boolean c(DownloadInfo downloadInfo) {
            if (downloadInfo == null) {
                return false;
            }
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 != null) {
                g.b.a(c2);
            } else {
                d.o.a.d.n.h.j(n.a(), downloadInfo.v0());
            }
            d.o.a.e.b.p.b.a().m(downloadInfo.c0());
            return true;
        }

        public final boolean d(DownloadInfo downloadInfo) {
            String d2;
            r A = n.A();
            if (A != null) {
                d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                if (c2 != null && c2.c()) {
                    d2 = d.o.a.e.b.j.a.d(downloadInfo.c0()).h("ad_notification_jump_url", null);
                } else {
                    d2 = d.o.a.d.f.l.d(downloadInfo);
                }
                if (TextUtils.isEmpty(d2)) {
                    return false;
                }
                return A.a(n.a(), d2);
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public class c {

        /* loaded from: classes7.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public static c f70835a = new c();
        }

        public static c a() {
            return b.f70835a;
        }

        public final JSONObject b(d.o.a.b.a.c.a aVar) {
            JSONObject jSONObject = new JSONObject();
            try {
                d.o.a.d.n.k.o(aVar.g(), jSONObject);
                d.o.a.d.n.k.o(aVar.p(), jSONObject);
                jSONObject.putOpt("download_url", aVar.a());
                jSONObject.putOpt("package_name", aVar.e());
                jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
                jSONObject.putOpt("rom_name", d.o.a.e.a.h.c.i());
                jSONObject.putOpt("rom_version", d.o.a.e.a.h.c.j());
                jSONObject.putOpt("ttdownloader", 1);
                jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.h()));
                if (aVar.h() == 2) {
                    f.e(jSONObject, aVar);
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public void c(long j, int i2) {
            c.f v = c.g.e().v(j);
            if (v.w()) {
                d.o.a.d.n.k.B();
            } else if (v.f70650c.l()) {
                int i3 = 1;
                d.o.a.a.a.c.c cVar = v.f70650c;
                String c2 = i2 == 1 ? cVar.c() : cVar.b();
                String m = d.o.a.d.n.k.m(v.f70650c.d(), PrefetchEvent.STATE_CLICK);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
                    jSONObject.putOpt("permission_notification", Integer.valueOf(d.o.a.e.a.f.c.d() ? 1 : 2));
                    if (!d.o.a.e.b.l.e.p0(n.a())) {
                        i3 = 2;
                    }
                    jSONObject.putOpt("network_available", Integer.valueOf(i3));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                r(c2, m, jSONObject, v);
                if (!PrefetchEvent.STATE_CLICK.equals(m) || v.f70649b == null) {
                    return;
                }
                e.a().b(j, v.f70649b.u());
            }
        }

        public void d(long j, int i2, DownloadInfo downloadInfo) {
            c.f v = c.g.e().v(j);
            if (v.w()) {
                d.o.a.d.n.k.B();
                return;
            }
            String str = null;
            JSONObject jSONObject = new JSONObject();
            if (i2 == 1) {
                str = d.o.a.d.n.k.m(v.f70650c.i(), "storage_deny");
            } else if (i2 == 2) {
                str = d.o.a.d.n.k.m(v.f70650c.e(), "click_start");
                f.c(downloadInfo, jSONObject);
            } else if (i2 == 3) {
                str = d.o.a.d.n.k.m(v.f70650c.f(), "click_pause");
                f.f(downloadInfo, jSONObject);
            } else if (i2 == 4) {
                str = d.o.a.d.n.k.m(v.f70650c.g(), "click_continue");
                f.g(downloadInfo, jSONObject);
            } else if (i2 == 5) {
                if (downloadInfo != null) {
                    try {
                        f.d(jSONObject, downloadInfo.c0());
                        d.o.a.d.e.s(jSONObject, downloadInfo);
                    } catch (Throwable unused) {
                    }
                }
                str = d.o.a.d.n.k.m(v.f70650c.h(), "click_install");
            }
            q(null, str, jSONObject, 0L, 1, v);
        }

        public void e(long j, BaseException baseException) {
            c.f v = c.g.e().v(j);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_time", 0);
                if (baseException != null) {
                    jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                    jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            t("download_failed", jSONObject, v);
        }

        public void f(long j, BaseException baseException, JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (baseException != null) {
                try {
                    jSONObject.putOpt("error_code", Integer.valueOf(baseException.getErrorCode()));
                    jSONObject.putOpt("ttdownloader_message", baseException.getErrorMessage());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            s("download_sdk_error", jSONObject, j);
        }

        public void g(long j, boolean z, int i2) {
            c.f v = c.g.e().v(j);
            if (v.w()) {
                d.o.a.d.n.k.B();
            } else if (v.f70649b.B() == null) {
            } else {
                d.o.a.a.a.c.d dVar = v.f70649b;
                if (dVar instanceof d.o.a.b.a.a.c) {
                    ((d.o.a.b.a.a.c) dVar).b(3);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                t(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, v);
            }
        }

        public final void h(d.o.a.a.a.d.d dVar) {
            if (n.k() == null) {
                return;
            }
            if (dVar.e()) {
                n.k().a(dVar);
            } else {
                n.k().b(dVar);
            }
        }

        public void i(DownloadInfo downloadInfo) {
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                f.g(downloadInfo, jSONObject);
                c2.X(System.currentTimeMillis());
                r(c2.j(), "download_resume", jSONObject, c2);
                c.j.b().c(c2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void j(DownloadInfo downloadInfo, BaseException baseException) {
            if (downloadInfo == null) {
                return;
            }
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 == null) {
                d.o.a.d.n.k.B();
            } else if (c2.K.get()) {
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    d.o.a.d.e.g(jSONObject, downloadInfo);
                    jSONObject.putOpt("fail_status", Integer.valueOf(c2.z()));
                    jSONObject.putOpt("fail_msg", c2.A());
                    jSONObject.put("download_failed_times", c2.f1());
                    if (downloadInfo.Q0() > 0) {
                        jSONObject.put("download_percent", downloadInfo.E() / downloadInfo.Q0());
                    }
                    jSONObject.put("download_status", downloadInfo.z0());
                    long currentTimeMillis = System.currentTimeMillis();
                    if (c2.C() > 0) {
                        jSONObject.put("time_from_start_download", currentTimeMillis - c2.C());
                    }
                    if (c2.w() > 0) {
                        jSONObject.put("time_from_download_resume", currentTimeMillis - c2.w());
                    }
                    int i2 = 1;
                    jSONObject.put("is_update_download", c2.Q() ? 1 : 2);
                    jSONObject.put("can_show_notification", d.o.a.e.a.f.c.d() ? 1 : 2);
                    if (!c2.L.get()) {
                        i2 = 2;
                    }
                    jSONObject.put("has_send_download_failed_finally", i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                r(c2.j(), "download_cancel", jSONObject, c2);
            }
        }

        public void k(String str, int i2, c.f fVar) {
            q(null, str, null, i2, 0, fVar);
        }

        public void l(String str, long j) {
            d.o.a.b.a.c.b u = c.g.e().u(j);
            if (u != null) {
                n(str, u);
            } else {
                n(str, c.g.e().v(j));
            }
        }

        public void m(String str, @NonNull d.o.a.a.a.c.d dVar, @NonNull d.o.a.a.a.c.c cVar, @NonNull d.o.a.a.a.c.b bVar) {
            n(str, new c.f(dVar.d(), dVar, cVar, bVar));
        }

        public void n(String str, d.o.a.b.a.c.a aVar) {
            p(null, str, aVar);
        }

        public void o(String str, d.o.a.b.a.c.b bVar) {
            u(str, null, bVar);
        }

        public void p(String str, String str2, d.o.a.b.a.c.a aVar) {
            r(str, str2, null, aVar);
        }

        public final void q(String str, String str2, JSONObject jSONObject, long j, int i2, d.o.a.b.a.c.a aVar) {
            if (aVar != null && (!(aVar instanceof c.f) || !((c.f) aVar).w())) {
                try {
                    d.a aVar2 = new d.a();
                    aVar2.d(d.o.a.d.n.k.m(str, aVar.j(), "embeded_ad"));
                    aVar2.k(str2);
                    aVar2.m(aVar.c());
                    aVar2.b(aVar.b());
                    aVar2.o(aVar.d());
                    if (j <= 0) {
                        j = aVar.l();
                    }
                    aVar2.j(j);
                    aVar2.q(aVar.i());
                    aVar2.e(aVar.n());
                    aVar2.f(d.o.a.d.n.k.p(b(aVar), jSONObject));
                    aVar2.l(aVar.k());
                    aVar2.c(aVar.o());
                    if (i2 <= 0) {
                        i2 = 2;
                    }
                    aVar2.a(i2);
                    aVar2.g(aVar.m());
                    h(aVar2.h());
                    return;
                } catch (Exception e2) {
                    d.o.a.d.n.k.q(e2);
                    return;
                }
            }
            d.o.a.d.n.k.B();
        }

        public void r(String str, String str2, JSONObject jSONObject, d.o.a.b.a.c.a aVar) {
            q(str, str2, jSONObject, 0L, 0, aVar);
        }

        public void s(String str, JSONObject jSONObject, long j) {
            d.o.a.b.a.c.b u = c.g.e().u(j);
            if (u != null) {
                u(str, jSONObject, u);
                return;
            }
            c.f v = c.g.e().v(j);
            if (v.w()) {
                d.o.a.d.n.k.B();
            } else {
                v(str, jSONObject, v);
            }
        }

        public void t(String str, JSONObject jSONObject, d.o.a.b.a.c.a aVar) {
            r(null, str, jSONObject, aVar);
        }

        public void u(String str, JSONObject jSONObject, d.o.a.b.a.c.b bVar) {
            JSONObject jSONObject2 = new JSONObject();
            d.o.a.d.n.k.r(jSONObject2, "unity_label", str);
            d.o.a.d.n.k.o(jSONObject2, jSONObject);
            r("embeded_ad", "ttdownloader_unity", jSONObject, bVar);
        }

        public void v(String str, JSONObject jSONObject, c.f fVar) {
            JSONObject jSONObject2 = new JSONObject();
            d.o.a.d.n.k.r(jSONObject2, "unity_label", str);
            d.o.a.d.n.k.o(jSONObject2, jSONObject);
            r("embeded_ad", "ttdownloader_unity", jSONObject, fVar);
        }

        public void w(JSONObject jSONObject, @NonNull d.o.a.b.a.c.b bVar) {
            r(bVar.j(), "install_finish", jSONObject, bVar);
        }

        public void x(long j, int i2) {
            d(j, i2, null);
        }

        public void y(long j, BaseException baseException) {
            f(j, baseException, null);
        }

        public void z(DownloadInfo downloadInfo, BaseException baseException) {
            if (downloadInfo == null) {
                return;
            }
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 == null) {
                d.o.a.d.n.k.B();
            } else if (c2.K.get()) {
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    f.g(downloadInfo, jSONObject);
                    d.o.a.d.e.g(jSONObject, downloadInfo);
                    if (baseException != null) {
                        jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                        jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                        c2.r0(baseException.getErrorCode());
                        c2.Y(baseException.getErrorMessage());
                    }
                    c2.g1();
                    jSONObject.put("download_failed_times", c2.f1());
                    if (downloadInfo.Q0() > 0) {
                        jSONObject.put("download_percent", downloadInfo.E() / downloadInfo.Q0());
                    }
                    int i2 = 1;
                    jSONObject.put("has_send_download_failed_finally", c2.L.get() ? 1 : 2);
                    f.b(c2, jSONObject);
                    if (!c2.Q()) {
                        i2 = 2;
                    }
                    jSONObject.put("is_update_download", i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                r(c2.j(), "download_failed", jSONObject, c2);
                c.j.b().c(c2);
            }
        }

        public c() {
        }
    }

    /* loaded from: classes7.dex */
    public class d extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f70836a = {"_id", LegoListActivityConfig.AD_ID, IAdRequestParam.REQ_ID, "time"};

        public d(@Nullable Context context) {
            super(context, "click_event", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS click_event(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_id INTEGER,req_id TEXT,time INTEGER)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS click_event");
            onCreate(sQLiteDatabase);
        }
    }

    /* loaded from: classes7.dex */
    public class e {

        /* renamed from: b  reason: collision with root package name */
        public static volatile e f70837b;

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f70838a;

        public e() {
            try {
                this.f70838a = new d(n.a()).getWritableDatabase();
            } catch (Throwable th) {
                d.o.a.d.n.k.q(th);
            }
        }

        public static e a() {
            if (f70837b == null) {
                synchronized (e.class) {
                    if (f70837b == null) {
                        f70837b = new e();
                    }
                }
            }
            return f70837b;
        }

        public void b(long j, String str) {
            String optString;
            SQLiteDatabase sQLiteDatabase = this.f70838a;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                optString = new JSONObject(str).optString(IAdRequestParam.REQ_ID);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(LegoListActivityConfig.AD_ID, Long.valueOf(j));
            contentValues.put(IAdRequestParam.REQ_ID, optString);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            this.f70838a.insert("click_event", null, contentValues);
            e(j, str);
        }

        public boolean c() {
            return d.o.a.e.b.j.a.r().b("click_event_switch", 0) == 1;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
        public boolean d(long j, String str) {
            SQLiteDatabase sQLiteDatabase = this.f70838a;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
                return false;
            }
            Cursor cursor = null;
            try {
                try {
                    String optString = new JSONObject(str).optString(IAdRequestParam.REQ_ID);
                    if (TextUtils.isEmpty(optString)) {
                        return false;
                    }
                    cursor = this.f70838a.query("click_event", d.f70836a, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString}, null, null, null, null);
                    boolean z = cursor.getCount() > 0;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        public final void e(long j, String str) {
            SQLiteDatabase sQLiteDatabase = this.f70838a;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String optString = new JSONObject(str).optString(IAdRequestParam.REQ_ID);
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                this.f70838a.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public boolean f() {
            return d.o.a.e.b.j.a.r().b("click_event_switch", 0) == 2;
        }
    }

    @Override // d.o.a.a.a.b
    public d.o.a.a.a.b a(@NonNull d.o.a.a.a.a.k kVar) {
        n.h(kVar);
        return this;
    }

    @Override // d.o.a.a.a.b
    public d.o.a.a.a.b b(@NonNull d.o.a.a.a.d.a aVar) {
        n.i(aVar);
        return this;
    }

    @Override // d.o.a.a.a.b
    public d.o.a.a.a.b c(@NonNull d.o.a.a.a.a.b bVar) {
        n.c(bVar);
        d.o.a.e.b.a.a.c().g(new a(this, bVar));
        return this;
    }

    @Override // d.o.a.a.a.b
    public d.o.a.a.a.b d(d.o.a.e.b.g.b bVar) {
        if (bVar.g() == null) {
            bVar.c(d.o.a.d.f.g.a());
        }
        if (bVar.B() == null) {
            bVar.H(new b(this));
        }
        if (bVar.m().isEmpty()) {
            bVar.a(new i.d());
        }
        d.o.a.e.b.g.a.q(bVar);
        return this;
    }

    @Override // d.o.a.a.a.b
    public d.o.a.a.a.b e(@NonNull d.o.a.a.a.a.f fVar) {
        n.d(fVar);
        return this;
    }

    @Override // d.o.a.a.a.b
    public d.o.a.a.a.b f(@NonNull d.o.a.a.a.a.g gVar) {
        n.e(gVar);
        return this;
    }

    @Override // d.o.a.a.a.b
    public d.o.a.a.a.b g(@NonNull d.o.a.a.a.a.h hVar) {
        n.f(hVar);
        return this;
    }

    @Override // d.o.a.a.a.b
    public d.o.a.a.a.b h(@NonNull d.o.a.a.a.a.i iVar) {
        n.g(iVar);
        return this;
    }

    @Override // d.o.a.a.a.b
    public d.o.a.a.a.b a(String str) {
        n.j(str);
        return this;
    }
}
