package d.a.m0.c.a.k;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import d.a.m0.n.i.a;
import java.io.IOException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a<T> extends c {

    /* renamed from: d  reason: collision with root package name */
    public String f50274d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f50275e = null;

    /* renamed from: f  reason: collision with root package name */
    public a.c f50276f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f50277g;

    /* renamed from: h  reason: collision with root package name */
    public int f50278h;

    @Override // d.a.m0.c.a.k.c
    public String b() {
        return this.f50277g;
    }

    @Override // d.a.m0.c.a.k.c
    public void e(IOException iOException) {
    }

    @Override // d.a.m0.c.a.k.c
    public void f(int i2) {
    }

    @Override // d.a.m0.c.a.k.c
    public void h(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.f50286a) {
            hashMap.put("Bdtls", TextUtils.equals(b(), "GET") ? Base64.encodeToString(bArr, 2) : "Bdtls");
        } else {
            hashMap.put("Bdtls-Downgrade", "1");
        }
        this.f50276f.a(hashMap, bArr, this.f50274d);
    }

    public void j() {
        k(this.f50274d, this.f50275e, this.f50276f);
    }

    public void k(String str, String str2, a.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f50274d = str;
        this.f50275e = str2;
        this.f50276f = cVar;
        if (str2 == null) {
            this.f50277g = "GET";
        } else {
            this.f50277g = "POST";
        }
        if (d.a.m0.c.a.a.f50231a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f50275e);
    }
}
