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
    public final /* synthetic */ boolean f40126a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Z0 f40128c;

    public Y0(Z0 z0, boolean z, String str) {
        this.f40128c = z0;
        this.f40126a = z;
        this.f40127b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b2;
        String str = this.f40126a ? t1.f40326b : t1.f40327c;
        HashMap a2 = p1.a(this.f40128c.f40138a);
        try {
            str = str + p1.a(a2);
        } catch (UnsupportedEncodingException unused) {
        }
        String str2 = this.f40127b;
        try {
            T0 t0 = new T0(str, "POST", G.a((Map) null));
            t0.f40090b = G.j(str2);
            U0 a3 = t0.a();
            byte[] bArr = a3.f40107b;
            if (a3.f40106a == 200) {
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
