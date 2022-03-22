package com.fun.ad.sdk.internal.api.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes6.dex */
public abstract class Request {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f38613b;
    public String contentType;
    public String httpMethod;
    public byte[] requestBody;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Request(String str, RequestParams requestParams) {
        this(str, requestParams, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, requestParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (RequestParams) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Request(String str, RequestParams requestParams, boolean z) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, requestParams, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (str == null) {
            throw new IllegalArgumentException("url is null");
        }
        this.a = str;
        this.f38613b = z;
        if (requestParams != null) {
            String str2 = "?";
            if (str.contains("?")) {
                sb = new StringBuilder();
                sb.append(this.a);
                str2 = "&";
            } else {
                sb = new StringBuilder();
                sb.append(this.a);
            }
            sb.append(str2);
            sb.append(requestParams.flatToString());
            this.a = sb.toString();
        }
    }

    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.contentType : (String) invokeV.objValue;
    }

    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.httpMethod : (String) invokeV.objValue;
    }

    public byte[] getRequestBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.requestBody : (byte[]) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean isDoOutput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "POST".equals(this.httpMethod) && this.requestBody != null : invokeV.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(14:16|(4:67|68|(3:70|71|72)|73)|18|(2:23|24)|32|33|34|(2:35|(1:37)(1:38))|39|40|41|42|(2:45|46)|44)|33|34|(3:35|(0)(0)|37)|39|40|41|42|(0)|44) */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc A[Catch: all -> 0x00ff, Exception -> 0x0101, LOOP:0: B:34:0x00d5->B:36:0x00dc, LOOP_END, TryCatch #9 {Exception -> 0x0101, all -> 0x00ff, blocks: (B:33:0x00ce, B:34:0x00d5, B:36:0x00dc, B:37:0x00e0), top: B:88:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e0 A[EDGE_INSN: B:90:0x00e0->B:37:0x00e0 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response perform() {
        InterceptResult invokeV;
        OutputStream outputStream;
        OutputStream outputStream2;
        Throwable th;
        OutputStream outputStream3;
        Exception e2;
        String contentEncoding;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048581, this)) != null) {
            return (Response) invokeV.objValue;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(getUrl()).openConnection();
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(8000);
                httpURLConnection.setRequestMethod(getMethod());
                httpURLConnection.setDoOutput(isDoOutput());
                if (getContentType() != null) {
                    httpURLConnection.setRequestProperty("Content-Type", getContentType());
                }
                if (this.f38613b) {
                    httpURLConnection.setRequestProperty("Content-Encoding", "application/gzip");
                }
                httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                httpURLConnection.setRequestProperty("User-agent", System.getProperty("http.agent"));
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                httpURLConnection.connect();
            } catch (Throwable th2) {
                outputStream = 30000;
                th = th2;
                OutputStream outputStream4 = outputStream;
                th = th;
                outputStream3 = outputStream4;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            OutputStream outputStream42 = outputStream;
            th = th;
            outputStream3 = outputStream42;
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
            if (outputStream3 != null) {
            }
            throw th;
        }
        try {
            if (httpURLConnection.getDoOutput()) {
                outputStream3 = httpURLConnection.getOutputStream();
                if (outputStream3 != null) {
                    try {
                        byte[] requestBody = getRequestBody();
                        if (this.f38613b) {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                            gZIPOutputStream.write(requestBody);
                            gZIPOutputStream.flush();
                            gZIPOutputStream.close();
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            LogPrinter.v("origin:%d gzip:%d", Integer.valueOf(requestBody.length), Integer.valueOf(byteArray.length));
                            requestBody = byteArray;
                        }
                        outputStream3.write(requestBody);
                        outputStream3.flush();
                        outputStream3.close();
                    } catch (Exception e4) {
                        outputStream2 = outputStream3;
                        e = e4;
                        e2 = e;
                        throw new IOException(e2);
                    }
                }
                inputStream = httpURLConnection.getInputStream();
                contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding != null && "gzip".equals(contentEncoding.toLowerCase())) {
                    inputStream = new GZIPInputStream(inputStream);
                }
                bArr = new byte[16384];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    read = inputStream.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                Response response = new Response(httpURLConnection.getResponseCode(), httpURLConnection.getContentType(), byteArrayOutputStream.toString());
                httpURLConnection.disconnect();
                inputStream.close();
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (Exception unused3) {
                    }
                }
                return response;
            }
            bArr = new byte[16384];
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                read = inputStream.read(bArr);
                if (read != -1) {
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            Response response2 = new Response(httpURLConnection.getResponseCode(), httpURLConnection.getContentType(), byteArrayOutputStream.toString());
            httpURLConnection.disconnect();
            inputStream.close();
            if (outputStream3 != null) {
            }
            return response2;
        } catch (Exception e5) {
            e2 = e5;
            throw new IOException(e2);
        } catch (Throwable th4) {
            th = th4;
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
            if (outputStream3 != null) {
            }
            throw th;
        }
        outputStream3 = null;
        inputStream = httpURLConnection.getInputStream();
        contentEncoding = httpURLConnection.getContentEncoding();
        if (contentEncoding != null) {
            inputStream = new GZIPInputStream(inputStream);
        }
    }
}
