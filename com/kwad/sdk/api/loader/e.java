package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f56995b;

    /* renamed from: c  reason: collision with root package name */
    public int f56996c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f56997d;

    /* renamed from: e  reason: collision with root package name */
    public IKsAdSDK f56998e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(a.b bVar);

        void a(Exception exc);
    }

    public e(String str, IKsAdSDK iKsAdSDK) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iKsAdSDK};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56997d = new HashMap();
        this.f56995b = str;
        this.a = str;
        this.f56998e = iKsAdSDK;
    }

    private String a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String valueOf = String.valueOf(Loader.get().a(Loader.get().getContext()));
            IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
            if (ksAdSDKImpl != null) {
                if (TextUtils.isEmpty(valueOf)) {
                    valueOf = ksAdSDKImpl.getSDKVersion();
                }
                i2 = ksAdSDKImpl.getSDKVersionCode();
            } else {
                i2 = -1;
            }
            JSONObject appInfo = Loader.get().getKsAdSDKImpl().getAppInfo();
            JSONObject deviceInfo = Loader.get().getKsAdSDKImpl().getDeviceInfo();
            JSONObject networkInfo = Loader.get().getKsAdSDKImpl().getNetworkInfo();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdkApiVersion", "3.3.17.4");
                jSONObject.put("sdkApiVersionCode", 3031704);
                jSONObject.put(CommandMessage.SDK_VERSION, valueOf);
                jSONObject.put("SDKVersionCode", i2);
                jSONObject.put("sdkType", 1);
                jSONObject.put(DI.APP_INFO_NAME, appInfo);
                jSONObject.put(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, deviceInfo);
                jSONObject.put("networkInfo", networkInfo);
                jSONObject.put("sdkAbi", s.b());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (this.f56998e != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("version", "3.3.17.4");
                    jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, appInfo.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                    jSONObject2.put("message", this.f56998e.getRM(jSONObject.toString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                this.f56998e.sR(this.f56995b.replace("https://open.e.kuaishou.com", ""), this.f56997d, jSONObject2.toString());
                return jSONObject2.toString();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                            return null;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
            }
            return new String(byteArrayOutputStream.toByteArray());
        }
        return (String) invokeL.objValue;
    }

    private URLConnection a(String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            URLConnection openConnection = new URL(str).openConnection();
            TLSConnectionUtils.wrapHttpURLConnection(openConnection);
            a("Accept-Language", "zh-CN");
            if (i2 > 0) {
                openConnection.setConnectTimeout(i2);
            }
            if (i3 > 0) {
                openConnection.setReadTimeout(i3);
            }
            openConnection.setUseCaches(z);
            openConnection.setDoInput(true);
            a(HTTP.CONN_DIRECTIVE, "keep-alive");
            a(BOSTokenRequest.CHARSET, "UTF-8");
            return openConnection;
        }
        return (URLConnection) invokeCommon.objValue;
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, str, str2) == null) {
            this.f56997d.put(str, str2);
        }
    }

    @Nullable
    private HttpURLConnection b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) a(this.a, 10000, 30000, false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setInstanceFollowRedirects(true);
            a("Content-Type", "application/json; charset=UTF-8");
            a("User-Agent", RequestParamsUtils.getUserAgent());
            IKsAdSDK iKsAdSDK = this.f56998e;
            if (iKsAdSDK != null) {
                iKsAdSDK.addHp(this.f56997d);
            }
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65543, this, aVar) != null) {
            return;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = b();
                if (httpURLConnection != null) {
                    String a2 = a();
                    if (this.f56997d != null) {
                        for (Map.Entry<String, String> entry : this.f56997d.entrySet()) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    httpURLConnection.connect();
                    new DataOutputStream(httpURLConnection.getOutputStream()).write(a2.getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String a3 = a(httpURLConnection.getInputStream());
                        a.b bVar = new a.b();
                        JSONObject jSONObject = new JSONObject(a3);
                        if (this.f56998e != null) {
                            jSONObject.put("data", new JSONObject(this.f56998e.getRD(jSONObject.optString("data"))));
                        }
                        bVar.a(jSONObject);
                        aVar.a(bVar);
                    } else if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = " + responseCode);
                    } else if (this.f56996c < 21) {
                        this.a = httpURLConnection.getHeaderField("Location");
                        this.f56996c++;
                        b(aVar);
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                aVar.a(e2);
                if (0 == 0) {
                    return;
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            i.a(new Runnable(this, aVar) { // from class: com.kwad.sdk.api.loader.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f56999b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f56999b = this;
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f56999b.b(this.a);
                    }
                }
            });
        }
    }
}
