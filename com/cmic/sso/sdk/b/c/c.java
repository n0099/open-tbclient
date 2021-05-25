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
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f30537a;

    /* renamed from: b  reason: collision with root package name */
    public String f30538b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f30539c;

    /* renamed from: d  reason: collision with root package name */
    public String f30540d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30541e;

    /* renamed from: f  reason: collision with root package name */
    public String f30542f;

    /* renamed from: g  reason: collision with root package name */
    public Network f30543g;

    /* renamed from: h  reason: collision with root package name */
    public long f30544h;

    /* renamed from: i  reason: collision with root package name */
    public String f30545i;
    public int j;
    public g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.f30541e = false;
        this.f30538b = str;
        this.k = gVar;
        this.f30539c = map == null ? new HashMap<>() : map;
        this.f30537a = gVar == null ? "" : gVar.b().toString();
        this.f30540d = str2;
        this.f30542f = str3;
        this.f30545i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        this.f30539c.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
        this.f30539c.put("Content-Type", "application/json");
        this.f30539c.put("traceId", this.f30542f);
        this.f30539c.put("appid", this.f30545i);
        this.f30539c.put(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
    }

    public void a(String str, String str2) {
        this.f30539c.put(str, str2);
    }

    public boolean b() {
        return this.f30541e;
    }

    public Map<String, String> c() {
        return this.f30539c;
    }

    public String d() {
        return this.f30537a;
    }

    public String e() {
        return this.f30540d;
    }

    public String f() {
        return this.f30542f;
    }

    public boolean g() {
        return !e.a(this.f30542f) || this.f30538b.contains("logReport") || this.f30538b.contains("uniConfig");
    }

    public Network h() {
        return this.f30543g;
    }

    public long i() {
        return this.f30544h;
    }

    public boolean j() {
        int i2 = this.j;
        this.j = i2 + 1;
        return i2 < 2;
    }

    public g k() {
        return this.k;
    }

    public String a() {
        return this.f30538b;
    }

    public void a(boolean z) {
        this.f30541e = z;
    }

    public void a(Network network) {
        this.f30543g = network;
    }

    public void a(long j) {
        this.f30544h = j;
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }
}
