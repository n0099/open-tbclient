package d.m.b.a;

import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.pgl.sys.ces.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f66440a = 504;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f66441b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f66442c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f66443d = "";

    /* renamed from: e  reason: collision with root package name */
    public static Context f66444e;

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdRequestParam.OS, "Android");
            jSONObject.put("version", "1.0.5");
            if (f66443d == null || f66443d.length() <= 0) {
                jSONObject.put("token_id", a.meta(303, f66444e, null));
            } else {
                jSONObject.put("token_id", f66443d);
            }
            jSONObject.put("code", f66440a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable unused) {
            d.m.a.b.d.a("Call onEvent Error");
            return "";
        }
    }

    public static void b(Context context, String str, d.m.b.a.a.a aVar) {
        if (f66444e == null) {
            f66444e = context;
        }
        int i2 = f66440a;
        if (i2 == 102 || i2 == 202 || i2 == 200) {
            return;
        }
        System.currentTimeMillis();
        f66442c = str;
        f66440a = 102;
        Thread thread = new Thread(new d(context, aVar));
        thread.setName("CZL-3");
        thread.start();
    }
}
