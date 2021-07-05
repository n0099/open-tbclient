package org.vinuxproject.sonic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class Sonic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f76130a;

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
        this.f76130a = 0L;
        b();
        this.f76130a = initNative(i2, i3);
    }

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

    private native long initNative(int i2, int i3);

    private native boolean putBytesNative(long j, byte[] bArr, int i2);

    private native int receiveBytesNative(long j, byte[] bArr, int i2);

    private native void setChordPitchNative(long j, boolean z);

    private native void setNumChannelsNative(long j, int i2);

    private native void setPitchNative(long j, float f2);

    private native void setRateNative(long j, float f2);

    private native void setSampleRateNative(long j, int i2);

    private native void setSpeedNative(long j, float f2);

    private native void setVolumeNative(long j, float f2);

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? availableBytesNative(this.f76130a) : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long j = this.f76130a;
            if (j != 0) {
                closeNative(j);
                this.f76130a = 0L;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            flushNative(this.f76130a);
        }
    }

    public boolean d(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bArr, i2)) == null) ? putBytesNative(this.f76130a, bArr, i2) : invokeLI.booleanValue;
    }

    public int e(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i2)) == null) ? receiveBytesNative(this.f76130a, bArr, i2) : invokeLI.intValue;
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            setSpeedNative(this.f76130a, f2);
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
        }
    }
}
