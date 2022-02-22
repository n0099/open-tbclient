package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import com.kuaishou.weapon.un.w0;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes3.dex */
public class SampleGroupDescriptionBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "sgpd";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public int defaultLength;
    public int descriptionLength;
    public List<GroupEntry> groupEntries;
    public String groupingType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(916336567, "Lcom/googlecode/mp4parser/boxes/mp4/samplegrouping/SampleGroupDescriptionBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(916336567, "Lcom/googlecode/mp4parser/boxes/mp4/samplegrouping/SampleGroupDescriptionBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SampleGroupDescriptionBox() {
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
        this.groupEntries = new LinkedList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("SampleGroupDescriptionBox.java", SampleGroupDescriptionBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 135);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.String", "groupingType", "", "void"), w0.o);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), w0.x0);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 147);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), Opcodes.DCMPL);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), a.f32571e);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "equals", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", "o", "", "boolean"), 160);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", TTDownloadField.TT_HASHCODE, "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), Opcodes.INVOKESTATIC);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 192);
    }

    private GroupEntry parseGroupEntry(ByteBuffer byteBuffer, String str) {
        InterceptResult invokeLL;
        GroupEntry unknownEntry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, byteBuffer, str)) == null) {
            if ("roll".equals(str)) {
                unknownEntry = new RollRecoveryEntry();
            } else if (RateShareEntry.TYPE.equals(str)) {
                unknownEntry = new RateShareEntry();
            } else if (CencSampleEncryptionInformationGroupEntry.TYPE.equals(str)) {
                unknownEntry = new CencSampleEncryptionInformationGroupEntry();
            } else if (VisualRandomAccessEntry.TYPE.equals(str)) {
                unknownEntry = new VisualRandomAccessEntry();
            } else if (TemporalLevelEntry.TYPE.equals(str)) {
                unknownEntry = new TemporalLevelEntry();
            } else {
                unknownEntry = new UnknownEntry();
            }
            unknownEntry.parse(byteBuffer);
            return unknownEntry;
        }
        return (GroupEntry) invokeLL.objValue;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, byteBuffer) != null) {
            return;
        }
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.groupingType = IsoTypeReader.read4cc(byteBuffer);
            if (getVersion() == 1) {
                this.defaultLength = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
            }
            long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
            while (true) {
                long j2 = readUInt32 - 1;
                if (readUInt32 <= 0) {
                    return;
                }
                int i2 = this.defaultLength;
                if (getVersion() == 1) {
                    if (this.defaultLength == 0) {
                        i2 = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
                        this.descriptionLength = i2;
                    }
                    int position = byteBuffer.position() + i2;
                    ByteBuffer slice = byteBuffer.slice();
                    slice.limit(i2);
                    this.groupEntries.add(parseGroupEntry(slice, this.groupingType));
                    byteBuffer.position(position);
                    readUInt32 = j2;
                } else {
                    throw new RuntimeException("This should be implemented");
                }
            }
        } else {
            throw new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this, obj));
            if (this == obj) {
                return true;
            }
            if (obj == null || SampleGroupDescriptionBox.class != obj.getClass()) {
                return false;
            }
            SampleGroupDescriptionBox sampleGroupDescriptionBox = (SampleGroupDescriptionBox) obj;
            if (this.defaultLength != sampleGroupDescriptionBox.defaultLength) {
                return false;
            }
            List<GroupEntry> list = this.groupEntries;
            if (list == null ? sampleGroupDescriptionBox.groupEntries == null : list.equals(sampleGroupDescriptionBox.groupEntries)) {
                String str = this.groupingType;
                String str2 = sampleGroupDescriptionBox.groupingType;
                return str == null ? str2 == null : str.equals(str2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            byteBuffer.put(this.groupingType.getBytes());
            if (getVersion() == 1) {
                IsoTypeWriter.writeUInt32(byteBuffer, this.defaultLength);
            }
            IsoTypeWriter.writeUInt32(byteBuffer, this.groupEntries.size());
            for (GroupEntry groupEntry : this.groupEntries) {
                if (getVersion() == 1 && this.defaultLength == 0) {
                    IsoTypeWriter.writeUInt32(byteBuffer, groupEntry.get().limit());
                }
                byteBuffer.put(groupEntry.get());
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j2 = (getVersion() == 1 ? 12L : 8L) + 4;
            for (GroupEntry groupEntry : this.groupEntries) {
                if (getVersion() == 1 && this.defaultLength == 0) {
                    j2 += 4;
                }
                j2 += groupEntry.size();
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public int getDefaultLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return this.defaultLength;
        }
        return invokeV.intValue;
    }

    public List<GroupEntry> getGroupEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return this.groupEntries;
        }
        return (List) invokeV.objValue;
    }

    public String getGroupingType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.groupingType;
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this));
            String str = this.groupingType;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.defaultLength) * 31;
            List<GroupEntry> list = this.groupEntries;
            return hashCode + (list != null ? list.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public void setDefaultLength(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.intObject(i2)));
            this.defaultLength = i2;
        }
    }

    public void setGroupEntries(List<GroupEntry> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, list));
            this.groupEntries = list;
        }
    }

    public void setGroupingType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, str));
            this.groupingType = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
            return "SampleGroupDescriptionBox{groupingType='" + this.groupingType + ExtendedMessageFormat.QUOTE + ", defaultLength=" + this.defaultLength + ", groupEntries=" + this.groupEntries + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
