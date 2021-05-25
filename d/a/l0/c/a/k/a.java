package d.a.l0.c.a.k;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import d.a.l0.n.i.a;
import java.io.IOException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a<T> extends c {

    /* renamed from: d  reason: collision with root package name */
    public String f46492d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f46493e = null;

    /* renamed from: f  reason: collision with root package name */
    public a.c f46494f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f46495g;

    /* renamed from: h  reason: collision with root package name */
    public int f46496h;

    @Override // d.a.l0.c.a.k.c
    public String b() {
        return this.f46495g;
    }

    @Override // d.a.l0.c.a.k.c
    public void e(IOException iOException) {
    }

    @Override // d.a.l0.c.a.k.c
    public void f(int i2) {
    }

    @Override // d.a.l0.c.a.k.c
    public void h(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.f46504a) {
            hashMap.put("Bdtls", TextUtils.equals(b(), "GET") ? Base64.encodeToString(bArr, 2) : "Bdtls");
        } else {
            hashMap.put("Bdtls-Downgrade", "1");
        }
        this.f46494f.a(hashMap, bArr, this.f46492d);
    }

    public void j() {
        k(this.f46492d, this.f46493e, this.f46494f);
    }

    public void k(String str, String str2, a.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f46492d = str;
        this.f46493e = str2;
        this.f46494f = cVar;
        if (str2 == null) {
            this.f46495g = "GET";
        } else {
            this.f46495g = "POST";
        }
        if (d.a.l0.c.a.a.f46449a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f46493e);
    }
}
