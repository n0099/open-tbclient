package com.coremedia.iso.boxes;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes6.dex */
public class SyncSampleBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "stss";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public long[] sampleNumber;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1023758375, "Lcom/coremedia/iso/boxes/SyncSampleBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1023758375, "Lcom/coremedia/iso/boxes/SyncSampleBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncSampleBox() {
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
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("SyncSampleBox.java", SyncSampleBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            int l2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
            this.sampleNumber = new long[l2i];
            for (int i2 = 0; i2 < l2i; i2++) {
                this.sampleNumber[i2] = IsoTypeReader.readUInt32(byteBuffer);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            IsoTypeWriter.writeUInt32(byteBuffer, this.sampleNumber.length);
            for (long j : this.sampleNumber) {
                IsoTypeWriter.writeUInt32(byteBuffer, j);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.sampleNumber.length * 4) + 8 : invokeV.longValue;
    }

    public long[] getSampleNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.sampleNumber;
        }
        return (long[]) invokeV.objValue;
    }

    public void setSampleNumber(long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jArr) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this, jArr));
            this.sampleNumber = jArr;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this));
            return "SyncSampleBox[entryCount=" + this.sampleNumber.length + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
