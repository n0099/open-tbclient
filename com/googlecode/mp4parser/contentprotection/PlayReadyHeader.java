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
import org.apache.commons.base.CharEncoding;
/* loaded from: classes7.dex */
public class PlayReadyHeader extends ProtectionSpecificHeader {
    public static /* synthetic */ Interceptable $ic;
    public static UUID PROTECTION_SYSTEM_ID;
    public transient /* synthetic */ FieldHolder $fh;
    public long length;
    public List records;

    /* loaded from: classes7.dex */
    public abstract class PlayReadyRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int type;

        public abstract ByteBuffer getValue();

        public abstract void parse(ByteBuffer byteBuffer);

        /* loaded from: classes7.dex */
        public class DefaulPlayReadyRecord extends PlayReadyRecord {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public ByteBuffer value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DefaulPlayReadyRecord(int i) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i)};
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
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.value;
                }
                return (ByteBuffer) invokeV.objValue;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public void parse(ByteBuffer byteBuffer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                    this.value = byteBuffer.duplicate();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class EmeddedLicenseStore extends PlayReadyRecord {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.value;
                }
                return (ByteBuffer) invokeV.objValue;
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
                    return "EmeddedLicenseStore{length=" + getValue().limit() + '}';
                }
                return (String) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class RMHeader extends PlayReadyRecord {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.header;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.googlecode.mp4parser.contentprotection.PlayReadyHeader.PlayReadyRecord
            public ByteBuffer getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    try {
                        return ByteBuffer.wrap(this.header.getBytes(CharEncoding.UTF_16LE));
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
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
                        this.header = new String(bArr, CharEncoding.UTF_16LE);
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
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
                    return "RMHeader{length=" + getValue().limit() + ", header='" + this.header + "'}";
                }
                return (String) invokeV.objValue;
            }
        }

        public PlayReadyRecord(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = i;
        }

        public static List createFor(ByteBuffer byteBuffer, int i) {
            InterceptResult invokeLI;
            PlayReadyRecord rMHeader;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, byteBuffer, i)) == null) {
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    int readUInt16BE = IsoTypeReader.readUInt16BE(byteBuffer);
                    int readUInt16BE2 = IsoTypeReader.readUInt16BE(byteBuffer);
                    if (readUInt16BE != 1) {
                        if (readUInt16BE != 2) {
                            if (readUInt16BE != 3) {
                                rMHeader = new DefaulPlayReadyRecord(readUInt16BE);
                            } else {
                                rMHeader = new EmeddedLicenseStore();
                            }
                        } else {
                            rMHeader = new DefaulPlayReadyRecord(2);
                        }
                    } else {
                        rMHeader = new RMHeader();
                    }
                    rMHeader.parse((ByteBuffer) byteBuffer.slice().limit(readUInt16BE2));
                    byteBuffer.position(byteBuffer.position() + readUInt16BE2);
                    arrayList.add(rMHeader);
                }
                return arrayList;
            }
            return (List) invokeLI.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "PlayReadyRecord{type=" + this.type + ", length=" + getValue().limit() + '}';
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public List getRecords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return Collections.unmodifiableList(this.records);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public UUID getSystemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return PROTECTION_SYSTEM_ID;
        }
        return (UUID) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public ByteBuffer getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = 6;
            for (PlayReadyRecord playReadyRecord : this.records) {
                i = i + 4 + playReadyRecord.getValue().rewind().limit();
            }
            ByteBuffer allocate = ByteBuffer.allocate(i);
            IsoTypeWriter.writeUInt32BE(allocate, i);
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

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public void parse(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            this.length = IsoTypeReader.readUInt32BE(byteBuffer);
            this.records = PlayReadyRecord.createFor(byteBuffer, IsoTypeReader.readUInt16BE(byteBuffer));
        }
    }

    public void setRecords(List list) {
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
            return "PlayReadyHeader{length=" + this.length + ", recordCount=" + this.records.size() + ", records=" + this.records + '}';
        }
        return (String) invokeV.objValue;
    }
}
