package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public class T implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f77251a;

    /* renamed from: b  reason: collision with root package name */
    public String f77252b;

    /* renamed from: c  reason: collision with root package name */
    public String f77253c;

    /* renamed from: d  reason: collision with root package name */
    public V f77254d;

    /* renamed from: e  reason: collision with root package name */
    public Q f77255e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f77256f;

    /* renamed from: g  reason: collision with root package name */
    public long f77257g;

    public T(String str, String str2, V v) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, v};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77251a = 0;
        this.f77256f = false;
        this.f77252b = str;
        this.f77253c = str2;
        this.f77254d = v;
        this.f77255e = new Q(this);
        this.f77256f = true;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f77252b);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f77251a + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.f77257g = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f77255e != null && this.f77257g > 10) {
                this.f77255e.a(httpURLConnection.getInputStream());
            } else if (this.f77254d != null) {
                this.f77254d.a();
            }
        } catch (IOException e2) {
            if (!Thread.currentThread().isInterrupted()) {
                throw e2;
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
                Q q = this.f77255e;
                if (q != null) {
                    q.b(q.a(1, new Object[]{S.f77228b}));
                }
            }
        }
    }
}
