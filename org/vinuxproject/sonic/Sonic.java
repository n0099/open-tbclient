package org.vinuxproject.sonic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Sonic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

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

    public Sonic(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        b();
        this.a = initNative(i2, i3);
    }

    private native int availableBytesNative(long j2);

    private native void closeNative(long j2);

    private native void flushNative(long j2);

    private native boolean getChordPitchNative(long j2);

    private native int getNumChannelsNative(long j2);

    private native float getPitchNative(long j2);

    private native float getRateNative(long j2);

    private native int getSampleRateNative(long j2);

    private native float getSpeedNative(long j2);

    private native float getVolumeNative(long j2);

    private native long initNative(int i2, int i3);

    private native boolean putBytesNative(long j2, byte[] bArr, int i2);

    private native int receiveBytesNative(long j2, byte[] bArr, int i2);

    private native void setChordPitchNative(long j2, boolean z);

    private native void setNumChannelsNative(long j2, int i2);

    private native void setPitchNative(long j2, float f2);

    private native void setRateNative(long j2, float f2);

    private native void setSampleRateNative(long j2, int i2);

    private native void setSpeedNative(long j2, float f2);

    private native void setVolumeNative(long j2, float f2);

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? availableBytesNative(this.a) : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long j2 = this.a;
            if (j2 != 0) {
                closeNative(j2);
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

    public boolean d(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bArr, i2)) == null) ? putBytesNative(this.a, bArr, i2) : invokeLI.booleanValue;
    }

    public int e(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i2)) == null) ? receiveBytesNative(this.a, bArr, i2) : invokeLI.intValue;
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            setSpeedNative(this.a, f2);
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
        }
    }
}
