package d.a.k0.s2.c0.m;

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
    public static String f60892d;

    /* renamed from: e  reason: collision with root package name */
    public static String f60893e;

    /* renamed from: f  reason: collision with root package name */
    public static String f60894f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f60895g;

    /* renamed from: h  reason: collision with root package name */
    public static String f60896h;

    /* renamed from: a  reason: collision with root package name */
    public g f60897a;

    /* renamed from: b  reason: collision with root package name */
    public c f60898b;

    /* renamed from: c  reason: collision with root package name */
    public long f60899c;

    public d() {
        h();
    }

    public static void l(String str) {
        f60892d = str;
    }

    public static void m(String str) {
        f60894f = str;
    }

    public static void n(String str) {
        f60893e = str;
    }

    public final void a(g gVar) {
        b(gVar, false);
    }

    public final void b(g gVar, boolean z) {
        if (gVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(f60892d)) {
            gVar.a().a("Cookie", f60892d);
        } else {
            gVar.a().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f60894f)) {
            gVar.a().a("client_user_token", f60894f);
        }
        if (!TextUtils.isEmpty(f60893e)) {
            gVar.a().a("User-Agent", f60893e);
        }
        if (z) {
            gVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        } else {
            gVar.a().a("Accept-Encoding", "");
        }
        if (f60895g) {
            gVar.a().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            gVar.a().a(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
        gVar.a().a("client_logid", String.valueOf(this.f60899c));
        if (TextUtils.isEmpty(f60896h)) {
            return;
        }
        gVar.a().a("cuid", f60896h);
    }

    public void c() {
        c cVar = this.f60898b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return e(str, str2, z, i2, i3, i4, i5, linkedList, jVar, z2, false);
    }

    public boolean e(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        g gVar = new g();
        this.f60897a = gVar;
        a(gVar);
        this.f60897a.a().i(str);
        c cVar = new c(this.f60897a);
        this.f60898b = cVar;
        return cVar.b(str2, jVar, i2, i3, i4, i5, z2, z3);
    }

    public g f() {
        return this.f60897a;
    }

    public i g(String str, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        g gVar = new g();
        this.f60897a = gVar;
        b(gVar, z);
        this.f60897a.a().i(str);
        c cVar = new c(this.f60897a);
        this.f60898b = cVar;
        cVar.c(i2, i4, i5);
        return this.f60897a.b();
    }

    public void h() {
        System.setProperty("http.keepAlive", "false");
        this.f60899c = BdStatisticsManager.getInstance().getClientLogId();
    }

    public boolean i() {
        c cVar = this.f60898b;
        if (cVar != null) {
            return cVar.d();
        }
        return false;
    }

    public i j(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        g gVar = new g();
        this.f60897a = gVar;
        b(gVar, z);
        this.f60897a.a().i(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f60897a.a().b(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f60897a.a().a(next.getName(), next.getValue());
            }
        }
        c cVar = new c(this.f60897a);
        this.f60898b = cVar;
        cVar.f(i2, i3, -1);
        return this.f60897a.b();
    }

    public void k() {
        c cVar = this.f60898b;
        if (cVar != null) {
            cVar.i();
        }
    }
}
