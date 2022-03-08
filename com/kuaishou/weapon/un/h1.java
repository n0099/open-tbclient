package com.kuaishou.weapon.un;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes7.dex */
public class h1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static h1 f53634c;
    public transient /* synthetic */ FieldHolder $fh;
    public SSLContext a;

    /* renamed from: b  reason: collision with root package name */
    public SSLSocketFactory f53635b;

    /* loaded from: classes7.dex */
    public class a implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ X509TrustManager a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h1 f53636b;

        public a(h1 h1Var, X509TrustManager x509TrustManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h1Var, x509TrustManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53636b = h1Var;
            this.a = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, x509CertificateArr, str) == null) {
                this.a.checkClientTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) == null) {
                try {
                    this.a.checkServerTrusted(x509CertificateArr, str);
                } catch (CertificateException e2) {
                    x0.a(e2);
                    for (Throwable th = e2; th != null; th = th.getCause()) {
                        if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
                            return;
                        }
                    }
                    throw e2;
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getAcceptedIssuers() : (X509Certificate[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h1 a;

        public b(h1 h1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h1Var;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, x509CertificateArr, str) == null) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) == null) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new X509Certificate[0] : (X509Certificate[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(534992775, "Lcom/kuaishou/weapon/un/h1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(534992775, "Lcom/kuaishou/weapon/un/h1;");
        }
    }

    public h1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized h1 b() {
        InterceptResult invokeV;
        h1 h1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (h1.class) {
                if (f53634c == null) {
                    f53634c = new h1();
                }
                h1Var = f53634c;
            }
            return h1Var;
        }
        return (h1) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0081 A[Catch: Exception -> 0x00af, TryCatch #5 {Exception -> 0x00af, blocks: (B:31:0x0061, B:33:0x0077, B:35:0x0081, B:37:0x00a6, B:36:0x0095, B:26:0x0054, B:20:0x0046), top: B:52:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095 A[Catch: Exception -> 0x00af, TryCatch #5 {Exception -> 0x00af, blocks: (B:31:0x0061, B:33:0x0077, B:35:0x0081, B:37:0x00a6, B:36:0x0095, B:26:0x0054, B:20:0x0046), top: B:52:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SSLSocketFactory a() {
        InterceptResult invokeV;
        KeyStore keyStore;
        X509TrustManager x509TrustManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SSLSocketFactory sSLSocketFactory = this.f53635b;
            if (sSLSocketFactory == null) {
                sSLSocketFactory = null;
                try {
                    keyStore = KeyStore.getInstance("AndroidCAStore");
                } catch (Throwable unused) {
                    keyStore = null;
                }
                try {
                    keyStore.load(null, null);
                } catch (Throwable unused2) {
                    try {
                        String property = System.getProperty("javax.net.ssl.trustStore");
                        String property2 = System.getProperty("javax.net.ssl.trustStorePassword");
                        char[] charArray = property2 == null ? null : property2.toCharArray();
                        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(property));
                        keyStore.load(bufferedInputStream, charArray);
                        bufferedInputStream.close();
                    } catch (Throwable unused3) {
                    }
                    if (keyStore != null) {
                    }
                    x509TrustManager = null;
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    this.a = sSLContext;
                    if (x509TrustManager != null) {
                    }
                    SSLSocketFactory socketFactory = this.a.getSocketFactory();
                    this.f53635b = socketFactory;
                    return socketFactory;
                }
                if (keyStore != null) {
                    try {
                        Class<?> cls = Class.forName("com.android.org.conscrypt.TrustManagerImpl");
                        if (cls == null) {
                            cls = Class.forName("org.apache.harmony.xnet.provider.jsse.TrustManagerImpl");
                        }
                        if (cls != null) {
                            x509TrustManager = (X509TrustManager) cls.getDeclaredConstructor(KeyStore.class).newInstance(keyStore);
                            SSLContext sSLContext2 = SSLContext.getInstance("TLS");
                            this.a = sSLContext2;
                            if (x509TrustManager != null) {
                                this.a.init(null, new TrustManager[]{new a(this, x509TrustManager)}, new SecureRandom());
                            } else {
                                sSLContext2.init(null, new TrustManager[]{new b(this)}, new SecureRandom());
                            }
                            SSLSocketFactory socketFactory2 = this.a.getSocketFactory();
                            this.f53635b = socketFactory2;
                            return socketFactory2;
                        }
                    } catch (Exception unused4) {
                    }
                }
                x509TrustManager = null;
                SSLContext sSLContext22 = SSLContext.getInstance("TLS");
                this.a = sSLContext22;
                if (x509TrustManager != null) {
                }
                SSLSocketFactory socketFactory22 = this.a.getSocketFactory();
                this.f53635b = socketFactory22;
                return socketFactory22;
            }
            return sSLSocketFactory;
        }
        return (SSLSocketFactory) invokeV.objValue;
    }
}
