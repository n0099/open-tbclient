package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes8.dex */
public class VisualRandomAccessEntry extends GroupEntry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "rap ";
    public transient /* synthetic */ FieldHolder $fh;
    public short numLeadingSamples;
    public boolean numLeadingSamplesKnown;

    public VisualRandomAccessEntry() {
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

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(1);
            if (this.numLeadingSamplesKnown) {
                i = 128;
            } else {
                i = 0;
            }
            allocate.put((byte) (i | (this.numLeadingSamples & 127)));
            allocate.rewind();
            return allocate;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public short getNumLeadingSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.numLeadingSamples;
        }
        return invokeV.shortValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ((this.numLeadingSamplesKnown ? 1 : 0) * 31) + this.numLeadingSamples;
        }
        return invokeV.intValue;
    }

    public boolean isNumLeadingSamplesKnown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.numLeadingSamplesKnown;
        }
        return invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VisualRandomAccessEntry.class != obj.getClass()) {
                return false;
            }
            VisualRandomAccessEntry visualRandomAccessEntry = (VisualRandomAccessEntry) obj;
            if (this.numLeadingSamples == visualRandomAccessEntry.numLeadingSamples && this.numLeadingSamplesKnown == visualRandomAccessEntry.numLeadingSamplesKnown) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, byteBuffer) == null) {
            byte b = byteBuffer.get();
            if ((b & 128) == 128) {
                z = true;
            } else {
                z = false;
            }
            this.numLeadingSamplesKnown = z;
            this.numLeadingSamples = (short) (b & ByteCompanionObject.MAX_VALUE);
        }
    }

    public void setNumLeadingSamples(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Short.valueOf(s)}) == null) {
            this.numLeadingSamples = s;
        }
    }

    public void setNumLeadingSamplesKnown(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.numLeadingSamplesKnown = z;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VisualRandomAccessEntry{numLeadingSamplesKnown=" + this.numLeadingSamplesKnown + ", numLeadingSamples=" + ((int) this.numLeadingSamples) + '}';
        }
        return (String) invokeV.objValue;
    }
}
