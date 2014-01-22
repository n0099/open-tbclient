package protobuf.CommitPusherCount;

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
public final class CommitPusherCountReq {

    /* loaded from: classes.dex */
    public final class DataReq extends GeneratedMessageLite implements g {
        public static final int DOWNFLOWSIZE_FIELD_NUMBER = 3;
        public static final int ENTERFORECOUNT_FIELD_NUMBER = 4;
        public static final int PUSHERCOUNT_FIELD_NUMBER = 1;
        public static final int UPFLOWSIZE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private long downFlowSize_;
        private long enterForeCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long pusherCount_;
        private long upFlowSize_;
        public static Parser<DataReq> PARSER = new e();
        private static final DataReq a = new DataReq(true);

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
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.pusherCount_ = codedInputStream.readInt64();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.upFlowSize_ = codedInputStream.readInt64();
                                    break;
                                case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                    this.bitField0_ |= 4;
                                    this.downFlowSize_ = codedInputStream.readInt64();
                                    break;
                                case Im.GroupInfo.ISNEWLYCREATE_FIELD_NUMBER /* 32 */:
                                    this.bitField0_ |= 8;
                                    this.enterForeCount_ = codedInputStream.readInt64();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<DataReq> getParserForType() {
            return PARSER;
        }

        public boolean hasPusherCount() {
            return (this.bitField0_ & 1) == 1;
        }

        public long getPusherCount() {
            return this.pusherCount_;
        }

        public boolean hasUpFlowSize() {
            return (this.bitField0_ & 2) == 2;
        }

        public long getUpFlowSize() {
            return this.upFlowSize_;
        }

        public boolean hasDownFlowSize() {
            return (this.bitField0_ & 4) == 4;
        }

        public long getDownFlowSize() {
            return this.downFlowSize_;
        }

        public boolean hasEnterForeCount() {
            return (this.bitField0_ & 8) == 8;
        }

        public long getEnterForeCount() {
            return this.enterForeCount_;
        }

        private void a() {
            this.pusherCount_ = 0L;
            this.upFlowSize_ = 0L;
            this.downFlowSize_ = 0L;
            this.enterForeCount_ = 0L;
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
                codedOutputStream.writeInt64(1, this.pusherCount_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt64(2, this.upFlowSize_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.downFlowSize_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.enterForeCount_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.pusherCount_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.upFlowSize_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.downFlowSize_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.enterForeCount_);
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

        public static f newBuilder() {
            return f.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public f newBuilderForType() {
            return newBuilder();
        }

        public static f newBuilder(DataReq dataReq) {
            return newBuilder().mergeFrom(dataReq);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public f toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class CommitPusherCountReqIdl extends GeneratedMessageLite implements d {
        public static final int DATA_FIELD_NUMBER = 1;
        public static Parser<CommitPusherCountReqIdl> PARSER = new b();
        private static final CommitPusherCountReqIdl a = new CommitPusherCountReqIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataReq data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private CommitPusherCountReqIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private CommitPusherCountReqIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static CommitPusherCountReqIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public CommitPusherCountReqIdl getDefaultInstanceForType() {
            return a;
        }

        private CommitPusherCountReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            f fVar;
            boolean z;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 10:
                                if ((this.bitField0_ & 1) != 1) {
                                    fVar = null;
                                } else {
                                    fVar = this.data_.toBuilder();
                                }
                                this.data_ = (DataReq) codedInputStream.readMessage(DataReq.PARSER, extensionRegistryLite);
                                if (fVar != null) {
                                    fVar.mergeFrom(this.data_);
                                    this.data_ = fVar.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                z = z2;
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    break;
                                } else {
                                    z = z2;
                                    break;
                                }
                        }
                        z2 = z;
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

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<CommitPusherCountReqIdl> getParserForType() {
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

        public static CommitPusherCountReqIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static CommitPusherCountReqIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CommitPusherCountReqIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static CommitPusherCountReqIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CommitPusherCountReqIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static CommitPusherCountReqIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CommitPusherCountReqIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CommitPusherCountReqIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CommitPusherCountReqIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CommitPusherCountReqIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static c newBuilder() {
            return c.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public c newBuilderForType() {
            return newBuilder();
        }

        public static c newBuilder(CommitPusherCountReqIdl commitPusherCountReqIdl) {
            return newBuilder().mergeFrom(commitPusherCountReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public c toBuilder() {
            return newBuilder(this);
        }
    }
}
