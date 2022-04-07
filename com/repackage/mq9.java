package com.repackage;

import android.text.TextUtils;
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
public class mq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public URL a;
    public byte[] b;
    public Map c;
    public Map d;
    public String e;
    public int f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;

    public mq9(String str, String str2, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = "GET";
        this.f = -1;
        this.g = false;
        this.h = true;
        this.a = new URL(str);
        this.e = str2;
        this.c = map;
        this.i = 20000;
        this.j = 20000;
    }

    public pq9 a() {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String url = this.a.toString();
            if (!TextUtils.isEmpty(url) ? url.startsWith("http") : false) {
                httpURLConnection = (HttpURLConnection) this.a.openConnection();
            } else {
                httpURLConnection = (HttpsURLConnection) this.a.openConnection();
            }
            httpURLConnection.setRequestMethod(this.e);
            httpURLConnection.setInstanceFollowRedirects(this.h);
            httpURLConnection.setReadTimeout(this.j);
            httpURLConnection.setConnectTimeout(this.i);
            httpURLConnection.setDoInput(true);
            Map map = this.c;
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    for (String str2 : (List) entry.getValue()) {
                        String str3 = "header:" + str + "=" + str2;
                        httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
            if (this.e.equals("POST")) {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                PrintWriter printWriter = null;
                PrintWriter printWriter2 = null;
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    byte[] bArr = this.b;
                    if (bArr == null) {
                        PrintWriter printWriter3 = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                        try {
                            URL url2 = this.a;
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
            this.f = httpURLConnection.getResponseCode();
            httpURLConnection.getContentLength();
            if (httpURLConnection.getHeaderFields() != null) {
                this.d = httpURLConnection.getHeaderFields();
            }
            try {
                String contentEncoding = httpURLConnection.getContentEncoding();
                errorStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
            } catch (IOException e) {
                errorStream = httpURLConnection.getErrorStream();
                if (errorStream == null) {
                    throw new RuntimeException("InputStream is error: " + e.getMessage());
                }
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
            byte[] bArr2 = new byte[4096];
            int i = 0;
            while (!this.g && i != -1) {
                i = bufferedInputStream.read(bArr2);
                if (i > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
            }
            httpURLConnection.disconnect();
            byteArrayOutputStream.flush();
            errorStream.close();
            return new pq9(this.f, byteArrayOutputStream.toByteArray(), this.d);
        }
        return (pq9) invokeV.objValue;
    }
}
