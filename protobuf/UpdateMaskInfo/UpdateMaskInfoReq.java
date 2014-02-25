package protobuf.UpdateMaskInfo;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import protobuf.Im;
/* loaded from: classes.dex */
public final class UpdateMaskInfoReq {

    /* loaded from: classes.dex */
    public final class DataReq extends GeneratedMessageLite implements c {
        public static final int ISMASK_FIELD_NUMBER = 2;
        public static final int LIST_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int isMask_;
        private Object list_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int type_;
        public static Parser<DataReq> PARSER = new a();
        private static final DataReq a = new DataReq(true);

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ DataReq(GeneratedMessageLite.Builder builder, DataReq dataReq) {
            this(builder);
        }

        private DataReq(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private DataReq(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DataReq getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public DataReq getDefaultInstanceForType() {
            return a;
        }

        private DataReq(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.type_ = codedInputStream.readUInt32();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.isMask_ = codedInputStream.readUInt32();
                                break;
                            case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                this.bitField0_ |= 4;
                                this.list_ = codedInputStream.readBytes();
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ DataReq(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DataReq dataReq) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<DataReq> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasIsMask() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getIsMask() {
            return this.isMask_;
        }

        public boolean hasList() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getList() {
            Object obj = this.list_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.list_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getListBytes() {
            Object obj = this.list_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.list_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void a() {
            this.type_ = 0;
            this.isMask_ = 0;
            this.list_ = "";
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeUInt32(1, this.type_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeUInt32(2, this.isMask_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getListBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.type_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeUInt32Size(2, this.isMask_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getListBytes());
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() {
            return super.writeReplace();
        }

        public static DataReq parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static DataReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DataReq parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static DataReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static DataReq parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static DataReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static DataReq parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static DataReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static DataReq parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static DataReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static b newBuilder() {
            return b.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public b newBuilderForType() {
            return newBuilder();
        }

        public static b newBuilder(DataReq dataReq) {
            return newBuilder().mergeFrom(dataReq);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public b toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class UpdateMaskInfoReqIdl extends GeneratedMessageLite implements f {
        public static final int DATA_FIELD_NUMBER = 1;
        public static Parser<UpdateMaskInfoReqIdl> PARSER = new d();
        private static final UpdateMaskInfoReqIdl a = new UpdateMaskInfoReqIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataReq data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ UpdateMaskInfoReqIdl(GeneratedMessageLite.Builder builder, UpdateMaskInfoReqIdl updateMaskInfoReqIdl) {
            this(builder);
        }

        private UpdateMaskInfoReqIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UpdateMaskInfoReqIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UpdateMaskInfoReqIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public UpdateMaskInfoReqIdl getDefaultInstanceForType() {
            return a;
        }

        private UpdateMaskInfoReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            b bVar;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 10:
                                if ((this.bitField0_ & 1) != 1) {
                                    bVar = null;
                                } else {
                                    bVar = this.data_.toBuilder();
                                }
                                this.data_ = (DataReq) codedInputStream.readMessage(DataReq.PARSER, extensionRegistryLite);
                                if (bVar != null) {
                                    bVar.mergeFrom(this.data_);
                                    this.data_ = bVar.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ UpdateMaskInfoReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UpdateMaskInfoReqIdl updateMaskInfoReqIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<UpdateMaskInfoReqIdl> getParserForType() {
            return PARSER;
        }

        public boolean hasData() {
            return (this.bitField0_ & 1) == 1;
        }

        public DataReq getData() {
            return this.data_;
        }

        private void a() {
            this.data_ = DataReq.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.data_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.data_) : 0;
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() {
            return super.writeReplace();
        }

        public static UpdateMaskInfoReqIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static UpdateMaskInfoReqIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UpdateMaskInfoReqIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static UpdateMaskInfoReqIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UpdateMaskInfoReqIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static UpdateMaskInfoReqIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateMaskInfoReqIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static UpdateMaskInfoReqIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateMaskInfoReqIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static UpdateMaskInfoReqIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static e newBuilder() {
            return e.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public e newBuilderForType() {
            return newBuilder();
        }

        public static e newBuilder(UpdateMaskInfoReqIdl updateMaskInfoReqIdl) {
            return newBuilder().mergeFrom(updateMaskInfoReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public e toBuilder() {
            return newBuilder(this);
        }
    }
}
