package io.flutter.plugin.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes3.dex */
public final class StandardMethodCodec implements MethodCodec {
    public static /* synthetic */ Interceptable $ic;
    public static final StandardMethodCodec INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public final StandardMessageCodec messageCodec;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-746529285, "Lio/flutter/plugin/common/StandardMethodCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-746529285, "Lio/flutter/plugin/common/StandardMethodCodec;");
                return;
            }
        }
        INSTANCE = new StandardMethodCodec(StandardMessageCodec.INSTANCE);
    }

    public StandardMethodCodec(StandardMessageCodec standardMessageCodec) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {standardMessageCodec};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.messageCodec = standardMessageCodec;
    }

    public static String getStackTrace(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r0 == 1) goto L10;
     */
    @Override // io.flutter.plugin.common.MethodCodec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decodeEnvelope(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            byteBuffer.order(ByteOrder.nativeOrder());
            byte b2 = byteBuffer.get();
            if (b2 == 0) {
                Object readValue = this.messageCodec.readValue(byteBuffer);
                if (!byteBuffer.hasRemaining()) {
                    return readValue;
                }
            }
            Object readValue2 = this.messageCodec.readValue(byteBuffer);
            Object readValue3 = this.messageCodec.readValue(byteBuffer);
            Object readValue4 = this.messageCodec.readValue(byteBuffer);
            if ((readValue2 instanceof String) && ((readValue3 == null || (readValue3 instanceof String)) && !byteBuffer.hasRemaining())) {
                throw new FlutterException((String) readValue2, (String) readValue3, readValue4);
            }
            throw new IllegalArgumentException("Envelope corrupted");
        }
        return invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public MethodCall decodeMethodCall(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer)) == null) {
            byteBuffer.order(ByteOrder.nativeOrder());
            Object readValue = this.messageCodec.readValue(byteBuffer);
            Object readValue2 = this.messageCodec.readValue(byteBuffer);
            if ((readValue instanceof String) && !byteBuffer.hasRemaining()) {
                return new MethodCall((String) readValue, readValue2);
            }
            throw new IllegalArgumentException("Method call corrupted");
        }
        return (MethodCall) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public ByteBuffer encodeErrorEnvelope(String str, String str2, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, obj)) == null) {
            StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
            exposedByteArrayOutputStream.write(1);
            this.messageCodec.writeValue(exposedByteArrayOutputStream, str);
            this.messageCodec.writeValue(exposedByteArrayOutputStream, str2);
            if (obj instanceof Throwable) {
                this.messageCodec.writeValue(exposedByteArrayOutputStream, getStackTrace((Throwable) obj));
            } else {
                this.messageCodec.writeValue(exposedByteArrayOutputStream, obj);
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
            allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
            return allocateDirect;
        }
        return (ByteBuffer) invokeLLL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public ByteBuffer encodeErrorEnvelopeWithStacktrace(String str, String str2, Object obj, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, obj, str3)) == null) {
            StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
            exposedByteArrayOutputStream.write(1);
            this.messageCodec.writeValue(exposedByteArrayOutputStream, str);
            this.messageCodec.writeValue(exposedByteArrayOutputStream, str2);
            if (obj instanceof Throwable) {
                this.messageCodec.writeValue(exposedByteArrayOutputStream, getStackTrace((Throwable) obj));
            } else {
                this.messageCodec.writeValue(exposedByteArrayOutputStream, obj);
            }
            this.messageCodec.writeValue(exposedByteArrayOutputStream, str3);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
            allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
            return allocateDirect;
        }
        return (ByteBuffer) invokeLLLL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public ByteBuffer encodeMethodCall(MethodCall methodCall) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, methodCall)) == null) {
            StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
            this.messageCodec.writeValue(exposedByteArrayOutputStream, methodCall.method);
            this.messageCodec.writeValue(exposedByteArrayOutputStream, methodCall.arguments);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
            allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
            return allocateDirect;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    public ByteBuffer encodeSuccessEnvelope(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
            exposedByteArrayOutputStream.write(0);
            this.messageCodec.writeValue(exposedByteArrayOutputStream, obj);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
            allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
            return allocateDirect;
        }
        return (ByteBuffer) invokeL.objValue;
    }
}
