package com.googlecode.mp4parser.boxes;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
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
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes2.dex */
public abstract class AbstractSampleEncryptionBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public int algorithmId;
    public List<CencSampleAuxiliaryDataFormat> entries;
    public int ivSize;
    public byte[] kid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1227386307, "Lcom/googlecode/mp4parser/boxes/AbstractSampleEncryptionBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1227386307, "Lcom/googlecode/mp4parser/boxes/AbstractSampleEncryptionBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractSampleEncryptionBox(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
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
        this.algorithmId = -1;
        this.ivSize = -1;
        this.kid = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        this.entries = new LinkedList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("AbstractSampleEncryptionBox.java", AbstractSampleEncryptionBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getOffsetToFirstIV", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 33);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 92);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 96);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "equals", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.lang.Object", "o", "", "boolean"), 164);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", TTDownloadField.TT_HASHCODE, "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 191);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntrySizes", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), Opcodes.IFNONNULL);
    }

    private List<CencSampleAuxiliaryDataFormat> parseEntries(ByteBuffer byteBuffer, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{byteBuffer, Long.valueOf(j), Integer.valueOf(i2)})) != null) {
            return (List) invokeCommon.objValue;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            long j2 = j - 1;
            if (j <= 0) {
                return linkedList;
            }
            try {
                CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = new CencSampleAuxiliaryDataFormat();
                byte[] bArr = new byte[i2];
                cencSampleAuxiliaryDataFormat.iv = bArr;
                byteBuffer.get(bArr);
                if ((getFlags() & 2) > 0) {
                    int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
                    cencSampleAuxiliaryDataFormat.pairs = new LinkedList();
                    while (true) {
                        int i3 = readUInt16 - 1;
                        if (readUInt16 <= 0) {
                            break;
                        }
                        cencSampleAuxiliaryDataFormat.pairs.add(cencSampleAuxiliaryDataFormat.createPair(IsoTypeReader.readUInt16(byteBuffer), IsoTypeReader.readUInt32(byteBuffer)));
                        readUInt16 = i3;
                    }
                }
                linkedList.add(cencSampleAuxiliaryDataFormat);
                j = j2;
            } catch (BufferUnderflowException unused) {
                return null;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            if ((getFlags() & 1) > 0) {
                this.algorithmId = IsoTypeReader.readUInt24(byteBuffer);
                this.ivSize = IsoTypeReader.readUInt8(byteBuffer);
                byte[] bArr = new byte[16];
                this.kid = bArr;
                byteBuffer.get(bArr);
            }
            long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
            ByteBuffer duplicate = byteBuffer.duplicate();
            ByteBuffer duplicate2 = byteBuffer.duplicate();
            List<CencSampleAuxiliaryDataFormat> parseEntries = parseEntries(duplicate, readUInt32, 8);
            this.entries = parseEntries;
            if (parseEntries == null) {
                this.entries = parseEntries(duplicate2, readUInt32, 16);
                byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate2.remaining());
            } else {
                byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate.remaining());
            }
            if (this.entries == null) {
                throw new RuntimeException("Cannot parse SampleEncryptionBox");
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, obj));
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AbstractSampleEncryptionBox abstractSampleEncryptionBox = (AbstractSampleEncryptionBox) obj;
            if (this.algorithmId == abstractSampleEncryptionBox.algorithmId && this.ivSize == abstractSampleEncryptionBox.ivSize) {
                List<CencSampleAuxiliaryDataFormat> list = this.entries;
                if (list == null ? abstractSampleEncryptionBox.entries == null : list.equals(abstractSampleEncryptionBox.entries)) {
                    return Arrays.equals(this.kid, abstractSampleEncryptionBox.kid);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.googlecode.mp4parser.AbstractBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writableByteChannel) == null) {
            super.getBox(writableByteChannel);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            if (isOverrideTrackEncryptionBoxParameters()) {
                IsoTypeWriter.writeUInt24(byteBuffer, this.algorithmId);
                IsoTypeWriter.writeUInt8(byteBuffer, this.ivSize);
                byteBuffer.put(this.kid);
            }
            IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
            for (CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat : this.entries) {
                byte[] bArr = cencSampleAuxiliaryDataFormat.iv;
                if (bArr.length != 8 && bArr.length != 16) {
                    throw new RuntimeException("IV must be either 8 or 16 bytes");
                }
                byteBuffer.put(cencSampleAuxiliaryDataFormat.iv);
                if (isSubSampleEncryption()) {
                    IsoTypeWriter.writeUInt16(byteBuffer, cencSampleAuxiliaryDataFormat.pairs.size());
                    for (CencSampleAuxiliaryDataFormat.Pair pair : cencSampleAuxiliaryDataFormat.pairs) {
                        IsoTypeWriter.writeUInt16(byteBuffer, pair.clear);
                        IsoTypeWriter.writeUInt32(byteBuffer, pair.encrypted);
                    }
                }
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long length = (isOverrideTrackEncryptionBoxParameters() ? 8 + this.kid.length : 4L) + 4;
            for (CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat : this.entries) {
                length += cencSampleAuxiliaryDataFormat.getSize();
            }
            return length;
        }
        return invokeV.longValue;
    }

    public List<CencSampleAuxiliaryDataFormat> getEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this));
            return this.entries;
        }
        return (List) invokeV.objValue;
    }

    public List<Short> getEntrySizes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this));
            ArrayList arrayList = new ArrayList(this.entries.size());
            for (CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat : this.entries) {
                short length = (short) cencSampleAuxiliaryDataFormat.iv.length;
                if (isSubSampleEncryption()) {
                    length = (short) (((short) (length + 2)) + (cencSampleAuxiliaryDataFormat.pairs.size() * 6));
                }
                arrayList.add(Short.valueOf(length));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int getOffsetToFirstIV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return (getSize() > 4294967296L ? 16 : 8) + (isOverrideTrackEncryptionBoxParameters() ? this.kid.length + 4 : 0) + 4;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            int i2 = ((this.algorithmId * 31) + this.ivSize) * 31;
            byte[] bArr = this.kid;
            int hashCode = (i2 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
            List<CencSampleAuxiliaryDataFormat> list = this.entries;
            return hashCode + (list != null ? list.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @DoNotParseDetail
    public boolean isOverrideTrackEncryptionBoxParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (getFlags() & 1) > 0 : invokeV.booleanValue;
    }

    @DoNotParseDetail
    public boolean isSubSampleEncryption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (getFlags() & 2) > 0 : invokeV.booleanValue;
    }

    public void setEntries(List<CencSampleAuxiliaryDataFormat> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this, list));
            this.entries = list;
        }
    }

    @DoNotParseDetail
    public void setSubSampleEncryption(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                setFlags(getFlags() | 2);
            } else {
                setFlags(getFlags() & 16777213);
            }
        }
    }
}
