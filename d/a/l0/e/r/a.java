package d.a.l0.e.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;
import d.a.l0.a.d0.c;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.u2.a;
import d.a.l0.a.v2.o0;
import d.a.l0.t.f;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpDate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.u2.a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46617a = k.f43199a;

    /* renamed from: d.a.l0.e.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0973a extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0873a f46618a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46619b;

        public C0973a(a aVar, a.InterfaceC0873a interfaceC0873a, String str) {
            this.f46618a = interfaceC0873a;
            this.f46619b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            a.InterfaceC0873a interfaceC0873a = this.f46618a;
            if (interfaceC0873a != null) {
                interfaceC0873a.c(jSONObject, this.f46619b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            String string = response.body().string();
            a.f(response, System.currentTimeMillis());
            return new JSONObject(string);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.InterfaceC0873a interfaceC0873a = this.f46618a;
            if (interfaceC0873a != null) {
                interfaceC0873a.c(null, null);
            }
        }
    }

    public static String c(String str, String str2) {
        return f.d((str + System.currentTimeMillis() + str2).getBytes(), false);
    }

    public static String d(Context context) {
        return context.getExternalCacheDir() + File.separator + "favor_screenshot" + File.separator;
    }

    public static RequestBody e(String str) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oname_list", jSONArray);
            return RequestBody.create(d.a.l0.a.n1.f.f43693a, jSONObject.toString());
        } catch (JSONException e2) {
            if (f46617a) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static void f(Response response, long j) {
        Date parse;
        String header = response.header("Date");
        if (TextUtils.isEmpty(header) || (parse = HttpDate.parse(header)) == null) {
            return;
        }
        long time = parse.getTime();
        if (time >= 1) {
            long j2 = j - time;
            h.a().putLong("server_time_delta", j2);
            if (f46617a) {
                Log.i("getServerTimeDelta", "deltaTime sDate:" + parse + "  sTime:" + time + "   diff:" + j2);
            }
        }
    }

    @Override // d.a.l0.a.u2.a
    public boolean a(String str, d.a.l0.a.j1.d.a aVar) {
        PutObjectResponse putObject;
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.f43084a) && !TextUtils.isEmpty(aVar.f43085b) && !TextUtils.isEmpty(aVar.f43086c) && !TextUtils.isEmpty(aVar.f43089f)) {
            try {
                BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
                bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(aVar.f43084a, aVar.f43085b, aVar.f43086c));
                bosClientConfiguration.setEndpoint("bj.bcebos.com");
                BosClient bosClient = new BosClient(bosClientConfiguration);
                File file = new File(str);
                if (file.exists() && (putObject = bosClient.putObject(new PutObjectRequest(aVar.f43087d, aVar.f43089f, file))) != null) {
                    if (!TextUtils.isEmpty(putObject.getETag())) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                if (f46617a) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override // d.a.l0.a.u2.a
    public void b(Context context, String str, a.InterfaceC0873a interfaceC0873a) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        String v = c.v(d.a.l0.a.c1.a.n().e());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        for (Map.Entry<String, String> entry : d.a.l0.a.d0.b.b().f41308d.entrySet()) {
            v = o0.a(v, entry.getKey(), entry.getValue());
        }
        String c2 = c(d(context), str.substring(str.lastIndexOf(".")));
        RequestBody e2 = e(c2);
        if (e2 == null) {
            return;
        }
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(v, e2, new C0973a(this, interfaceC0873a, c2));
        if (d.a.l0.m.e.a.g().c()) {
            aVar.f47974f = true;
        }
        aVar.f47975g = false;
        aVar.f47971c = hashMap;
        d.a.l0.m.e.a.g().e(aVar);
    }
}
