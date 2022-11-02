package org.vinuxproject.sonic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class Sonic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    private native int availableBytesNative(long j);

    private native void closeNative(long j);

    private native void flushNative(long j);

    private native boolean getChordPitchNative(long j);

    private native int getNumChannelsNative(long j);

    private native float getPitchNative(long j);

    private native float getRateNative(long j);

    private native int getSampleRateNative(long j);

    private native float getSpeedNative(long j);

    private native float getVolumeNative(long j);

    private native long initNative(int i, int i2);

    private native boolean putBytesNative(long j, byte[] bArr, int i);

    private native int receiveBytesNative(long j, byte[] bArr, int i);

    private native void setChordPitchNative(long j, boolean z);

    private native void setNumChannelsNative(long j, int i);

    private native void setPitchNative(long j, float f);

    private native void setRateNative(long j, float f);

    private native void setSampleRateNative(long j, int i);

    private native void setSpeedNative(long j, float f);

    private native void setVolumeNative(long j, float f);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(10700015, "Lorg/vinuxproject/sonic/Sonic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(10700015, "Lorg/vinuxproject/sonic/Sonic;");
                return;
            }
        }
        System.loadLibrary("sonic");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return availableBytesNative(this.a);
        }
        return invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long j = this.a;
            if (j != 0) {
                closeNative(j);
                this.a = 0L;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            flushNative(this.a);
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
        }
    }

    public Sonic(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        b();
        this.a = initNative(i, i2);
    }

    public boolean d(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bArr, i)) == null) {
            return putBytesNative(this.a, bArr, i);
        }
        return invokeLI.booleanValue;
    }

    public int e(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i)) == null) {
            return receiveBytesNative(this.a, bArr, i);
        }
        return invokeLI.intValue;
    }

    public void f(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            setSpeedNative(this.a, f);
        }
    }
}
