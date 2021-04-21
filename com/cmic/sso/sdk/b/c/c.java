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
    public String f30435a;

    /* renamed from: b  reason: collision with root package name */
    public String f30436b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f30437c;

    /* renamed from: d  reason: collision with root package name */
    public String f30438d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30439e;

    /* renamed from: f  reason: collision with root package name */
    public String f30440f;

    /* renamed from: g  reason: collision with root package name */
    public Network f30441g;

    /* renamed from: h  reason: collision with root package name */
    public long f30442h;
    public String i;
    public int j;
    public g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.f30439e = false;
        this.f30436b = str;
        this.k = gVar;
        this.f30437c = map == null ? new HashMap<>() : map;
        this.f30435a = gVar == null ? "" : gVar.b().toString();
        this.f30438d = str2;
        this.f30440f = str3;
        this.i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        this.f30437c.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
        this.f30437c.put("Content-Type", "application/json");
        this.f30437c.put("traceId", this.f30440f);
        this.f30437c.put("appid", this.i);
        this.f30437c.put(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
    }

    public void a(String str, String str2) {
        this.f30437c.put(str, str2);
    }

    public boolean b() {
        return this.f30439e;
    }

    public Map<String, String> c() {
        return this.f30437c;
    }

    public String d() {
        return this.f30435a;
    }

    public String e() {
        return this.f30438d;
    }

    public String f() {
        return this.f30440f;
    }

    public boolean g() {
        return !e.a(this.f30440f) || this.f30436b.contains("logReport") || this.f30436b.contains("uniConfig");
    }

    public Network h() {
        return this.f30441g;
    }

    public long i() {
        return this.f30442h;
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
        return this.f30436b;
    }

    public void a(boolean z) {
        this.f30439e = z;
    }

    public void a(Network network) {
        this.f30441g = network;
    }

    public void a(long j) {
        this.f30442h = j;
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }
}
