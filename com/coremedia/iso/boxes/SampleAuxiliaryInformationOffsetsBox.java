package com.coremedia.iso.boxes;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes7.dex */
public class SampleAuxiliaryInformationOffsetsBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "saio";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public String auxInfoType;
    public String auxInfoTypeParameter;
    public List<Long> offsets;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1774353412, "Lcom/coremedia/iso/boxes/SampleAuxiliaryInformationOffsetsBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1774353412, "Lcom/coremedia/iso/boxes/SampleAuxiliaryInformationOffsetsBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    public String getAuxInfoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.auxInfoType;
        }
        return (String) invokeV.objValue;
    }

    public String getAuxInfoTypeParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return this.auxInfoTypeParameter;
        }
        return (String) invokeV.objValue;
    }

    public List<Long> getOffsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return this.offsets;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SampleAuxiliaryInformationOffsetsBox() {
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
        this.offsets = new LinkedList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = 8;
            if (getVersion() == 0) {
                size = this.offsets.size() * 4;
            } else {
                size = this.offsets.size() * 8;
            }
            int i2 = size + 8;
            if ((getFlags() & 1) != 1) {
                i = 0;
            }
            return i2 + i;
        }
        return invokeV.longValue;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("SampleAuxiliaryInformationOffsetsBox.java", SampleAuxiliaryInformationOffsetsBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getAuxInfoType", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 109);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setAuxInfoType", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoType", "", "void"), 113);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getAuxInfoTypeParameter", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 117);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setAuxInfoTypeParameter", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 121);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getOffsets", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.util.List"), 125);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setOffsets", "com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox", "java.util.List", SevenZipUtils.LZMA_META_KEY_OFFSET, "", "void"), 129);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            if ((getFlags() & 1) == 1) {
                this.auxInfoType = IsoTypeReader.read4cc(byteBuffer);
                this.auxInfoTypeParameter = IsoTypeReader.read4cc(byteBuffer);
            }
            int l2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
            this.offsets.clear();
            for (int i = 0; i < l2i; i++) {
                if (getVersion() == 0) {
                    this.offsets.add(Long.valueOf(IsoTypeReader.readUInt32(byteBuffer)));
                } else {
                    this.offsets.add(Long.valueOf(IsoTypeReader.readUInt64(byteBuffer)));
                }
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            if ((getFlags() & 1) == 1) {
                byteBuffer.put(IsoFile.fourCCtoBytes(this.auxInfoType));
                byteBuffer.put(IsoFile.fourCCtoBytes(this.auxInfoTypeParameter));
            }
            IsoTypeWriter.writeUInt32(byteBuffer, this.offsets.size());
            for (Long l : this.offsets) {
                if (getVersion() == 0) {
                    IsoTypeWriter.writeUInt32(byteBuffer, l.longValue());
                } else {
                    IsoTypeWriter.writeUInt64(byteBuffer, l.longValue());
                }
            }
        }
    }

    public void setAuxInfoType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, str));
            this.auxInfoType = str;
        }
    }

    public void setAuxInfoTypeParameter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, str));
            this.auxInfoTypeParameter = str;
        }
    }

    public void setOffsets(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, list));
            this.offsets = list;
        }
    }
}
