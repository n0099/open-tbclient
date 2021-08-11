package com.coremedia.iso.boxes.fragment;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class SampleFlags {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int reserved;
    public int sampleDegradationPriority;
    public int sampleDependsOn;
    public int sampleHasRedundancy;
    public int sampleIsDependedOn;
    public boolean sampleIsDifferenceSample;
    public int samplePaddingValue;

    public SampleFlags() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SampleFlags.class != obj.getClass()) {
                return false;
            }
            SampleFlags sampleFlags = (SampleFlags) obj;
            return this.reserved == sampleFlags.reserved && this.sampleDegradationPriority == sampleFlags.sampleDegradationPriority && this.sampleDependsOn == sampleFlags.sampleDependsOn && this.sampleHasRedundancy == sampleFlags.sampleHasRedundancy && this.sampleIsDependedOn == sampleFlags.sampleIsDependedOn && this.sampleIsDifferenceSample == sampleFlags.sampleIsDifferenceSample && this.samplePaddingValue == sampleFlags.samplePaddingValue;
        }
        return invokeL.booleanValue;
    }

    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
            BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer.writeBits(this.reserved, 6);
            bitWriterBuffer.writeBits(this.sampleDependsOn, 2);
            bitWriterBuffer.writeBits(this.sampleIsDependedOn, 2);
            bitWriterBuffer.writeBits(this.sampleHasRedundancy, 2);
            bitWriterBuffer.writeBits(this.samplePaddingValue, 3);
            bitWriterBuffer.writeBits(this.sampleIsDifferenceSample ? 1 : 0, 1);
            bitWriterBuffer.writeBits(this.sampleDegradationPriority, 16);
        }
    }

    public int getReserved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.reserved : invokeV.intValue;
    }

    public int getSampleDegradationPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sampleDegradationPriority : invokeV.intValue;
    }

    public int getSampleDependsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sampleDependsOn : invokeV.intValue;
    }

    public int getSampleHasRedundancy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sampleHasRedundancy : invokeV.intValue;
    }

    public int getSampleIsDependedOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.sampleIsDependedOn : invokeV.intValue;
    }

    public int getSamplePaddingValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.samplePaddingValue : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (((((((((((this.reserved * 31) + this.sampleDependsOn) * 31) + this.sampleIsDependedOn) * 31) + this.sampleHasRedundancy) * 31) + this.samplePaddingValue) * 31) + (this.sampleIsDifferenceSample ? 1 : 0)) * 31) + this.sampleDegradationPriority;
        }
        return invokeV.intValue;
    }

    public boolean isSampleIsDifferenceSample() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.sampleIsDifferenceSample : invokeV.booleanValue;
    }

    public void setReserved(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.reserved = i2;
        }
    }

    public void setSampleDegradationPriority(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.sampleDegradationPriority = i2;
        }
    }

    public void setSampleDependsOn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.sampleDependsOn = i2;
        }
    }

    public void setSampleHasRedundancy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.sampleHasRedundancy = i2;
        }
    }

    public void setSampleIsDependedOn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.sampleIsDependedOn = i2;
        }
    }

    public void setSampleIsDifferenceSample(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.sampleIsDifferenceSample = z;
        }
    }

    public void setSamplePaddingValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.samplePaddingValue = i2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "SampleFlags{reserved=" + this.reserved + ", sampleDependsOn=" + this.sampleDependsOn + ", sampleHasRedundancy=" + this.sampleHasRedundancy + ", samplePaddingValue=" + this.samplePaddingValue + ", sampleIsDifferenceSample=" + this.sampleIsDifferenceSample + ", sampleDegradationPriority=" + this.sampleDegradationPriority + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public SampleFlags(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.reserved = bitReaderBuffer.readBits(6);
        this.sampleDependsOn = bitReaderBuffer.readBits(2);
        this.sampleIsDependedOn = bitReaderBuffer.readBits(2);
        this.sampleHasRedundancy = bitReaderBuffer.readBits(2);
        this.samplePaddingValue = bitReaderBuffer.readBits(3);
        this.sampleIsDifferenceSample = bitReaderBuffer.readBits(1) == 1;
        this.sampleDegradationPriority = bitReaderBuffer.readBits(16);
    }
}
