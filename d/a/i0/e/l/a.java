package d.a.i0.e.l;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import d.a.i0.a.k;
import d.a.i0.a.z1.b.f.e;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46367a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f46368b = SchemeConfig.getSchemeHead() + "://";

    /* renamed from: d.a.i0.e.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0953a extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public Response f46369a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46370b;

        public C0953a(String str) {
            this.f46370b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (a.f46367a) {
                Log.d("SwanAppExchanger", "startLaunchAction onSuccess result: " + str);
                Log.d("SwanAppExchanger", "startLaunchAction onSuccess status: " + i2);
            }
            if (i2 != 200) {
                String f2 = a.f(this.f46369a);
                if (!TextUtils.isEmpty(f2)) {
                    b.a(f2);
                    return;
                }
                a.d("get launch scheme fail: request fail with code " + i2, this.f46370b, str, true);
                return;
            }
            try {
                b.a(new JSONObject(str).optString("data"));
            } catch (JSONException e2) {
                e2.printStackTrace();
                a.d("get launch scheme fail: " + e2.getMessage(), this.f46370b, str, false);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.d("get launch scheme fail: network err with exception: " + exc.getMessage(), this.f46370b, "", true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.StringResponseCallback, com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            this.f46369a = response;
            return super.parseResponse(response, i2);
        }
    }

    public static void d(String str, String str2, String str3, boolean z) {
        if (z) {
            e.g(AppRuntime.getAppContext(), "打开失败，请检查网络设置").F();
        }
        d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
        aVar.j(1L);
        aVar.h(12L);
        aVar.e(str);
        d.a.i0.a.q2.e.a().f(aVar);
        if (f46367a) {
            Log.w("SwanAppExchanger", "open aiapp fail, url : " + str2);
        }
    }

    public static void e(String str) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().setHeader("Swan-Accept", "swan/json").userAgent(d.a.i0.a.s2.a.a()).url(str).build().executeAsyncOnUIBack(new C0953a(str));
    }

    public static String f(Response response) {
        if (response == null) {
            return null;
        }
        String header = response.header("Location");
        if (!TextUtils.isEmpty(header) && header.startsWith("baiduboxapp://")) {
            return header.replace("baiduboxapp://", f46368b);
        }
        return null;
    }
}
