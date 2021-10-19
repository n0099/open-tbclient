package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes10.dex */
public class U0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public URL f77260a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f77261b;

    /* renamed from: c  reason: collision with root package name */
    public Map f77262c;

    /* renamed from: d  reason: collision with root package name */
    public Map f77263d;

    /* renamed from: e  reason: collision with root package name */
    public String f77264e;

    /* renamed from: f  reason: collision with root package name */
    public int f77265f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f77266g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f77267h;

    /* renamed from: i  reason: collision with root package name */
    public int f77268i;

    /* renamed from: j  reason: collision with root package name */
    public int f77269j;

    public U0(String str, String str2, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77264e = "GET";
        this.f77265f = -1;
        this.f77266g = false;
        this.f77267h = true;
        this.f77260a = new URL(str);
        this.f77264e = str2;
        this.f77262c = map;
        this.f77268i = 20000;
        this.f77269j = 20000;
    }

    public V0 a() {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String url = this.f77260a.toString();
            if (!TextUtils.isEmpty(url) ? url.startsWith("http") : false) {
                httpURLConnection = (HttpURLConnection) this.f77260a.openConnection();
            } else {
                httpURLConnection = (HttpsURLConnection) this.f77260a.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f77264e);
            httpURLConnection.setInstanceFollowRedirects(this.f77267h);
            httpURLConnection.setReadTimeout(this.f77269j);
            httpURLConnection.setConnectTimeout(this.f77268i);
            httpURLConnection.setDoInput(true);
            Map map = this.f77262c;
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    for (String str2 : (List) entry.getValue()) {
                        String str3 = "header:" + str + "=" + str2;
                        httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
            if (this.f77264e.equals("POST")) {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                PrintWriter printWriter = null;
                PrintWriter printWriter2 = null;
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    byte[] bArr = this.f77261b;
                    if (bArr == null) {
                        PrintWriter printWriter3 = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                        try {
                            URL url2 = this.f77260a;
                            printWriter3.print(url2 != null ? url2.getQuery() : null);
                            printWriter3.flush();
                            printWriter2 = printWriter3;
                        } catch (Throwable th) {
                            th = th;
                            printWriter = printWriter3;
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            throw th;
                        }
                    } else {
                        outputStream.write(bArr);
                        outputStream.flush();
                    }
                    if (printWriter2 != null) {
                        printWriter2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            this.f77265f = httpURLConnection.getResponseCode();
            httpURLConnection.getContentLength();
            if (httpURLConnection.getHeaderFields() != null) {
                this.f77263d = httpURLConnection.getHeaderFields();
            }
            try {
                String contentEncoding = httpURLConnection.getContentEncoding();
                errorStream = (contentEncoding == null || !contentEncoding.contains(AsyncHttpClient.ENCODING_GZIP)) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
            } catch (IOException e2) {
                errorStream = httpURLConnection.getErrorStream();
                if (errorStream == null) {
                    throw new RuntimeException("InputStream is error: " + e2.getMessage());
                }
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
            byte[] bArr2 = new byte[4096];
            int i2 = 0;
            while (!this.f77266g && i2 != -1) {
                i2 = bufferedInputStream.read(bArr2);
                if (i2 > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i2);
                }
            }
            httpURLConnection.disconnect();
            byteArrayOutputStream.flush();
            errorStream.close();
            return new V0(this.f77265f, byteArrayOutputStream.toByteArray(), this.f77263d);
        }
        return (V0) invokeV.objValue;
    }
}
