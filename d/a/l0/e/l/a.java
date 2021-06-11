package d.a.l0.e.l;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import d.a.l0.a.k;
import d.a.l0.a.z1.b.f.e;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50217a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f50218b = SchemeConfig.getSchemeHead() + "://";

    /* renamed from: d.a.l0.e.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1020a extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public Response f50219a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50220b;

        public C1020a(String str) {
            this.f50220b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (a.f50217a) {
                Log.d("SwanAppExchanger", "startLaunchAction onSuccess result: " + str);
                Log.d("SwanAppExchanger", "startLaunchAction onSuccess status: " + i2);
            }
            if (i2 != 200) {
                String f2 = a.f(this.f50219a);
                if (!TextUtils.isEmpty(f2)) {
                    b.a(f2);
                    return;
                }
                a.d("get launch scheme fail: request fail with code " + i2, this.f50220b, str, true);
                return;
            }
            try {
                b.a(new JSONObject(str).optString("data"));
            } catch (JSONException e2) {
                e2.printStackTrace();
                a.d("get launch scheme fail: " + e2.getMessage(), this.f50220b, str, false);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.d("get launch scheme fail: network err with exception: " + exc.getMessage(), this.f50220b, "", true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.StringResponseCallback, com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            this.f50219a = response;
            return super.parseResponse(response, i2);
        }
    }

    public static void d(String str, String str2, String str3, boolean z) {
        if (z) {
            e.g(AppRuntime.getAppContext(), "打开失败，请检查网络设置").F();
        }
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(1L);
        aVar.h(12L);
        aVar.e(str);
        d.a.l0.a.q2.e.a().f(aVar);
        if (f50217a) {
            Log.w("SwanAppExchanger", "open aiapp fail, url : " + str2);
        }
    }

    public static void e(String str) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().setHeader("Swan-Accept", "swan/json").userAgent(d.a.l0.a.s2.a.a()).url(str).build().executeAsyncOnUIBack(new C1020a(str));
    }

    public static String f(Response response) {
        if (response == null) {
            return null;
        }
        String header = response.header("Location");
        if (!TextUtils.isEmpty(header) && header.startsWith("baiduboxapp://")) {
            return header.replace("baiduboxapp://", f50218b);
        }
        return null;
    }
}
