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
    public String f50166d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f50167e = null;

    /* renamed from: f  reason: collision with root package name */
    public a.c f50168f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f50169g;

    /* renamed from: h  reason: collision with root package name */
    public int f50170h;

    @Override // d.a.l0.c.a.k.c
    public String b() {
        return this.f50169g;
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
        if (this.f50178a) {
            hashMap.put("Bdtls", TextUtils.equals(b(), "GET") ? Base64.encodeToString(bArr, 2) : "Bdtls");
        } else {
            hashMap.put("Bdtls-Downgrade", "1");
        }
        this.f50168f.a(hashMap, bArr, this.f50166d);
    }

    public void j() {
        k(this.f50166d, this.f50167e, this.f50168f);
    }

    public void k(String str, String str2, a.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f50166d = str;
        this.f50167e = str2;
        this.f50168f = cVar;
        if (str2 == null) {
            this.f50169g = "GET";
        } else {
            this.f50169g = "POST";
        }
        if (d.a.l0.c.a.a.f50123a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f50167e);
    }
}
