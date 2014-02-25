package protobuf.ApplyJoinGroup;

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
public final class ApplyJoinGroupReq {

    /* loaded from: classes.dex */
    public final class DataReq extends GeneratedMessageLite implements f {
        public static final int GROUPID_FIELD_NUMBER = 1;
        public static final int INVITEUSERID_FIELD_NUMBER = 3;
        public static final int JOINTYPE_FIELD_NUMBER = 4;
        public static final int USERMSG_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int groupId_;
        private long inviteUserId_;
        private int joinType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object userMsg_;
        public static Parser<DataReq> PARSER = new d();
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
                                this.groupId_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.userMsg_ = codedInputStream.readBytes();
                                break;
                            case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.inviteUserId_ = codedInputStream.readInt64();
                                break;
                            case 32:
                                this.bitField0_ |= 8;
                                this.joinType_ = codedInputStream.readInt32();
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

        public boolean hasGroupId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getGroupId() {
            return this.groupId_;
        }

        public boolean hasUserMsg() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getUserMsg() {
            Object obj = this.userMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.userMsg_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getUserMsgBytes() {
            Object obj = this.userMsg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasInviteUserId() {
            return (this.bitField0_ & 4) == 4;
        }

        public long getInviteUserId() {
            return this.inviteUserId_;
        }

        public boolean hasJoinType() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getJoinType() {
            return this.joinType_;
        }

        private void a() {
            this.groupId_ = 0;
            this.userMsg_ = "";
            this.inviteUserId_ = 0L;
            this.joinType_ = 0;
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
                codedOutputStream.writeInt32(1, this.groupId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getUserMsgBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.inviteUserId_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.joinType_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.groupId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getUserMsgBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.inviteUserId_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(4, this.joinType_);
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

        public static e newBuilder() {
            return e.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public e newBuilderForType() {
            return newBuilder();
        }

        public static e newBuilder(DataReq dataReq) {
            return newBuilder().mergeFrom(dataReq);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public e toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class ApplyJoinGroupReqIdl extends GeneratedMessageLite implements c {
        public static final int DATA_FIELD_NUMBER = 1;
        public static Parser<ApplyJoinGroupReqIdl> PARSER = new a();
        private static final ApplyJoinGroupReqIdl a = new ApplyJoinGroupReqIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataReq data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ ApplyJoinGroupReqIdl(GeneratedMessageLite.Builder builder, ApplyJoinGroupReqIdl applyJoinGroupReqIdl) {
            this(builder);
        }

        private ApplyJoinGroupReqIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ApplyJoinGroupReqIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ApplyJoinGroupReqIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public ApplyJoinGroupReqIdl getDefaultInstanceForType() {
            return a;
        }

        private ApplyJoinGroupReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            e eVar;
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
                                    eVar = null;
                                } else {
                                    eVar = this.data_.toBuilder();
                                }
                                this.data_ = (DataReq) codedInputStream.readMessage(DataReq.PARSER, extensionRegistryLite);
                                if (eVar != null) {
                                    eVar.mergeFrom(this.data_);
                                    this.data_ = eVar.buildPartial();
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
        public /* synthetic */ ApplyJoinGroupReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ApplyJoinGroupReqIdl applyJoinGroupReqIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ApplyJoinGroupReqIdl> getParserForType() {
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

        public static ApplyJoinGroupReqIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static ApplyJoinGroupReqIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ApplyJoinGroupReqIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static ApplyJoinGroupReqIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ApplyJoinGroupReqIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static ApplyJoinGroupReqIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ApplyJoinGroupReqIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ApplyJoinGroupReqIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ApplyJoinGroupReqIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ApplyJoinGroupReqIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static b newBuilder(ApplyJoinGroupReqIdl applyJoinGroupReqIdl) {
            return newBuilder().mergeFrom(applyJoinGroupReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public b toBuilder() {
            return newBuilder(this);
        }
    }
}
