package protobuf.GetGroupMsg;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
/* loaded from: classes.dex */
public final class GetGroupMsgReq {

    /* loaded from: classes.dex */
    public final class DataReq extends GeneratedMessageLite implements c {
        public static final int GROUPMIDS_FIELD_NUMBER = 6;
        public static final int HEIGHT_FIELD_NUMBER = 2;
        public static final int PUSHTIMES_FIELD_NUMBER = 5;
        public static final int SMALLHEIGHT_FIELD_NUMBER = 4;
        public static final int SMALLWIDTH_FIELD_NUMBER = 3;
        public static final int WIDTH_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<Im.GroupLastId> groupMids_;
        private int height_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object pushTimes_;
        private int smallHeight_;
        private int smallWidth_;
        private int width_;
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
            boolean z2 = false;
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
                                this.width_ = codedInputStream.readInt32();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.height_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.smallWidth_ = codedInputStream.readInt32();
                                break;
                            case 32:
                                this.bitField0_ |= 8;
                                this.smallHeight_ = codedInputStream.readInt32();
                                break;
                            case 42:
                                this.bitField0_ |= 16;
                                this.pushTimes_ = codedInputStream.readBytes();
                                break;
                            case 50:
                                if (!(z2 & true)) {
                                    this.groupMids_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.groupMids_.add((Im.GroupLastId) codedInputStream.readMessage(Im.GroupLastId.PARSER, extensionRegistryLite));
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
                    if (z2 & true) {
                        this.groupMids_ = Collections.unmodifiableList(this.groupMids_);
                    }
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

        public boolean hasWidth() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getWidth() {
            return this.width_;
        }

        public boolean hasHeight() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getHeight() {
            return this.height_;
        }

        public boolean hasSmallWidth() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getSmallWidth() {
            return this.smallWidth_;
        }

        public boolean hasSmallHeight() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getSmallHeight() {
            return this.smallHeight_;
        }

        public boolean hasPushTimes() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getPushTimes() {
            Object obj = this.pushTimes_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.pushTimes_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPushTimesBytes() {
            Object obj = this.pushTimes_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pushTimes_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public List<Im.GroupLastId> getGroupMidsList() {
            return this.groupMids_;
        }

        public List<? extends protobuf.o> getGroupMidsOrBuilderList() {
            return this.groupMids_;
        }

        public int getGroupMidsCount() {
            return this.groupMids_.size();
        }

        public Im.GroupLastId getGroupMids(int i) {
            return this.groupMids_.get(i);
        }

        public protobuf.o getGroupMidsOrBuilder(int i) {
            return this.groupMids_.get(i);
        }

        private void a() {
            this.width_ = 0;
            this.height_ = 0;
            this.smallWidth_ = 0;
            this.smallHeight_ = 0;
            this.pushTimes_ = "";
            this.groupMids_ = Collections.emptyList();
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
                codedOutputStream.writeInt32(1, this.width_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.height_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.smallWidth_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.smallHeight_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(5, getPushTimesBytes());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.groupMids_.size()) {
                    codedOutputStream.writeMessage(6, this.groupMids_.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 == -1) {
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.width_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.height_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(3, this.smallWidth_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(4, this.smallHeight_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(5, getPushTimesBytes());
                }
                while (true) {
                    i2 = computeInt32Size;
                    if (i >= this.groupMids_.size()) {
                        break;
                    }
                    computeInt32Size = CodedOutputStream.computeMessageSize(6, this.groupMids_.get(i)) + i2;
                    i++;
                }
                this.memoizedSerializedSize = i2;
            }
            return i2;
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
    public final class GetGroupMsgReqIdl extends GeneratedMessageLite implements f {
        public static final int CUID_FIELD_NUMBER = 1;
        public static final int DATA_FIELD_NUMBER = 2;
        public static Parser<GetGroupMsgReqIdl> PARSER = new d();
        private static final GetGroupMsgReqIdl a = new GetGroupMsgReqIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object cuid_;
        private DataReq data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ GetGroupMsgReqIdl(GeneratedMessageLite.Builder builder, GetGroupMsgReqIdl getGroupMsgReqIdl) {
            this(builder);
        }

        private GetGroupMsgReqIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GetGroupMsgReqIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GetGroupMsgReqIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public GetGroupMsgReqIdl getDefaultInstanceForType() {
            return a;
        }

        private GetGroupMsgReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                this.bitField0_ |= 1;
                                this.cuid_ = codedInputStream.readBytes();
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                if ((this.bitField0_ & 2) != 2) {
                                    bVar = null;
                                } else {
                                    bVar = this.data_.toBuilder();
                                }
                                this.data_ = (DataReq) codedInputStream.readMessage(DataReq.PARSER, extensionRegistryLite);
                                if (bVar != null) {
                                    bVar.mergeFrom(this.data_);
                                    this.data_ = bVar.buildPartial();
                                }
                                this.bitField0_ |= 2;
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
        public /* synthetic */ GetGroupMsgReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, GetGroupMsgReqIdl getGroupMsgReqIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<GetGroupMsgReqIdl> getParserForType() {
            return PARSER;
        }

        public boolean hasCuid() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getCuid() {
            Object obj = this.cuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.cuid_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCuidBytes() {
            Object obj = this.cuid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cuid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasData() {
            return (this.bitField0_ & 2) == 2;
        }

        public DataReq getData() {
            return this.data_;
        }

        private void a() {
            this.cuid_ = "";
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
                codedOutputStream.writeBytes(1, getCuidBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.data_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getCuidBytes()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeMessageSize(2, this.data_);
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

        public static GetGroupMsgReqIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static GetGroupMsgReqIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GetGroupMsgReqIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static GetGroupMsgReqIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static GetGroupMsgReqIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static GetGroupMsgReqIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static GetGroupMsgReqIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static GetGroupMsgReqIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static GetGroupMsgReqIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static GetGroupMsgReqIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static e newBuilder(GetGroupMsgReqIdl getGroupMsgReqIdl) {
            return newBuilder().mergeFrom(getGroupMsgReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public e toBuilder() {
            return newBuilder(this);
        }
    }
}
