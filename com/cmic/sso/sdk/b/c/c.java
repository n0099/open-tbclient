package com.cmic.sso.sdk.b.c;

import android.net.Network;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b.b.g;
import com.cmic.sso.sdk.d.e;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f30340a;

    /* renamed from: b  reason: collision with root package name */
    public String f30341b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f30342c;

    /* renamed from: d  reason: collision with root package name */
    public String f30343d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30344e;

    /* renamed from: f  reason: collision with root package name */
    public String f30345f;

    /* renamed from: g  reason: collision with root package name */
    public Network f30346g;

    /* renamed from: h  reason: collision with root package name */
    public long f30347h;
    public String i;
    public int j;
    public g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.f30344e = false;
        this.f30341b = str;
        this.k = gVar;
        this.f30342c = map == null ? new HashMap<>() : map;
        this.f30340a = gVar == null ? "" : gVar.b().toString();
        this.f30343d = str2;
        this.f30345f = str3;
        this.i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        this.f30342c.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
        this.f30342c.put("Content-Type", "application/json");
        this.f30342c.put("traceId", this.f30345f);
        this.f30342c.put("appid", this.i);
        this.f30342c.put(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
    }

    public void a(String str, String str2) {
        this.f30342c.put(str, str2);
    }

    public boolean b() {
        return this.f30344e;
    }

    public Map<String, String> c() {
        return this.f30342c;
    }

    public String d() {
        return this.f30340a;
    }

    public String e() {
        return this.f30343d;
    }

    public String f() {
        return this.f30345f;
    }

    public boolean g() {
        return !e.a(this.f30345f) || this.f30341b.contains("logReport") || this.f30341b.contains("uniConfig");
    }

    public Network h() {
        return this.f30346g;
    }

    public long i() {
        return this.f30347h;
    }

    public boolean j() {
        int i = this.j;
        this.j = i + 1;
        return i < 2;
    }

    public g k() {
        return this.k;
    }

    public String a() {
        return this.f30341b;
    }

    public void a(boolean z) {
        this.f30344e = z;
    }

    public void a(Network network) {
        this.f30346g = network;
    }

    public void a(long j) {
        this.f30347h = j;
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }
}
