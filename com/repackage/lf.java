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
/* loaded from: classes6.dex */
public class lf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pf a;
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

    /* loaded from: classes6.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf a;

        public a(lf lfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfVar;
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

    /* loaded from: classes6.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf a;

        public b(lf lfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    jg.e(this.a.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpsURLConnection a;

        public c(lf lfVar, HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfVar, httpsURLConnection};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964034613, "Lcom/repackage/lf;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964034613, "Lcom/repackage/lf;");
                return;
            }
        }
        System.setProperty("http.keepAlive", "false");
    }

    public lf(pf pfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pfVar};
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
        if (pfVar != null) {
            this.a = pfVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.c().a = true;
            jg.e(this.b);
        }
    }

    public final byte[] c(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            if (str != null && str.toLowerCase().contains("gzip")) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                hi.c(byteArrayInputStream, byteArrayOutputStream);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:136:0x030a */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02cc, code lost:
        r10.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02cf, code lost:
        r2 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02d0, code lost:
        r7.w = r2;
        r7.x = r14;
        r7.y = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02d9, code lost:
        if ((r2 + r14) < r5) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02db, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02dd, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02de, code lost:
        r21.f = java.lang.System.currentTimeMillis();
        com.repackage.jg.c(r1);
        com.repackage.jg.e(r21.b);
        com.repackage.jg.d(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02ef, code lost:
        return r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v56 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(String str, tf tfVar, int i, int i2, boolean z, of ofVar, boolean z2) throws Exception {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        String m;
        URL m2;
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, tfVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), ofVar, Boolean.valueOf(z2)})) == null) {
            of ofVar2 = ofVar == null ? new of() : ofVar;
            InputStream inputStream3 = null;
            try {
                m = this.a.b().m();
                ofVar2.s = m;
                m2 = m(m, ofVar2);
                this.b = g(m2, i2, i);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            if (this.a.c().a) {
                this.f = System.currentTimeMillis();
                jg.c(null);
                jg.e(this.b);
                jg.d(null);
                return false;
            }
            if (z2) {
                gi.k(str);
            }
            if (z) {
                i3 = new File(str);
            } else {
                i3 = gi.i(str);
            }
            if (i3 != null) {
                long length = i3.length();
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(i3, true);
                    try {
                        this.a.b().w(this.b);
                        this.b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.b.connect();
                        if (this.c <= 0) {
                            try {
                                this.c = System.currentTimeMillis();
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                inputStream3 = null;
                            }
                        }
                        this.d = System.currentTimeMillis();
                        int responseCode = this.b.getResponseCode();
                        this.e = System.currentTimeMillis();
                        if (responseCode == 302) {
                            url = this.b.getURL();
                            if (url != null) {
                                ofVar2.r = url.toString();
                            }
                            if (url != null) {
                                i4 = responseCode;
                                if (!TextUtils.equals(url.getProtocol(), m2.getProtocol())) {
                                    jg.e(this.b);
                                    this.b = g(new URL(url.toString()), i2, i);
                                    this.a.b().w(this.b);
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
                        int e = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : kg.e(headerField2.substring(indexOf + 1), 0);
                        if (e == 0 && this.a.c().b == 200 && (headerField = this.b.getHeaderField("Content-Length")) != null) {
                            e = kg.e(headerField, 0);
                        }
                        this.a.c().f = String.valueOf(e);
                        if (!n()) {
                            str2 = "";
                            if (responseCode == 302) {
                                str2 = (z3 ? "isReConn " : "") + "url=" + m2 + "-newUrl=" + url;
                            } else if (responseCode == 416) {
                                if (e > 0 && e == length) {
                                    this.f = System.currentTimeMillis();
                                    jg.c(null);
                                    jg.e(this.b);
                                    jg.d(fileOutputStream2);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + e;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.b.getContentType() != null && this.b.getContentType().contains("text/vnd.wap.wml")) {
                            this.b.disconnect();
                            this.a.c().b = 0;
                            boolean d = d(str, tfVar, i, i2, z, ofVar2, z2);
                            this.f = System.currentTimeMillis();
                            jg.c(null);
                            jg.e(this.b);
                            jg.d(fileOutputStream2);
                            return d;
                        } else {
                            ofVar2.a = m.getBytes().length;
                            long length2 = this.b.getHeaderFields().toString().getBytes().length;
                            ofVar2.b = length2;
                            long j = e;
                            ofVar2.b = length2 + j;
                            if (e != 0 && length >= j) {
                                this.f = System.currentTimeMillis();
                                this.f = System.currentTimeMillis();
                                jg.c(null);
                                jg.e(this.b);
                                jg.d(fileOutputStream2);
                                return true;
                            }
                            inputStream2 = null;
                            try {
                                inputStream2 = this.b.getInputStream();
                                byte[] bArr = new byte[1024];
                                int i5 = e > 0 ? e / 50 : 0;
                                if (tfVar != null && length > 0) {
                                    tfVar.onProgress((int) length, e);
                                }
                                int i6 = 0;
                                loop0: while (true) {
                                    int i7 = 0;
                                    while (!this.a.c().a) {
                                        int read = inputStream2.read(bArr);
                                        if (read != -1) {
                                            try {
                                                fileOutputStream2.write(bArr, 0, read);
                                                i6 += read;
                                                i7 += read;
                                                if (tfVar == null || (i7 <= i5 && i6 != e)) {
                                                    bArr = bArr;
                                                } else {
                                                    byte[] bArr2 = bArr;
                                                    tfVar.onProgress((int) (i6 + length), e);
                                                    bArr = bArr2;
                                                }
                                            } catch (Exception unused) {
                                                throw new FileNotFoundException();
                                            }
                                        }
                                    }
                                    try {
                                        break loop0;
                                    } catch (Exception unused2) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream3 = inputStream2;
                                fileOutputStream = fileOutputStream2;
                                this.f = System.currentTimeMillis();
                                jg.c(inputStream3);
                                jg.e(this.b);
                                jg.d(fileOutputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream2 = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            } else {
                inputStream = null;
                try {
                    throw new FileNotFoundException();
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            inputStream3 = inputStream;
            fileOutputStream = inputStream;
            this.f = System.currentTimeMillis();
            jg.c(inputStream3);
            jg.e(this.b);
            jg.d(fileOutputStream);
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
            if (ki.z()) {
                if (ki.x() && (c2 = ki.c()) != null && c2.length() > 0) {
                    if (ki.F(c2) && ki.D()) {
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
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, ki.d())));
                    }
                    httpsURLConnection = httpURLConnection;
                }
                if (httpsURLConnection == null) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (this.h && url.getProtocol().equals("https")) {
                    HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new uf(httpsURLConnection2));
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

    public void k(boolean z, int i, int i2, of ofVar) throws Exception {
        IHttpNet vfVar;
        URL d;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), ofVar}) == null) {
            ofVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                if (!this.a.c().a) {
                    String f = this.a.b().f(z, ofVar);
                    ofVar.s = f;
                    URL m = m(f, ofVar);
                    if (!this.a.c().a) {
                        ofVar.j = -2;
                        if (((jf) ServiceManager.getService(jf.a)).netABTest()) {
                            vfVar = new nf(this.a, IHttpNet.HttpNetType.GET);
                        } else {
                            vfVar = new vf(this.a, IHttpNet.HttpNetType.GET);
                        }
                        IHttpNet iHttpNet2 = vfVar;
                        iHttpNet2.e(m);
                        iHttpNet2.g(m, this.h);
                        ofVar.j = -3;
                        long currentTimeMillis = System.currentTimeMillis();
                        iHttpNet2.a(m, i2, i);
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            ofVar.g = new Date().getTime() - currentTimeMillis;
                            ofVar.j = -4;
                            iHttpNet2.connect();
                            if (this.c <= 0) {
                                this.c = System.currentTimeMillis();
                            }
                            this.d = System.currentTimeMillis();
                            ofVar.j = -5;
                            ofVar.c = (new Date().getTime() - currentTimeMillis) - ofVar.g;
                            if (!this.a.c().a) {
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                if (this.a.b().o() && this.m != null && this.j >= 0 && this.j < 3) {
                                    this.m.schedule(this.l, (this.j + 1) * 3000);
                                }
                                this.e = System.currentTimeMillis();
                                iHttpNet2.h();
                                ofVar.j = -8;
                                if (f.contains("c.tieba.baidu.com") && (map = this.a.c().h) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                    ofVar.t = list.get(0);
                                    ofVar.u = list.get(1);
                                }
                                if (this.a.c().b == 302 && (d = iHttpNet2.d()) != null) {
                                    ofVar.r = d.toString();
                                }
                                ofVar.i = this.a.c().b;
                                ofVar.b = iHttpNet2.b().toString().getBytes().length;
                                if (this.m != null) {
                                    this.m.cancel();
                                }
                                if (execute != null) {
                                    ofVar.b += execute.length;
                                    this.a.c().i = c(this.a.c().d, execute);
                                }
                                ofVar.j = -9;
                                ofVar.d = new Date().getTime() - currentTimeMillis;
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

    public final URL m(String str, of ofVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, ofVar)) == null) {
            String str2 = "hiphotos.baidu.com";
            boolean netABTest = ((jf) ServiceManager.getService(jf.a)).netABTest();
            URL url = new URL(str);
            if (netABTest && url.getProtocol().equals("https")) {
                return url;
            }
            if (!TextUtils.isEmpty(str) && this.i) {
                try {
                    String host = url.getHost();
                    if (!TextUtils.isEmpty(host)) {
                        if (!host.contains("hiphotos.baidu.com")) {
                            str2 = host;
                        }
                        BDHttpDnsResult r = BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).r(str2, true);
                        if (r != null) {
                            ofVar.m = r.d();
                            ofVar.o = r.c();
                            ArrayList<String> a2 = r.a();
                            if (a2 != null && a2.size() > 0) {
                                ofVar.p = a2.toString();
                                int size = this.j % a2.size();
                                String str3 = a2.get(size);
                                if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url.getProtocol().equals("https"))) {
                                    this.a.b().a("Host", str2);
                                    URL url2 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                    try {
                                        this.h = true;
                                        ofVar.q = size;
                                        ofVar.l = str3;
                                        ofVar.n = true;
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
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return url;
        }
        return (URL) invokeLL.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.c().b == 200 || this.a.c().b == 206 : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public void p(boolean z, int i, int i2, of ofVar) throws Exception {
        IHttpNet vfVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), ofVar}) == null) {
            ofVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String i3 = z ? this.a.b().i() : this.a.b().m();
                ofVar.s = i3;
                URL m = m(i3, ofVar);
                if (!this.a.c().a) {
                    ofVar.j = -2;
                    if (((jf) ServiceManager.getService(jf.a)).netABTest()) {
                        vfVar = new nf(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    } else {
                        vfVar = new vf(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    }
                    IHttpNet iHttpNet2 = vfVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.h);
                    ofVar.j = -3;
                    System.currentTimeMillis();
                    iHttpNet2.a(m, i2, i);
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            long time = new Date().getTime();
                            ofVar.g = new Date().getTime() - time;
                            ofVar.j = -4;
                            iHttpNet2.connect();
                            if (this.c <= 0) {
                                this.c = System.currentTimeMillis();
                            }
                            this.d = System.currentTimeMillis();
                            ofVar.j = -5;
                            ofVar.c = (new Date().getTime() - time) - ofVar.g;
                            if (!this.a.c().a) {
                                if (this.m != null) {
                                    this.m.schedule(this.k, 45000L);
                                }
                                ofVar.j = -6;
                                iHttpNet2.c();
                                ofVar.j = -7;
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                iHttpNet2.h();
                                this.e = System.currentTimeMillis();
                                if (!this.a.c().a) {
                                    ofVar.j = -8;
                                    ofVar.i = this.a.c().b;
                                    long length = iHttpNet2.b().toString().getBytes().length;
                                    ofVar.b = length;
                                    if (execute != null) {
                                        ofVar.b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().d, execute);
                                    }
                                    ofVar.d = new Date().getTime() - time;
                                    ofVar.j = -9;
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

    public void q(boolean z, int i, int i2, of ofVar) throws Exception {
        IHttpNet vfVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), ofVar}) == null) {
            ofVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String i3 = z ? this.a.b().i() : this.a.b().m();
                ofVar.s = i3;
                URL m = m(i3, ofVar);
                if (!this.a.c().a) {
                    ofVar.j = -2;
                    if (((jf) ServiceManager.getService(jf.a)).netABTest()) {
                        vfVar = new nf(this.a, IHttpNet.HttpNetType.POST_FORM);
                    } else {
                        vfVar = new vf(this.a, IHttpNet.HttpNetType.POST_FORM);
                    }
                    IHttpNet iHttpNet2 = vfVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.h);
                    iHttpNet2.a(m, i2, i);
                    ofVar.j = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            ofVar.g = System.currentTimeMillis() - currentTimeMillis;
                            ofVar.j = -4;
                            iHttpNet2.connect();
                            if (this.c <= 0) {
                                this.c = System.currentTimeMillis();
                            }
                            this.d = System.currentTimeMillis();
                            ofVar.j = -5;
                            ofVar.c = (System.currentTimeMillis() - currentTimeMillis) - ofVar.g;
                            if (!this.a.c().a) {
                                ofVar.j = -6;
                                ofVar.a = iHttpNet2.c();
                                ofVar.j = -7;
                                if (!this.a.c().a) {
                                    iHttpNet2.h();
                                    this.e = System.currentTimeMillis();
                                    ofVar.j = -8;
                                    byte[] execute = iHttpNet2.execute();
                                    this.f = System.currentTimeMillis();
                                    this.a.c().a(iHttpNet2);
                                    ofVar.i = this.a.c().b;
                                    long length = this.a.c().h.toString().getBytes().length;
                                    ofVar.b = length;
                                    if (execute != null) {
                                        ofVar.b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().d, execute);
                                    }
                                    ofVar.d = new Date().getTime() - currentTimeMillis;
                                    ofVar.j = -9;
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

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.j = i;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.i = z;
        }
    }
}
