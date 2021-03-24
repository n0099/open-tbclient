package d.b.i0.r2.x.m;

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
    public static String f59957d;

    /* renamed from: e  reason: collision with root package name */
    public static String f59958e;

    /* renamed from: f  reason: collision with root package name */
    public static String f59959f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f59960g;

    /* renamed from: h  reason: collision with root package name */
    public static String f59961h;

    /* renamed from: a  reason: collision with root package name */
    public g f59962a;

    /* renamed from: b  reason: collision with root package name */
    public c f59963b;

    /* renamed from: c  reason: collision with root package name */
    public long f59964c;

    public d() {
        h();
    }

    public static void l(String str) {
        f59957d = str;
    }

    public static void m(String str) {
        f59959f = str;
    }

    public static void n(String str) {
        f59958e = str;
    }

    public final void a(g gVar) {
        b(gVar, false);
    }

    public final void b(g gVar, boolean z) {
        if (gVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(f59957d)) {
            gVar.a().a("Cookie", f59957d);
        } else {
            gVar.a().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f59959f)) {
            gVar.a().a("client_user_token", f59959f);
        }
        if (!TextUtils.isEmpty(f59958e)) {
            gVar.a().a("User-Agent", f59958e);
        }
        if (z) {
            gVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        } else {
            gVar.a().a("Accept-Encoding", "");
        }
        if (f59960g) {
            gVar.a().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            gVar.a().a(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
        gVar.a().a("client_logid", String.valueOf(this.f59964c));
        if (TextUtils.isEmpty(f59961h)) {
            return;
        }
        gVar.a().a("cuid", f59961h);
    }

    public void c() {
        c cVar = this.f59963b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean d(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return e(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean e(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        g gVar = new g();
        this.f59962a = gVar;
        a(gVar);
        this.f59962a.a().i(str);
        c cVar = new c(this.f59962a);
        this.f59963b = cVar;
        return cVar.b(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public g f() {
        return this.f59962a;
    }

    public i g(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        g gVar = new g();
        this.f59962a = gVar;
        b(gVar, z);
        this.f59962a.a().i(str);
        c cVar = new c(this.f59962a);
        this.f59963b = cVar;
        cVar.c(i, i3, i4);
        return this.f59962a.b();
    }

    public void h() {
        System.setProperty("http.keepAlive", "false");
        this.f59964c = BdStatisticsManager.getInstance().getClientLogId();
    }

    public boolean i() {
        c cVar = this.f59963b;
        if (cVar != null) {
            return cVar.d();
        }
        return false;
    }

    public i j(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        g gVar = new g();
        this.f59962a = gVar;
        b(gVar, z);
        this.f59962a.a().i(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f59962a.a().b(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f59962a.a().a(next.getName(), next.getValue());
            }
        }
        c cVar = new c(this.f59962a);
        this.f59963b = cVar;
        cVar.f(i, i2, -1);
        return this.f59962a.b();
    }

    public void k() {
        c cVar = this.f59963b;
        if (cVar != null) {
            cVar.i();
        }
    }
}
