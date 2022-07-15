package com.coremedia.iso.boxes.fragment;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes4.dex */
public class TrackRunBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "trun";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_10 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_11 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_12 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_13 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_14 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_15 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_16 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_17 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_18 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_19 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public int dataOffset;
    public List<Entry> entries;
    public SampleFlags firstSampleFlags;

    /* loaded from: classes4.dex */
    public static class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long sampleCompositionTimeOffset;
        public long sampleDuration;
        public SampleFlags sampleFlags;
        public long sampleSize;

        public Entry() {
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

        public long getSampleCompositionTimeOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.sampleCompositionTimeOffset : invokeV.longValue;
        }

        public long getSampleDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sampleDuration : invokeV.longValue;
        }

        public SampleFlags getSampleFlags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sampleFlags : (SampleFlags) invokeV.objValue;
        }

        public long getSampleSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sampleSize : invokeV.longValue;
        }

        public void setSampleCompositionTimeOffset(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.sampleCompositionTimeOffset = i;
            }
        }

        public void setSampleDuration(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.sampleDuration = j;
            }
        }

        public void setSampleFlags(SampleFlags sampleFlags) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, sampleFlags) == null) {
                this.sampleFlags = sampleFlags;
            }
        }

        public void setSampleSize(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                this.sampleSize = j;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return "Entry{sampleDuration=" + this.sampleDuration + ", sampleSize=" + this.sampleSize + ", sampleFlags=" + this.sampleFlags + ", sampleCompositionTimeOffset=" + this.sampleCompositionTimeOffset + '}';
            }
            return (String) invokeV.objValue;
        }

        public Entry(long j, long j2, SampleFlags sampleFlags, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), sampleFlags, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.sampleDuration = j;
            this.sampleSize = j2;
            this.sampleFlags = sampleFlags;
            this.sampleCompositionTimeOffset = i;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-440280053, "Lcom/coremedia/iso/boxes/fragment/TrackRunBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-440280053, "Lcom/coremedia/iso/boxes/fragment/TrackRunBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackRunBox() {
        super(TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.entries = new ArrayList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("TrackRunBox.java", TrackRunBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.util.List"), 57);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "int", "dataOffset", "", "void"), 120);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 271);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 279);
        ajc$tjp_12 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 287);
        ajc$tjp_13 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 296);
        ajc$tjp_14 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 304);
        ajc$tjp_15 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "int"), 313);
        ajc$tjp_16 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 317);
        ajc$tjp_17 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "firstSampleFlags", "", "void"), 321);
        ajc$tjp_18 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.lang.String"), 331);
        ajc$tjp_19 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "java.util.List", "entries", "", "void"), 346);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSampleCompositionTimeOffsets", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "[J"), 129);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSampleCount", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "long"), 242);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 246);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isFirstSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 250);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 255);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 263);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 267);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
            if ((getFlags() & 1) == 1) {
                this.dataOffset = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
            } else {
                this.dataOffset = -1;
            }
            if ((getFlags() & 4) == 4) {
                this.firstSampleFlags = new SampleFlags(byteBuffer);
            }
            for (int i = 0; i < readUInt32; i++) {
                Entry entry = new Entry();
                if ((getFlags() & 256) == 256) {
                    entry.sampleDuration = IsoTypeReader.readUInt32(byteBuffer);
                }
                if ((getFlags() & 512) == 512) {
                    entry.sampleSize = IsoTypeReader.readUInt32(byteBuffer);
                }
                if ((getFlags() & 1024) == 1024) {
                    entry.sampleFlags = new SampleFlags(byteBuffer);
                }
                if ((getFlags() & 2048) == 2048) {
                    if (getVersion() == 0) {
                        entry.sampleCompositionTimeOffset = IsoTypeReader.readUInt32(byteBuffer);
                    } else {
                        entry.sampleCompositionTimeOffset = byteBuffer.getInt();
                    }
                }
                this.entries.add(entry);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
            int flags = getFlags();
            if ((flags & 1) == 1) {
                IsoTypeWriter.writeUInt32(byteBuffer, this.dataOffset);
            }
            if ((flags & 4) == 4) {
                this.firstSampleFlags.getContent(byteBuffer);
            }
            for (Entry entry : this.entries) {
                if ((flags & 256) == 256) {
                    IsoTypeWriter.writeUInt32(byteBuffer, entry.sampleDuration);
                }
                if ((flags & 512) == 512) {
                    IsoTypeWriter.writeUInt32(byteBuffer, entry.sampleSize);
                }
                if ((flags & 1024) == 1024) {
                    entry.sampleFlags.getContent(byteBuffer);
                }
                if ((flags & 2048) == 2048) {
                    if (getVersion() == 0) {
                        IsoTypeWriter.writeUInt32(byteBuffer, entry.sampleCompositionTimeOffset);
                    } else {
                        byteBuffer.putInt((int) entry.sampleCompositionTimeOffset);
                    }
                }
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int flags = getFlags();
            long j = (flags & 1) == 1 ? 12L : 8L;
            if ((flags & 4) == 4) {
                j += 4;
            }
            long j2 = (flags & 256) == 256 ? 4L : 0L;
            if ((flags & 512) == 512) {
                j2 += 4;
            }
            if ((flags & 1024) == 1024) {
                j2 += 4;
            }
            if ((flags & 2048) == 2048) {
                j2 += 4;
            }
            return j + (j2 * this.entries.size());
        }
        return invokeV.longValue;
    }

    public int getDataOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_15, this, this));
            return this.dataOffset;
        }
        return invokeV.intValue;
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

    public SampleFlags getFirstSampleFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_16, this, this));
            return this.firstSampleFlags;
        }
        return (SampleFlags) invokeV.objValue;
    }

    public long[] getSampleCompositionTimeOffsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            if (isSampleCompositionTimeOffsetPresent()) {
                int size = this.entries.size();
                long[] jArr = new long[size];
                for (int i = 0; i < size; i++) {
                    jArr[i] = this.entries.get(i).getSampleCompositionTimeOffset();
                }
                return jArr;
            }
            return null;
        }
        return (long[]) invokeV.objValue;
    }

    public long getSampleCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this));
            return this.entries.size();
        }
        return invokeV.longValue;
    }

    public boolean isDataOffsetPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return (getFlags() & 1) == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isFirstSampleFlagsPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this));
            return (getFlags() & 4) == 4;
        }
        return invokeV.booleanValue;
    }

    public boolean isSampleCompositionTimeOffsetPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this));
            return (getFlags() & 2048) == 2048;
        }
        return invokeV.booleanValue;
    }

    public boolean isSampleDurationPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this));
            return (getFlags() & 256) == 256;
        }
        return invokeV.booleanValue;
    }

    public boolean isSampleFlagsPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
            return (getFlags() & 1024) == 1024;
        }
        return invokeV.booleanValue;
    }

    public boolean isSampleSizePresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
            return (getFlags() & 512) == 512;
        }
        return invokeV.booleanValue;
    }

    public void setDataOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.intObject(i)));
            if (i == -1) {
                setFlags(getFlags() & 16777214);
            } else {
                setFlags(getFlags() | 1);
            }
            this.dataOffset = i;
        }
    }

    public void setDataOffsetPresent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this, Conversions.booleanObject(z)));
            if (z) {
                setFlags(getFlags() | 1);
            } else {
                setFlags(getFlags() & 16777214);
            }
        }
    }

    public void setEntries(List<Entry> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_19, this, this, list));
            this.entries = list;
        }
    }

    public void setFirstSampleFlags(SampleFlags sampleFlags) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sampleFlags) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_17, this, this, sampleFlags));
            if (sampleFlags == null) {
                setFlags(getFlags() & 16777211);
            } else {
                setFlags(getFlags() | 4);
            }
            this.firstSampleFlags = sampleFlags;
        }
    }

    public void setSampleCompositionTimeOffsetPresent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_14, this, this, Conversions.booleanObject(z)));
            if (z) {
                setFlags(getFlags() | 2048);
            } else {
                setFlags(getFlags() & 16775167);
            }
        }
    }

    public void setSampleDurationPresent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this, Conversions.booleanObject(z)));
            if (z) {
                setFlags(getFlags() | 256);
            } else {
                setFlags(getFlags() & 16776959);
            }
        }
    }

    public void setSampleFlagsPresent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, Conversions.booleanObject(z)));
            if (z) {
                setFlags(getFlags() | 1024);
            } else {
                setFlags(getFlags() & 16776191);
            }
        }
    }

    public void setSampleSizePresent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.booleanObject(z)));
            if (z) {
                setFlags(getFlags() | 512);
            } else {
                setFlags(getFlags() & 16776703);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_18, this, this));
            return "TrackRunBox{sampleCount=" + this.entries.size() + ", dataOffset=" + this.dataOffset + ", dataOffsetPresent=" + isDataOffsetPresent() + ", sampleSizePresent=" + isSampleSizePresent() + ", sampleDurationPresent=" + isSampleDurationPresent() + ", sampleFlagsPresentPresent=" + isSampleFlagsPresent() + ", sampleCompositionTimeOffsetPresent=" + isSampleCompositionTimeOffsetPresent() + ", firstSampleFlags=" + this.firstSampleFlags + '}';
        }
        return (String) invokeV.objValue;
    }
}
