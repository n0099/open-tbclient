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
    public String f30655a;

    /* renamed from: b  reason: collision with root package name */
    public String f30656b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f30657c;

    /* renamed from: d  reason: collision with root package name */
    public String f30658d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30659e;

    /* renamed from: f  reason: collision with root package name */
    public String f30660f;

    /* renamed from: g  reason: collision with root package name */
    public Network f30661g;

    /* renamed from: h  reason: collision with root package name */
    public long f30662h;
    public String i;
    public int j;
    public g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.f30659e = false;
        this.f30656b = str;
        this.k = gVar;
        this.f30657c = map == null ? new HashMap<>() : map;
        this.f30655a = gVar == null ? "" : gVar.b().toString();
        this.f30658d = str2;
        this.f30660f = str3;
        this.i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        this.f30657c.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
        this.f30657c.put("Content-Type", "application/json");
        this.f30657c.put("traceId", this.f30660f);
        this.f30657c.put("appid", this.i);
        this.f30657c.put(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
    }

    public void a(String str, String str2) {
        this.f30657c.put(str, str2);
    }

    public boolean b() {
        return this.f30659e;
    }

    public Map<String, String> c() {
        return this.f30657c;
    }

    public String d() {
        return this.f30655a;
    }

    public String e() {
        return this.f30658d;
    }

    public String f() {
        return this.f30660f;
    }

    public boolean g() {
        return !e.a(this.f30660f) || this.f30656b.contains("logReport") || this.f30656b.contains("uniConfig");
    }

    public Network h() {
        return this.f30661g;
    }

    public long i() {
        return this.f30662h;
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
        return this.f30656b;
    }

    public void a(boolean z) {
        this.f30659e = z;
    }

    public void a(Network network) {
        this.f30661g = network;
    }

    public void a(long j) {
        this.f30662h = j;
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }
}
