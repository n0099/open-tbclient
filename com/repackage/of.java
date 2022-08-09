package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes7.dex */
public class of {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sf a;
    public HttpURLConnection b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;
    public int j;
    public TimerTask k;
    public TimerTask l;
    public Timer m;

    /* loaded from: classes7.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of a;

        public a(of ofVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ofVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ofVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of a;

        public b(of ofVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ofVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ofVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ng.f(this.a.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpsURLConnection a;

        public c(of ofVar, HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ofVar, httpsURLConnection};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964031730, "Lcom/repackage/of;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964031730, "Lcom/repackage/of;");
                return;
            }
        }
        System.setProperty("http.keepAlive", "false");
    }

    public of(sf sfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sfVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = false;
        this.i = true;
        this.j = 0;
        this.k = new a(this);
        this.l = new b(this);
        this.m = new Timer();
        if (sfVar != null) {
            this.a = sfVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.c().a = true;
            ng.f(this.b);
        }
    }

    public final byte[] c(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            if (str != null && str.toLowerCase().contains("gzip")) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                li.c(byteArrayInputStream, byteArrayOutputStream);
                this.g = System.currentTimeMillis();
                return byteArrayOutputStream.toByteArray();
            }
            if (this.g == 0) {
                this.g = System.currentTimeMillis();
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v1 */
    public boolean d(String str, wf wfVar, int i, int i2, boolean z, rf rfVar, boolean z2) throws Exception {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        String k;
        URL m;
        File i3;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z3;
        URL url;
        String str2;
        String headerField;
        int indexOf;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, wfVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), rfVar, Boolean.valueOf(z2)})) == null) {
            rf rfVar2 = rfVar == null ? new rf() : rfVar;
            InputStream inputStream3 = null;
            try {
                k = this.a.b().k(true);
                rfVar2.s = k;
                m = m(k, false, rfVar2, null);
                this.b = g(m, i2, i);
            } catch (Throwable th) {
                th = th;
            }
            if (this.a.c().a) {
                this.f = System.currentTimeMillis();
                ng.c(null);
                ng.f(this.b);
                ng.d(null);
                return false;
            }
            if (z2) {
                try {
                    ki.k(str);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                i3 = new File(str);
            } else {
                i3 = ki.i(str);
            }
            if (i3 != null) {
                try {
                    long length = i3.length();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(i3, true);
                    try {
                        this.a.b().t(this.b);
                        this.b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.b.connect();
                        if (this.c <= 0) {
                            try {
                                this.c = System.currentTimeMillis();
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream3 = null;
                                fileOutputStream = fileOutputStream2;
                            }
                        }
                        this.d = System.currentTimeMillis();
                        int responseCode = this.b.getResponseCode();
                        this.e = System.currentTimeMillis();
                        if (responseCode == 302) {
                            url = this.b.getURL();
                            if (url != null) {
                                rfVar2.r = url.toString();
                            }
                            if (url != null) {
                                i4 = responseCode;
                                if (!TextUtils.equals(url.getProtocol(), m.getProtocol())) {
                                    ng.f(this.b);
                                    this.b = g(new URL(url.toString()), i2, i);
                                    this.a.b().t(this.b);
                                    this.b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                                    this.b.connect();
                                    responseCode = this.b.getResponseCode();
                                    z3 = true;
                                }
                            } else {
                                i4 = responseCode;
                            }
                            responseCode = i4;
                            z3 = false;
                        } else {
                            z3 = false;
                            url = null;
                        }
                        this.a.c().b = responseCode;
                        String headerField2 = this.b.getHeaderField("Content-Range");
                        int e = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : og.e(headerField2.substring(indexOf + 1), 0);
                        if (e == 0 && this.a.c().b == 200 && (headerField = this.b.getHeaderField("Content-Length")) != null) {
                            e = og.e(headerField, 0);
                        }
                        this.a.c().f = String.valueOf(e);
                        if (!n()) {
                            str2 = "";
                            if (responseCode == 302) {
                                str2 = (z3 ? "isReConn " : "") + "url=" + m + "-newUrl=" + url;
                            } else if (responseCode == 416) {
                                if (e > 0 && e == length) {
                                    this.f = System.currentTimeMillis();
                                    ng.c(null);
                                    ng.f(this.b);
                                    ng.d(fileOutputStream2);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + e;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.b.getContentType() != null && this.b.getContentType().contains("text/vnd.wap.wml")) {
                            this.b.disconnect();
                            this.a.c().b = 0;
                            boolean d = d(str, wfVar, i, i2, z, rfVar2, z2);
                            this.f = System.currentTimeMillis();
                            ng.c(null);
                            ng.f(this.b);
                            ng.d(fileOutputStream2);
                            return d;
                        } else {
                            rfVar2.a = k.getBytes().length;
                            long length2 = this.b.getHeaderFields().toString().getBytes().length;
                            rfVar2.b = length2;
                            long j = e;
                            rfVar2.b = length2 + j;
                            if (e != 0 && length >= j) {
                                this.f = System.currentTimeMillis();
                                this.f = System.currentTimeMillis();
                                ng.c(null);
                                ng.f(this.b);
                                ng.d(fileOutputStream2);
                                return true;
                            }
                            inputStream2 = null;
                            try {
                                inputStream2 = this.b.getInputStream();
                                byte[] bArr = new byte[1024];
                                int i5 = e > 0 ? e / 50 : 0;
                                if (wfVar != null && length > 0) {
                                    wfVar.onProgress((int) length, e);
                                }
                                int i6 = 0;
                                loop0: while (true) {
                                    int i7 = 0;
                                    while (!this.a.c().a) {
                                        int read = inputStream2.read(bArr);
                                        if (read == -1) {
                                            break loop0;
                                        }
                                        try {
                                            fileOutputStream2.write(bArr, 0, read);
                                            i6 += read;
                                            int i8 = i7 + read;
                                            if (wfVar == null || (i8 <= i5 && i6 != e)) {
                                                i7 = i8;
                                                j = j;
                                            } else {
                                                long j2 = j;
                                                wfVar.onProgress((int) (i6 + length), e);
                                                j = j2;
                                            }
                                        } catch (Exception unused) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                    break loop0;
                                }
                                long j3 = j;
                                try {
                                    fileOutputStream2.flush();
                                    long j4 = i6;
                                    rfVar2.w = j4;
                                    rfVar2.x = length;
                                    rfVar2.y = j3;
                                    boolean z4 = j4 + length >= j3;
                                    this.f = System.currentTimeMillis();
                                    ng.c(inputStream2);
                                    ng.f(this.b);
                                    ng.d(fileOutputStream2);
                                    return z4;
                                } catch (Exception unused2) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream3 = inputStream2;
                                fileOutputStream = fileOutputStream2;
                                this.f = System.currentTimeMillis();
                                ng.c(inputStream3);
                                ng.f(this.b);
                                ng.d(fileOutputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream2 = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                }
            } else {
                inputStream = null;
                try {
                    throw new FileNotFoundException();
                } catch (Throwable th7) {
                    th = th7;
                }
            }
            inputStream3 = inputStream;
            fileOutputStream = inputStream3;
            this.f = System.currentTimeMillis();
            ng.c(inputStream3);
            ng.f(this.b);
            ng.d(fileOutputStream);
            throw th;
        }
        return invokeCommon.booleanValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : invokeV.longValue;
    }

    public final HttpURLConnection f(URL url) {
        InterceptResult invokeL;
        String c2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, url)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
        HttpsURLConnection httpsURLConnection = null;
        try {
            if (oi.z()) {
                if (oi.x() && (c2 = oi.c()) != null && c2.length() > 0) {
                    if (oi.F(c2) && oi.D()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(c2);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.a.b().a("X-Online-Host", url.getHost());
                        } catch (Exception e) {
                            e = e;
                            httpsURLConnection = httpURLConnection;
                            e.printStackTrace();
                            return httpsURLConnection;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, oi.d())));
                    }
                    httpsURLConnection = httpURLConnection;
                }
                if (httpsURLConnection == null) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (this.h && url.getProtocol().equals("https")) {
                    HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new xf(httpsURLConnection2));
                    httpsURLConnection2.setHostnameVerifier(new c(this, httpsURLConnection2));
                    return httpsURLConnection2;
                }
                return httpsURLConnection;
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public final HttpURLConnection g(URL url, int i, int i2) throws SocketException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, url, i, i2)) == null) {
            HttpURLConnection f = f(url);
            if (f != null) {
                f.setConnectTimeout(i);
                f.setReadTimeout(i2);
                return f;
            }
            throw new SocketException();
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : invokeV.longValue;
    }

    public void k(boolean z, boolean z2, int i, int i2, rf rfVar, zf zfVar) throws Exception {
        IHttpNet yfVar;
        URL d;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), rfVar, zfVar}) == null) {
            rfVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                if (!this.a.c().a) {
                    String f = this.a.b().f(z, rfVar);
                    rfVar.s = f;
                    URL m = m(f, z2, rfVar, zfVar);
                    if (!this.a.c().a) {
                        rfVar.j = -2;
                        if (((nf) ServiceManager.getService(nf.a)).netABTest()) {
                            yfVar = new qf(this.a, IHttpNet.HttpNetType.GET);
                        } else {
                            yfVar = new yf(this.a, IHttpNet.HttpNetType.GET);
                        }
                        IHttpNet iHttpNet2 = yfVar;
                        iHttpNet2.e(m);
                        iHttpNet2.g(m, this.h);
                        rfVar.j = -3;
                        long currentTimeMillis = System.currentTimeMillis();
                        iHttpNet2.a(m, i2, i);
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            rfVar.g = new Date().getTime() - currentTimeMillis;
                            rfVar.j = -4;
                            iHttpNet2.connect();
                            if (this.c <= 0) {
                                this.c = System.currentTimeMillis();
                            }
                            this.d = System.currentTimeMillis();
                            rfVar.j = -5;
                            rfVar.c = (new Date().getTime() - currentTimeMillis) - rfVar.g;
                            if (!this.a.c().a) {
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                if (this.a.b().m() && this.m != null && this.j >= 0 && this.j < 3) {
                                    this.m.schedule(this.l, (this.j + 1) * 3000);
                                }
                                this.e = System.currentTimeMillis();
                                iHttpNet2.h();
                                rfVar.j = -8;
                                if (f.contains("tiebac.baidu.com") && (map = this.a.c().h) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                    rfVar.t = list.get(0);
                                    rfVar.u = list.get(1);
                                }
                                if (this.a.c().b == 302 && (d = iHttpNet2.d()) != null) {
                                    rfVar.r = d.toString();
                                }
                                rfVar.i = this.a.c().b;
                                rfVar.b = iHttpNet2.b().toString().getBytes().length;
                                if (this.m != null) {
                                    this.m.cancel();
                                }
                                if (execute != null) {
                                    rfVar.b += execute.length;
                                    this.a.c().i = c(this.a.c().d, execute);
                                }
                                rfVar.j = -9;
                                rfVar.d = new Date().getTime() - currentTimeMillis;
                                Timer timer = this.m;
                                if (timer != null) {
                                    timer.cancel();
                                }
                                iHttpNet2.disconnect();
                                return;
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                Timer timer2 = this.m;
                if (timer2 != null) {
                    timer2.cancel();
                }
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f : invokeV.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final URL m(String str, boolean z, rf rfVar, zf zfVar) throws Exception {
        InterceptResult invokeCommon;
        boolean z2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), rfVar, zfVar})) == null) {
            String str3 = "hiphotos.baidu.com";
            boolean netABTest = ((nf) ServiceManager.getService(nf.a)).netABTest();
            URL url = new URL(str);
            if (netABTest && url.getProtocol().equals("https")) {
                return url;
            }
            if (!TextUtils.isEmpty(str) && this.i) {
                try {
                    String host = url.getHost();
                    if (!TextUtils.isEmpty(host)) {
                        if (!host.contains("hiphotos.baidu.com")) {
                            str3 = host;
                        }
                        BDHttpDnsResult r = BDHttpDns.h(BdBaseApplication.getInst().getApplicationContext()).r(str3, true);
                        if (r != null) {
                            rfVar.m = r.d();
                            rfVar.o = r.c();
                            ArrayList<String> b2 = r.b();
                            if (((mf) ServiceManager.getService(mf.a)).isIpv6() && z && b2 != null && b2.size() != 0) {
                                z2 = true;
                                if (b2 != null && b2.size() > 0) {
                                    rfVar.p = b2.toString();
                                    int size = this.j % b2.size();
                                    str2 = b2.get(size);
                                    if (!TextUtils.isEmpty(str2)) {
                                        if (z2) {
                                            str2 = PreferencesUtil.LEFT_MOUNT + str2 + PreferencesUtil.RIGHT_MOUNT;
                                            if (zfVar != null) {
                                                zfVar.e = true;
                                            }
                                        }
                                        if (!str2.startsWith("10.") || !url.getProtocol().equals("https")) {
                                            this.a.b().a("Host", str3);
                                            URL url2 = new URL(str.replaceFirst("://(.*)" + str3, "://" + str2));
                                            try {
                                                this.h = true;
                                                rfVar.q = size;
                                                rfVar.l = str2;
                                                rfVar.n = true;
                                                return url2;
                                            } catch (Exception e) {
                                                e = e;
                                                url = url2;
                                                BdLog.e(e);
                                                return url;
                                            }
                                        }
                                    }
                                }
                            }
                            z2 = false;
                            b2 = r.a();
                            if (b2 != null) {
                                rfVar.p = b2.toString();
                                int size2 = this.j % b2.size();
                                str2 = b2.get(size2);
                                if (!TextUtils.isEmpty(str2)) {
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return url;
        }
        return (URL) invokeCommon.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.c().b == 200 || this.a.c().b == 206 : invokeV.booleanValue;
    }

    public void o(boolean z, boolean z2, int i, int i2, rf rfVar, zf zfVar) throws Exception {
        IHttpNet yfVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), rfVar, zfVar}) == null) {
            rfVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String k = this.a.b().k(z);
                rfVar.s = k;
                URL m = m(k, z2, rfVar, zfVar);
                if (!this.a.c().a) {
                    rfVar.j = -2;
                    if (((nf) ServiceManager.getService(nf.a)).netABTest()) {
                        yfVar = new qf(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    } else {
                        yfVar = new yf(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    }
                    IHttpNet iHttpNet2 = yfVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.h);
                    rfVar.j = -3;
                    System.currentTimeMillis();
                    iHttpNet2.a(m, i2, i);
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            long time = new Date().getTime();
                            rfVar.g = new Date().getTime() - time;
                            rfVar.j = -4;
                            iHttpNet2.connect();
                            if (this.c <= 0) {
                                this.c = System.currentTimeMillis();
                            }
                            this.d = System.currentTimeMillis();
                            rfVar.j = -5;
                            rfVar.c = (new Date().getTime() - time) - rfVar.g;
                            if (!this.a.c().a) {
                                if (this.m != null) {
                                    this.m.schedule(this.k, 45000L);
                                }
                                rfVar.j = -6;
                                iHttpNet2.c();
                                rfVar.j = -7;
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                iHttpNet2.h();
                                this.e = System.currentTimeMillis();
                                if (!this.a.c().a) {
                                    rfVar.j = -8;
                                    rfVar.i = this.a.c().b;
                                    long length = iHttpNet2.b().toString().getBytes().length;
                                    rfVar.b = length;
                                    if (execute != null) {
                                        rfVar.b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().d, execute);
                                    }
                                    rfVar.d = new Date().getTime() - time;
                                    rfVar.j = -9;
                                    Timer timer = this.m;
                                    if (timer != null) {
                                        timer.cancel();
                                    }
                                    iHttpNet2.disconnect();
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                Timer timer2 = this.m;
                if (timer2 != null) {
                    timer2.cancel();
                }
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    public void p(boolean z, boolean z2, int i, int i2, rf rfVar, zf zfVar) throws Exception {
        IHttpNet yfVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), rfVar, zfVar}) == null) {
            rfVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String k = this.a.b().k(z);
                rfVar.s = k;
                URL m = m(k, z2, rfVar, zfVar);
                if (!this.a.c().a) {
                    rfVar.j = -2;
                    if (((nf) ServiceManager.getService(nf.a)).netABTest()) {
                        yfVar = new qf(this.a, IHttpNet.HttpNetType.POST_FORM);
                    } else {
                        yfVar = new yf(this.a, IHttpNet.HttpNetType.POST_FORM);
                    }
                    IHttpNet iHttpNet2 = yfVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.h);
                    iHttpNet2.a(m, i2, i);
                    rfVar.j = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            rfVar.g = System.currentTimeMillis() - currentTimeMillis;
                            rfVar.j = -4;
                            iHttpNet2.connect();
                            if (this.c <= 0) {
                                this.c = System.currentTimeMillis();
                            }
                            this.d = System.currentTimeMillis();
                            rfVar.j = -5;
                            rfVar.c = (System.currentTimeMillis() - currentTimeMillis) - rfVar.g;
                            if (!this.a.c().a) {
                                rfVar.j = -6;
                                rfVar.a = iHttpNet2.c();
                                rfVar.j = -7;
                                if (!this.a.c().a) {
                                    iHttpNet2.h();
                                    this.e = System.currentTimeMillis();
                                    rfVar.j = -8;
                                    byte[] execute = iHttpNet2.execute();
                                    this.f = System.currentTimeMillis();
                                    this.a.c().a(iHttpNet2);
                                    rfVar.i = this.a.c().b;
                                    long length = this.a.c().h.toString().getBytes().length;
                                    rfVar.b = length;
                                    if (execute != null) {
                                        rfVar.b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().d, execute);
                                    }
                                    rfVar.d = new Date().getTime() - currentTimeMillis;
                                    rfVar.j = -9;
                                    iHttpNet2.disconnect();
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.j = i;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.i = z;
        }
    }
}
