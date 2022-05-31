package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.Q;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class hm9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public nm9 d;
    public ul9 e;
    public boolean f;
    public long g;

    public hm9(String str, String str2, nm9 nm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, nm9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f = false;
        this.b = str;
        this.c = str2;
        this.d = nm9Var;
        this.e = new ul9(this);
        this.f = true;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.b);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.a + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.g = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.e != null && this.g > 10) {
                this.e.c(httpURLConnection.getInputStream());
            } else if (this.d != null) {
                this.d.a();
            }
        } catch (IOException e) {
            if (!Thread.currentThread().isInterrupted()) {
                throw e;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                a();
            } catch (Exception unused) {
                ul9 ul9Var = this.e;
                if (ul9Var != null) {
                    ul9Var.d(ul9Var.a(1, new Object[]{Q.b}));
                }
            }
        }
    }
}
