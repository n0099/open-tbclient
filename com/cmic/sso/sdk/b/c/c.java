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
    public String f31363a;

    /* renamed from: b  reason: collision with root package name */
    public String f31364b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f31365c;

    /* renamed from: d  reason: collision with root package name */
    public String f31366d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31367e;

    /* renamed from: f  reason: collision with root package name */
    public String f31368f;

    /* renamed from: g  reason: collision with root package name */
    public Network f31369g;

    /* renamed from: h  reason: collision with root package name */
    public long f31370h;

    /* renamed from: i  reason: collision with root package name */
    public String f31371i;
    public int j;
    public g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.f31367e = false;
        this.f31364b = str;
        this.k = gVar;
        this.f31365c = map == null ? new HashMap<>() : map;
        this.f31363a = gVar == null ? "" : gVar.b().toString();
        this.f31366d = str2;
        this.f31368f = str3;
        this.f31371i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        this.f31365c.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
        this.f31365c.put("Content-Type", "application/json");
        this.f31365c.put("traceId", this.f31368f);
        this.f31365c.put("appid", this.f31371i);
        this.f31365c.put(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
    }

    public void a(String str, String str2) {
        this.f31365c.put(str, str2);
    }

    public boolean b() {
        return this.f31367e;
    }

    public Map<String, String> c() {
        return this.f31365c;
    }

    public String d() {
        return this.f31363a;
    }

    public String e() {
        return this.f31366d;
    }

    public String f() {
        return this.f31368f;
    }

    public boolean g() {
        return !e.a(this.f31368f) || this.f31364b.contains("logReport") || this.f31364b.contains("uniConfig");
    }

    public Network h() {
        return this.f31369g;
    }

    public long i() {
        return this.f31370h;
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
        return this.f31364b;
    }

    public void a(boolean z) {
        this.f31367e = z;
    }

    public void a(Network network) {
        this.f31369g = network;
    }

    public void a(long j) {
        this.f31370h = j;
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }
}
