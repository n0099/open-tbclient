package com.coremedia.iso.boxes.fragment;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.facebook.imageutils.JfifUtil;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.CollectionToArray;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes11.dex */
public class TrackFragmentHeaderBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "tfhd";
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
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_20 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_21 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public long baseDataOffset;
    public boolean defaultBaseIsMoof;
    public long defaultSampleDuration;
    public SampleFlags defaultSampleFlags;
    public long defaultSampleSize;
    public boolean durationIsEmpty;
    public long sampleDescriptionIndex;
    public long trackId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2064704861, "Lcom/coremedia/iso/boxes/fragment/TrackFragmentHeaderBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2064704861, "Lcom/coremedia/iso/boxes/fragment/TrackFragmentHeaderBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackFragmentHeaderBox() {
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
        this.baseDataOffset = -1L;
        this.defaultSampleDuration = -1L;
        this.defaultSampleSize = -1L;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("TrackFragmentHeaderBox.java", TrackFragmentHeaderBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "hasBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 126);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "hasSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 166);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID);
        ajc$tjp_12 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 174);
        ajc$tjp_13 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "trackId", "", "void"), 178);
        ajc$tjp_14 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "baseDataOffset", "", "void"), Opcodes.INVOKEVIRTUAL);
        ajc$tjp_15 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "sampleDescriptionIndex", "", "void"), 191);
        ajc$tjp_16 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleDuration", "", "void"), 200);
        ajc$tjp_17 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleSize", "", "void"), 205);
        ajc$tjp_18 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 210);
        ajc$tjp_19 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "durationIsEmpty", "", "void"), JfifUtil.MARKER_RST7);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "hasDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 134);
        ajc$tjp_20 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "defaultBaseIsMoof", "", "void"), PassLivenessRecogActivity.S);
        ajc$tjp_21 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "java.lang.String"), Constants.METHOD_MEDIA_NOTIFY);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "hasDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 138);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "hasDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 142);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 146);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 150);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), Opcodes.IFNE);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 158);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 162);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            this.trackId = IsoTypeReader.readUInt32(byteBuffer);
            if ((getFlags() & 1) == 1) {
                this.baseDataOffset = IsoTypeReader.readUInt64(byteBuffer);
            }
            if ((getFlags() & 2) == 2) {
                this.sampleDescriptionIndex = IsoTypeReader.readUInt32(byteBuffer);
            }
            if ((getFlags() & 8) == 8) {
                this.defaultSampleDuration = IsoTypeReader.readUInt32(byteBuffer);
            }
            if ((getFlags() & 16) == 16) {
                this.defaultSampleSize = IsoTypeReader.readUInt32(byteBuffer);
            }
            if ((getFlags() & 32) == 32) {
                this.defaultSampleFlags = new SampleFlags(byteBuffer);
            }
            if ((getFlags() & 65536) == 65536) {
                this.durationIsEmpty = true;
            }
            if ((getFlags() & 131072) == 131072) {
                this.defaultBaseIsMoof = true;
            }
        }
    }

    public long getBaseDataOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
            return this.baseDataOffset;
        }
        return invokeV.longValue;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
            if ((getFlags() & 1) == 1) {
                IsoTypeWriter.writeUInt64(byteBuffer, getBaseDataOffset());
            }
            if ((getFlags() & 2) == 2) {
                IsoTypeWriter.writeUInt32(byteBuffer, getSampleDescriptionIndex());
            }
            if ((getFlags() & 8) == 8) {
                IsoTypeWriter.writeUInt32(byteBuffer, getDefaultSampleDuration());
            }
            if ((getFlags() & 16) == 16) {
                IsoTypeWriter.writeUInt32(byteBuffer, getDefaultSampleSize());
            }
            if ((getFlags() & 32) == 32) {
                this.defaultSampleFlags.getContent(byteBuffer);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int flags = getFlags();
            long j = (flags & 1) == 1 ? 16L : 8L;
            if ((flags & 2) == 2) {
                j += 4;
            }
            if ((flags & 8) == 8) {
                j += 4;
            }
            if ((flags & 16) == 16) {
                j += 4;
            }
            return (flags & 32) == 32 ? j + 4 : j;
        }
        return invokeV.longValue;
    }

    public long getDefaultSampleDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
            return this.defaultSampleDuration;
        }
        return invokeV.longValue;
    }

    public SampleFlags getDefaultSampleFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this));
            return this.defaultSampleFlags;
        }
        return (SampleFlags) invokeV.objValue;
    }

    public long getDefaultSampleSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this));
            return this.defaultSampleSize;
        }
        return invokeV.longValue;
    }

    public long getSampleDescriptionIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this));
            return this.sampleDescriptionIndex;
        }
        return invokeV.longValue;
    }

    public long getTrackId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this));
            return this.trackId;
        }
        return invokeV.longValue;
    }

    public boolean hasBaseDataOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return (getFlags() & 1) != 0;
        }
        return invokeV.booleanValue;
    }

    public boolean hasDefaultSampleDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return (getFlags() & 8) != 0;
        }
        return invokeV.booleanValue;
    }

    public boolean hasDefaultSampleFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return (getFlags() & 32) != 0;
        }
        return invokeV.booleanValue;
    }

    public boolean hasDefaultSampleSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this));
            return (getFlags() & 16) != 0;
        }
        return invokeV.booleanValue;
    }

    public boolean hasSampleDescriptionIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this));
            return (getFlags() & 2) != 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isDefaultBaseIsMoof() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this));
            return this.defaultBaseIsMoof;
        }
        return invokeV.booleanValue;
    }

    public boolean isDurationIsEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this));
            return this.durationIsEmpty;
        }
        return invokeV.booleanValue;
    }

    public void setBaseDataOffset(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_14, this, this, Conversions.longObject(j)));
            if (j == -1) {
                setFlags(getFlags() & 2147483646);
            } else {
                setFlags(getFlags() | 1);
            }
            this.baseDataOffset = j;
        }
    }

    public void setDefaultBaseIsMoof(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_20, this, this, Conversions.booleanObject(z)));
            setFlags(getFlags() | 131072);
            this.defaultBaseIsMoof = z;
        }
    }

    public void setDefaultSampleDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_16, this, this, Conversions.longObject(j)));
            setFlags(getFlags() | 8);
            this.defaultSampleDuration = j;
        }
    }

    public void setDefaultSampleFlags(SampleFlags sampleFlags) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, sampleFlags) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_18, this, this, sampleFlags));
            setFlags(getFlags() | 32);
            this.defaultSampleFlags = sampleFlags;
        }
    }

    public void setDefaultSampleSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_17, this, this, Conversions.longObject(j)));
            setFlags(getFlags() | 16);
            this.defaultSampleSize = j;
        }
    }

    public void setDurationIsEmpty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_19, this, this, Conversions.booleanObject(z)));
            setFlags(getFlags() | 65536);
            this.durationIsEmpty = z;
        }
    }

    public void setSampleDescriptionIndex(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_15, this, this, Conversions.longObject(j)));
            if (j == -1) {
                setFlags(getFlags() & CollectionToArray.MAX_SIZE);
            } else {
                setFlags(getFlags() | 2);
            }
            this.sampleDescriptionIndex = j;
        }
    }

    public void setTrackId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, Conversions.longObject(j)));
            this.trackId = j;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_21, this, this));
            return "TrackFragmentHeaderBox{trackId=" + this.trackId + ", baseDataOffset=" + this.baseDataOffset + ", sampleDescriptionIndex=" + this.sampleDescriptionIndex + ", defaultSampleDuration=" + this.defaultSampleDuration + ", defaultSampleSize=" + this.defaultSampleSize + ", defaultSampleFlags=" + this.defaultSampleFlags + ", durationIsEmpty=" + this.durationIsEmpty + ", defaultBaseIsMoof=" + this.defaultBaseIsMoof + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
