package d.a.d0.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.prologue.service.network.Als;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43462a = d.a.d0.a.b.a.f43374a.get().s();

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f43463b = {"deeplink", "open"};

    /* loaded from: classes2.dex */
    public class a implements b {
        public a(i iVar, d.a.d0.c.a aVar) {
        }
    }

    @Override // d.a.d0.c.e
    public void a(HashMap<String, String> hashMap) {
        String[] strArr;
        for (String str : f43463b) {
            hashMap.put("splash/ad/" + str, "splash_ad/" + str);
        }
    }

    @Override // d.a.d0.c.e
    @SuppressLint({"LongLogTag"})
    public boolean c(Context context, g gVar, d.a.d0.c.a aVar) {
        String e2 = gVar.e(true);
        if (!TextUtils.isEmpty(e2) && context != null) {
            if (gVar.g()) {
                return true;
            }
            if (f43462a) {
                Log.e("UnitedSchemeSplashDispatcher", "invoke: " + gVar.f().toString());
            }
            char c2 = 65535;
            int hashCode = e2.hashCode();
            if (hashCode != 3417674) {
                if (hashCode == 629233382 && e2.equals("deeplink")) {
                    c2 = 0;
                }
            } else if (e2.equals("open")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (f43462a) {
                        throw new IllegalStateException("scheme action 不支持错误");
                    }
                    return false;
                }
                return f(gVar, aVar);
            }
            return e(context, gVar, aVar);
        }
        gVar.m = j.h(201);
        return false;
    }

    public final boolean e(@NonNull Context context, @NonNull g gVar, d.a.d0.c.a aVar) {
        String str = gVar.d().get("params");
        if (TextUtils.isEmpty(str)) {
            if (f43462a) {
                throw new IllegalStateException("action deeplink 没有params参数");
            }
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appUrl");
            String optString2 = jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL);
            String optString3 = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
            if (!TextUtils.isEmpty(optString) && d.a.d0.a.c.i.b(context, optString)) {
                h(Als.Area.DEEPLINK_RESULT_APP);
                return true;
            } else if (!TextUtils.isEmpty(optString3) && d.a.d0.a.c.i.a(context, optString3)) {
                h(Als.Area.DEEPLINK_RESULT_APP);
                return true;
            } else if (TextUtils.isEmpty(optString2)) {
                return false;
            } else {
                h(Als.Area.DEEPLINK_RESULT_H5);
                return g(optString2, aVar);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean f(g gVar, d.a.d0.c.a aVar) {
        String str = gVar.d().get("params");
        if (TextUtils.isEmpty(str)) {
            if (f43462a) {
                throw new IllegalStateException("action deeplink 没有params参数");
            }
            return false;
        }
        try {
            return g(new JSONObject(str).optString(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL), aVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean g(@NonNull String str, d.a.d0.c.a aVar) {
        return d.a.d0.a.b.a.f43374a.get().v(str, new a(this, aVar));
    }

    public final void h(Als.Area area) {
        if (!TextUtils.isEmpty(d.a.d0.b.g.c.f43423a)) {
            Als.c cVar = new Als.c(Als.Type.DEEP_LINK);
            cVar.i(Als.Page.NA_DEEPLINK);
            cVar.e(area);
            cVar.j(d.a.d0.b.g.c.f43423a);
            Als.e(cVar);
        } else if (f43462a) {
            throw new IllegalStateException("全局数据仓库获取数据失败，打点失败...");
        }
    }
}
