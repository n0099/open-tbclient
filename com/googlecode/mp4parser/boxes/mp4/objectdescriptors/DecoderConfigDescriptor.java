package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
@Descriptor(tags = {4})
/* loaded from: classes6.dex */
public class DecoderConfigDescriptor extends BaseDescriptor {
    public static /* synthetic */ Interceptable $ic;
    public static Logger log;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioSpecificConfig audioSpecificInfo;
    public long avgBitRate;
    public int bufferSizeDB;
    public byte[] configDescriptorDeadBytes;
    public DecoderSpecificInfo decoderSpecificInfo;
    public long maxBitRate;
    public int objectTypeIndication;
    public List<ProfileLevelIndicationDescriptor> profileLevelIndicationDescriptors;
    public int streamType;
    public int upStream;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-582946862, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/DecoderConfigDescriptor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-582946862, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/DecoderConfigDescriptor;");
                return;
            }
        }
        log = Logger.getLogger(DecoderConfigDescriptor.class.getName());
    }

    public DecoderConfigDescriptor() {
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
        this.profileLevelIndicationDescriptors = new ArrayList();
    }

    public AudioSpecificConfig getAudioSpecificInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.audioSpecificInfo : (AudioSpecificConfig) invokeV.objValue;
    }

    public long getAvgBitRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.avgBitRate : invokeV.longValue;
    }

    public int getBufferSizeDB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bufferSizeDB : invokeV.intValue;
    }

    public DecoderSpecificInfo getDecoderSpecificInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.decoderSpecificInfo : (DecoderSpecificInfo) invokeV.objValue;
    }

    public long getMaxBitRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.maxBitRate : invokeV.longValue;
    }

    public int getObjectTypeIndication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.objectTypeIndication : invokeV.intValue;
    }

    public List<ProfileLevelIndicationDescriptor> getProfileLevelIndicationDescriptors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.profileLevelIndicationDescriptors : (List) invokeV.objValue;
    }

    public int getStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.streamType : invokeV.intValue;
    }

    public int getUpStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.upStream : invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, byteBuffer) == null) {
            this.objectTypeIndication = IsoTypeReader.readUInt8(byteBuffer);
            int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            this.streamType = readUInt8 >>> 2;
            this.upStream = (readUInt8 >> 1) & 1;
            this.bufferSizeDB = IsoTypeReader.readUInt24(byteBuffer);
            this.maxBitRate = IsoTypeReader.readUInt32(byteBuffer);
            this.avgBitRate = IsoTypeReader.readUInt32(byteBuffer);
            if (byteBuffer.remaining() > 2) {
                int position = byteBuffer.position();
                BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(this.objectTypeIndication, byteBuffer);
                int position2 = byteBuffer.position() - position;
                Logger logger = log;
                StringBuilder sb = new StringBuilder();
                sb.append(createFrom);
                sb.append(" - DecoderConfigDescr1 read: ");
                sb.append(position2);
                sb.append(", size: ");
                sb.append(createFrom != null ? Integer.valueOf(createFrom.getSize()) : null);
                logger.finer(sb.toString());
                if (createFrom != null && position2 < (size = createFrom.getSize())) {
                    byte[] bArr = new byte[size - position2];
                    this.configDescriptorDeadBytes = bArr;
                    byteBuffer.get(bArr);
                }
                if (createFrom instanceof DecoderSpecificInfo) {
                    this.decoderSpecificInfo = (DecoderSpecificInfo) createFrom;
                }
                if (createFrom instanceof AudioSpecificConfig) {
                    this.audioSpecificInfo = (AudioSpecificConfig) createFrom;
                }
            }
            while (byteBuffer.remaining() > 2) {
                long position3 = byteBuffer.position();
                BaseDescriptor createFrom2 = ObjectDescriptorFactory.createFrom(this.objectTypeIndication, byteBuffer);
                long position4 = byteBuffer.position() - position3;
                Logger logger2 = log;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(createFrom2);
                sb2.append(" - DecoderConfigDescr2 read: ");
                sb2.append(position4);
                sb2.append(", size: ");
                sb2.append(createFrom2 != null ? Integer.valueOf(createFrom2.getSize()) : null);
                logger2.finer(sb2.toString());
                if (createFrom2 instanceof ProfileLevelIndicationDescriptor) {
                    this.profileLevelIndicationDescriptors.add((ProfileLevelIndicationDescriptor) createFrom2);
                }
            }
        }
    }

    public ByteBuffer serialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(serializedSize());
            IsoTypeWriter.writeUInt8(allocate, 4);
            IsoTypeWriter.writeUInt8(allocate, serializedSize() - 2);
            IsoTypeWriter.writeUInt8(allocate, this.objectTypeIndication);
            IsoTypeWriter.writeUInt8(allocate, (this.streamType << 2) | (this.upStream << 1) | 1);
            IsoTypeWriter.writeUInt24(allocate, this.bufferSizeDB);
            IsoTypeWriter.writeUInt32(allocate, this.maxBitRate);
            IsoTypeWriter.writeUInt32(allocate, this.avgBitRate);
            AudioSpecificConfig audioSpecificConfig = this.audioSpecificInfo;
            if (audioSpecificConfig != null) {
                allocate.put(audioSpecificConfig.serialize().array());
            }
            return allocate;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public int serializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AudioSpecificConfig audioSpecificConfig = this.audioSpecificInfo;
            return (audioSpecificConfig == null ? 0 : audioSpecificConfig.serializedSize()) + 15;
        }
        return invokeV.intValue;
    }

    public void setAudioSpecificInfo(AudioSpecificConfig audioSpecificConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, audioSpecificConfig) == null) {
            this.audioSpecificInfo = audioSpecificConfig;
        }
    }

    public void setAvgBitRate(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.avgBitRate = j;
        }
    }

    public void setBufferSizeDB(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.bufferSizeDB = i2;
        }
    }

    public void setMaxBitRate(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.maxBitRate = j;
        }
    }

    public void setObjectTypeIndication(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.objectTypeIndication = i2;
        }
    }

    public void setStreamType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.streamType = i2;
        }
    }

    public void setUpStream(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.upStream = i2;
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("DecoderConfigDescriptor");
            sb.append("{objectTypeIndication=");
            sb.append(this.objectTypeIndication);
            sb.append(", streamType=");
            sb.append(this.streamType);
            sb.append(", upStream=");
            sb.append(this.upStream);
            sb.append(", bufferSizeDB=");
            sb.append(this.bufferSizeDB);
            sb.append(", maxBitRate=");
            sb.append(this.maxBitRate);
            sb.append(", avgBitRate=");
            sb.append(this.avgBitRate);
            sb.append(", decoderSpecificInfo=");
            sb.append(this.decoderSpecificInfo);
            sb.append(", audioSpecificInfo=");
            sb.append(this.audioSpecificInfo);
            sb.append(", configDescriptorDeadBytes=");
            byte[] bArr = this.configDescriptorDeadBytes;
            if (bArr == null) {
                bArr = new byte[0];
            }
            sb.append(Hex.encodeHex(bArr));
            sb.append(", profileLevelIndicationDescriptors=");
            List<ProfileLevelIndicationDescriptor> list = this.profileLevelIndicationDescriptors;
            sb.append(list == null ? StringUtil.NULL_STRING : Arrays.asList(list).toString());
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
