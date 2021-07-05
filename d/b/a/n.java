package d.b.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.embedapplog.AppLog;
import com.yy.hiidostatis.inner.BaseStatisContent;
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
/* loaded from: classes10.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f71703a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f71704b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f71705c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f71706d;

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f71707e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-125210657, "Ld/b/a/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-125210657, "Ld/b/a/n;");
                return;
            }
        }
        f71703a = new String[]{"GET", "POST"};
        f71705c = new String[]{"aid", "app_version", "tt_data"};
        f71706d = new String[]{"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", CommonUrlParamManager.PARAM_IID, "device_platform"};
        f71707e = new String[]{"tt_data", "device_platform"};
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String[] strArr, byte[] bArr, y1 y1Var) {
        InterceptResult invokeLLL;
        JSONObject jSONObject;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, strArr, bArr, y1Var)) == null) {
            HashMap hashMap = new HashMap(2);
            if (AppLog.getEncryptAndCompress()) {
                hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
            } else {
                hashMap.put("Content-Type", "application/json; charset=utf-8");
            }
            String str = null;
            for (String str2 : strArr) {
                str = b(1, str2, hashMap, bArr);
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
                i2 = jSONObject.optInt("http_code");
                if (i2 == 200) {
                    if ("ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                        i2 = "success".equals(jSONObject.optString("message")) ? 200 : Integer.valueOf("101").intValue();
                    } else {
                        i2 = Integer.valueOf("102").intValue();
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                h0.b(e);
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
                        f71704b = jSONObject2;
                    }
                } catch (Exception e4) {
                    h0.b(e4);
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
                    y1Var.u(hashSet, hashSet2);
                }
            }
            return i2;
        }
        return invokeLLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(int i2, String str, HashMap<String, String> hashMap, byte[] bArr) {
        InterceptResult invokeCommon;
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        String str2;
        String str3;
        DataOutputStream dataOutputStream2;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), str, hashMap, bArr})) == null) {
            if (h0.f71677b) {
                h0.a("http: " + str, null);
                if (hashMap != null) {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                            h0.a("http headers key:" + entry.getKey() + " value:" + entry.getValue(), null);
                        }
                    }
                }
                if (bArr != null) {
                    h0.a("http data length:" + bArr.length, null);
                }
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                if (i2 == 0) {
                    httpURLConnection.setDoOutput(false);
                } else if (i2 == 1) {
                    httpURLConnection.setDoOutput(true);
                } else {
                    h0.b(null);
                }
                httpURLConnection.setRequestMethod(f71703a[i2]);
                if (hashMap != null && !hashMap.isEmpty()) {
                    for (Map.Entry<String, String> entry2 : hashMap.entrySet()) {
                        if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                            httpURLConnection.addRequestProperty(entry2.getKey(), entry2.getValue());
                        } else {
                            h0.b(null);
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
                            h0.b(th);
                            str3 = str2;
                            if (h0.f71677b) {
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
                                jSONObject.put("http_code", 200);
                                str3 = jSONObject.toString();
                            } catch (Throwable th2) {
                                bufferedReader3 = bufferedReader2;
                                dataOutputStream = dataOutputStream2;
                                th = th2;
                                str2 = str4;
                                bufferedReader = bufferedReader3;
                                h0.b(th);
                                str3 = str2;
                                if (h0.f71677b) {
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
                        h0.b(null);
                        bufferedReader2 = null;
                        str3 = null;
                    }
                } else {
                    String jSONObject2 = new JSONObject().put("http_code", responseCode).toString();
                    try {
                        new RuntimeException("HttpCode:" + responseCode).printStackTrace();
                        str3 = jSONObject2;
                        bufferedReader2 = null;
                    } catch (Throwable th4) {
                        str2 = jSONObject2;
                        dataOutputStream = dataOutputStream2;
                        th = th4;
                        bufferedReader = null;
                        h0.b(th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        str3 = str2;
                        if (h0.f71677b) {
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
            if (h0.f71677b) {
                h0.a("http response: " + str3, null);
            }
            return str3;
        }
        return (String) invokeCommon.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && AppLog.getEncryptAndCompress()) {
                Uri parse = Uri.parse(str);
                String query = parse.getQuery();
                ArrayList<Pair> arrayList = new ArrayList();
                for (String str2 : f71705c) {
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
                buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(AppLog.toEncryptByte(query), 8)));
                return buildUpon.build().toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, strArr)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public static JSONObject e(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, jSONObject)) == null) {
            HashMap hashMap = new HashMap(2);
            if (AppLog.getEncryptAndCompress()) {
                hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
            } else {
                hashMap.put("Content-Type", "application/json; charset=utf-8");
            }
            String b2 = b(1, c(str), hashMap, AppLog.toEncryptByte(jSONObject.toString()));
            if (b2 != null) {
                try {
                    return new JSONObject(b2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void f(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, sb, str, str2) == null) || sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
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

    public static boolean g(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, jSONObject)) == null) {
            StringBuilder sb = new StringBuilder(str);
            float rawOffset = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
            if (rawOffset < -12.0f) {
                rawOffset = -12.0f;
            }
            if (rawOffset > 12.0f) {
                rawOffset = 12.0f;
            }
            f(sb, BaseStatisContent.TIMEZONE, rawOffset + "");
            JSONArray optJSONArray = jSONObject.optJSONArray("sim_serial_number");
            if (optJSONArray != null) {
                try {
                    String optString = ((JSONObject) optJSONArray.get(0)).optString("sim_serial_number");
                    for (int i2 = 1; i2 < optJSONArray.length(); i2++) {
                        optString = optString + "," + ((JSONObject) optJSONArray.get(i2)).optString("sim_serial_number");
                    }
                    f(sb, "sim_serial_number", optString);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            JSONObject jSONObject2 = null;
            String b2 = b(0, c(sb.toString()), null, null);
            if (b2 != null) {
                try {
                    jSONObject2 = new JSONObject(b2);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return jSONObject2 != null && "success".equals(jSONObject2.optString("message", ""));
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject h(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, str, jSONObject)) != null) {
            return (JSONObject) invokeLL.objValue;
        }
        boolean z = true;
        String b2 = b(1, str, null, AppLog.toEncryptByte(jSONObject.toString()));
        if (b2 != null) {
            try {
                jSONObject2 = new JSONObject(b2);
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject i(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65545, null, str, jSONObject)) != null) {
            return (JSONObject) invokeLL.objValue;
        }
        boolean z = true;
        String b2 = b(1, str, null, AppLog.toEncryptByte(jSONObject.toString()));
        if (b2 != null) {
            try {
                jSONObject2 = new JSONObject(b2);
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
