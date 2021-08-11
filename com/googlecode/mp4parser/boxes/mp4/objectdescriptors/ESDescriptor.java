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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
@Descriptor(tags = {3})
/* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.URLLength = 0;
        this.otherDescriptors = new ArrayList();
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
            if (this.URLFlag == eSDescriptor.URLFlag && this.URLLength == eSDescriptor.URLLength && this.dependsOnEsId == eSDescriptor.dependsOnEsId && this.esId == eSDescriptor.esId && this.oCREsId == eSDescriptor.oCREsId && this.oCRstreamFlag == eSDescriptor.oCRstreamFlag && this.remoteODFlag == eSDescriptor.remoteODFlag && this.streamDependenceFlag == eSDescriptor.streamDependenceFlag && this.streamPriority == eSDescriptor.streamPriority) {
                String str = this.URLString;
                if (str == null ? eSDescriptor.URLString == null : str.equals(eSDescriptor.URLString)) {
                    DecoderConfigDescriptor decoderConfigDescriptor = this.decoderConfigDescriptor;
                    if (decoderConfigDescriptor == null ? eSDescriptor.decoderConfigDescriptor == null : decoderConfigDescriptor.equals(eSDescriptor.decoderConfigDescriptor)) {
                        List<BaseDescriptor> list = this.otherDescriptors;
                        if (list == null ? eSDescriptor.otherDescriptors == null : list.equals(eSDescriptor.otherDescriptors)) {
                            SLConfigDescriptor sLConfigDescriptor = this.slConfigDescriptor;
                            SLConfigDescriptor sLConfigDescriptor2 = eSDescriptor.slConfigDescriptor;
                            return sLConfigDescriptor == null ? sLConfigDescriptor2 == null : sLConfigDescriptor.equals(sLConfigDescriptor2);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public DecoderConfigDescriptor getDecoderConfigDescriptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.decoderConfigDescriptor : (DecoderConfigDescriptor) invokeV.objValue;
    }

    public int getDependsOnEsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dependsOnEsId : invokeV.intValue;
    }

    public int getEsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.esId : invokeV.intValue;
    }

    public List<BaseDescriptor> getOtherDescriptors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.otherDescriptors : (List) invokeV.objValue;
    }

    public int getRemoteODFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.remoteODFlag : invokeV.intValue;
    }

    public SLConfigDescriptor getSlConfigDescriptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.slConfigDescriptor : (SLConfigDescriptor) invokeV.objValue;
    }

    public int getStreamDependenceFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.streamDependenceFlag : invokeV.intValue;
    }

    public int getStreamPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.streamPriority : invokeV.intValue;
    }

    public int getURLFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.URLFlag : invokeV.intValue;
    }

    public int getURLLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.URLLength : invokeV.intValue;
    }

    public String getURLString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.URLString : (String) invokeV.objValue;
    }

    public int getoCREsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.oCREsId : invokeV.intValue;
    }

    public int getoCRstreamFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.oCRstreamFlag : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i2 = ((((((((((this.esId * 31) + this.streamDependenceFlag) * 31) + this.URLFlag) * 31) + this.oCRstreamFlag) * 31) + this.streamPriority) * 31) + this.URLLength) * 31;
            String str = this.URLString;
            int hashCode = (((((((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.remoteODFlag) * 31) + this.dependsOnEsId) * 31) + this.oCREsId) * 31;
            DecoderConfigDescriptor decoderConfigDescriptor = this.decoderConfigDescriptor;
            int hashCode2 = (hashCode + (decoderConfigDescriptor != null ? decoderConfigDescriptor.hashCode() : 0)) * 31;
            SLConfigDescriptor sLConfigDescriptor = this.slConfigDescriptor;
            int hashCode3 = (hashCode2 + (sLConfigDescriptor != null ? sLConfigDescriptor.hashCode() : 0)) * 31;
            List<BaseDescriptor> list = this.otherDescriptors;
            return hashCode3 + (list != null ? list.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, byteBuffer) == null) {
            this.esId = IsoTypeReader.readUInt16(byteBuffer);
            int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            int i2 = readUInt8 >>> 7;
            this.streamDependenceFlag = i2;
            this.URLFlag = (readUInt8 >>> 6) & 1;
            this.oCRstreamFlag = (readUInt8 >>> 5) & 1;
            this.streamPriority = readUInt8 & 31;
            if (i2 == 1) {
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
            int sizeBytes = getSizeBytes() + 1 + 2 + 1 + (this.streamDependenceFlag == 1 ? 2 : 0) + (this.URLFlag == 1 ? this.URLLength + 1 : 0) + (this.oCRstreamFlag == 1 ? 2 : 0);
            int position = byteBuffer.position();
            if (getSize() > sizeBytes + 2) {
                BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                long position2 = byteBuffer.position() - position;
                Logger logger = log;
                StringBuilder sb = new StringBuilder();
                sb.append(createFrom);
                sb.append(" - ESDescriptor1 read: ");
                sb.append(position2);
                sb.append(", size: ");
                sb.append(createFrom != null ? Integer.valueOf(createFrom.getSize()) : null);
                logger.finer(sb.toString());
                if (createFrom != null) {
                    int size = createFrom.getSize();
                    byteBuffer.position(position + size);
                    sizeBytes += size;
                } else {
                    sizeBytes = (int) (sizeBytes + position2);
                }
                if (createFrom instanceof DecoderConfigDescriptor) {
                    this.decoderConfigDescriptor = (DecoderConfigDescriptor) createFrom;
                }
            }
            int position3 = byteBuffer.position();
            if (getSize() > sizeBytes + 2) {
                BaseDescriptor createFrom2 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                long position4 = byteBuffer.position() - position3;
                Logger logger2 = log;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(createFrom2);
                sb2.append(" - ESDescriptor2 read: ");
                sb2.append(position4);
                sb2.append(", size: ");
                sb2.append(createFrom2 != null ? Integer.valueOf(createFrom2.getSize()) : null);
                logger2.finer(sb2.toString());
                if (createFrom2 != null) {
                    int size2 = createFrom2.getSize();
                    byteBuffer.position(position3 + size2);
                    sizeBytes += size2;
                } else {
                    sizeBytes = (int) (sizeBytes + position4);
                }
                if (createFrom2 instanceof SLConfigDescriptor) {
                    this.slConfigDescriptor = (SLConfigDescriptor) createFrom2;
                }
            } else {
                log.warning("SLConfigDescriptor is missing!");
            }
            while (getSize() - sizeBytes > 2) {
                int position5 = byteBuffer.position();
                BaseDescriptor createFrom3 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                long position6 = byteBuffer.position() - position5;
                Logger logger3 = log;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(createFrom3);
                sb3.append(" - ESDescriptor3 read: ");
                sb3.append(position6);
                sb3.append(", size: ");
                sb3.append(createFrom3 != null ? Integer.valueOf(createFrom3.getSize()) : null);
                logger3.finer(sb3.toString());
                if (createFrom3 != null) {
                    int size3 = createFrom3.getSize();
                    byteBuffer.position(position5 + size3);
                    sizeBytes += size3;
                } else {
                    sizeBytes = (int) (sizeBytes + position6);
                }
                this.otherDescriptors.add(createFrom3);
            }
        }
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

    public int serializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i2 = this.streamDependenceFlag > 0 ? 7 : 5;
            if (this.URLFlag > 0) {
                i2 += this.URLLength + 1;
            }
            if (this.oCRstreamFlag > 0) {
                i2 += 2;
            }
            return i2 + this.decoderConfigDescriptor.serializedSize() + this.slConfigDescriptor.serializedSize();
        }
        return invokeV.intValue;
    }

    public void setDecoderConfigDescriptor(DecoderConfigDescriptor decoderConfigDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, decoderConfigDescriptor) == null) {
            this.decoderConfigDescriptor = decoderConfigDescriptor;
        }
    }

    public void setDependsOnEsId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.dependsOnEsId = i2;
        }
    }

    public void setEsId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.esId = i2;
        }
    }

    public void setRemoteODFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.remoteODFlag = i2;
        }
    }

    public void setSlConfigDescriptor(SLConfigDescriptor sLConfigDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, sLConfigDescriptor) == null) {
            this.slConfigDescriptor = sLConfigDescriptor;
        }
    }

    public void setStreamDependenceFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.streamDependenceFlag = i2;
        }
    }

    public void setStreamPriority(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.streamPriority = i2;
        }
    }

    public void setURLFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.URLFlag = i2;
        }
    }

    public void setURLLength(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.URLLength = i2;
        }
    }

    public void setURLString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.URLString = str;
        }
    }

    public void setoCREsId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.oCREsId = i2;
        }
    }

    public void setoCRstreamFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.oCRstreamFlag = i2;
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return "ESDescriptor{esId=" + this.esId + ", streamDependenceFlag=" + this.streamDependenceFlag + ", URLFlag=" + this.URLFlag + ", oCRstreamFlag=" + this.oCRstreamFlag + ", streamPriority=" + this.streamPriority + ", URLLength=" + this.URLLength + ", URLString='" + this.URLString + ExtendedMessageFormat.QUOTE + ", remoteODFlag=" + this.remoteODFlag + ", dependsOnEsId=" + this.dependsOnEsId + ", oCREsId=" + this.oCREsId + ", decoderConfigDescriptor=" + this.decoderConfigDescriptor + ", slConfigDescriptor=" + this.slConfigDescriptor + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
