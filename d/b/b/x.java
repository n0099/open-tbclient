package d.b.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.AbstractBceClient;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class x {

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f64396b;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f64395a = {"GET", "POST"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f64397c = {"aid", "app_version", "tt_data"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f64398d = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", CommonUrlParamManager.PARAM_IID, "device_platform"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f64399e = {"tt_data", "device_platform"};

    /* renamed from: f  reason: collision with root package name */
    public static d.b.b.c2.a f64400f = d.b.b.c2.a.a(0);

    /* JADX WARN: Removed duplicated region for block: B:66:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String[] strArr, byte[] bArr, i iVar) {
        JSONObject jSONObject;
        int i2;
        HashMap hashMap = new HashMap(2);
        if (a.h()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", AbstractBceClient.DEFAULT_CONTENT_TYPE);
        }
        String str = null;
        for (String str2 : strArr) {
            str = c(1, str2, hashMap, bArr);
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        try {
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        if (TextUtils.isEmpty(str)) {
            jSONObject = null;
            i2 = 0;
            if (i2 == 200) {
            }
            return i2;
        }
        jSONObject = new JSONObject(str);
        try {
            i2 = jSONObject.optInt(ETAG.KEY_HTTP_CODE);
            if (i2 == 200) {
                if ("ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                    i2 = "success".equals(jSONObject.optString("message")) ? 200 : Integer.valueOf("101").intValue();
                } else {
                    i2 = Integer.valueOf(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY).intValue();
                }
            }
        } catch (JSONException e3) {
            e = e3;
            r0.b(e);
            i2 = 0;
            if (i2 == 200) {
            }
            return i2;
        }
        if (i2 == 200) {
            try {
                long optLong = jSONObject.optLong("server_time");
                if (optLong > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("server_time", optLong);
                    jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                    f64396b = jSONObject2;
                }
            } catch (Exception e4) {
                r0.b(e4);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(TableDefine.UserInfoColumns.COLUMN_BLACKLIST);
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("v1");
                int length = optJSONArray != null ? optJSONArray.length() : 0;
                HashSet<String> hashSet = new HashSet<>(length);
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3, null);
                    if (!TextUtils.isEmpty(optString)) {
                        hashSet.add(optString);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("v3");
                int length2 = optJSONArray2 != null ? optJSONArray2.length() : 0;
                HashSet<String> hashSet2 = new HashSet<>(length2);
                for (int i4 = 0; i4 < length2; i4++) {
                    String optString2 = optJSONArray2.optString(i4, null);
                    if (!TextUtils.isEmpty(optString2)) {
                        hashSet2.add(optString2);
                    }
                }
                iVar.t(hashSet, hashSet2);
            }
        }
        return i2;
    }

    public static d.b.b.c2.a b() {
        return f64400f;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(int i2, String str, HashMap<String, String> hashMap, byte[] bArr) {
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        String str2;
        String str3;
        DataOutputStream dataOutputStream2;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str4;
        if (r0.f64363b) {
            r0.a("http: " + str, null);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        r0.a("http headers key:" + entry.getKey() + " value:" + entry.getValue(), null);
                    }
                }
            }
            if (bArr != null) {
                r0.a("http data length:" + bArr.length, null);
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i2 == 0) {
                httpURLConnection.setDoOutput(false);
            } else if (i2 == 1) {
                httpURLConnection.setDoOutput(true);
            } else {
                r0.b(null);
            }
            httpURLConnection.setRequestMethod(f64395a[i2]);
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry2 : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                        httpURLConnection.addRequestProperty(entry2.getKey(), entry2.getValue());
                    } else {
                        r0.b(null);
                    }
                }
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream2 = null;
            } else {
                dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (Throwable th) {
                    bufferedReader = null;
                    str2 = null;
                    dataOutputStream = dataOutputStream2;
                    th = th;
                    try {
                        r0.b(th);
                        str3 = str2;
                        if (r0.f64363b) {
                        }
                        return str3;
                    } finally {
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                if (httpURLConnection.getContentLength() < 10240) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)));
                    } else {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                    }
                    try {
                        StringBuilder sb = new StringBuilder(inputStream.available());
                        while (true) {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(sb.toString());
                            jSONObject.put(ETAG.KEY_HTTP_CODE, 200);
                            str3 = jSONObject.toString();
                        } catch (Throwable th2) {
                            bufferedReader3 = bufferedReader2;
                            dataOutputStream = dataOutputStream2;
                            th = th2;
                            str2 = str4;
                            bufferedReader = bufferedReader3;
                            r0.b(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused3) {
                                }
                            }
                            str3 = str2;
                            if (r0.f64363b) {
                            }
                            return str3;
                        }
                    } catch (Throwable th3) {
                        str2 = null;
                        bufferedReader3 = bufferedReader2;
                        dataOutputStream = dataOutputStream2;
                        th = th3;
                    }
                } else {
                    r0.b(null);
                    bufferedReader2 = null;
                    str3 = null;
                }
            } else {
                String jSONObject2 = new JSONObject().put(ETAG.KEY_HTTP_CODE, responseCode).toString();
                try {
                    new RuntimeException("HttpCode:" + responseCode).printStackTrace();
                    str3 = jSONObject2;
                    bufferedReader2 = null;
                } catch (Throwable th4) {
                    str2 = jSONObject2;
                    dataOutputStream = dataOutputStream2;
                    th = th4;
                    bufferedReader = null;
                    r0.b(th);
                    str3 = str2;
                    if (r0.f64363b) {
                    }
                    return str3;
                }
            }
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException unused4) {
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream = null;
            bufferedReader = null;
            str2 = null;
        }
        if (r0.f64363b) {
            r0.a("http response: " + str3, null);
        }
        return str3;
    }

    public static String d(String str) {
        String[] strArr;
        if (!TextUtils.isEmpty(str) && a.h()) {
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            ArrayList<Pair> arrayList = new ArrayList();
            for (String str2 : f64397c) {
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    arrayList.add(new Pair(str2, queryParameter));
                }
            }
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.clearQuery();
            for (Pair pair : arrayList) {
                buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
            }
            buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(a.u(query), 8)));
            return buildUpon.build().toString();
        }
        return str;
    }

    public static String e(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    public static JSONObject f(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap(2);
        if (a.h()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", AbstractBceClient.DEFAULT_CONTENT_TYPE);
        }
        String c2 = c(1, d(str), hashMap, a.u(jSONObject.toString()));
        if (c2 != null) {
            try {
                return new JSONObject(c2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void g(int i2) {
        f64400f = d.b.b.c2.a.a(i2);
    }

    public static void h(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (sb.toString().indexOf(63) < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        sb.append(Uri.encode(str2));
    }

    public static boolean i(String str, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(str);
        float rawOffset = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
        if (rawOffset < -12.0f) {
            rawOffset = -12.0f;
        }
        if (rawOffset > 12.0f) {
            rawOffset = 12.0f;
        }
        h(sb, "timezone", rawOffset + "");
        JSONArray optJSONArray = jSONObject.optJSONArray("sim_serial_number");
        if (optJSONArray != null) {
            try {
                String optString = ((JSONObject) optJSONArray.get(0)).optString("sim_serial_number");
                for (int i2 = 1; i2 < optJSONArray.length(); i2++) {
                    optString = optString + "," + ((JSONObject) optJSONArray.get(i2)).optString("sim_serial_number");
                }
                h(sb, "sim_serial_number", optString);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        String c2 = c(0, d(sb.toString()), null, null);
        if (c2 != null) {
            try {
                jSONObject2 = new JSONObject(c2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return jSONObject2 != null && "success".equals(jSONObject2.optString("message", ""));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject j(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        boolean z = true;
        String c2 = c(1, str, null, a.u(jSONObject.toString()));
        if (c2 != null) {
            try {
                jSONObject2 = new JSONObject(c2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if ((jSONObject2 == null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) ? false : false) {
                return null;
            }
            return jSONObject2.optJSONObject("config");
        }
        jSONObject2 = null;
        if ((jSONObject2 == null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) ? false : false) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject k(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        boolean z = true;
        String c2 = c(1, str, null, a.u(jSONObject.toString()));
        if (c2 != null) {
            try {
                jSONObject2 = new JSONObject(c2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if ((jSONObject2 == null && "success".equals(jSONObject2.optString("message", ""))) ? false : false) {
                return null;
            }
            return jSONObject2.optJSONObject("data");
        }
        jSONObject2 = null;
        if ((jSONObject2 == null && "success".equals(jSONObject2.optString("message", ""))) ? false : false) {
        }
    }
}
