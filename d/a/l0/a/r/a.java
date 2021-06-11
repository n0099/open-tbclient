package d.a.l0.a.r;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.k;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47914a = k.f46875a;

    /* renamed from: d.a.l0.a.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0859a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f47915a;

        public C0859a(d.a.l0.a.v2.e1.b bVar) {
            this.f47915a = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f47915a.onCallback(null);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            a.i(response, this.f47915a);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f47916a;

        public b(d.a.l0.a.v2.e1.b bVar) {
            this.f47916a = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f47916a.onCallback(null);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            a.g(response, this.f47916a);
            return response;
        }
    }

    @Nullable
    public static Request c(d.a.l0.a.a2.e eVar, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity) {
        if (jSONObject == null) {
            q(unitedSchemeEntity, 202, "illegal entity");
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("stringMap");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("fileMap");
        String optString = jSONObject.optString("service");
        String optString2 = jSONObject.optString(RetrieveTaskManager.KEY);
        if (eVar != null && optJSONObject != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                type.addFormDataPart(next, optJSONObject.optString(next));
            }
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    String M = d.a.l0.a.k2.b.M(optJSONObject2.optString(next2), d.a.l0.a.a2.e.V());
                    if (!TextUtils.isEmpty(M)) {
                        File file = new File(M);
                        if (!file.exists()) {
                            q(unitedSchemeEntity, 1001, "upload file not exist");
                            return null;
                        } else if (file.length() > Config.FULL_TRACE_LOG_LIMIT) {
                            q(unitedSchemeEntity, 1001, "upload file too large");
                            return null;
                        } else {
                            type.addFormDataPart(next2, file.getName(), new h(file));
                        }
                    }
                }
            }
            String D = eVar.D();
            long a2 = d.a.l0.a.c1.a.k().a(AppRuntime.getAppContext());
            String r = r(optJSONObject, D, a2, d.a.l0.a.c1.a.a0().f(AppRuntime.getAppContext()));
            if (r == null) {
                q(unitedSchemeEntity, 1001, "sign error");
                return null;
            }
            HttpUrl parse = HttpUrl.parse(d.a.l0.a.c1.a.l().processUrl(d.a.l0.a.c1.a.n().L() + "/" + optString + optString2));
            if (parse == null) {
                q(unitedSchemeEntity, 1001, "request url error");
                return null;
            }
            HttpUrl.Builder newBuilder = parse.newBuilder();
            newBuilder.addQueryParameter("ai_sign", r);
            newBuilder.addQueryParameter(Constants.API_KEY, D);
            newBuilder.addQueryParameter("timestamp", String.valueOf(a2));
            newBuilder.addQueryParameter("host_app", d.a.l0.n.c.b().c());
            newBuilder.addQueryParameter("host_app_ver", d.a.l0.n.c.b().i());
            newBuilder.addQueryParameter("sdk_ver", d.a.l0.n.c.b().b());
            newBuilder.addQueryParameter("host_os", d.a.l0.t.a.f());
            newBuilder.addQueryParameter("host_os_ver", d.a.l0.t.a.g());
            Request.Builder post = new Request.Builder().url(newBuilder.build()).post(type.build());
            String d2 = d.a.l0.a.c1.a.a0().d(AppRuntime.getAppContext());
            String str = "BDUSS=" + d2;
            if (!TextUtils.isEmpty(d2)) {
                post.addHeader("Cookie", str);
            }
            return post.build();
        }
        q(unitedSchemeEntity, 202, "illegal request");
        return null;
    }

    public static void d(String str, d.a.l0.a.v2.e1.b<String> bVar) {
        if (!TextUtils.isEmpty(str) && str.startsWith("cloud")) {
            URI create = URI.create(str);
            String host = create.getHost();
            if (TextUtils.isEmpty(create.toString()) && TextUtils.isEmpty(host)) {
                bVar.onCallback(null);
                return;
            }
            Request c2 = c(d.a.l0.a.a2.e.i(), h(str), null);
            if (d.a.l0.a.a2.e.i() == null) {
                bVar.onCallback(null);
                return;
            } else {
                p(c2.url().toString(), c2.body(), new C0859a(bVar));
                return;
            }
        }
        bVar.onCallback(null);
    }

    public static void e(JSONArray jSONArray, d.a.l0.a.v2.e1.b<String> bVar) {
        if (jSONArray != null && jSONArray.length() > 0) {
            Request c2 = c(d.a.l0.a.a2.e.i(), f(jSONArray.toString()), null);
            if (d.a.l0.a.a2.e.i() == null) {
                bVar.onCallback(null);
                return;
            } else {
                p(c2.url().toString(), c2.body(), new b(bVar));
                return;
            }
        }
        bVar.onCallback(null);
    }

    public static JSONObject f(String str) {
        return l(str, null);
    }

    public static void g(Response response, d.a.l0.a.v2.e1.b<String> bVar) {
        String header = response.header("Content-Type", "");
        if (header == null || !header.contains("application/json")) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (response.body() != null) {
            try {
                jSONObject = new JSONObject(response.body().string());
            } catch (IOException e2) {
                if (f47914a) {
                    e2.printStackTrace();
                }
                bVar.onCallback(null);
            } catch (JSONException e3) {
                if (f47914a) {
                    e3.printStackTrace();
                }
                bVar.onCallback(null);
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("fileList");
        if (optJSONArray == null) {
            bVar.onCallback(null);
        } else {
            bVar.onCallback(optJSONArray.toString());
        }
    }

    public static JSONObject h(String str) {
        return l(null, str);
    }

    public static void i(Response response, d.a.l0.a.v2.e1.b<String> bVar) {
        try {
            String header = response.header("Content-Type", "");
            if (header == null || !header.contains("application/json")) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (response.body() != null) {
                jSONObject = new JSONObject(response.body().string());
            }
            String optString = jSONObject.optString("DownloadUrl");
            if (!TextUtils.isEmpty(optString)) {
                bVar.onCallback(optString);
            } else {
                bVar.onCallback(null);
            }
        } catch (Exception unused) {
            bVar.onCallback(null);
        }
    }

    public static int j(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1001;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            if (f47914a) {
                e2.printStackTrace();
            }
            return 1001;
        }
    }

    public static String k(String str) {
        return TextUtils.isEmpty(str) ? "请求失败" : str;
    }

    public static JSONObject l(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("fileID", str2);
                jSONObject.put(RetrieveTaskManager.KEY, "/v1/workspace/storage/request-download");
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(RetrieveTaskManager.KEY, "/v1/workspace/storage/batch-download");
                jSONObject2.put("fileList", str);
            }
            jSONObject.put("service", "cloud");
            jSONObject.put("stringMap", jSONObject2);
        } catch (JSONException e2) {
            if (f47914a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject m(Response response) {
        try {
            return new JSONObject(response.body() != null ? response.body().string() : null);
        } catch (IOException e2) {
            if (f47914a) {
                e2.printStackTrace();
            }
            return null;
        } catch (JSONException e3) {
            if (f47914a) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    public static JSONObject n(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", str3);
            jSONObject.put("statusCode", 200);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("fileID", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("tempFilePath", str2);
            }
        } catch (JSONException e2) {
            if (f47914a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static boolean o(String str) {
        return j(str) != 0;
    }

    public static void p(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(str, requestBody, responseCallback);
        aVar.f51648f = true;
        aVar.f51649g = true;
        aVar.f51650h = true;
        d.a.l0.m.e.a.g().e(aVar);
    }

    public static void q(UnitedSchemeEntity unitedSchemeEntity, int i2, String str) {
        if (unitedSchemeEntity == null) {
            return;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i2, str);
    }

    public static String r(JSONObject jSONObject, String str, long j, String str2) {
        try {
            Iterator<String> keys = jSONObject.keys();
            ArrayList<String> arrayList = new ArrayList();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            for (String str3 : arrayList) {
                String optString = jSONObject.optString(str3);
                sb.append(URLEncoder.encode(str3));
                sb.append("=");
                sb.append(URLEncoder.encode(optString));
                sb.append("&");
            }
            String sb2 = sb.toString();
            if (sb2.endsWith("&")) {
                sb2 = sb2.substring(0, sb2.length() - 1);
            }
            String d2 = d.a.l0.t.f.d(sb2.getBytes(), false);
            byte[] copyOf = Arrays.copyOf(Base64.decode(d.a.l0.t.f.d(str.getBytes(), false), 0), 24);
            byte[] copyOf2 = Arrays.copyOf(Base64.decode(d.a.l0.t.f.d(String.format("%s%d", str2, Long.valueOf(j)).getBytes(), false).getBytes(), 0), 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, new SecretKeySpec(copyOf, "AES"), new IvParameterSpec(copyOf2));
            String str4 = new String(Base64.encode(cipher.doFinal(d2.getBytes()), 0), StandardCharsets.UTF_8);
            return str4.endsWith("\n") ? str4.substring(0, str4.length() - 1) : str4;
        } catch (Exception unused) {
            return null;
        }
    }
}
