package d.n.b.a;

import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.pgl.sys.ces.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f67425a = 504;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f67426b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f67427c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f67428d = "";

    /* renamed from: e  reason: collision with root package name */
    public static Context f67429e;

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdRequestParam.OS, "Android");
            jSONObject.put("version", "1.0.5");
            if (f67428d == null || f67428d.length() <= 0) {
                jSONObject.put("token_id", a.meta(303, f67429e, null));
            } else {
                jSONObject.put("token_id", f67428d);
            }
            jSONObject.put("code", f67425a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable unused) {
            d.n.a.b.d.a("Call onEvent Error");
            return "";
        }
    }

    public static void b(Context context, String str, d.n.b.a.a.a aVar) {
        if (f67429e == null) {
            f67429e = context;
        }
        int i = f67425a;
        if (i == 102 || i == 202 || i == 200) {
            return;
        }
        System.currentTimeMillis();
        f67427c = str;
        f67425a = 102;
        Thread thread = new Thread(new d(context, aVar));
        thread.setName("CZL-3");
        thread.start();
    }
}
