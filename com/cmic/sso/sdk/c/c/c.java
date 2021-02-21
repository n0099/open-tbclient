package com.cmic.sso.sdk.c.c;

import android.net.Network;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.e.e;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    String f7715a;

    /* renamed from: b  reason: collision with root package name */
    private String f7716b;
    private Map<String, String> c;
    private String d;
    private boolean e;
    private String f;
    private long h;
    private String i;
    private int j;
    private Network pxt;
    private g pxu;

    private c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.e = false;
        this.f7716b = str;
        this.pxu = gVar;
        this.c = map == null ? new HashMap<>() : map;
        this.f7715a = gVar == null ? "" : gVar.b().toString();
        this.d = str2;
        this.f = str3;
        this.i = gVar == null ? "" : gVar.a();
        l();
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }

    private void l() {
        this.c.put(CommandMessage.SDK_VERSION, "quick_login_android_9.2.0.2");
        this.c.put("Content-Type", HttpHelper.CONTENT_JSON);
        this.c.put("traceId", this.f);
        this.c.put("appid", this.i);
        this.c.put(HTTP.CONN_DIRECTIVE, "close");
    }

    public void a(String str, String str2) {
        this.c.put(str, str2);
    }

    public String a() {
        return this.f7716b;
    }

    public boolean b() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.e = z;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public String d() {
        return this.f7715a;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.f;
    }

    public boolean g() {
        return !e.a(this.f) || this.f7716b.contains("logReport") || this.f7716b.contains("uniConfig");
    }

    public Network ery() {
        return this.pxt;
    }

    public void d(Network network) {
        this.pxt = network;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.h = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long i() {
        return this.h;
    }

    public boolean j() {
        int i = this.j;
        this.j = i + 1;
        return i < 2;
    }

    public g erz() {
        return this.pxu;
    }
}
