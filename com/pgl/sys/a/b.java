package com.pgl.sys.a;

import android.content.Context;
import android.util.Log;
import com.pgl.a.b.f;
import java.util.Calendar;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements Runnable {
    private Context b;
    private com.pgl.sys.a.a.a qbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, com.pgl.sys.a.a.a aVar) {
        this.qbr = aVar;
        this.b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        byte[] bArr;
        int i;
        String valueOf = String.valueOf(System.currentTimeMillis());
        int i2 = 504;
        try {
            str = com.pgl.a.a.a.b() + "/v1/getInfoPgl";
            long timeInMillis = com.pgl.sys.ces.b.a().f7479a ? Calendar.getInstance().getTimeInMillis() : 0L;
            bArr = (byte[]) com.pgl.sys.ces.a.meta(301, this.b, null);
            long timeInMillis2 = com.pgl.sys.ces.b.a().f7479a ? Calendar.getInstance().getTimeInMillis() : 0L;
            if (com.pgl.sys.ces.b.a().f7479a) {
                Log.d("CZL_Efficient", "[Efficient] selas : " + (timeInMillis2 - timeInMillis));
            }
        } catch (Throwable th) {
            try {
                a.f7475a = 500;
            } finally {
                com.pgl.sys.ces.b.a().reportNow("SS-" + a.f7475a);
            }
        }
        if (bArr == null || bArr.length <= 0) {
            throw new NullPointerException("NullPointerException");
        }
        String str2 = str + "?os=android&app_key=" + a.c + "&did=" + com.pgl.sys.ces.b.c() + "&version=1.0.5&version_code=5&time=" + valueOf;
        for (int i3 = 0; i3 < 3; i3++) {
            JSONObject jSONObject = new JSONObject(com.pgl.sys.a.b.a.a(str2, bArr));
            i2 = jSONObject.getInt("code");
            if (i2 == 200 || i2 == 202) {
                if (i2 == 200) {
                    a.b = true;
                    a.d = jSONObject.getString("token_id");
                }
                if (i2 == 202) {
                    a.b = true;
                    String string = jSONObject.getString("token_id");
                    a.d = string;
                    com.pgl.sys.ces.a.meta(302, this.b, string);
                    i = i2;
                    a.f7475a = i;
                    if (this.qbr != null) {
                        this.qbr.a(a.a());
                        return;
                    }
                    return;
                }
                i = i2;
                a.f7475a = i;
                if (this.qbr != null) {
                }
            } else {
                f.a((i3 + 1) * 3 * 1000);
            }
        }
        i = i2;
        a.f7475a = i;
        if (this.qbr != null) {
        }
    }
}
