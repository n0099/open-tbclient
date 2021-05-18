package d.a.m.d;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import com.baidu.crabsdk.b.j;
import com.baidu.crabsdk.b.o;
import com.baidu.crabsdk.sender.r;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ OnUploadFilesCallback f63864e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f63865f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f63866g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f63867h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f63868i;

    public e(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.f63864e = onUploadFilesCallback;
        this.f63865f = str;
        this.f63866g = str2;
        this.f63867h = str3;
        this.f63868i = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String b2 = o.b();
        if (!((b2.equals("NONE") || b2.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.f63864e.onFailed("Network is not connected!");
            return;
        }
        JSONObject a2 = j.a(this.f63865f, this.f63864e, this.f63866g, this.f63867h, this.f63868i);
        if (a2 == null) {
            return;
        }
        String h2 = com.baidu.crabsdk.c.d.h(com.baidu.crabsdk.a.f4636d, this.f63865f);
        try {
            byte[] g2 = com.baidu.crabsdk.c.d.g(com.baidu.crabsdk.c.c.j(a2.toString()), h2);
            String a3 = com.baidu.crabsdk.c.e.a(h2);
            String e2 = com.baidu.crabsdk.a.e();
            com.baidu.crabsdk.c.a.b("sendLogRecord postUrl:" + e2);
            String a4 = r.a(e2, g2, a3);
            if (TextUtils.isEmpty(a4)) {
                com.baidu.crabsdk.c.a.e("result is empty!");
                this.f63864e.onFailed("Result is empty!");
            } else if (a4 != null && a4.equals("N/A")) {
                this.f63864e.onFailed("Not connected to server!");
            } else {
                com.baidu.crabsdk.c.a.c("Result is: " + a4);
                try {
                    JSONObject jSONObject = new JSONObject(a4);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            this.f63864e.onSuccess();
                        } else {
                            this.f63864e.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                        }
                    }
                } catch (Exception e3) {
                    com.baidu.crabsdk.c.a.a("Parse result error!", e3);
                    this.f63864e.onFailed("Parse result error!");
                }
            }
        } catch (Exception e4) {
            com.baidu.crabsdk.c.a.a("crash content AES failed!", e4);
            this.f63864e.onFailed(e4.getMessage());
        } catch (OutOfMemoryError e5) {
            com.baidu.crabsdk.c.a.a("OutOfMemoryError", e5);
            this.f63864e.onFailed(e5.getMessage());
        }
    }
}
