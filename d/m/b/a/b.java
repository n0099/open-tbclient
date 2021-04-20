package d.m.b.a;

import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.pgl.sys.ces.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f67278a = 504;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f67279b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f67280c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f67281d = "";

    /* renamed from: e  reason: collision with root package name */
    public static Context f67282e;

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdRequestParam.OS, "Android");
            jSONObject.put("version", "1.0.5");
            if (f67281d == null || f67281d.length() <= 0) {
                jSONObject.put("token_id", a.meta(303, f67282e, null));
            } else {
                jSONObject.put("token_id", f67281d);
            }
            jSONObject.put("code", f67278a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable unused) {
            d.m.a.b.d.a("Call onEvent Error");
            return "";
        }
    }

    public static void b(Context context, String str, d.m.b.a.a.a aVar) {
        if (f67282e == null) {
            f67282e = context;
        }
        int i = f67278a;
        if (i == 102 || i == 202 || i == 200) {
            return;
        }
        System.currentTimeMillis();
        f67280c = str;
        f67278a = 102;
        Thread thread = new Thread(new d(context, aVar));
        thread.setName("CZL-3");
        thread.start();
    }
}
