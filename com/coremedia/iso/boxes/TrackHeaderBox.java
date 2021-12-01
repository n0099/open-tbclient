package com.coremedia.iso.boxes;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import com.googlecode.mp4parser.util.Matrix;
import com.kuaishou.weapon.un.w0;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes12.dex */
public class TrackHeaderBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "tkhd";
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
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_22 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_23 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_24 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_25 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_26 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_27 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_28 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_29 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public int alternateGroup;
    public Date creationTime;
    public long duration;
    public double height;
    public int layer;
    public Matrix matrix;
    public Date modificationTime;
    public long trackId;
    public float volume;
    public double width;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1775008228, "Lcom/coremedia/iso/boxes/TrackHeaderBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1775008228, "Lcom/coremedia/iso/boxes/TrackHeaderBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackHeaderBox() {
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
        this.matrix = Matrix.ROTATE_0;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("TrackHeaderBox.java", TrackHeaderBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 60);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 64);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 138);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 166);
        ajc$tjp_12 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 192);
        ajc$tjp_13 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 199);
        ajc$tjp_14 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), 207);
        ajc$tjp_15 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "duration", "", "void"), w0.A);
        ajc$tjp_16 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), 218);
        ajc$tjp_17 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), w0.f56899k);
        ajc$tjp_18 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", ShaderParams.VALUE_TYPE_FLOAT, "volume", "", "void"), Constants.METHOD_MEDIA_NOTIFY);
        ajc$tjp_19 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 230);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 68);
        ajc$tjp_20 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "width", "", "void"), 234);
        ajc$tjp_21 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "height", "", "void"), 238);
        ajc$tjp_22 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK);
        ajc$tjp_23 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), GDiffPatcher.DATA_USHORT);
        ajc$tjp_24 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), GDiffPatcher.COPY_USHORT_INT);
        ajc$tjp_25 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 255);
        ajc$tjp_26 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", SapiOptions.KEY_CACHE_ENABLED, "", "void"), 259);
        ajc$tjp_27 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), w0.g0);
        ajc$tjp_28 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), w0.y);
        ajc$tjp_29 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 283);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 72);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 76);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 80);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", ShaderParams.VALUE_TYPE_FLOAT), 84);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 88);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 92);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 96);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            if (getVersion() == 1) {
                this.creationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
                this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
                this.trackId = IsoTypeReader.readUInt32(byteBuffer);
                IsoTypeReader.readUInt32(byteBuffer);
                this.duration = IsoTypeReader.readUInt64(byteBuffer);
            } else {
                this.creationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
                this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
                this.trackId = IsoTypeReader.readUInt32(byteBuffer);
                IsoTypeReader.readUInt32(byteBuffer);
                this.duration = IsoTypeReader.readUInt32(byteBuffer);
            }
            IsoTypeReader.readUInt32(byteBuffer);
            IsoTypeReader.readUInt32(byteBuffer);
            this.layer = IsoTypeReader.readUInt16(byteBuffer);
            this.alternateGroup = IsoTypeReader.readUInt16(byteBuffer);
            this.volume = IsoTypeReader.readFixedPoint88(byteBuffer);
            IsoTypeReader.readUInt16(byteBuffer);
            this.matrix = Matrix.fromByteBuffer(byteBuffer);
            this.width = IsoTypeReader.readFixedPoint1616(byteBuffer);
            this.height = IsoTypeReader.readFixedPoint1616(byteBuffer);
        }
    }

    public int getAlternateGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this));
            return this.alternateGroup;
        }
        return invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this, byteBuffer));
            writeVersionAndFlags(byteBuffer);
            if (getVersion() == 1) {
                IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.creationTime));
                IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.modificationTime));
                IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
                IsoTypeWriter.writeUInt32(byteBuffer, 0L);
                IsoTypeWriter.writeUInt64(byteBuffer, this.duration);
            } else {
                IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.creationTime));
                IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.modificationTime));
                IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
                IsoTypeWriter.writeUInt32(byteBuffer, 0L);
                IsoTypeWriter.writeUInt32(byteBuffer, this.duration);
            }
            IsoTypeWriter.writeUInt32(byteBuffer, 0L);
            IsoTypeWriter.writeUInt32(byteBuffer, 0L);
            IsoTypeWriter.writeUInt16(byteBuffer, this.layer);
            IsoTypeWriter.writeUInt16(byteBuffer, this.alternateGroup);
            IsoTypeWriter.writeFixedPoint88(byteBuffer, this.volume);
            IsoTypeWriter.writeUInt16(byteBuffer, 0);
            this.matrix.getContent(byteBuffer);
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.width);
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.height);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (getVersion() == 1 ? 36L : 24L) + 60;
        }
        return invokeV.longValue;
    }

    public Date getCreationTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.creationTime;
        }
        return (Date) invokeV.objValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this));
            return this.duration;
        }
        return invokeV.longValue;
    }

    public double getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this));
            return this.height;
        }
        return invokeV.doubleValue;
    }

    public int getLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return this.layer;
        }
        return invokeV.intValue;
    }

    public Matrix getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this));
            return this.matrix;
        }
        return (Matrix) invokeV.objValue;
    }

    public Date getModificationTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this));
            return this.modificationTime;
        }
        return (Date) invokeV.objValue;
    }

    public long getTrackId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return this.trackId;
        }
        return invokeV.longValue;
    }

    public float getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
            return this.volume;
        }
        return invokeV.floatValue;
    }

    public double getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
            return this.width;
        }
        return invokeV.doubleValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_22, this, this));
            return (getFlags() & 1) > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isInMovie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_23, this, this));
            return (getFlags() & 2) > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isInPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_25, this, this));
            return (getFlags() & 8) > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isInPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_24, this, this));
            return (getFlags() & 4) > 0;
        }
        return invokeV.booleanValue;
    }

    public void setAlternateGroup(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_17, this, this, Conversions.intObject(i2)));
            this.alternateGroup = i2;
        }
    }

    public void setCreationTime(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, date) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this, date));
            this.creationTime = date;
            if (DateHelper.convert(date) >= 4294967296L) {
                setVersion(1);
            }
        }
    }

    public void setDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_15, this, this, Conversions.longObject(j2)));
            this.duration = j2;
            if (j2 >= 4294967296L) {
                setFlags(1);
            }
        }
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_26, this, this, Conversions.booleanObject(z)));
            if (z) {
                setFlags(getFlags() | 1);
            } else {
                setFlags(getFlags() & (-2));
            }
        }
    }

    public void setHeight(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Double.valueOf(d2)}) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_21, this, this, Conversions.doubleObject(d2)));
            this.height = d2;
        }
    }

    public void setInMovie(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_27, this, this, Conversions.booleanObject(z)));
            if (z) {
                setFlags(getFlags() | 2);
            } else {
                setFlags(getFlags() & (-3));
            }
        }
    }

    public void setInPoster(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_29, this, this, Conversions.booleanObject(z)));
            if (z) {
                setFlags(getFlags() | 8);
            } else {
                setFlags(getFlags() & (-9));
            }
        }
    }

    public void setInPreview(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_28, this, this, Conversions.booleanObject(z)));
            if (z) {
                setFlags(getFlags() | 4);
            } else {
                setFlags(getFlags() & (-5));
            }
        }
    }

    public void setLayer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_16, this, this, Conversions.intObject(i2)));
            this.layer = i2;
        }
    }

    public void setMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, matrix) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_19, this, this, matrix));
            this.matrix = matrix;
        }
    }

    public void setModificationTime(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, date) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, date));
            this.modificationTime = date;
            if (DateHelper.convert(date) >= 4294967296L) {
                setVersion(1);
            }
        }
    }

    public void setTrackId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_14, this, this, Conversions.longObject(j2)));
            this.trackId = j2;
        }
    }

    public void setVolume(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_18, this, this, Conversions.floatObject(f2)));
            this.volume = f2;
        }
    }

    public void setWidth(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Double.valueOf(d2)}) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_20, this, this, Conversions.doubleObject(d2)));
            this.width = d2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this));
            return "TrackHeaderBox[creationTime=" + getCreationTime() + ";modificationTime=" + getModificationTime() + ";trackId=" + getTrackId() + ";duration=" + getDuration() + ";layer=" + getLayer() + ";alternateGroup=" + getAlternateGroup() + ";volume=" + getVolume() + ";matrix=" + this.matrix + ";" + BigImageLoaderProc.NCDN_PER + getWidth() + ";height=" + getHeight() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
