package d.a.o0.t2.c0.m;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static String f64811d;

    /* renamed from: e  reason: collision with root package name */
    public static String f64812e;

    /* renamed from: f  reason: collision with root package name */
    public static String f64813f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f64814g;

    /* renamed from: h  reason: collision with root package name */
    public static String f64815h;

    /* renamed from: a  reason: collision with root package name */
    public g f64816a;

    /* renamed from: b  reason: collision with root package name */
    public c f64817b;

    /* renamed from: c  reason: collision with root package name */
    public long f64818c;

    public d() {
        h();
    }

    public static void l(String str) {
        f64811d = str;
    }

    public static void m(String str) {
        f64813f = str;
    }

    public static void n(String str) {
        f64812e = str;
    }

    public final void a(g gVar) {
        b(gVar, false);
    }

    public final void b(g gVar, boolean z) {
        if (gVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(f64811d)) {
            gVar.a().a("Cookie", f64811d);
        } else {
            gVar.a().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f64813f)) {
            gVar.a().a("client_user_token", f64813f);
        }
        if (!TextUtils.isEmpty(f64812e)) {
            gVar.a().a("User-Agent", f64812e);
        }
        if (z) {
            gVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        } else {
            gVar.a().a("Accept-Encoding", "");
        }
        if (f64814g) {
            gVar.a().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            gVar.a().a(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
        gVar.a().a("client_logid", String.valueOf(this.f64818c));
        if (TextUtils.isEmpty(f64815h)) {
            return;
        }
        gVar.a().a("cuid", f64815h);
    }

    public void c() {
        c cVar = this.f64817b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return e(str, str2, z, i2, i3, i4, i5, linkedList, jVar, z2, false);
    }

    public boolean e(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        g gVar = new g();
        this.f64816a = gVar;
        a(gVar);
        this.f64816a.a().i(str);
        c cVar = new c(this.f64816a);
        this.f64817b = cVar;
        return cVar.b(str2, jVar, i2, i3, i4, i5, z2, z3);
    }

    public g f() {
        return this.f64816a;
    }

    public i g(String str, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        g gVar = new g();
        this.f64816a = gVar;
        b(gVar, z);
        this.f64816a.a().i(str);
        c cVar = new c(this.f64816a);
        this.f64817b = cVar;
        cVar.c(i2, i4, i5);
        return this.f64816a.b();
    }

    public void h() {
        System.setProperty("http.keepAlive", "false");
        this.f64818c = BdStatisticsManager.getInstance().getClientLogId();
    }

    public boolean i() {
        c cVar = this.f64817b;
        if (cVar != null) {
            return cVar.d();
        }
        return false;
    }

    public i j(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        g gVar = new g();
        this.f64816a = gVar;
        b(gVar, z);
        this.f64816a.a().i(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f64816a.a().b(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f64816a.a().a(next.getName(), next.getValue());
            }
        }
        c cVar = new c(this.f64816a);
        this.f64817b = cVar;
        cVar.f(i2, i3, -1);
        return this.f64816a.b();
    }

    public void k() {
        c cVar = this.f64817b;
        if (cVar != null) {
            cVar.i();
        }
    }
}
