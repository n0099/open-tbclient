package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f8132a;
    public final /* synthetic */ String b;
    public final /* synthetic */ bx qlj;

    public bu(bx bxVar, boolean z, String str) {
        this.qlj = bxVar;
        this.f8132a = z;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b;
        String str = this.f8132a ? el.b : el.c;
        try {
            str = str + dw.a(dw.iV(this.qlj.f8135a));
        } catch (UnsupportedEncodingException e) {
        }
        String str2 = this.b;
        try {
            bk bkVar = new bk(str, "POST", v.a((Map) null));
            bkVar.b = v.abX(str2);
            bm eJc = bkVar.eJc();
            byte[] bArr = eJc.b;
            if (eJc.f8119a == 200) {
                JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                jSONObject.optInt(Constants.KEYS.RET);
                jSONObject.optString("msg");
                try {
                    b = v.b(jSONObject.optString("data"));
                } catch (Exception e2) {
                }
                if (TextUtils.isEmpty(b)) {
                    new JSONObject();
                } else {
                    new JSONObject(b);
                }
            }
        } catch (JSONException e3) {
            e3.getMessage();
        } catch (Exception e4) {
            e4.getMessage();
        }
    }
}
