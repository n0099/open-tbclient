package d.m.b.a;

import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.pgl.sys.ces.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f66285a = 504;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f66286b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f66287c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f66288d = "";

    /* renamed from: e  reason: collision with root package name */
    public static Context f66289e;

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IXAdRequestInfo.OS, "Android");
            jSONObject.put("version", "1.0.5");
            if (f66288d == null || f66288d.length() <= 0) {
                jSONObject.put("token_id", a.meta(303, f66289e, null));
            } else {
                jSONObject.put("token_id", f66288d);
            }
            jSONObject.put("code", f66285a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable unused) {
            d.m.a.b.d.a("Call onEvent Error");
            return "";
        }
    }

    public static void b(Context context, String str, d.m.b.a.a.a aVar) {
        if (f66289e == null) {
            f66289e = context;
        }
        int i = f66285a;
        if (i == 102 || i == 202 || i == 200) {
            return;
        }
        System.currentTimeMillis();
        f66287c = str;
        f66285a = 102;
        Thread thread = new Thread(new d(context, aVar));
        thread.setName("CZL-3");
        thread.start();
    }
}
