package com.coremedia.iso.boxes;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import com.googlecode.mp4parser.util.Matrix;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes7.dex */
public class MovieHeaderBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "mvhd";
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
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public Date creationTime;
    public int currentTime;
    public long duration;
    public Matrix matrix;
    public Date modificationTime;
    public long nextTrackId;
    public int posterTime;
    public int previewDuration;
    public int previewTime;
    public double rate;
    public int selectionDuration;
    public int selectionTime;
    public long timescale;
    public float volume;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1866437239, "Lcom/coremedia/iso/boxes/MovieHeaderBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1866437239, "Lcom/coremedia/iso/boxes/MovieHeaderBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getVersion() == 1) {
                j = 32;
            } else {
                j = 20;
            }
            return j + 80;
        }
        return invokeV.longValue;
    }

    public Date getCreationTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.creationTime;
        }
        return (Date) invokeV.objValue;
    }

    public int getCurrentTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_27, this, this));
            return this.currentTime;
        }
        return invokeV.intValue;
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

    public Matrix getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
            return this.matrix;
        }
        return (Matrix) invokeV.objValue;
    }

    public Date getModificationTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this));
            return this.modificationTime;
        }
        return (Date) invokeV.objValue;
    }

    public long getNextTrackId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this));
            return this.nextTrackId;
        }
        return invokeV.longValue;
    }

    public int getPosterTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_21, this, this));
            return this.posterTime;
        }
        return invokeV.intValue;
    }

    public int getPreviewDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_19, this, this));
            return this.previewDuration;
        }
        return invokeV.intValue;
    }

    public int getPreviewTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_17, this, this));
            return this.previewTime;
        }
        return invokeV.intValue;
    }

    public double getRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return this.rate;
        }
        return invokeV.doubleValue;
    }

    public int getSelectionDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_25, this, this));
            return this.selectionDuration;
        }
        return invokeV.intValue;
    }

    public int getSelectionTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_23, this, this));
            return this.selectionTime;
        }
        return invokeV.intValue;
    }

    public long getTimescale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return this.timescale;
        }
        return invokeV.longValue;
    }

    public float getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this));
            return this.volume;
        }
        return invokeV.floatValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieHeaderBox() {
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
        this.rate = 1.0d;
        this.volume = 1.0f;
        this.matrix = Matrix.ROTATE_0;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("MovieHeaderBox.java", MovieHeaderBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 63);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 67);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 211);
        ajc$tjp_12 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "duration", "", "void"), 215);
        ajc$tjp_13 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 222);
        ajc$tjp_14 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", ShaderParams.VALUE_TYPE_FLOAT, "volume", "", "void"), Constants.METHOD_MEDIA_NOTIFY);
        ajc$tjp_15 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 230);
        ajc$tjp_16 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 234);
        ajc$tjp_17 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 238);
        ajc$tjp_18 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 242);
        ajc$tjp_19 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 246);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 71);
        ajc$tjp_20 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 250);
        ajc$tjp_21 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 254);
        ajc$tjp_22 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512);
        ajc$tjp_23 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 262);
        ajc$tjp_24 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 266);
        ajc$tjp_25 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 270);
        ajc$tjp_26 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 274);
        ajc$tjp_27 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 278);
        ajc$tjp_28 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 282);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 75);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 79);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", ShaderParams.VALUE_TYPE_FLOAT), 83);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 87);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 91);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), Cea708Decoder.COMMAND_TGW);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), DownloadConstants.STATUS_WAITING_FOR_NETWORK);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            if (getVersion() == 1) {
                this.creationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
                this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
                this.timescale = IsoTypeReader.readUInt32(byteBuffer);
                this.duration = IsoTypeReader.readUInt64(byteBuffer);
            } else {
                this.creationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
                this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
                this.timescale = IsoTypeReader.readUInt32(byteBuffer);
                this.duration = IsoTypeReader.readUInt32(byteBuffer);
            }
            this.rate = IsoTypeReader.readFixedPoint1616(byteBuffer);
            this.volume = IsoTypeReader.readFixedPoint88(byteBuffer);
            IsoTypeReader.readUInt16(byteBuffer);
            IsoTypeReader.readUInt32(byteBuffer);
            IsoTypeReader.readUInt32(byteBuffer);
            this.matrix = Matrix.fromByteBuffer(byteBuffer);
            this.previewTime = byteBuffer.getInt();
            this.previewDuration = byteBuffer.getInt();
            this.posterTime = byteBuffer.getInt();
            this.selectionTime = byteBuffer.getInt();
            this.selectionDuration = byteBuffer.getInt();
            this.currentTime = byteBuffer.getInt();
            this.nextTrackId = IsoTypeReader.readUInt32(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            if (getVersion() == 1) {
                IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.creationTime));
                IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.modificationTime));
                IsoTypeWriter.writeUInt32(byteBuffer, this.timescale);
                IsoTypeWriter.writeUInt64(byteBuffer, this.duration);
            } else {
                IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.creationTime));
                IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.modificationTime));
                IsoTypeWriter.writeUInt32(byteBuffer, this.timescale);
                IsoTypeWriter.writeUInt32(byteBuffer, this.duration);
            }
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.rate);
            IsoTypeWriter.writeFixedPoint88(byteBuffer, this.volume);
            IsoTypeWriter.writeUInt16(byteBuffer, 0);
            IsoTypeWriter.writeUInt32(byteBuffer, 0L);
            IsoTypeWriter.writeUInt32(byteBuffer, 0L);
            this.matrix.getContent(byteBuffer);
            byteBuffer.putInt(this.previewTime);
            byteBuffer.putInt(this.previewDuration);
            byteBuffer.putInt(this.posterTime);
            byteBuffer.putInt(this.selectionTime);
            byteBuffer.putInt(this.selectionDuration);
            byteBuffer.putInt(this.currentTime);
            IsoTypeWriter.writeUInt32(byteBuffer, this.nextTrackId);
        }
    }

    public void setCreationTime(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, date) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, date));
            this.creationTime = date;
            if (DateHelper.convert(date) >= 4294967296L) {
                setVersion(1);
            }
        }
    }

    public void setCurrentTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_28, this, this, Conversions.intObject(i)));
            this.currentTime = i;
        }
    }

    public void setDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this, Conversions.longObject(j)));
            this.duration = j;
            if (j >= 4294967296L) {
                setVersion(1);
            }
        }
    }

    public void setMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, matrix) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_15, this, this, matrix));
            this.matrix = matrix;
        }
    }

    public void setModificationTime(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, date) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this, date));
            this.modificationTime = date;
            if (DateHelper.convert(date) >= 4294967296L) {
                setVersion(1);
            }
        }
    }

    public void setNextTrackId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_16, this, this, Conversions.longObject(j)));
            this.nextTrackId = j;
        }
    }

    public void setPosterTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_22, this, this, Conversions.intObject(i)));
            this.posterTime = i;
        }
    }

    public void setPreviewDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_20, this, this, Conversions.intObject(i)));
            this.previewDuration = i;
        }
    }

    public void setPreviewTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_18, this, this, Conversions.intObject(i)));
            this.previewTime = i;
        }
    }

    public void setRate(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Double.valueOf(d)}) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, Conversions.doubleObject(d)));
            this.rate = d;
        }
    }

    public void setSelectionDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_26, this, this, Conversions.intObject(i)));
            this.selectionDuration = i;
        }
    }

    public void setSelectionTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_24, this, this, Conversions.intObject(i)));
            this.selectionTime = i;
        }
    }

    public void setTimescale(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.longObject(j)));
            this.timescale = j;
        }
    }

    public void setVolume(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_14, this, this, Conversions.floatObject(f)));
            this.volume = f;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
            return "MovieHeaderBox[creationTime=" + getCreationTime() + ";modificationTime=" + getModificationTime() + ";timescale=" + getTimescale() + ";duration=" + getDuration() + ";rate=" + getRate() + ";volume=" + getVolume() + ";matrix=" + this.matrix + ";nextTrackId=" + getNextTrackId() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
