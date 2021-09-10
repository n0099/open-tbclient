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
    public URL f76906a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f76907b;

    /* renamed from: c  reason: collision with root package name */
    public Map f76908c;

    /* renamed from: d  reason: collision with root package name */
    public Map f76909d;

    /* renamed from: e  reason: collision with root package name */
    public String f76910e;

    /* renamed from: f  reason: collision with root package name */
    public int f76911f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f76912g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f76913h;

    /* renamed from: i  reason: collision with root package name */
    public int f76914i;

    /* renamed from: j  reason: collision with root package name */
    public int f76915j;

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
        this.f76910e = "GET";
        this.f76911f = -1;
        this.f76912g = false;
        this.f76913h = true;
        this.f76906a = new URL(str);
        this.f76910e = str2;
        this.f76908c = map;
        this.f76914i = 20000;
        this.f76915j = 20000;
    }

    public V0 a() {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String url = this.f76906a.toString();
            if (!TextUtils.isEmpty(url) ? url.startsWith("http") : false) {
                httpURLConnection = (HttpURLConnection) this.f76906a.openConnection();
            } else {
                httpURLConnection = (HttpsURLConnection) this.f76906a.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f76910e);
            httpURLConnection.setInstanceFollowRedirects(this.f76913h);
            httpURLConnection.setReadTimeout(this.f76915j);
            httpURLConnection.setConnectTimeout(this.f76914i);
            httpURLConnection.setDoInput(true);
            Map map = this.f76908c;
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    for (String str2 : (List) entry.getValue()) {
                        String str3 = "header:" + str + "=" + str2;
                        httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
            if (this.f76910e.equals("POST")) {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                PrintWriter printWriter = null;
                PrintWriter printWriter2 = null;
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    byte[] bArr = this.f76907b;
                    if (bArr == null) {
                        PrintWriter printWriter3 = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                        try {
                            URL url2 = this.f76906a;
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
            this.f76911f = httpURLConnection.getResponseCode();
            httpURLConnection.getContentLength();
            if (httpURLConnection.getHeaderFields() != null) {
                this.f76909d = httpURLConnection.getHeaderFields();
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
            while (!this.f76912g && i2 != -1) {
                i2 = bufferedInputStream.read(bArr2);
                if (i2 > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i2);
                }
            }
            httpURLConnection.disconnect();
            byteArrayOutputStream.flush();
            errorStream.close();
            return new V0(this.f76911f, byteArrayOutputStream.toByteArray(), this.f76909d);
        }
        return (V0) invokeV.objValue;
    }
}
