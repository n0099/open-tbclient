package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class vf implements IHttpNet {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final pf a;
    public HttpURLConnection b;
    public final IHttpNet.HttpNetType c;

    /* loaded from: classes7.dex */
    public class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpsURLConnection a;

        public a(vf vfVar, HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vfVar, httpsURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = httpsURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                String requestProperty = this.a.getRequestProperty("Host");
                if (requestProperty == null) {
                    requestProperty = this.a.getURL().getHost();
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    public vf(pf pfVar, IHttpNet.HttpNetType httpNetType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pfVar, httpNetType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pfVar;
        this.c = httpNetType;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void a(URL url, int i, int i2) throws SocketException, ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, url, i, i2) == null) {
            HttpURLConnection httpURLConnection = this.b;
            if (httpURLConnection != null) {
                if (this.c == IHttpNet.HttpNetType.GET) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    this.b.setDoOutput(true);
                    this.b.setDoInput(true);
                    IHttpNet.HttpNetType httpNetType = this.c;
                    if (httpNetType == IHttpNet.HttpNetType.POST_FORM) {
                        this.b.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    } else if (httpNetType == IHttpNet.HttpNetType.POST_BYTE) {
                        this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=--------7da3d81520810*");
                    }
                }
                this.b.setConnectTimeout(i);
                this.b.setReadTimeout(i2);
                return;
            }
            throw new SocketException("network not available.");
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public Map<String, List<String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.getHeaderFields() : (Map) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int c() throws IOException {
        InterceptResult invokeV;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b == null) {
                return 0;
            }
            IHttpNet.HttpNetType httpNetType = this.c;
            if (httpNetType == IHttpNet.HttpNetType.POST_FORM) {
                String sb = i().toString();
                dataOutputStream = new DataOutputStream(this.b.getOutputStream());
                try {
                    dataOutputStream.writeBytes(sb);
                    dataOutputStream.flush();
                    jg.d(dataOutputStream);
                    return sb.length();
                } finally {
                }
            } else if (httpNetType == IHttpNet.HttpNetType.POST_BYTE) {
                dataOutputStream = new DataOutputStream(this.b.getOutputStream());
                try {
                    if (this.a.b().l() != null) {
                        Iterator<BasicNameValuePair> it = this.a.b().l().iterator();
                        while (it.hasNext()) {
                            BasicNameValuePair next = it.next();
                            if (next != null) {
                                String name = next.getName();
                                String value = next.getValue();
                                if (value != null && name != null) {
                                    dataOutputStream.writeBytes("----------7da3d81520810*\r\n");
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                                    dataOutputStream.writeBytes("\r\n");
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes("\r\n");
                                }
                            }
                        }
                    }
                    if (this.a.b().g != null) {
                        for (Map.Entry<String, byte[]> entry : this.a.b().g.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (value2 != null) {
                                dataOutputStream.writeBytes("----------7da3d81520810*\r\n");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"\r\n");
                                dataOutputStream.writeBytes("\r\n");
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes("\r\n");
                            }
                        }
                    }
                    dataOutputStream.writeBytes("----------7da3d81520810*--\r\n");
                    dataOutputStream.flush();
                    return dataOutputStream.size();
                } finally {
                }
            } else {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void connect() throws IOException {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (httpURLConnection = this.b) == null) {
            return;
        }
        httpURLConnection.connect();
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public URL d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
            if (httpURLConnection == null) {
                return null;
            }
            return httpURLConnection.getURL();
        }
        return (URL) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            jg.e(this.b);
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void e(URL url) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, url) == null) && ki.z() && ki.x()) {
            try {
                String c = ki.c();
                if (c == null || c.length() <= 0) {
                    return;
                }
                if (ki.F(c) && ki.D()) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("http://");
                    sb.append(c);
                    String file = url.getFile();
                    if (file != null && file.startsWith("?")) {
                        sb.append("/");
                    }
                    sb.append(file);
                    this.b = (HttpURLConnection) new URL(sb.toString()).openConnection();
                    this.a.b().a("X-Online-Host", url.getHost());
                    return;
                }
                this.b = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c, ki.d())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public byte[] execute() throws IOException {
        InterceptResult invokeV;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.b == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                InputStream inputStream = this.b.getInputStream();
                while (!this.a.c().a && (read = inputStream.read(bArr)) != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (!this.a.c().a) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    jg.d(byteArrayOutputStream);
                    jg.c(inputStream);
                    return byteArray;
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                jg.d(byteArrayOutputStream);
                jg.c(null);
                throw th;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.b == null || this.a.b().h() == null) {
            return;
        }
        for (Map.Entry<String, String> entry : this.a.b().h().entrySet()) {
            this.b.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void g(URL url, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, url, z) == null) {
            try {
                if (this.b == null) {
                    this.b = (HttpURLConnection) url.openConnection();
                }
                if (z && url.getProtocol().equals("https")) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.b;
                    httpsURLConnection.setSSLSocketFactory(new uf(httpsURLConnection));
                    httpsURLConnection.setHostnameVerifier(new a(this, httpsURLConnection));
                    this.b = httpsURLConnection;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
            return httpURLConnection == null ? "" : httpURLConnection.getContentEncoding();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
            if (httpURLConnection == null) {
                return 0L;
            }
            return httpURLConnection.getContentLength();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
            return httpURLConnection == null ? "" : httpURLConnection.getContentType();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
            if (httpURLConnection == null) {
                return 0;
            }
            return httpURLConnection.getResponseCode();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void h() throws IOException {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (httpURLConnection = this.b) != null && zf.c(httpURLConnection.getContentType())) {
            this.b.disconnect();
            this.b.connect();
            if (this.a.c().a) {
                throw new BdHttpCancelException();
            }
        }
    }

    public final StringBuilder i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder(1024);
            LinkedList<BasicNameValuePair> l = this.a.b().l();
            if (l == null) {
                return sb;
            }
            int i = 0;
            Iterator<BasicNameValuePair> it = l.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(name + "=");
                    sb.append(li.getUrlEncode(value));
                    i++;
                }
            }
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }
}
