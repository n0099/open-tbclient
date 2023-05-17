package com.sina.weibo.sdk.network.base;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.impl.RequestParam;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes9.dex */
public class RequestBodyHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String OCTET_STREAM = "application/octet-stream";
    public transient /* synthetic */ FieldHolder $fh;

    public RequestBodyHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void fillMultiBody(OutputStream outputStream, IRequestParam iRequestParam, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, outputStream, iRequestParam, str) == null) {
            Bundle postBundle = iRequestParam.getPostBundle();
            for (String str2 : postBundle.keySet()) {
                StringBuilder sb = new StringBuilder(100);
                sb.setLength(0);
                sb.append("--");
                sb.append(str);
                sb.append("\r\n");
                sb.append("Content-Disposition: form-data; name=\"");
                sb.append(str2);
                sb.append("\"");
                sb.append("\r\n");
                sb.append("Content-Type: text/plain;charset:\"UTF-8\"\r\n");
                sb.append("Content-Transfer-Encoding: 8bit");
                sb.append("\r\n");
                sb.append("\r\n");
                sb.append(String.valueOf(postBundle.get(str2)));
                sb.append("\r\n");
                outputStream.write(sb.toString().getBytes("UTF-8"));
            }
            Map<String, IRequestParam.ValuePart<File>> files = iRequestParam.files();
            for (String str3 : files.keySet()) {
                IRequestParam.ValuePart<File> valuePart = files.get(str3);
                File file = valuePart.value;
                String str4 = valuePart.mimeType;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("--");
                stringBuffer.append(str);
                stringBuffer.append("\r\n");
                stringBuffer.append("Content-Disposition: form-data; name=\"");
                stringBuffer.append(str3);
                stringBuffer.append("\";");
                stringBuffer.append("filename=\"");
                stringBuffer.append(file.getName());
                stringBuffer.append("\"");
                stringBuffer.append("\r\n");
                stringBuffer.append(Part.CONTENT_TYPE + str4 + ";charset:\"UTF-8\"\r\n");
                stringBuffer.append("\r\n");
                outputStream.write(stringBuffer.toString().getBytes("UTF-8"));
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    }
                }
                fileInputStream.close();
                outputStream.write("\r\n".getBytes());
            }
            Map<String, byte[]> byteArrays = iRequestParam.byteArrays();
            for (String str5 : byteArrays.keySet()) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("--");
                stringBuffer2.append(str);
                stringBuffer2.append("\r\n");
                stringBuffer2.append("Content-Disposition: form-data; name=\"");
                stringBuffer2.append(str5);
                stringBuffer2.append("\"");
                stringBuffer2.append("\r\n");
                stringBuffer2.append("Content-Type: text/plain;charset:\"UTF-8\"\r\n");
                stringBuffer2.append("\r\n");
                outputStream.write(stringBuffer2.toString().getBytes());
                outputStream.write(byteArrays.get(str5));
                outputStream.write("\r\n".getBytes());
            }
            outputStream.write(("--" + str + "--\r\n").getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }

    public static void fillRequestBody(IRequestParam iRequestParam, HttpURLConnection httpURLConnection, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, iRequestParam, httpURLConnection, str) == null) {
            byte[] byteArray = iRequestParam.getPostBundle().getByteArray(RequestParam.KEY_PARAM_BODY_BYTE_ARRAY);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            if (byteArray != null) {
                if (iRequestParam.needGzip()) {
                    dataOutputStream.write(transGzip(byteArray));
                } else {
                    dataOutputStream.write(byteArray);
                }
            } else if (isMultipartRequest(iRequestParam)) {
                fillMultiBody(dataOutputStream, iRequestParam, str);
            } else {
                Bundle postBundle = iRequestParam.getPostBundle();
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (String str2 : postBundle.keySet()) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    try {
                        String valueOf = String.valueOf(postBundle.get(str2));
                        sb.append(URLEncoder.encode(str2, "UTF-8"));
                        sb.append("=");
                        sb.append(URLEncoder.encode(valueOf, "UTF-8"));
                    } catch (Exception unused) {
                    }
                }
                DataOutputStream dataOutputStream2 = new DataOutputStream(dataOutputStream);
                if (iRequestParam.needGzip()) {
                    dataOutputStream2.write(transGzip(sb.toString().getBytes("UTF-8")));
                } else {
                    dataOutputStream2.write(sb.toString().getBytes("UTF-8"));
                }
                dataOutputStream2.flush();
                dataOutputStream2.close();
            }
            outputStream.flush();
            outputStream.close();
        }
    }

    public static String getBoundry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 1; i < 12; i++) {
                long currentTimeMillis = System.currentTimeMillis() + i;
                long j = currentTimeMillis % 3;
                if (j == 0) {
                    stringBuffer.append(((char) currentTimeMillis) % '\t');
                } else if (j == 1) {
                    stringBuffer.append((char) ((currentTimeMillis % 26) + 65));
                } else {
                    stringBuffer.append((char) ((currentTimeMillis % 26) + 97));
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public static boolean isMultipartRequest(IRequestParam iRequestParam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iRequestParam)) == null) {
            Map<String, IRequestParam.ValuePart<File>> files = iRequestParam.files();
            Map<String, byte[]> byteArrays = iRequestParam.byteArrays();
            if (files.isEmpty() && byteArrays.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static byte[] transGzip(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }
}
