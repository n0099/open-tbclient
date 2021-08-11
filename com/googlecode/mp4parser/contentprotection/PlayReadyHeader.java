package com.googlecode.mp4parser.contentprotection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class PlayReadyHeader extends ProtectionSpecificHeader {
    public static /* synthetic */ Interceptable $ic;
    public static UUID PROTECTION_SYSTEM_ID;
    public transient /* synthetic */ FieldHolder $fh;
    public long length;
    public List<PlayReadyRecord> records;

    /* loaded from: classes10.dex */
    public static abstract class PlayReadyRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int type;

        /* loaded from: classes10.dex */
        public static class DefaulPlayReadyRecord extends PlayReadyRecord {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public ByteBuffer value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DefaulPlayReadyRecord(int i2) {
                super(i2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (ByteBuffer) invokeV.objValue;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                    this.value = byteBuffer.duplicate();
                }
            }
        }

        /* loaded from: classes10.dex */
        public static class EmeddedLicenseStore extends PlayReadyRecord {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public ByteBuffer value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmeddedLicenseStore() {
                super(3);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (ByteBuffer) invokeV.objValue;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                    this.value = byteBuffer.duplicate();
                }
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return "EmeddedLicenseStore{length=" + getValue().limit() + ExtendedMessageFormat.END_FE;
                }
                return (String) invokeV.objValue;
            }
        }

        /* loaded from: classes10.dex */
        public static class RMHeader extends PlayReadyRecord {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String header;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RMHeader() {
                super(1);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            public String getHeader() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.header : (String) invokeV.objValue;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    try {
                        return ByteBuffer.wrap(this.header.getBytes("UTF-16LE"));
                    } catch (UnsupportedEncodingException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                return (ByteBuffer) invokeV.objValue;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
                    try {
                        byte[] bArr = new byte[byteBuffer.slice().limit()];
                        byteBuffer.get(bArr);
                        this.header = new String(bArr, "UTF-16LE");
                    } catch (UnsupportedEncodingException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }

            public void setHeader(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    this.header = str;
                }
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return "RMHeader{length=" + getValue().limit() + ", header='" + this.header + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
                }
                return (String) invokeV.objValue;
            }
        }

        public PlayReadyRecord(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = i2;
        }

        public static List<PlayReadyRecord> createFor(ByteBuffer byteBuffer, int i2) {
            InterceptResult invokeLI;
            PlayReadyRecord rMHeader;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, byteBuffer, i2)) == null) {
                ArrayList arrayList = new ArrayList(i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    int readUInt16BE = IsoTypeReader.readUInt16BE(byteBuffer);
                    int readUInt16BE2 = IsoTypeReader.readUInt16BE(byteBuffer);
                    if (readUInt16BE == 1) {
                        rMHeader = new RMHeader();
                    } else if (readUInt16BE == 2) {
                        rMHeader = new DefaulPlayReadyRecord(2);
                    } else if (readUInt16BE != 3) {
                        rMHeader = new DefaulPlayReadyRecord(readUInt16BE);
                    } else {
                        rMHeader = new EmeddedLicenseStore();
                    }
                    rMHeader.parse((ByteBuffer) byteBuffer.slice().limit(readUInt16BE2));
                    byteBuffer.position(byteBuffer.position() + readUInt16BE2);
                    arrayList.add(rMHeader);
                }
                return arrayList;
            }
            return (List) invokeLI.objValue;
        }

        public abstract ByteBuffer getValue();

        public abstract void parse(ByteBuffer byteBuffer);

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "PlayReadyRecord{type=" + this.type + ", length=" + getValue().limit() + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1704222838, "Lcom/googlecode/mp4parser/contentprotection/PlayReadyHeader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1704222838, "Lcom/googlecode/mp4parser/contentprotection/PlayReadyHeader;");
                return;
            }
        }
        PROTECTION_SYSTEM_ID = UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95");
        ProtectionSpecificHeader.uuidRegistry.put(PROTECTION_SYSTEM_ID, PlayReadyHeader.class);
    }

    public PlayReadyHeader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public ByteBuffer getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = 6;
            for (PlayReadyRecord playReadyRecord : this.records) {
                i2 = i2 + 4 + playReadyRecord.getValue().rewind().limit();
            }
            ByteBuffer allocate = ByteBuffer.allocate(i2);
            IsoTypeWriter.writeUInt32BE(allocate, i2);
            IsoTypeWriter.writeUInt16BE(allocate, this.records.size());
            for (PlayReadyRecord playReadyRecord2 : this.records) {
                IsoTypeWriter.writeUInt16BE(allocate, playReadyRecord2.type);
                IsoTypeWriter.writeUInt16BE(allocate, playReadyRecord2.getValue().limit());
                allocate.put(playReadyRecord2.getValue());
            }
            return allocate;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public List<PlayReadyRecord> getRecords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Collections.unmodifiableList(this.records) : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public UUID getSystemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PROTECTION_SYSTEM_ID : (UUID) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public void parse(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            this.length = IsoTypeReader.readUInt32BE(byteBuffer);
            this.records = PlayReadyRecord.createFor(byteBuffer, IsoTypeReader.readUInt16BE(byteBuffer));
        }
    }

    public void setRecords(List<PlayReadyRecord> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.records = list;
        }
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "PlayReadyHeader{length=" + this.length + ", recordCount=" + this.records.size() + ", records=" + this.records + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
