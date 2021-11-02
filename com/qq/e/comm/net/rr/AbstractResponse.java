package com.qq.e.comm.net.rr;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
/* loaded from: classes2.dex */
public abstract class AbstractResponse implements Response {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HttpURLConnection f68066a;

    /* renamed from: b  reason: collision with root package name */
    public int f68067b;

    public AbstractResponse(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpURLConnection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68067b = 0;
        if (httpURLConnection == null) {
            throw new AssertionError("AbstractResponse parameter is null");
        }
        this.f68066a = httpURLConnection;
        try {
            this.f68067b = httpURLConnection.getResponseCode();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public void close() throws IllegalStateException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f68066a.disconnect();
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() throws IllegalStateException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (byte[]) invokeV.objValue;
        }
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = streamContent.read(bArr);
            if (read <= 0) {
                streamContent.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68067b : invokeV.intValue;
    }

    @Override // com.qq.e.comm.net.rr.Response
    public InputStream getStreamContent() throws IllegalStateException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68066a.getInputStream() : (InputStream) invokeV.objValue;
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getStringContent("UTF-8") : (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            byte[] bytesContent = getBytesContent();
            String str2 = null;
            if (bytesContent == null) {
                return null;
            }
            if (bytesContent.length == 0) {
                return "";
            }
            try {
                str2 = this.f68066a.getContentEncoding();
            } catch (Throwable unused) {
            }
            if (str2 != null) {
                str = str2;
            }
            return new String(bytesContent, str);
        }
        return (String) invokeL.objValue;
    }
}
