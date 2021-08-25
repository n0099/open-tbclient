package com.googlecode.mp4parser.boxes.threegpp26244;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.apollon.a;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes10.dex */
public class SegmentIndexBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "sidx";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_10 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_11 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public long earliestPresentationTime;
    public List<Entry> entries;
    public long firstOffset;
    public long referenceId;
    public int reserved;
    public long timeScale;

    /* loaded from: classes10.dex */
    public static class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte referenceType;
        public int referencedSize;
        public int sapDeltaTime;
        public byte sapType;
        public byte startsWithSap;
        public long subsegmentDuration;

        public Entry() {
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
                if (obj == null || Entry.class != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.referenceType == entry.referenceType && this.referencedSize == entry.referencedSize && this.sapDeltaTime == entry.sapDeltaTime && this.sapType == entry.sapType && this.startsWithSap == entry.startsWithSap && this.subsegmentDuration == entry.subsegmentDuration;
            }
            return invokeL.booleanValue;
        }

        public byte getReferenceType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.referenceType : invokeV.byteValue;
        }

        public int getReferencedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.referencedSize : invokeV.intValue;
        }

        public int getSapDeltaTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sapDeltaTime : invokeV.intValue;
        }

        public byte getSapType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sapType : invokeV.byteValue;
        }

        public byte getStartsWithSap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.startsWithSap : invokeV.byteValue;
        }

        public long getSubsegmentDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.subsegmentDuration : invokeV.longValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                long j2 = this.subsegmentDuration;
                return (((((((((this.referenceType * 31) + this.referencedSize) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.startsWithSap) * 31) + this.sapType) * 31) + this.sapDeltaTime;
            }
            return invokeV.intValue;
        }

        public void setReferenceType(byte b2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeB(InputDeviceCompat.SOURCE_TOUCHPAD, this, b2) == null) {
                this.referenceType = b2;
            }
        }

        public void setReferencedSize(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                this.referencedSize = i2;
            }
        }

        public void setSapDeltaTime(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                this.sapDeltaTime = i2;
            }
        }

        public void setSapType(byte b2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeB(1048587, this, b2) == null) {
                this.sapType = b2;
            }
        }

        public void setStartsWithSap(byte b2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeB(1048588, this, b2) == null) {
                this.startsWithSap = b2;
            }
        }

        public void setSubsegmentDuration(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
                this.subsegmentDuration = j2;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return "Entry{referenceType=" + ((int) this.referenceType) + ", referencedSize=" + this.referencedSize + ", subsegmentDuration=" + this.subsegmentDuration + ", startsWithSap=" + ((int) this.startsWithSap) + ", sapType=" + ((int) this.sapType) + ", sapDeltaTime=" + this.sapDeltaTime + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public Entry(byte b2, int i2, long j2, byte b3, byte b4, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Byte.valueOf(b2), Integer.valueOf(i2), Long.valueOf(j2), Byte.valueOf(b3), Byte.valueOf(b4), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.referenceType = b2;
            this.referencedSize = i2;
            this.subsegmentDuration = j2;
            this.startsWithSap = b3;
            this.sapType = b4;
            this.sapDeltaTime = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2027187939, "Lcom/googlecode/mp4parser/boxes/threegpp26244/SegmentIndexBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2027187939, "Lcom/googlecode/mp4parser/boxes/threegpp26244/SegmentIndexBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentIndexBox() {
        super(TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.entries = new ArrayList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("SegmentIndexBox.java", SegmentIndexBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.util.List"), 128);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "java.util.List", "entries", "", "void"), 132);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "int"), 168);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "int", GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "", "void"), 172);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 136);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "referenceId", "", "void"), 140);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 144);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "timeScale", "", "void"), Opcodes.LCMP);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), a.f37632e);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "earliestPresentationTime", "", "void"), 156);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 160);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "firstOffset", "", "void"), IChannelPay.ID_IPAY_PAY_GAME);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            this.referenceId = IsoTypeReader.readUInt32(byteBuffer);
            this.timeScale = IsoTypeReader.readUInt32(byteBuffer);
            if (getVersion() == 0) {
                this.earliestPresentationTime = IsoTypeReader.readUInt32(byteBuffer);
                this.firstOffset = IsoTypeReader.readUInt32(byteBuffer);
            } else {
                this.earliestPresentationTime = IsoTypeReader.readUInt64(byteBuffer);
                this.firstOffset = IsoTypeReader.readUInt64(byteBuffer);
            }
            this.reserved = IsoTypeReader.readUInt16(byteBuffer);
            int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
            for (int i2 = 0; i2 < readUInt16; i2++) {
                BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
                Entry entry = new Entry();
                entry.setReferenceType((byte) bitReaderBuffer.readBits(1));
                entry.setReferencedSize(bitReaderBuffer.readBits(31));
                entry.setSubsegmentDuration(IsoTypeReader.readUInt32(byteBuffer));
                BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
                entry.setStartsWithSap((byte) bitReaderBuffer2.readBits(1));
                entry.setSapType((byte) bitReaderBuffer2.readBits(3));
                entry.setSapDeltaTime(bitReaderBuffer2.readBits(28));
                this.entries.add(entry);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            IsoTypeWriter.writeUInt32(byteBuffer, this.referenceId);
            IsoTypeWriter.writeUInt32(byteBuffer, this.timeScale);
            if (getVersion() == 0) {
                IsoTypeWriter.writeUInt32(byteBuffer, this.earliestPresentationTime);
                IsoTypeWriter.writeUInt32(byteBuffer, this.firstOffset);
            } else {
                IsoTypeWriter.writeUInt64(byteBuffer, this.earliestPresentationTime);
                IsoTypeWriter.writeUInt64(byteBuffer, this.firstOffset);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.reserved);
            IsoTypeWriter.writeUInt16(byteBuffer, this.entries.size());
            for (Entry entry : this.entries) {
                BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
                bitWriterBuffer.writeBits(entry.getReferenceType(), 1);
                bitWriterBuffer.writeBits(entry.getReferencedSize(), 31);
                IsoTypeWriter.writeUInt32(byteBuffer, entry.getSubsegmentDuration());
                BitWriterBuffer bitWriterBuffer2 = new BitWriterBuffer(byteBuffer);
                bitWriterBuffer2.writeBits(entry.getStartsWithSap(), 1);
                bitWriterBuffer2.writeBits(entry.getSapType(), 3);
                bitWriterBuffer2.writeBits(entry.getSapDeltaTime(), 28);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 12 + (getVersion() == 0 ? 8 : 16) + 2 + 2 + (this.entries.size() * 12);
        }
        return invokeV.longValue;
    }

    public long getEarliestPresentationTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
            return this.earliestPresentationTime;
        }
        return invokeV.longValue;
    }

    public List<Entry> getEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.entries;
        }
        return (List) invokeV.objValue;
    }

    public long getFirstOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
            return this.firstOffset;
        }
        return invokeV.longValue;
    }

    public long getReferenceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return this.referenceId;
        }
        return invokeV.longValue;
    }

    public int getReserved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this));
            return this.reserved;
        }
        return invokeV.intValue;
    }

    public long getTimeScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return this.timeScale;
        }
        return invokeV.longValue;
    }

    public void setEarliestPresentationTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.longObject(j2)));
            this.earliestPresentationTime = j2;
        }
    }

    public void setEntries(List<Entry> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, list));
            this.entries = list;
        }
    }

    public void setFirstOffset(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, Conversions.longObject(j2)));
            this.firstOffset = j2;
        }
    }

    public void setReferenceId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.longObject(j2)));
            this.referenceId = j2;
        }
    }

    public void setReserved(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.intObject(i2)));
            this.reserved = i2;
        }
    }

    public void setTimeScale(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.longObject(j2)));
            this.timeScale = j2;
        }
    }
}
