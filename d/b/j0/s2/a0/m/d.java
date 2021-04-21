package d.b.j0.s2.a0.m;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static String f61979d;

    /* renamed from: e  reason: collision with root package name */
    public static String f61980e;

    /* renamed from: f  reason: collision with root package name */
    public static String f61981f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f61982g;

    /* renamed from: h  reason: collision with root package name */
    public static String f61983h;

    /* renamed from: a  reason: collision with root package name */
    public g f61984a;

    /* renamed from: b  reason: collision with root package name */
    public c f61985b;

    /* renamed from: c  reason: collision with root package name */
    public long f61986c;

    public d() {
        h();
    }

    public static void l(String str) {
        f61979d = str;
    }

    public static void m(String str) {
        f61981f = str;
    }

    public static void n(String str) {
        f61980e = str;
    }

    public final void a(g gVar) {
        b(gVar, false);
    }

    public final void b(g gVar, boolean z) {
        if (gVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(f61979d)) {
            gVar.a().a("Cookie", f61979d);
        } else {
            gVar.a().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f61981f)) {
            gVar.a().a("client_user_token", f61981f);
        }
        if (!TextUtils.isEmpty(f61980e)) {
            gVar.a().a("User-Agent", f61980e);
        }
        if (z) {
            gVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        } else {
            gVar.a().a("Accept-Encoding", "");
        }
        if (f61982g) {
            gVar.a().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            gVar.a().a(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
        gVar.a().a("client_logid", String.valueOf(this.f61986c));
        if (TextUtils.isEmpty(f61983h)) {
            return;
        }
        gVar.a().a("cuid", f61983h);
    }

    public void c() {
        c cVar = this.f61985b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean d(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return e(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean e(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        g gVar = new g();
        this.f61984a = gVar;
        a(gVar);
        this.f61984a.a().i(str);
        c cVar = new c(this.f61984a);
        this.f61985b = cVar;
        return cVar.b(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public g f() {
        return this.f61984a;
    }

    public i g(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        g gVar = new g();
        this.f61984a = gVar;
        b(gVar, z);
        this.f61984a.a().i(str);
        c cVar = new c(this.f61984a);
        this.f61985b = cVar;
        cVar.c(i, i3, i4);
        return this.f61984a.b();
    }

    public void h() {
        System.setProperty("http.keepAlive", "false");
        this.f61986c = BdStatisticsManager.getInstance().getClientLogId();
    }

    public boolean i() {
        c cVar = this.f61985b;
        if (cVar != null) {
            return cVar.d();
        }
        return false;
    }

    public i j(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        g gVar = new g();
        this.f61984a = gVar;
        b(gVar, z);
        this.f61984a.a().i(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f61984a.a().b(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f61984a.a().a(next.getName(), next.getValue());
            }
        }
        c cVar = new c(this.f61984a);
        this.f61985b = cVar;
        cVar.f(i, i2, -1);
        return this.f61984a.b();
    }

    public void k() {
        c cVar = this.f61985b;
        if (cVar != null) {
            cVar.i();
        }
    }
}
