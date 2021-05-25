package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f37132a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37133b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w0 f37134c;

    public v0(w0 w0Var, boolean z, String str) {
        this.f37134c = w0Var;
        this.f37132a = z;
        this.f37133b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b2;
        String str = this.f37132a ? Q0.f36918b : Q0.f36919c;
        HashMap a2 = M0.a(this.f37134c.f37157a);
        try {
            str = str + M0.a(a2);
        } catch (UnsupportedEncodingException unused) {
        }
        String str2 = this.f37133b;
        try {
            s0 s0Var = new s0(str, "POST", z.a((Map) null));
            s0Var.f37113b = z.h(str2);
            t0 a3 = s0Var.a();
            byte[] bArr = a3.f37123b;
            if (a3.f37122a == 200) {
                JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                jSONObject.optInt(Constants.KEYS.RET);
                jSONObject.optString("msg");
                try {
                    b2 = z.b(jSONObject.optString("data"));
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
