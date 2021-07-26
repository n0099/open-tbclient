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
/* loaded from: classes6.dex */
public class U0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public URL f39686a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f39687b;

    /* renamed from: c  reason: collision with root package name */
    public Map f39688c;

    /* renamed from: d  reason: collision with root package name */
    public Map f39689d;

    /* renamed from: e  reason: collision with root package name */
    public String f39690e;

    /* renamed from: f  reason: collision with root package name */
    public int f39691f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39692g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39693h;

    /* renamed from: i  reason: collision with root package name */
    public int f39694i;
    public int j;

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
        this.f39690e = "GET";
        this.f39691f = -1;
        this.f39692g = false;
        this.f39693h = true;
        this.f39686a = new URL(str);
        this.f39690e = str2;
        this.f39688c = map;
        this.f39694i = 20000;
        this.j = 20000;
    }

    public V0 a() {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String url = this.f39686a.toString();
            if (!TextUtils.isEmpty(url) ? url.startsWith("http") : false) {
                httpURLConnection = (HttpURLConnection) this.f39686a.openConnection();
            } else {
                httpURLConnection = (HttpsURLConnection) this.f39686a.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f39690e);
            httpURLConnection.setInstanceFollowRedirects(this.f39693h);
            httpURLConnection.setReadTimeout(this.j);
            httpURLConnection.setConnectTimeout(this.f39694i);
            httpURLConnection.setDoInput(true);
            Map map = this.f39688c;
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    for (String str2 : (List) entry.getValue()) {
                        String str3 = "header:" + str + "=" + str2;
                        httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
            if (this.f39690e.equals("POST")) {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                PrintWriter printWriter = null;
                PrintWriter printWriter2 = null;
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    byte[] bArr = this.f39687b;
                    if (bArr == null) {
                        PrintWriter printWriter3 = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                        try {
                            URL url2 = this.f39686a;
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
            this.f39691f = httpURLConnection.getResponseCode();
            httpURLConnection.getContentLength();
            if (httpURLConnection.getHeaderFields() != null) {
                this.f39689d = httpURLConnection.getHeaderFields();
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
            while (!this.f39692g && i2 != -1) {
                i2 = bufferedInputStream.read(bArr2);
                if (i2 > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i2);
                }
            }
            httpURLConnection.disconnect();
            byteArrayOutputStream.flush();
            errorStream.close();
            return new V0(this.f39691f, byteArrayOutputStream.toByteArray(), this.f39689d);
        }
        return (V0) invokeV.objValue;
    }
}
