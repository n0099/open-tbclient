package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
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
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71420a;

    /* renamed from: b  reason: collision with root package name */
    public String f71421b;

    /* renamed from: c  reason: collision with root package name */
    public int f71422c;

    /* loaded from: classes10.dex */
    public interface a {
        void a(a.b bVar);

        void a(Exception exc);
    }

    public e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71421b = str;
        this.f71420a = str;
    }

    private String a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Context context = Loader.get().getContext();
            int i3 = com.kwad.sdk.api.a.f71379a;
            String valueOf = String.valueOf(Loader.get().a(context));
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
                jSONObject.put("sdkApiVersion", "3.3.11");
                jSONObject.put("sdkApiVersionCode", 3031100);
                jSONObject.put(CommandMessage.SDK_VERSION, valueOf);
                jSONObject.put("SDKVersionCode", i2);
                jSONObject.put("sdkType", i3);
                jSONObject.put(DI.APP_INFO_NAME, appInfo);
                jSONObject.put(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, deviceInfo);
                jSONObject.put("networkInfo", networkInfo);
                jSONObject.put("sdkAbi", s.b());
            } catch (JSONException e2) {
                e2.printStackTrace();
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
            openConnection.setRequestProperty("Accept-Language", "zh-CN");
            if (i2 > 0) {
                openConnection.setConnectTimeout(i2);
            }
            if (i3 > 0) {
                openConnection.setReadTimeout(i3);
            }
            openConnection.setUseCaches(z);
            openConnection.setDoInput(true);
            openConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            openConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
            return openConnection;
        }
        return (URLConnection) invokeCommon.objValue;
    }

    @Nullable
    private HttpURLConnection b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (TextUtils.isEmpty(this.f71420a)) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) a(this.f71420a, 10000, 30000, false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.setRequestProperty("User-Agent", RequestParamsUtils.getUserAgent());
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, aVar) != null) {
            return;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = b();
                if (httpURLConnection != null) {
                    httpURLConnection.connect();
                    new DataOutputStream(httpURLConnection.getOutputStream()).write(a().getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String a2 = a(httpURLConnection.getInputStream());
                        a.b bVar = new a.b();
                        bVar.a(new JSONObject(a2));
                        aVar.a(bVar);
                    } else if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = " + responseCode);
                    } else if (this.f71422c < 21) {
                        this.f71420a = httpURLConnection.getHeaderField("Location");
                        this.f71422c++;
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f71423a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f71424b;

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
                    this.f71424b = this;
                    this.f71423a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f71424b.b(this.f71423a);
                    }
                }
            });
        }
    }
}
