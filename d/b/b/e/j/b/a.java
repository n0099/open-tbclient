package d.b.b.e.j.b;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.b.e.j.a.c;
import d.b.b.e.j.a.e;
import d.b.b.e.j.a.g;
import d.b.b.e.j.a.h;
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
    public static String f41822d;

    /* renamed from: e  reason: collision with root package name */
    public static String f41823e;

    /* renamed from: f  reason: collision with root package name */
    public static String f41824f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f41825g;

    /* renamed from: h  reason: collision with root package name */
    public static String f41826h;
    public static String i;
    public static String j;
    public static String k;

    /* renamed from: a  reason: collision with root package name */
    public e f41827a;

    /* renamed from: b  reason: collision with root package name */
    public c f41828b;

    /* renamed from: c  reason: collision with root package name */
    public long f41829c;

    public a() {
        i();
    }

    public static void n(String str) {
        f41822d = str;
    }

    public static void o(String str) {
        f41826h = str;
    }

    public static void p(String str) {
        i = str;
    }

    public static void q(String str) {
        j = str;
    }

    public static void r(String str) {
        k = str;
    }

    public static void s(boolean z) {
        f41825g = z;
    }

    public static void t(String str) {
        f41824f = str;
    }

    public static void u(String str) {
        f41823e = str;
    }

    public final void a(e eVar) {
        b(eVar, false);
    }

    public final void b(e eVar, boolean z) {
        if (eVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(f41822d)) {
            eVar.b().a("Cookie", f41822d);
        } else {
            eVar.b().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f41824f)) {
            eVar.b().a("client_user_token", f41824f);
        }
        if (!TextUtils.isEmpty(f41823e)) {
            eVar.b().a("User-Agent", f41823e);
        }
        if (z) {
            eVar.b().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        } else {
            eVar.b().a("Accept-Encoding", "");
        }
        if (f41825g) {
            eVar.b().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            eVar.b().a(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
        eVar.b().a("client_logid", String.valueOf(this.f41829c));
        if (!TextUtils.isEmpty(f41826h)) {
            eVar.b().a("cuid", f41826h);
        }
        if (!TextUtils.isEmpty(i)) {
            eVar.b().a(TiebaStatic.Params.CUID_GALAXY2, i);
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
        c cVar = this.f41828b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        e eVar = new e();
        this.f41827a = eVar;
        a(eVar);
        this.f41827a.b().s(str);
        this.f41827a.b().o(z4);
        c cVar = new c(this.f41827a);
        this.f41828b = cVar;
        return cVar.c(str2, hVar, i2, i3, i4, i5, z2, z3);
    }

    public e e() {
        return this.f41827a;
    }

    public c f() {
        return this.f41828b;
    }

    public g g(String str, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return h(str, false, i2, i3, i4, i5, linkedList);
    }

    public g h(String str, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        e eVar = new e();
        this.f41827a = eVar;
        b(eVar, z);
        this.f41827a.b().s(str);
        c cVar = new c(this.f41827a);
        this.f41828b = cVar;
        cVar.d(i2, i4, i5);
        return this.f41827a.c();
    }

    public void i() {
        System.setProperty("http.keepAlive", "false");
        this.f41829c = BdStatisticsManager.getInstance().getClientLogId();
    }

    public boolean j() {
        c cVar = this.f41828b;
        if (cVar != null) {
            return cVar.k();
        }
        return false;
    }

    public g k(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        e eVar = new e();
        this.f41827a = eVar;
        b(eVar, z);
        this.f41827a.b().s(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.f41827a.b().d(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f41827a.b().a(next.getName(), next.getValue());
            }
        }
        c cVar = new c(this.f41827a);
        this.f41828b = cVar;
        cVar.m(i2, i3, -1);
        return this.f41827a.c();
    }

    public g l(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        e eVar = new e();
        this.f41827a = eVar;
        b(eVar, z);
        this.f41827a.b().s(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.f41827a.b().a(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.f41827a.b().b(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.f41827a.b().c(entry.getKey(), entry.getValue());
            }
        }
        c cVar = new c(this.f41827a);
        this.f41828b = cVar;
        cVar.m(i2, i3, -1);
        return this.f41827a.c();
    }

    public void m() {
        c cVar = this.f41828b;
        if (cVar != null) {
            cVar.p();
        }
    }
}
