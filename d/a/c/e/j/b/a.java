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
    public static String f42322d;

    /* renamed from: e  reason: collision with root package name */
    public static String f42323e;

    /* renamed from: f  reason: collision with root package name */
    public static String f42324f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f42325g;

    /* renamed from: h  reason: collision with root package name */
    public static String f42326h;

    /* renamed from: i  reason: collision with root package name */
    public static String f42327i;
    public static String j;
    public static String k;

    /* renamed from: a  reason: collision with root package name */
    public e f42328a;

    /* renamed from: b  reason: collision with root package name */
    public c f42329b;

    /* renamed from: c  reason: collision with root package name */
    public long f42330c;

    public a() {
        i();
    }

    public static void n(String str) {
        f42322d = str;
    }

    public static void o(String str) {
        f42326h = str;
    }

    public static void p(String str) {
        f42327i = str;
    }

    public static void q(String str) {
        j = str;
    }

    public static void r(String str) {
        k = str;
    }

    public static void s(boolean z) {
        f42325g = z;
    }

    public static void t(String str) {
        f42324f = str;
    }

    public static void u(String str) {
        f42323e = str;
    }

    public final void a(e eVar) {
        b(eVar, false);
    }

    public final void b(e eVar, boolean z) {
        if (eVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(f42322d)) {
            eVar.b().a("Cookie", f42322d);
        } else {
            eVar.b().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f42324f)) {
            eVar.b().a("client_user_token", f42324f);
        }
        if (!TextUtils.isEmpty(f42323e)) {
            eVar.b().a("User-Agent", f42323e);
        }
        if (z) {
            eVar.b().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        } else {
            eVar.b().a("Accept-Encoding", "");
        }
        if (f42325g) {
            eVar.b().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            eVar.b().a(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
        eVar.b().a("client_logid", String.valueOf(this.f42330c));
        if (!TextUtils.isEmpty(f42326h)) {
            eVar.b().a("cuid", f42326h);
        }
        if (!TextUtils.isEmpty(f42327i)) {
            eVar.b().a("cuid_galaxy2", f42327i);
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
        c cVar = this.f42329b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        e eVar = new e();
        this.f42328a = eVar;
        a(eVar);
        this.f42328a.b().s(str);
        this.f42328a.b().o(z4);
        c cVar = new c(this.f42328a);
        this.f42329b = cVar;
        return cVar.c(str2, hVar, i2, i3, i4, i5, z2, z3);
    }

    public e e() {
        return this.f42328a;
    }

    public c f() {
        return this.f42329b;
    }

    public g g(String str, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return h(str, false, i2, i3, i4, i5, linkedList);
    }

    public g h(String str, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        e eVar = new e();
        this.f42328a = eVar;
        b(eVar, z);
        this.f42328a.b().s(str);
        c cVar = new c(this.f42328a);
        this.f42329b = cVar;
        cVar.e(i2, i4, i5);
        return this.f42328a.c();
    }

    public void i() {
        System.setProperty("http.keepAlive", "false");
        this.f42330c = BdStatisticsManager.getInstance().getClientLogId();
    }

    public boolean j() {
        c cVar = this.f42329b;
        if (cVar != null) {
            return cVar.l();
        }
        return false;
    }

    public g k(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        e eVar = new e();
        this.f42328a = eVar;
        b(eVar, z);
        this.f42328a.b().s(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f42328a.b().d(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f42328a.b().a(next.getName(), next.getValue());
            }
        }
        c cVar = new c(this.f42328a);
        this.f42329b = cVar;
        cVar.n(i2, i3, -1);
        return this.f42328a.c();
    }

    public g l(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        e eVar = new e();
        this.f42328a = eVar;
        b(eVar, z);
        this.f42328a.b().s(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f42328a.b().a(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.f42328a.b().b(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.f42328a.b().c(entry.getKey(), entry.getValue());
            }
        }
        c cVar = new c(this.f42328a);
        this.f42329b = cVar;
        cVar.n(i2, i3, -1);
        return this.f42328a.c();
    }

    public void m() {
        c cVar = this.f42329b;
        if (cVar != null) {
            cVar.q();
        }
    }
}
