package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
@Descriptor(tags = {3})
/* loaded from: classes7.dex */
public class ESDescriptor extends BaseDescriptor {
    public static /* synthetic */ Interceptable $ic;
    public static Logger log;
    public transient /* synthetic */ FieldHolder $fh;
    public int URLFlag;
    public int URLLength;
    public String URLString;
    public DecoderConfigDescriptor decoderConfigDescriptor;
    public int dependsOnEsId;
    public int esId;
    public int oCREsId;
    public int oCRstreamFlag;
    public List<BaseDescriptor> otherDescriptors;
    public int remoteODFlag;
    public SLConfigDescriptor slConfigDescriptor;
    public int streamDependenceFlag;
    public int streamPriority;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-8094958, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/ESDescriptor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-8094958, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/ESDescriptor;");
                return;
            }
        }
        log = Logger.getLogger(ESDescriptor.class.getName());
    }

    public ESDescriptor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.URLLength = 0;
        this.otherDescriptors = new ArrayList();
    }

    public DecoderConfigDescriptor getDecoderConfigDescriptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.decoderConfigDescriptor;
        }
        return (DecoderConfigDescriptor) invokeV.objValue;
    }

    public int getDependsOnEsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.dependsOnEsId;
        }
        return invokeV.intValue;
    }

    public int getEsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.esId;
        }
        return invokeV.intValue;
    }

    public List<BaseDescriptor> getOtherDescriptors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.otherDescriptors;
        }
        return (List) invokeV.objValue;
    }

    public int getRemoteODFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.remoteODFlag;
        }
        return invokeV.intValue;
    }

    public SLConfigDescriptor getSlConfigDescriptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.slConfigDescriptor;
        }
        return (SLConfigDescriptor) invokeV.objValue;
    }

    public int getStreamDependenceFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.streamDependenceFlag;
        }
        return invokeV.intValue;
    }

    public int getStreamPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.streamPriority;
        }
        return invokeV.intValue;
    }

    public int getURLFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.URLFlag;
        }
        return invokeV.intValue;
    }

    public int getURLLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.URLLength;
        }
        return invokeV.intValue;
    }

    public String getURLString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.URLString;
        }
        return (String) invokeV.objValue;
    }

    public int getoCREsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.oCREsId;
        }
        return invokeV.intValue;
    }

    public int getoCRstreamFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.oCRstreamFlag;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ESDescriptor.class != obj.getClass()) {
                return false;
            }
            ESDescriptor eSDescriptor = (ESDescriptor) obj;
            if (this.URLFlag != eSDescriptor.URLFlag || this.URLLength != eSDescriptor.URLLength || this.dependsOnEsId != eSDescriptor.dependsOnEsId || this.esId != eSDescriptor.esId || this.oCREsId != eSDescriptor.oCREsId || this.oCRstreamFlag != eSDescriptor.oCRstreamFlag || this.remoteODFlag != eSDescriptor.remoteODFlag || this.streamDependenceFlag != eSDescriptor.streamDependenceFlag || this.streamPriority != eSDescriptor.streamPriority) {
                return false;
            }
            String str = this.URLString;
            if (str == null ? eSDescriptor.URLString != null : !str.equals(eSDescriptor.URLString)) {
                return false;
            }
            DecoderConfigDescriptor decoderConfigDescriptor = this.decoderConfigDescriptor;
            if (decoderConfigDescriptor == null ? eSDescriptor.decoderConfigDescriptor != null : !decoderConfigDescriptor.equals(eSDescriptor.decoderConfigDescriptor)) {
                return false;
            }
            List<BaseDescriptor> list = this.otherDescriptors;
            if (list == null ? eSDescriptor.otherDescriptors != null : !list.equals(eSDescriptor.otherDescriptors)) {
                return false;
            }
            SLConfigDescriptor sLConfigDescriptor = this.slConfigDescriptor;
            SLConfigDescriptor sLConfigDescriptor2 = eSDescriptor.slConfigDescriptor;
            if (sLConfigDescriptor == null ? sLConfigDescriptor2 == null : sLConfigDescriptor.equals(sLConfigDescriptor2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i4 = ((((((((((this.esId * 31) + this.streamDependenceFlag) * 31) + this.URLFlag) * 31) + this.oCRstreamFlag) * 31) + this.streamPriority) * 31) + this.URLLength) * 31;
            String str = this.URLString;
            int i5 = 0;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            int i6 = (((((((i4 + i) * 31) + this.remoteODFlag) * 31) + this.dependsOnEsId) * 31) + this.oCREsId) * 31;
            DecoderConfigDescriptor decoderConfigDescriptor = this.decoderConfigDescriptor;
            if (decoderConfigDescriptor != null) {
                i2 = decoderConfigDescriptor.hashCode();
            } else {
                i2 = 0;
            }
            int i7 = (i6 + i2) * 31;
            SLConfigDescriptor sLConfigDescriptor = this.slConfigDescriptor;
            if (sLConfigDescriptor != null) {
                i3 = sLConfigDescriptor.hashCode();
            } else {
                i3 = 0;
            }
            int i8 = (i7 + i3) * 31;
            List<BaseDescriptor> list = this.otherDescriptors;
            if (list != null) {
                i5 = list.hashCode();
            }
            return i8 + i5;
        }
        return invokeV.intValue;
    }

    public ByteBuffer serialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(serializedSize());
            IsoTypeWriter.writeUInt8(allocate, 3);
            IsoTypeWriter.writeUInt8(allocate, serializedSize() - 2);
            IsoTypeWriter.writeUInt16(allocate, this.esId);
            IsoTypeWriter.writeUInt8(allocate, (this.streamDependenceFlag << 7) | (this.URLFlag << 6) | (this.oCRstreamFlag << 5) | (this.streamPriority & 31));
            if (this.streamDependenceFlag > 0) {
                IsoTypeWriter.writeUInt16(allocate, this.dependsOnEsId);
            }
            if (this.URLFlag > 0) {
                IsoTypeWriter.writeUInt8(allocate, this.URLLength);
                IsoTypeWriter.writeUtf8String(allocate, this.URLString);
            }
            if (this.oCRstreamFlag > 0) {
                IsoTypeWriter.writeUInt16(allocate, this.oCREsId);
            }
            ByteBuffer serialize = this.decoderConfigDescriptor.serialize();
            ByteBuffer serialize2 = this.slConfigDescriptor.serialize();
            allocate.put(serialize.array());
            allocate.put(serialize2.array());
            return allocate;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int i;
        int i2;
        Integer num;
        Integer num2;
        Integer num3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, byteBuffer) == null) {
            this.esId = IsoTypeReader.readUInt16(byteBuffer);
            int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            int i3 = readUInt8 >>> 7;
            this.streamDependenceFlag = i3;
            this.URLFlag = (readUInt8 >>> 6) & 1;
            this.oCRstreamFlag = (readUInt8 >>> 5) & 1;
            this.streamPriority = readUInt8 & 31;
            if (i3 == 1) {
                this.dependsOnEsId = IsoTypeReader.readUInt16(byteBuffer);
            }
            if (this.URLFlag == 1) {
                int readUInt82 = IsoTypeReader.readUInt8(byteBuffer);
                this.URLLength = readUInt82;
                this.URLString = IsoTypeReader.readString(byteBuffer, readUInt82);
            }
            if (this.oCRstreamFlag == 1) {
                this.oCREsId = IsoTypeReader.readUInt16(byteBuffer);
            }
            int sizeBytes = getSizeBytes() + 1 + 2 + 1;
            int i4 = 0;
            if (this.streamDependenceFlag == 1) {
                i = 2;
            } else {
                i = 0;
            }
            int i5 = sizeBytes + i;
            if (this.URLFlag == 1) {
                i2 = this.URLLength + 1;
            } else {
                i2 = 0;
            }
            int i6 = i5 + i2;
            if (this.oCRstreamFlag == 1) {
                i4 = 2;
            }
            int i7 = i6 + i4;
            int position = byteBuffer.position();
            if (getSize() > i7 + 2) {
                BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                long position2 = byteBuffer.position() - position;
                Logger logger = log;
                StringBuilder sb = new StringBuilder();
                sb.append(createFrom);
                sb.append(" - ESDescriptor1 read: ");
                sb.append(position2);
                sb.append(", size: ");
                if (createFrom != null) {
                    num3 = Integer.valueOf(createFrom.getSize());
                } else {
                    num3 = null;
                }
                sb.append(num3);
                logger.finer(sb.toString());
                if (createFrom != null) {
                    int size = createFrom.getSize();
                    byteBuffer.position(position + size);
                    i7 += size;
                } else {
                    i7 = (int) (i7 + position2);
                }
                if (createFrom instanceof DecoderConfigDescriptor) {
                    this.decoderConfigDescriptor = (DecoderConfigDescriptor) createFrom;
                }
            }
            int position3 = byteBuffer.position();
            if (getSize() > i7 + 2) {
                BaseDescriptor createFrom2 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                long position4 = byteBuffer.position() - position3;
                Logger logger2 = log;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(createFrom2);
                sb2.append(" - ESDescriptor2 read: ");
                sb2.append(position4);
                sb2.append(", size: ");
                if (createFrom2 != null) {
                    num2 = Integer.valueOf(createFrom2.getSize());
                } else {
                    num2 = null;
                }
                sb2.append(num2);
                logger2.finer(sb2.toString());
                if (createFrom2 != null) {
                    int size2 = createFrom2.getSize();
                    byteBuffer.position(position3 + size2);
                    i7 += size2;
                } else {
                    i7 = (int) (i7 + position4);
                }
                if (createFrom2 instanceof SLConfigDescriptor) {
                    this.slConfigDescriptor = (SLConfigDescriptor) createFrom2;
                }
            } else {
                log.warning("SLConfigDescriptor is missing!");
            }
            while (getSize() - i7 > 2) {
                int position5 = byteBuffer.position();
                BaseDescriptor createFrom3 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                long position6 = byteBuffer.position() - position5;
                Logger logger3 = log;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(createFrom3);
                sb3.append(" - ESDescriptor3 read: ");
                sb3.append(position6);
                sb3.append(", size: ");
                if (createFrom3 != null) {
                    num = Integer.valueOf(createFrom3.getSize());
                } else {
                    num = null;
                }
                sb3.append(num);
                logger3.finer(sb3.toString());
                if (createFrom3 != null) {
                    int size3 = createFrom3.getSize();
                    byteBuffer.position(position5 + size3);
                    i7 += size3;
                } else {
                    i7 = (int) (i7 + position6);
                }
                this.otherDescriptors.add(createFrom3);
            }
        }
    }

    public int serializedSize() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.streamDependenceFlag > 0) {
                i = 7;
            } else {
                i = 5;
            }
            if (this.URLFlag > 0) {
                i += this.URLLength + 1;
            }
            if (this.oCRstreamFlag > 0) {
                i += 2;
            }
            return i + this.decoderConfigDescriptor.serializedSize() + this.slConfigDescriptor.serializedSize();
        }
        return invokeV.intValue;
    }

    public void setDecoderConfigDescriptor(DecoderConfigDescriptor decoderConfigDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, decoderConfigDescriptor) == null) {
            this.decoderConfigDescriptor = decoderConfigDescriptor;
        }
    }

    public void setDependsOnEsId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.dependsOnEsId = i;
        }
    }

    public void setEsId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.esId = i;
        }
    }

    public void setRemoteODFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.remoteODFlag = i;
        }
    }

    public void setSlConfigDescriptor(SLConfigDescriptor sLConfigDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, sLConfigDescriptor) == null) {
            this.slConfigDescriptor = sLConfigDescriptor;
        }
    }

    public void setStreamDependenceFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.streamDependenceFlag = i;
        }
    }

    public void setStreamPriority(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.streamPriority = i;
        }
    }

    public void setURLFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.URLFlag = i;
        }
    }

    public void setURLLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.URLLength = i;
        }
    }

    public void setURLString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.URLString = str;
        }
    }

    public void setoCREsId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.oCREsId = i;
        }
    }

    public void setoCRstreamFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.oCRstreamFlag = i;
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return "ESDescriptor{esId=" + this.esId + ", streamDependenceFlag=" + this.streamDependenceFlag + ", URLFlag=" + this.URLFlag + ", oCRstreamFlag=" + this.oCRstreamFlag + ", streamPriority=" + this.streamPriority + ", URLLength=" + this.URLLength + ", URLString='" + this.URLString + "', remoteODFlag=" + this.remoteODFlag + ", dependsOnEsId=" + this.dependsOnEsId + ", oCREsId=" + this.oCREsId + ", decoderConfigDescriptor=" + this.decoderConfigDescriptor + ", slConfigDescriptor=" + this.slConfigDescriptor + '}';
        }
        return (String) invokeV.objValue;
    }
}
