package protobuf.CommitInviteMsg;

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
public final class CommitInviteMsgReq {

    /* loaded from: classes.dex */
    public final class DataReq extends GeneratedMessageLite implements f {
        public static final int CONTENT_FIELD_NUMBER = 4;
        public static final int DURATION_FIELD_NUMBER = 5;
        public static final int GROUPID_FIELD_NUMBER = 1;
        public static final int MSGTYPE_FIELD_NUMBER = 3;
        public static final int RECORDID_FIELD_NUMBER = 6;
        public static final int TOUIDS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object content_;
        private int duration_;
        private int groupId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int msgType_;
        private long recordId_;
        private Object toUids_;
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
                                this.toUids_ = codedInputStream.readBytes();
                                break;
                            case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.msgType_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                this.bitField0_ |= 8;
                                this.content_ = codedInputStream.readBytes();
                                break;
                            case 40:
                                this.bitField0_ |= 16;
                                this.duration_ = codedInputStream.readInt32();
                                break;
                            case 48:
                                this.bitField0_ |= 32;
                                this.recordId_ = codedInputStream.readInt64();
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

        public boolean hasToUids() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getToUids() {
            Object obj = this.toUids_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.toUids_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getToUidsBytes() {
            Object obj = this.toUids_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.toUids_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasMsgType() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getMsgType() {
            return this.msgType_;
        }

        public boolean hasContent() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.content_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasDuration() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getDuration() {
            return this.duration_;
        }

        public boolean hasRecordId() {
            return (this.bitField0_ & 32) == 32;
        }

        public long getRecordId() {
            return this.recordId_;
        }

        private void a() {
            this.groupId_ = 0;
            this.toUids_ = "";
            this.msgType_ = 0;
            this.content_ = "";
            this.duration_ = 0;
            this.recordId_ = 0L;
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
                codedOutputStream.writeBytes(2, getToUidsBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.msgType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getContentBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.duration_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt64(6, this.recordId_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.groupId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getToUidsBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.msgType_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getContentBytes());
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeInt32Size(5, this.duration_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeInt64Size(6, this.recordId_);
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
    public final class CommitInviteMsgReqIdl extends GeneratedMessageLite implements c {
        public static final int DATA_FIELD_NUMBER = 1;
        public static Parser<CommitInviteMsgReqIdl> PARSER = new a();
        private static final CommitInviteMsgReqIdl a = new CommitInviteMsgReqIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataReq data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ CommitInviteMsgReqIdl(GeneratedMessageLite.Builder builder, CommitInviteMsgReqIdl commitInviteMsgReqIdl) {
            this(builder);
        }

        private CommitInviteMsgReqIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private CommitInviteMsgReqIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static CommitInviteMsgReqIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public CommitInviteMsgReqIdl getDefaultInstanceForType() {
            return a;
        }

        private CommitInviteMsgReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public /* synthetic */ CommitInviteMsgReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, CommitInviteMsgReqIdl commitInviteMsgReqIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<CommitInviteMsgReqIdl> getParserForType() {
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

        public static CommitInviteMsgReqIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static CommitInviteMsgReqIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CommitInviteMsgReqIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static CommitInviteMsgReqIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CommitInviteMsgReqIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static CommitInviteMsgReqIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CommitInviteMsgReqIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CommitInviteMsgReqIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CommitInviteMsgReqIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CommitInviteMsgReqIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static b newBuilder(CommitInviteMsgReqIdl commitInviteMsgReqIdl) {
            return newBuilder().mergeFrom(commitInviteMsgReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public b toBuilder() {
            return newBuilder(this);
        }
    }
}
