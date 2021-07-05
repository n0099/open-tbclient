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
/* loaded from: classes7.dex */
public class E implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f42333a;

    /* renamed from: b  reason: collision with root package name */
    public String f42334b;

    /* renamed from: c  reason: collision with root package name */
    public String f42335c;

    /* renamed from: d  reason: collision with root package name */
    public G f42336d;

    /* renamed from: e  reason: collision with root package name */
    public C f42337e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42338f;

    /* renamed from: g  reason: collision with root package name */
    public long f42339g;

    public E(String str, String str2, G g2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, g2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42333a = 0;
        this.f42338f = false;
        this.f42334b = str;
        this.f42335c = str2;
        this.f42336d = g2;
        this.f42337e = new C(this);
        this.f42338f = true;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f42334b);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f42333a + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.f42339g = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f42337e != null && this.f42339g > 10) {
                this.f42337e.a(httpURLConnection.getInputStream());
            } else if (this.f42336d != null) {
                this.f42336d.a();
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
                C c2 = this.f42337e;
                if (c2 != null) {
                    c2.b(c2.a(1, new Object[]{D.f42319b}));
                }
            }
        }
    }
}
