package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class Y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f39836a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39837b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Z0 f39838c;

    public Y0(Z0 z0, boolean z, String str) {
        this.f39838c = z0;
        this.f39836a = z;
        this.f39837b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b2;
        String str = this.f39836a ? t1.f40036b : t1.f40037c;
        HashMap a2 = p1.a(this.f39838c.f39848a);
        try {
            str = str + p1.a(a2);
        } catch (UnsupportedEncodingException unused) {
        }
        String str2 = this.f39837b;
        try {
            T0 t0 = new T0(str, "POST", G.a((Map) null));
            t0.f39800b = G.j(str2);
            U0 a3 = t0.a();
            byte[] bArr = a3.f39817b;
            if (a3.f39816a == 200) {
                JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                jSONObject.optInt(Constants.KEYS.RET);
                jSONObject.optString("msg");
                try {
                    b2 = G.b(jSONObject.optString("data"));
                } catch (Exception unused2) {
                }
                if (TextUtils.isEmpty(b2)) {
                    new JSONObject();
                } else {
                    new JSONObject(b2);
                }
            }
        } catch (JSONException e2) {
            e2.getMessage();
        } catch (Exception e3) {
            e3.getMessage();
        }
    }
}
