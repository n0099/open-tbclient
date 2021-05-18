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
    public String f30608a;

    /* renamed from: b  reason: collision with root package name */
    public String f30609b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f30610c;

    /* renamed from: d  reason: collision with root package name */
    public String f30611d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30612e;

    /* renamed from: f  reason: collision with root package name */
    public String f30613f;

    /* renamed from: g  reason: collision with root package name */
    public Network f30614g;

    /* renamed from: h  reason: collision with root package name */
    public long f30615h;

    /* renamed from: i  reason: collision with root package name */
    public String f30616i;
    public int j;
    public g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.f30612e = false;
        this.f30609b = str;
        this.k = gVar;
        this.f30610c = map == null ? new HashMap<>() : map;
        this.f30608a = gVar == null ? "" : gVar.b().toString();
        this.f30611d = str2;
        this.f30613f = str3;
        this.f30616i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        this.f30610c.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
        this.f30610c.put("Content-Type", "application/json");
        this.f30610c.put("traceId", this.f30613f);
        this.f30610c.put("appid", this.f30616i);
        this.f30610c.put(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
    }

    public void a(String str, String str2) {
        this.f30610c.put(str, str2);
    }

    public boolean b() {
        return this.f30612e;
    }

    public Map<String, String> c() {
        return this.f30610c;
    }

    public String d() {
        return this.f30608a;
    }

    public String e() {
        return this.f30611d;
    }

    public String f() {
        return this.f30613f;
    }

    public boolean g() {
        return !e.a(this.f30613f) || this.f30609b.contains("logReport") || this.f30609b.contains("uniConfig");
    }

    public Network h() {
        return this.f30614g;
    }

    public long i() {
        return this.f30615h;
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
        return this.f30609b;
    }

    public void a(boolean z) {
        this.f30612e = z;
    }

    public void a(Network network) {
        this.f30614g = network;
    }

    public void a(long j) {
        this.f30615h = j;
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }
}
