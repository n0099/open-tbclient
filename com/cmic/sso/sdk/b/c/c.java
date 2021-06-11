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
    public String f30631a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30632b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f30633c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30634d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30635e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30636f;

    /* renamed from: g  reason: collision with root package name */
    public Network f30637g;

    /* renamed from: h  reason: collision with root package name */
    public long f30638h;

    /* renamed from: i  reason: collision with root package name */
    public final String f30639i;
    public int j;
    public final g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.f30635e = false;
        this.f30632b = str;
        this.k = gVar;
        this.f30633c = map == null ? new HashMap<>() : map;
        this.f30631a = gVar == null ? "" : gVar.b().toString();
        this.f30634d = str2;
        this.f30636f = str3;
        this.f30639i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        this.f30633c.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
        this.f30633c.put("Content-Type", "application/json");
        this.f30633c.put("CMCC-EncryptType", "STD");
        this.f30633c.put("traceId", this.f30636f);
        this.f30633c.put("appid", this.f30639i);
        this.f30633c.put(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
    }

    public void a(String str, String str2) {
        this.f30633c.put(str, str2);
    }

    public boolean b() {
        return this.f30635e;
    }

    public Map<String, String> c() {
        return this.f30633c;
    }

    public String d() {
        return this.f30631a;
    }

    public String e() {
        return this.f30634d;
    }

    public String f() {
        return this.f30636f;
    }

    public boolean g() {
        return !e.a(this.f30636f) || this.f30632b.contains("logReport") || this.f30632b.contains("uniConfig");
    }

    public Network h() {
        return this.f30637g;
    }

    public long i() {
        return this.f30638h;
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
        return this.f30632b;
    }

    public void a(boolean z) {
        this.f30635e = z;
    }

    public void a(Network network) {
        this.f30637g = network;
    }

    public void a(long j) {
        this.f30638h = j;
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }
}
