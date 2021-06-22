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
    public String f30713a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30714b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f30715c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30716d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30717e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30718f;

    /* renamed from: g  reason: collision with root package name */
    public Network f30719g;

    /* renamed from: h  reason: collision with root package name */
    public long f30720h;

    /* renamed from: i  reason: collision with root package name */
    public final String f30721i;
    public int j;
    public final g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.f30717e = false;
        this.f30714b = str;
        this.k = gVar;
        this.f30715c = map == null ? new HashMap<>() : map;
        this.f30713a = gVar == null ? "" : gVar.b().toString();
        this.f30716d = str2;
        this.f30718f = str3;
        this.f30721i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        this.f30715c.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
        this.f30715c.put("Content-Type", "application/json");
        this.f30715c.put("CMCC-EncryptType", "STD");
        this.f30715c.put("traceId", this.f30718f);
        this.f30715c.put("appid", this.f30721i);
        this.f30715c.put(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
    }

    public void a(String str, String str2) {
        this.f30715c.put(str, str2);
    }

    public boolean b() {
        return this.f30717e;
    }

    public Map<String, String> c() {
        return this.f30715c;
    }

    public String d() {
        return this.f30713a;
    }

    public String e() {
        return this.f30716d;
    }

    public String f() {
        return this.f30718f;
    }

    public boolean g() {
        return !e.a(this.f30718f) || this.f30714b.contains("logReport") || this.f30714b.contains("uniConfig");
    }

    public Network h() {
        return this.f30719g;
    }

    public long i() {
        return this.f30720h;
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
        return this.f30714b;
    }

    public void a(boolean z) {
        this.f30717e = z;
    }

    public void a(Network network) {
        this.f30719g = network;
    }

    public void a(long j) {
        this.f30720h = j;
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }
}
