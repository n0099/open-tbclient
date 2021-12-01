package org.webrtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.Logging;
/* loaded from: classes3.dex */
public class CallSessionFileRotatingLogSink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long nativeSink;

    public CallSessionFileRotatingLogSink(String str, int i2, Logging.Severity severity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), severity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (str != null) {
            this.nativeSink = nativeAddSink(str, i2, severity.ordinal());
            return;
        }
        throw new IllegalArgumentException("dirPath may not be null.");
    }

    public static byte[] getLogData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                return nativeGetLogData(str);
            }
            throw new IllegalArgumentException("dirPath may not be null.");
        }
        return (byte[]) invokeL.objValue;
    }

    public static native long nativeAddSink(String str, int i2, int i3);

    public static native void nativeDeleteSink(long j2);

    public static native byte[] nativeGetLogData(String str);

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.nativeSink;
            if (j2 != 0) {
                nativeDeleteSink(j2);
                this.nativeSink = 0L;
            }
        }
    }
}
