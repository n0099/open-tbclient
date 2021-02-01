package com.pgl.sys.a;

import android.content.Context;
import android.util.Log;
import com.pgl.a.b.f;
import java.util.Calendar;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private Context f11393b;
    private com.pgl.sys.a.a.a qad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, com.pgl.sys.a.a.a aVar) {
        this.qad = aVar;
        this.f11393b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        byte[] bArr;
        int i;
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            str = com.pgl.a.a.a.b() + "/v1/getInfoPgl";
            long timeInMillis = com.pgl.sys.ces.b.a().f11398a ? Calendar.getInstance().getTimeInMillis() : 0L;
            bArr = (byte[]) com.pgl.sys.ces.a.meta(301, this.f11393b, null);
            long timeInMillis2 = com.pgl.sys.ces.b.a().f11398a ? Calendar.getInstance().getTimeInMillis() : 0L;
            if (com.pgl.sys.ces.b.a().f11398a) {
                Log.d("CZL_Efficient", "[Efficient] selas : " + (timeInMillis2 - timeInMillis));
            }
        } catch (Throwable th) {
            try {
                a.f11391a = 500;
            } finally {
                com.pgl.sys.ces.b.a().reportNow("SS-" + a.f11391a);
            }
        }
        if (bArr == null || bArr.length <= 0) {
            throw new NullPointerException("NullPointerException");
        }
        String str2 = str + "?os=android&app_key=" + a.c + "&did=" + com.pgl.sys.ces.b.c() + "&version=1.0.5&version_code=5&time=" + valueOf;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            JSONObject jSONObject = new JSONObject(com.pgl.sys.a.b.a.a(str2, bArr));
            i3 = jSONObject.getInt("code");
            if (i3 == 500) {
                f.a((i2 + 1) * 3 * 1000);
                i2++;
            } else if (i3 == 200) {
                a.f11392b = true;
                a.d = jSONObject.getString("token_id");
                i = i3;
            } else if (i3 == 202) {
                a.f11392b = true;
                String string = jSONObject.getString("token_id");
                a.d = string;
                com.pgl.sys.ces.a.meta(302, this.f11393b, string);
                i = i3;
            }
        }
        i = i3;
        a.f11391a = i;
        if (this.qad != null) {
            this.qad.a(a.a());
        }
    }
}
