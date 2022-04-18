package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.recapp.download.http.BdHttpCancelException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class ub8 {
    public static /* synthetic */ Interceptable $ic;
    public static String i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public zb8 b;
    public HttpURLConnection c;
    public long d;
    public boolean e;
    public boolean f;
    public TimerTask g;
    public Timer h;

    /* loaded from: classes7.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub8 a;

        public a(ub8 ub8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub8Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.a();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755266618, "Lcom/repackage/ub8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755266618, "Lcom/repackage/ub8;");
                return;
            }
        }
        Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
        i = "--------7da3d81520810*";
        System.setProperty("http.keepAlive", "false");
    }

    public ub8(zb8 zb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zb8Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = 0L;
        this.e = false;
        this.f = true;
        this.g = new a(this);
        this.h = new Timer();
        if (zb8Var != null) {
            this.b = zb8Var;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.b().a = true;
            lg.e(this.c);
        }
    }

    public final byte[] b(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            if (str == null || !str.toLowerCase().contains("gzip")) {
                return bArr;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            ji.c(byteArrayInputStream, byteArrayOutputStream);
            System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:122:0x028d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v45 */
    public boolean c(String str, cc8 cc8Var, int i2, int i3, boolean z, xb8 xb8Var, boolean z2) throws Exception {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        String d;
        File i4;
        InputStream inputStream;
        InputStream inputStream2;
        int read;
        String headerField;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, cc8Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), xb8Var, Boolean.valueOf(z2)})) == null) {
            this.a = 0;
            xb8 xb8Var2 = xb8Var == null ? new xb8() : xb8Var;
            InputStream inputStream3 = null;
            try {
                d = this.b.a().d();
                xb8Var2.i = d;
                HttpURLConnection e = e(i(d, xb8Var2), i3, i2);
                this.c = e;
                e.setInstanceFollowRedirects(true);
                HttpURLConnection.setFollowRedirects(false);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            if (this.b.b().a) {
                System.currentTimeMillis();
                lg.c(null);
                lg.e(this.c);
                lg.d(null);
                return false;
            }
            if (z2) {
                ii.k(str);
            }
            if (z) {
                i4 = new File(str);
            } else {
                i4 = ii.i(str);
            }
            if (i4 != null) {
                long length = i4.length();
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(i4, true);
                    try {
                        this.b.a().i(this.c);
                        this.c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.c.connect();
                        if (this.d <= 0) {
                            try {
                                this.d = System.currentTimeMillis();
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                inputStream3 = null;
                            }
                        }
                        System.currentTimeMillis();
                        int responseCode = this.c.getResponseCode();
                        while (l(responseCode) && this.a <= 5) {
                            this.c = j(this.c, i3, i2);
                            this.b.a().i(this.c);
                            this.c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                            this.c.connect();
                            responseCode = this.c.getResponseCode();
                        }
                        System.currentTimeMillis();
                        this.b.b().b = responseCode;
                        if (k()) {
                            if (this.c.getContentType() != null && this.c.getContentType().contains("text/vnd.wap.wml")) {
                                this.c.disconnect();
                                this.b.b().b = 0;
                                boolean c = c(str, cc8Var, i2, i3, z, xb8Var2, z2);
                                System.currentTimeMillis();
                                lg.c(null);
                                lg.e(this.c);
                                lg.d(fileOutputStream2);
                                return c;
                            }
                            String headerField2 = this.c.getHeaderField("Content-Range");
                            int e2 = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : mg.e(headerField2.substring(indexOf + 1), 0);
                            if (e2 == 0 && this.b.b().b == 200 && (headerField = this.c.getHeaderField("Content-Length")) != null) {
                                e2 = mg.e(headerField, 0);
                            }
                            this.b.b().e = String.valueOf(e2);
                            xb8Var2.a = d.getBytes().length;
                            long length2 = this.c.getHeaderFields().toString().getBytes().length;
                            xb8Var2.b = length2;
                            long j = e2;
                            xb8Var2.b = length2 + j;
                            if (this.b.b().b != 416 && this.b.b().b != 204) {
                                if (e2 != 0 && length >= j) {
                                    System.currentTimeMillis();
                                    System.currentTimeMillis();
                                    lg.c(null);
                                    lg.e(this.c);
                                    lg.d(fileOutputStream2);
                                    return true;
                                }
                                InputStream inputStream4 = this.c.getInputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    int i5 = e2 > 0 ? e2 / 50 : 0;
                                    if (cc8Var != null && length > 0) {
                                        cc8Var.onProgress((int) length, e2);
                                    }
                                    int i6 = 0;
                                    loop1: while (true) {
                                        int i7 = 0;
                                        while (!this.b.b().a && (read = inputStream4.read(bArr)) != -1) {
                                            try {
                                                fileOutputStream2.write(bArr, 0, read);
                                                i6 += read;
                                                i7 += read;
                                                if (cc8Var != null && (i7 > i5 || i6 == e2)) {
                                                    cc8Var.onProgress((int) (i6 + length), e2);
                                                }
                                            } catch (Exception unused) {
                                                throw new FileNotFoundException();
                                            }
                                        }
                                    }
                                    try {
                                        fileOutputStream2.flush();
                                        boolean z3 = ((long) i6) + length >= j;
                                        System.currentTimeMillis();
                                        lg.c(inputStream4);
                                        lg.e(this.c);
                                        lg.d(fileOutputStream2);
                                        return z3;
                                    } catch (Exception unused2) {
                                        throw new FileNotFoundException();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = fileOutputStream2;
                                    inputStream3 = inputStream4;
                                }
                            }
                            System.currentTimeMillis();
                            lg.c(null);
                            lg.e(this.c);
                            lg.d(fileOutputStream2);
                            return true;
                        }
                        inputStream2 = null;
                        try {
                            throw new UnsupportedOperationException();
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream3 = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            System.currentTimeMillis();
                            lg.c(inputStream3);
                            lg.e(this.c);
                            lg.d(fileOutputStream);
                            throw th;
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
            fileOutputStream = inputStream;
            System.currentTimeMillis();
            lg.c(inputStream3);
            lg.e(this.c);
            lg.d(fileOutputStream);
            throw th;
        }
        return invokeCommon.booleanValue;
    }

    public final HttpURLConnection d(URL url) {
        InterceptResult invokeL;
        String c;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, url)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (mi.z()) {
                if (mi.x() && (c = mi.c()) != null && c.length() > 0) {
                    if (mi.F(c) && mi.D()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(c);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.b.a().a("X-Online-Host", url.getHost());
                        } catch (Exception e) {
                            e = e;
                            httpURLConnection2 = httpURLConnection;
                            e.printStackTrace();
                            return httpURLConnection2;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c, mi.d())));
                    }
                    httpURLConnection2 = httpURLConnection;
                }
                return httpURLConnection2 == null ? (HttpURLConnection) url.openConnection() : httpURLConnection2;
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public final HttpURLConnection e(URL url, int i2, int i3) throws SocketException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, url, i2, i3)) == null) {
            HttpURLConnection d = d(url);
            if (d != null) {
                d.setConnectTimeout(i2);
                d.setReadTimeout(i3);
                return d;
            }
            throw new SocketException();
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : invokeV.longValue;
    }

    public void g(int i2, int i3, xb8 xb8Var) throws Exception {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, xb8Var) == null) {
            xb8Var.g = -1;
            if (!this.b.b().a) {
                String c = this.b.a().c(xb8Var);
                xb8Var.i = c;
                URL i4 = i(c, xb8Var);
                if (!this.b.b().a) {
                    xb8Var.g = -2;
                    this.c = d(i4);
                    xb8Var.g = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (this.c != null) {
                            this.c.setRequestMethod("GET");
                            this.c.setConnectTimeout(i3);
                            this.c.setReadTimeout(i2);
                            this.b.a().i(this.c);
                            if (!this.b.b().a) {
                                xb8Var.e = new Date().getTime() - currentTimeMillis;
                                xb8Var.g = -4;
                                this.c.connect();
                                if (this.d <= 0) {
                                    this.d = System.currentTimeMillis();
                                }
                                System.currentTimeMillis();
                                xb8Var.g = -5;
                                xb8Var.c = (new Date().getTime() - currentTimeMillis) - xb8Var.e;
                                if (!this.b.b().a) {
                                    String contentType = this.c.getContentType();
                                    System.currentTimeMillis();
                                    if (yb8.a(contentType)) {
                                        this.c.disconnect();
                                        this.c.connect();
                                        if (this.b.b().a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    xb8Var.g = -8;
                                    this.b.b().a(this.c);
                                    if (c.contains("c.tieba.baidu.com") && (map = this.b.b().f) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                        xb8Var.j = list.get(0);
                                        xb8Var.k = list.get(1);
                                    }
                                    xb8Var.f = this.b.b().b;
                                    xb8Var.b = this.c.getHeaderFields().toString().getBytes().length;
                                    byte[] h = h(this.c);
                                    if (h != null) {
                                        xb8Var.b += h.length;
                                        this.b.b().g = b(this.b.b().d, h);
                                    }
                                    xb8Var.g = -9;
                                    xb8Var.d = new Date().getTime() - currentTimeMillis;
                                    if (httpURLConnection != null) {
                                        return;
                                    }
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new SocketException("network not available.");
                    } finally {
                        httpURLConnection = this.c;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
                throw new BdHttpCancelException();
            }
            throw new BdHttpCancelException();
        }
    }

    public final byte[] h(HttpURLConnection httpURLConnection) throws Exception {
        InterceptResult invokeL;
        InputStream inputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, httpURLConnection)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = null;
            if (httpURLConnection != null) {
                try {
                    byte[] bArr2 = new byte[1024];
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    while (!this.b.b().a && (read = inputStream2.read(bArr2)) != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    if (!this.b.b().a) {
                        bArr = byteArrayOutputStream.toByteArray();
                        inputStream = inputStream2;
                    } else {
                        throw new BdHttpCancelException();
                    }
                } catch (Throwable th) {
                    System.currentTimeMillis();
                    lg.d(byteArrayOutputStream);
                    lg.c(null);
                    throw th;
                }
            } else {
                inputStream = null;
            }
            System.currentTimeMillis();
            lg.d(byteArrayOutputStream);
            lg.c(inputStream);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final URL i(String str, xb8 xb8Var) throws Exception {
        InterceptResult invokeLL;
        tb8 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, xb8Var)) == null) {
            URL url = new URL(str);
            if (!this.f || (b = tb8.b()) == null) {
                return url;
            }
            String a2 = b.a(str);
            if (TextUtils.isEmpty(a2)) {
                return url;
            }
            this.b.a().a("Host", url.getHost());
            URL url2 = new URL(str.replace("://" + url.getHost(), "://" + a2));
            this.e = true;
            xb8Var.h = a2;
            return url2;
        }
        return (URL) invokeLL.objValue;
    }

    public final HttpURLConnection j(HttpURLConnection httpURLConnection, int i2, int i3) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, httpURLConnection, i2, i3)) == null) {
            if (httpURLConnection == null) {
                return null;
            }
            URL url = httpURLConnection.getURL().toURI().resolve(httpURLConnection.getHeaderField(Headers.LOCATION)).toURL();
            lg.e(httpURLConnection);
            HttpURLConnection e = e(url, i2, i3);
            this.a++;
            return e;
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b.b().b == 200 || this.b.b().b == 206 : invokeV.booleanValue;
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? i2 == 302 || i2 == 301 || i2 == 304 || i2 == 300 || i2 == 307 || i2 == 308 || i2 == 303 : invokeI.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void n(int i2, int i3, xb8 xb8Var) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, xb8Var) == null) {
            xb8Var.g = -1;
            try {
                String d = this.b.a().d();
                xb8Var.i = d;
                URL i4 = i(d, xb8Var);
                if (!this.b.b().a) {
                    xb8Var.g = -2;
                    this.c = d(i4);
                    xb8Var.g = -3;
                    System.currentTimeMillis();
                    if (this.c != null) {
                        this.c.setRequestMethod("POST");
                        this.c.setDoOutput(true);
                        this.c.setDoInput(true);
                        this.c.setConnectTimeout(i3);
                        this.c.setReadTimeout(i2);
                        this.c.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + i);
                        if (!this.b.b().a) {
                            this.b.a().i(this.c);
                            if (!this.b.b().a) {
                                long time = new Date().getTime();
                                xb8Var.e = new Date().getTime() - time;
                                xb8Var.g = -4;
                                this.c.connect();
                                if (this.d <= 0) {
                                    this.d = System.currentTimeMillis();
                                }
                                System.currentTimeMillis();
                                xb8Var.g = -5;
                                xb8Var.c = (new Date().getTime() - time) - xb8Var.e;
                                if (!this.b.b().a) {
                                    if (this.h != null) {
                                        this.h.schedule(this.g, 45000L);
                                    }
                                    xb8Var.g = -6;
                                    this.b.a().k(this.c, i, xb8Var);
                                    xb8Var.g = -7;
                                    String contentType = this.c.getContentType();
                                    System.currentTimeMillis();
                                    if (yb8.a(contentType)) {
                                        this.c.disconnect();
                                        this.c.connect();
                                        if (this.b.b().a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    if (!this.b.b().a) {
                                        xb8Var.g = -8;
                                        this.b.b().a(this.c);
                                        xb8Var.f = this.b.b().b;
                                        xb8Var.b = this.c.getHeaderFields().toString().getBytes().length;
                                        byte[] h = h(this.c);
                                        if (h != null) {
                                            xb8Var.b += h.length;
                                            this.b.b().h = h.length;
                                            this.b.b().g = b(this.b.b().d, h);
                                        }
                                        xb8Var.d = new Date().getTime() - time;
                                        xb8Var.g = -9;
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
                    throw new SocketException("network not available.");
                }
                throw new BdHttpCancelException();
            } finally {
                Timer timer = this.h;
                if (timer != null) {
                    timer.cancel();
                }
                lg.e(this.c);
            }
        }
    }

    public void o(int i2, int i3, xb8 xb8Var) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i2, i3, xb8Var) == null) {
            xb8Var.g = -1;
            try {
                String d = this.b.a().d();
                xb8Var.i = d;
                URL i4 = i(d, xb8Var);
                if (!this.b.b().a) {
                    xb8Var.g = -2;
                    this.c = d(i4);
                    xb8Var.g = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.c != null) {
                        this.c.setRequestMethod("POST");
                        this.c.setDoOutput(true);
                        this.c.setDoInput(true);
                        this.c.setConnectTimeout(i3);
                        this.c.setReadTimeout(i2);
                        this.c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        if (!this.b.b().a) {
                            this.b.a().i(this.c);
                            if (!this.b.b().a) {
                                xb8Var.e = System.currentTimeMillis() - currentTimeMillis;
                                xb8Var.g = -4;
                                this.c.connect();
                                if (this.d <= 0) {
                                    this.d = System.currentTimeMillis();
                                }
                                System.currentTimeMillis();
                                xb8Var.g = -5;
                                xb8Var.c = (System.currentTimeMillis() - currentTimeMillis) - xb8Var.e;
                                if (!this.b.b().a) {
                                    xb8Var.g = -6;
                                    this.b.a().j(this.c, xb8Var);
                                    xb8Var.g = -7;
                                    if (!this.b.b().a) {
                                        String contentType = this.c.getContentType();
                                        System.currentTimeMillis();
                                        if (yb8.a(contentType)) {
                                            this.c.disconnect();
                                            this.c.connect();
                                            if (this.b.b().a) {
                                                throw new BdHttpCancelException();
                                            }
                                        }
                                        this.b.b().a(this.c);
                                        xb8Var.g = -8;
                                        xb8Var.f = this.b.b().b;
                                        xb8Var.b = this.c.getHeaderFields().toString().getBytes().length;
                                        byte[] h = h(this.c);
                                        if (h != null) {
                                            xb8Var.b += h.length;
                                            this.b.b().h = h.length;
                                            this.b.b().g = b(this.b.b().d, h);
                                        }
                                        xb8Var.d = new Date().getTime() - currentTimeMillis;
                                        xb8Var.g = -9;
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
                    throw new SocketException("network not available.");
                }
                throw new BdHttpCancelException();
            } finally {
                lg.e(this.c);
            }
        }
    }
}
