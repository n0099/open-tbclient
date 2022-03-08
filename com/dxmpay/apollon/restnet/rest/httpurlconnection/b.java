package com.dxmpay.apollon.restnet.rest.httpurlconnection;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.RestDebugConfig;
import com.dxmpay.apollon.restnet.RestMultipartEntity;
import com.dxmpay.apollon.restnet.a;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.apollon.utils.LogUtil;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
/* loaded from: classes7.dex */
public class b implements com.dxmpay.apollon.restnet.rest.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f52287b;

    /* renamed from: c  reason: collision with root package name */
    public RestUrlConnectionRequest f52288c;

    /* renamed from: d  reason: collision with root package name */
    public URLConnection f52289d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52290e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52291f;

    public b(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52291f = false;
        this.a = context.getApplicationContext();
        this.f52287b = str;
        this.f52291f = z;
    }

    private e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, url)) == null) {
            a(this.f52289d);
            return a(url, this.f52289d, "GET");
        }
        return (e) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod("install", File.class, Long.TYPE).invoke(null, new File(this.a.getDir("appcache", 0), "http"), 10485760L);
            } catch (Exception unused) {
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod(IntentConfig.CLOSE, new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.dxmpay.apollon.restnet.rest.c
    public e a(com.dxmpay.apollon.restnet.rest.d dVar) throws MalformedURLException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            this.f52288c = (RestUrlConnectionRequest) dVar;
            String b2 = dVar.b();
            if (this.f52288c.k()) {
                b2 = a(b2);
            }
            URL url = new URL(b2);
            this.f52289d = url.openConnection();
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                if (RestDebugConfig.getInstance().isQAEnv()) {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, new TrustManager[]{new a()}, null);
                    ((HttpsURLConnection) this.f52289d).setSSLSocketFactory(sSLContext.getSocketFactory());
                    ((HttpsURLConnection) this.f52289d).setHostnameVerifier(new HostnameVerifier(this) { // from class: com.dxmpay.apollon.restnet.rest.httpurlconnection.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ b a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str, SSLSession sSLSession) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) {
                                return true;
                            }
                            return invokeLL.booleanValue;
                        }
                    });
                } else {
                    a((HttpsURLConnection) this.f52289d);
                    b((HttpsURLConnection) this.f52289d);
                }
            }
            LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "con url: " + url + ", host: " + this.f52289d.getURL().getHost());
            if (this.f52288c.j()) {
                return a(url);
            }
            if (this.f52288c.k()) {
                return b(url);
            }
            return null;
        }
        return (e) invokeL.objValue;
    }

    private void b(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, httpsURLConnection) == null) || httpsURLConnection == null) {
            return;
        }
        httpsURLConnection.setHostnameVerifier(com.dxmpay.apollon.restnet.rest.a.a);
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.f52288c != null) {
                a.InterfaceC2050a a = com.dxmpay.apollon.restnet.a.a();
                String f2 = this.f52288c.f();
                return (TextUtils.isEmpty(f2) || a == null || !a.a(f2)) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0061 -> B:40:0x0070). Please submit an issue!!! */
    private void b(URLConnection uRLConnection) {
        RestUrlConnectionRequest restUrlConnectionRequest;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, uRLConnection) == null) || (restUrlConnectionRequest = this.f52288c) == null) {
            return;
        }
        String processedParams = restUrlConnectionRequest.getProcessedParams();
        RestMultipartEntity g2 = this.f52288c.g();
        uRLConnection.setDoOutput(true);
        uRLConnection.setDoInput(true);
        if (g2 != null) {
            uRLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + g2.a());
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                try {
                    dataOutputStream = new DataOutputStream(uRLConnection.getOutputStream());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            dataOutputStream.writeBytes(processedParams);
            if (g2 != null) {
                g2.a(dataOutputStream);
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (IOException e4) {
            e = e4;
            dataOutputStream2 = dataOutputStream;
            e.printStackTrace();
            if (dataOutputStream2 != null) {
                dataOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    @Override // com.dxmpay.apollon.restnet.rest.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            URLConnection uRLConnection = this.f52289d;
            if (uRLConnection != null) {
                if (uRLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) uRLConnection).disconnect();
                } else if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).disconnect();
                }
                this.f52289d = null;
            }
            if (this.f52291f) {
                d();
            }
        }
    }

    private e a(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, url)) == null) {
            a(this.f52289d);
            b(this.f52289d);
            return a(url, this.f52289d, "POST");
        }
        return (e) invokeL.objValue;
    }

    private e a(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, url, uRLConnection, str)) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            return new d(new BufferedInputStream(uRLConnection.getInputStream()), httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), httpURLConnection.getHeaderFields());
        }
        return (e) invokeLLL.objValue;
    }

    private void a(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, httpsURLConnection) == null) {
            try {
                com.dxmpay.apollon.b.b bVar = new com.dxmpay.apollon.b.b(com.dxmpay.apollon.b.a.a().a(httpsURLConnection.getURL().getHost()));
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{bVar}, null);
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (KeyManagementException unused) {
                throw new IllegalStateException("Should never happen");
            } catch (NoSuchAlgorithmException unused2) {
                throw new IllegalStateException("Should never happen");
            }
        }
    }

    private void a(URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, uRLConnection) == null) {
            if (this.f52290e) {
                uRLConnection.setConnectTimeout(this.f52288c.i() > 0 ? this.f52288c.i() : 30000);
                uRLConnection.setReadTimeout(this.f52288c.i() > 0 ? this.f52288c.i() : 30000);
            } else {
                uRLConnection.setConnectTimeout(this.f52288c.i() > 0 ? this.f52288c.i() : 30000);
                uRLConnection.setReadTimeout(this.f52288c.i() > 0 ? this.f52288c.i() : 30000);
            }
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            } else {
                System.setProperty("http.keepAlive", "true");
                System.setProperty("http.maxConnections ", String.valueOf(10));
                System.setProperty("sun.net.http.errorstream.enableBuffering", "true");
            }
            if (b()) {
                uRLConnection.setRequestProperty("User-Agent", "");
                uRLConnection.setRequestProperty("Accept-Encoding", "");
                return;
            }
            uRLConnection.setRequestProperty("User-Agent", this.f52287b);
            for (Map.Entry<String, List<String>> entry : this.f52288c.a().entrySet()) {
                uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
            }
            if (this.f52291f) {
                c();
            }
        }
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            RestUrlConnectionRequest restUrlConnectionRequest = this.f52288c;
            if (restUrlConnectionRequest != null) {
                String processedParams = restUrlConnectionRequest.getProcessedParams();
                if (TextUtils.isEmpty(processedParams)) {
                    return str;
                }
                if (str.contains("?")) {
                    return str + "&" + processedParams;
                }
                return str + "?" + processedParams;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
