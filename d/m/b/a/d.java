package d.m.b.a;

import android.content.Context;
import android.util.Log;
import d.m.a.b.f;
import d.m.b.a.a.a;
import java.util.Calendar;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public a f65760e;

    /* renamed from: f  reason: collision with root package name */
    public Context f65761f;

    public d(Context context, a aVar) {
        this.f65760e = aVar;
        this.f65761f = context;
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
            str = d.m.a.a.a.c() + "/v1/getInfoPgl";
            long timeInMillis = com.pgl.sys.ces.b.a().f35945a ? Calendar.getInstance().getTimeInMillis() : 0L;
            bArr = (byte[]) com.pgl.sys.ces.a.meta(301, this.f65761f, null);
            long timeInMillis2 = com.pgl.sys.ces.b.a().f35945a ? Calendar.getInstance().getTimeInMillis() : 0L;
            if (com.pgl.sys.ces.b.a().f35945a) {
                Log.d("CZL_Efficient", "[Efficient] selas : " + (timeInMillis2 - timeInMillis));
            }
        } catch (Throwable unused) {
            try {
                b.f65754a = 500;
                a2 = com.pgl.sys.ces.b.a();
                sb = new StringBuilder();
            } catch (Throwable th) {
                com.pgl.sys.ces.b.a().reportNow("SS-" + b.f65754a);
                throw th;
            }
        }
        if (bArr == null || bArr.length <= 0) {
            throw new NullPointerException("NullPointerException");
        }
        String str2 = str + "?os=android&app_key=" + b.f65756c + "&did=" + com.pgl.sys.ces.b.c() + "&version=1.0.5&version_code=5&time=" + valueOf;
        int i2 = 0;
        int i3 = 504;
        while (i2 < 3) {
            JSONObject jSONObject = new JSONObject(d.m.b.a.c.a.a(str2, bArr));
            i3 = jSONObject.getInt("code");
            if (i3 == 200 || i3 == 202) {
                if (i3 == 200) {
                    b.f65755b = true;
                    b.f65757d = jSONObject.getString("token_id");
                }
                if (i3 == 202) {
                    b.f65755b = true;
                    String string = jSONObject.getString("token_id");
                    b.f65757d = string;
                    com.pgl.sys.ces.a.meta(302, this.f65761f, string);
                }
                b.f65754a = i3;
                a2 = com.pgl.sys.ces.b.a();
                sb = new StringBuilder();
                sb.append("SS-");
                sb.append(b.f65754a);
                a2.reportNow(sb.toString());
                aVar = this.f65760e;
                if (aVar == null) {
                    aVar.a(b.a());
                    return;
                }
                return;
            }
            i2++;
            f.a(i2 * 3 * 1000);
        }
        b.f65754a = i3;
        a2 = com.pgl.sys.ces.b.a();
        sb = new StringBuilder();
        sb.append("SS-");
        sb.append(b.f65754a);
        a2.reportNow(sb.toString());
        aVar = this.f65760e;
        if (aVar == null) {
        }
    }
}
