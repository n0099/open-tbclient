package d.a.c.e.j.b;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.j.a.c;
import d.a.c.e.j.a.e;
import d.a.c.e.j.a.g;
import d.a.c.e.j.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static String f39005d;

    /* renamed from: e  reason: collision with root package name */
    public static String f39006e;

    /* renamed from: f  reason: collision with root package name */
    public static String f39007f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f39008g;

    /* renamed from: h  reason: collision with root package name */
    public static String f39009h;

    /* renamed from: i  reason: collision with root package name */
    public static String f39010i;
    public static String j;
    public static String k;

    /* renamed from: a  reason: collision with root package name */
    public e f39011a;

    /* renamed from: b  reason: collision with root package name */
    public c f39012b;

    /* renamed from: c  reason: collision with root package name */
    public long f39013c;

    public a() {
        i();
    }

    public static void n(String str) {
        f39005d = str;
    }

    public static void o(String str) {
        f39009h = str;
    }

    public static void p(String str) {
        f39010i = str;
    }

    public static void q(String str) {
        j = str;
    }

    public static void r(String str) {
        k = str;
    }

    public static void s(boolean z) {
        f39008g = z;
    }

    public static void t(String str) {
        f39007f = str;
    }

    public static void u(String str) {
        f39006e = str;
    }

    public final void a(e eVar) {
        b(eVar, false);
    }

    public final void b(e eVar, boolean z) {
        if (eVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(f39005d)) {
            eVar.b().a("Cookie", f39005d);
        } else {
            eVar.b().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f39007f)) {
            eVar.b().a("client_user_token", f39007f);
        }
        if (!TextUtils.isEmpty(f39006e)) {
            eVar.b().a("User-Agent", f39006e);
        }
        if (z) {
            eVar.b().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        } else {
            eVar.b().a("Accept-Encoding", "");
        }
        if (f39008g) {
            eVar.b().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            eVar.b().a(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
        eVar.b().a("client_logid", String.valueOf(this.f39013c));
        if (!TextUtils.isEmpty(f39009h)) {
            eVar.b().a("cuid", f39009h);
        }
        if (!TextUtils.isEmpty(f39010i)) {
            eVar.b().a("cuid_galaxy2", f39010i);
        }
        if (!TextUtils.isEmpty(j)) {
            eVar.b().a("c3_aid", j);
        }
        if (TextUtils.isEmpty(k)) {
            return;
        }
        eVar.b().a(TiebaStatic.Params.CUID_GID, k);
    }

    public void c() {
        c cVar = this.f39012b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        e eVar = new e();
        this.f39011a = eVar;
        a(eVar);
        this.f39011a.b().s(str);
        this.f39011a.b().o(z4);
        c cVar = new c(this.f39011a);
        this.f39012b = cVar;
        return cVar.c(str2, hVar, i2, i3, i4, i5, z2, z3);
    }

    public e e() {
        return this.f39011a;
    }

    public c f() {
        return this.f39012b;
    }

    public g g(String str, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return h(str, false, i2, i3, i4, i5, linkedList);
    }

    public g h(String str, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        e eVar = new e();
        this.f39011a = eVar;
        b(eVar, z);
        this.f39011a.b().s(str);
        c cVar = new c(this.f39011a);
        this.f39012b = cVar;
        cVar.e(i2, i4, i5);
        return this.f39011a.c();
    }

    public void i() {
        System.setProperty("http.keepAlive", "false");
        this.f39013c = BdStatisticsManager.getInstance().getClientLogId();
    }

    public boolean j() {
        c cVar = this.f39012b;
        if (cVar != null) {
            return cVar.l();
        }
        return false;
    }

    public g k(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        e eVar = new e();
        this.f39011a = eVar;
        b(eVar, z);
        this.f39011a.b().s(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f39011a.b().d(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f39011a.b().a(next.getName(), next.getValue());
            }
        }
        c cVar = new c(this.f39011a);
        this.f39012b = cVar;
        cVar.n(i2, i3, -1);
        return this.f39011a.c();
    }

    public g l(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        e eVar = new e();
        this.f39011a = eVar;
        b(eVar, z);
        this.f39011a.b().s(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f39011a.b().a(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.f39011a.b().b(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.f39011a.b().c(entry.getKey(), entry.getValue());
            }
        }
        c cVar = new c(this.f39011a);
        this.f39012b = cVar;
        cVar.n(i2, i3, -1);
        return this.f39011a.c();
    }

    public void m() {
        c cVar = this.f39012b;
        if (cVar != null) {
            cVar.q();
        }
    }
}
