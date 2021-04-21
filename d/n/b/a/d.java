package d.n.b.a;

import android.content.Context;
import android.util.Log;
import d.n.a.b.f;
import d.n.b.a.a.a;
import java.util.Calendar;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public a f67431e;

    /* renamed from: f  reason: collision with root package name */
    public Context f67432f;

    public d(Context context, a aVar) {
        this.f67431e = aVar;
        this.f67432f = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.pgl.sys.ces.b a2;
        StringBuilder sb;
        a aVar;
        String str;
        byte[] bArr;
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            str = d.n.a.a.a.c() + "/v1/getInfoPgl";
            long timeInMillis = com.pgl.sys.ces.b.a().f38378a ? Calendar.getInstance().getTimeInMillis() : 0L;
            bArr = (byte[]) com.pgl.sys.ces.a.meta(301, this.f67432f, null);
            long timeInMillis2 = com.pgl.sys.ces.b.a().f38378a ? Calendar.getInstance().getTimeInMillis() : 0L;
            if (com.pgl.sys.ces.b.a().f38378a) {
                Log.d("CZL_Efficient", "[Efficient] selas : " + (timeInMillis2 - timeInMillis));
            }
        } catch (Throwable unused) {
            try {
                b.f67425a = 500;
                a2 = com.pgl.sys.ces.b.a();
                sb = new StringBuilder();
            } catch (Throwable th) {
                com.pgl.sys.ces.b.a().reportNow("SS-" + b.f67425a);
                throw th;
            }
        }
        if (bArr == null || bArr.length <= 0) {
            throw new NullPointerException("NullPointerException");
        }
        String str2 = str + "?os=android&app_key=" + b.f67427c + "&did=" + com.pgl.sys.ces.b.c() + "&version=1.0.5&version_code=5&time=" + valueOf;
        int i = 0;
        int i2 = 504;
        while (i < 3) {
            JSONObject jSONObject = new JSONObject(d.n.b.a.c.a.a(str2, bArr));
            i2 = jSONObject.getInt("code");
            if (i2 == 200 || i2 == 202) {
                if (i2 == 200) {
                    b.f67426b = true;
                    b.f67428d = jSONObject.getString("token_id");
                }
                if (i2 == 202) {
                    b.f67426b = true;
                    String string = jSONObject.getString("token_id");
                    b.f67428d = string;
                    com.pgl.sys.ces.a.meta(302, this.f67432f, string);
                }
                b.f67425a = i2;
                a2 = com.pgl.sys.ces.b.a();
                sb = new StringBuilder();
                sb.append("SS-");
                sb.append(b.f67425a);
                a2.reportNow(sb.toString());
                aVar = this.f67431e;
                if (aVar == null) {
                    aVar.a(b.a());
                    return;
                }
                return;
            }
            i++;
            f.a(i * 3 * 1000);
        }
        b.f67425a = i2;
        a2 = com.pgl.sys.ces.b.a();
        sb = new StringBuilder();
        sb.append("SS-");
        sb.append(b.f67425a);
        a2.reportNow(sb.toString());
        aVar = this.f67431e;
        if (aVar == null) {
        }
    }
}
