package d.b.n.d;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import com.baidu.crabsdk.b.j;
import com.baidu.crabsdk.b.o;
import com.baidu.crabsdk.sender.r;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ OnUploadFilesCallback f64146e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f64147f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f64148g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f64149h;
    public final /* synthetic */ String i;

    public e(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.f64146e = onUploadFilesCallback;
        this.f64147f = str;
        this.f64148g = str2;
        this.f64149h = str3;
        this.i = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String b2 = o.b();
        if (!((b2.equals("NONE") || b2.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.f64146e.onFailed("Network is not connected!");
            return;
        }
        JSONObject a2 = j.a(this.f64147f, this.f64146e, this.f64148g, this.f64149h, this.i);
        if (a2 == null) {
            return;
        }
        String h2 = com.baidu.crabsdk.c.d.h(com.baidu.crabsdk.a.f4637d, this.f64147f);
        try {
            byte[] g2 = com.baidu.crabsdk.c.d.g(com.baidu.crabsdk.c.c.j(a2.toString()), h2);
            String a3 = com.baidu.crabsdk.c.e.a(h2);
            String e2 = com.baidu.crabsdk.a.e();
            com.baidu.crabsdk.c.a.b("sendLogRecord postUrl:" + e2);
            String a4 = r.a(e2, g2, a3);
            if (TextUtils.isEmpty(a4)) {
                com.baidu.crabsdk.c.a.e("result is empty!");
                this.f64146e.onFailed("Result is empty!");
            } else if (a4 != null && a4.equals("N/A")) {
                this.f64146e.onFailed("Not connected to server!");
            } else {
                com.baidu.crabsdk.c.a.c("Result is: " + a4);
                try {
                    JSONObject jSONObject = new JSONObject(a4);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            this.f64146e.onSuccess();
                        } else {
                            this.f64146e.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                        }
                    }
                } catch (Exception e3) {
                    com.baidu.crabsdk.c.a.a("Parse result error!", e3);
                    this.f64146e.onFailed("Parse result error!");
                }
            }
        } catch (Exception e4) {
            com.baidu.crabsdk.c.a.a("crash content AES failed!", e4);
            this.f64146e.onFailed(e4.getMessage());
        } catch (OutOfMemoryError e5) {
            com.baidu.crabsdk.c.a.a("OutOfMemoryError", e5);
            this.f64146e.onFailed(e5.getMessage());
        }
    }
}
