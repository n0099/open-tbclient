package com.repackage;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes6.dex */
public class n81 implements m81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public boolean b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ j81 b;
        public final /* synthetic */ h81 c;
        public final /* synthetic */ n81 d;

        /* renamed from: com.repackage.n81$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0529a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0529a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.c.c(this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public b(a aVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h81 h81Var = this.c.c;
                    h81Var.a(new IOException("status code " + this.a + ", response " + this.b), 119501, this.b);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;
            public final /* synthetic */ a b;

            public c(a aVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h81 h81Var = this.b.c;
                    Throwable th = this.a;
                    h81Var.a(th, 119501, th.getMessage());
                }
            }
        }

        public a(n81 n81Var, String str, j81 j81Var, h81 h81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n81Var, str, j81Var, h81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n81Var;
            this.a = str;
            this.b = j81Var;
            this.c = h81Var;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00ce */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x0051 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable[]] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9, types: [java.io.Closeable[]] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable[]] */
        /* JADX WARN: Type inference failed for: r5v4, types: [com.repackage.h81] */
        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            HttpURLConnection httpURLConnection;
            int responseCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ?? r0 = 119501;
                r0 = 119501;
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
                    for (Map.Entry<String, String> entry : this.b.c().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = null;
                }
                try {
                    if (responseCode >= 200 && responseCode <= 299) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        String c2 = x91.c(inputStream);
                        httpURLConnection = inputStream;
                        if (this.c != null) {
                            if (this.d.b) {
                                this.d.a.post(new RunnableC0529a(this, c2));
                                httpURLConnection = inputStream;
                            } else {
                                this.c.c(c2);
                                httpURLConnection = inputStream;
                            }
                        }
                    } else {
                        InputStream errorStream = httpURLConnection.getErrorStream();
                        String c3 = x91.c(errorStream);
                        httpURLConnection = errorStream;
                        if (this.c != null) {
                            if (this.d.b) {
                                this.d.a.post(new b(this, responseCode, c3));
                                httpURLConnection = errorStream;
                            } else {
                                h81 h81Var = this.c;
                                StringBuilder sb = new StringBuilder();
                                sb.append("status code ");
                                sb.append(responseCode);
                                sb.append(", response ");
                                sb.append(c3);
                                h81Var.a(new IOException(sb.toString()), 119501, c3);
                                httpURLConnection = errorStream;
                            }
                        }
                    }
                    r0 = new Closeable[]{httpURLConnection};
                    x91.a(r0);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        if (this.c != null) {
                            z91.c("GET FAILED", th);
                            if (this.d.b) {
                                this.d.a.post(new c(this, th));
                            } else {
                                this.c.a(th, r0, th.getMessage());
                            }
                        }
                        x91.a(new Closeable[]{httpURLConnection});
                    } catch (Throwable th4) {
                        x91.a(new Closeable[]{httpURLConnection});
                        throw th4;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ j81 b;
        public final /* synthetic */ i81 c;
        public final /* synthetic */ h81 d;
        public final /* synthetic */ n81 e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.d.c(this.a);
                }
            }
        }

        /* renamed from: com.repackage.n81$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0530b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ b c;

            public RunnableC0530b(b bVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h81 h81Var = this.c.d;
                    h81Var.a(new IOException("status code " + this.a + ", response " + this.b), this.a, da1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0ec8));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;
            public final /* synthetic */ b b;

            public c(b bVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.d.a(this.a, -1000, da1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0ec8));
                }
            }
        }

        public b(n81 n81Var, String str, j81 j81Var, i81 i81Var, h81 h81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n81Var, str, j81Var, i81Var, h81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n81Var;
            this.a = str;
            this.b = j81Var;
            this.c = i81Var;
            this.d = h81Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            DataOutputStream dataOutputStream;
            HttpURLConnection httpURLConnection;
            byte[] bytes;
            InputStream errorStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m91.a("1.03", System.currentTimeMillis());
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
                    for (Map.Entry<String, String> entry : this.b.c().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<String, String> entry2 : this.c.c().entrySet()) {
                        String encode = URLEncoder.encode(entry2.getValue());
                        sb.append(entry2.getKey());
                        sb.append("=");
                        sb.append(encode);
                        sb.append("&");
                    }
                    bytes = sb.toString().getBytes();
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                    httpURLConnection.connect();
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = null;
                }
                try {
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode <= 299) {
                        errorStream = httpURLConnection.getInputStream();
                        String c2 = x91.c(errorStream);
                        if (this.d != null) {
                            if (this.e.b) {
                                this.e.a.post(new a(this, c2));
                            } else {
                                this.d.c(c2);
                            }
                        }
                    } else {
                        errorStream = httpURLConnection.getErrorStream();
                        String c3 = x91.c(errorStream);
                        if (this.d != null) {
                            if (this.e.b) {
                                this.e.a.post(new RunnableC0530b(this, responseCode, c3));
                            } else {
                                h81 h81Var = this.d;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("status code ");
                                sb2.append(responseCode);
                                sb2.append(", response ");
                                sb2.append(c3);
                                h81Var.a(new IOException(sb2.toString()), responseCode, da1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0ec8));
                            }
                        }
                    }
                    x91.a(errorStream, dataOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        z91.c("POST FAILED", th);
                        if (this.d != null) {
                            if (this.e.b) {
                                this.e.a.post(new c(this, th));
                            } else {
                                this.d.a(th, -1000, da1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0ec8));
                            }
                        }
                        x91.a(null, dataOutputStream);
                    } catch (Throwable th3) {
                        x91.a(null, dataOutputStream);
                        throw th3;
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n81() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.m81
    public void a(String str, j81 j81Var, i81 i81Var, h81<String> h81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, j81Var, i81Var, h81Var) == null) {
            if (!l81.b(da1.a())) {
                h81Var.a(new Exception(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR), 119501, da1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0415));
            } else {
                r91.a(new b(this, str, j81Var, i81Var, h81Var));
            }
        }
    }

    public void d(String str, j81 j81Var, h81<String> h81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j81Var, h81Var) == null) {
            r91.a(new a(this, str, j81Var, h81Var));
        }
    }

    public n81(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.b = z;
    }
}
