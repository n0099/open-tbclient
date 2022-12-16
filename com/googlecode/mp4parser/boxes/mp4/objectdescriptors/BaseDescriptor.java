package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;
@Descriptor(tags = {0})
/* loaded from: classes8.dex */
public abstract class BaseDescriptor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int sizeBytes;
    public int sizeOfInstance;
    public int tag;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1436115951, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/BaseDescriptor;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1436115951, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/BaseDescriptor;");
        }
    }

    public abstract void parseDetail(ByteBuffer byteBuffer) throws IOException;

    public BaseDescriptor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.sizeOfInstance + 1 + this.sizeBytes;
        }
        return invokeV.intValue;
    }

    public int getSizeBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.sizeBytes;
        }
        return invokeV.intValue;
    }

    public int getSizeOfInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.sizeOfInstance;
        }
        return invokeV.intValue;
    }

    public int getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.tag;
        }
        return invokeV.intValue;
    }

    public final void parse(int i, ByteBuffer byteBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, byteBuffer) == null) {
            this.tag = i;
            int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            this.sizeOfInstance = readUInt8 & 127;
            int i2 = 1;
            while ((readUInt8 >>> 7) == 1) {
                readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
                i2++;
                this.sizeOfInstance = (this.sizeOfInstance << 7) | (readUInt8 & 127);
            }
            this.sizeBytes = i2;
            ByteBuffer slice = byteBuffer.slice();
            slice.limit(this.sizeOfInstance);
            parseDetail(slice);
            byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "BaseDescriptor{tag=" + this.tag + ", sizeOfInstance=" + this.sizeOfInstance + '}';
        }
        return (String) invokeV.objValue;
    }
}
