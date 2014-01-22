package protobuf.QueryChatroomInfo;

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
import protobuf.ah;
/* loaded from: classes.dex */
public final class QueryChatroomInfoRes {

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements k {
        public static final int CONTENT_FIELD_NUMBER = 7;
        public static final int LASTMSGID_FIELD_NUMBER = 8;
        public static final int LEFTTIME_FIELD_NUMBER = 5;
        public static final int MAXUSERNUM_FIELD_NUMBER = 3;
        public static final int STATUS_FIELD_NUMBER = 4;
        public static final int TITLE_FIELD_NUMBER = 6;
        public static final int USERLIST_FIELD_NUMBER = 2;
        public static final int USERNUM_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object content_;
        private long lastMsgId_;
        private int leftTime_;
        private int maxUserNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int status_;
        private Object title_;
        private List<Im.UserInfo> userList_;
        private int userNum_;
        public static Parser<DataRes> PARSER = new i();
        private static final DataRes a = new DataRes(true);

        private DataRes(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private DataRes(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DataRes getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public DataRes getDefaultInstanceForType() {
            return a;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v21, resolved type: java.util.List<protobuf.Im$UserInfo> */
        /* JADX WARN: Multi-variable type inference failed */
        private DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            boolean z = false;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z2 = false;
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
                                    this.userNum_ = codedInputStream.readInt32();
                                    break;
                                case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                    if (!(z2 & true)) {
                                        this.userList_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.userList_.add(codedInputStream.readMessage(Im.UserInfo.PARSER, extensionRegistryLite));
                                    break;
                                case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                    this.bitField0_ |= 2;
                                    this.maxUserNum_ = codedInputStream.readInt32();
                                    break;
                                case Im.GroupInfo.ISNEWLYCREATE_FIELD_NUMBER /* 32 */:
                                    this.bitField0_ |= 4;
                                    this.status_ = codedInputStream.readInt32();
                                    break;
                                case 40:
                                    this.bitField0_ |= 8;
                                    this.leftTime_ = codedInputStream.readInt32();
                                    break;
                                case 50:
                                    this.bitField0_ |= 16;
                                    this.title_ = codedInputStream.readBytes();
                                    break;
                                case 58:
                                    this.bitField0_ |= 32;
                                    this.content_ = codedInputStream.readBytes();
                                    break;
                                case 64:
                                    this.bitField0_ |= 64;
                                    this.lastMsgId_ = codedInputStream.readInt64();
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
                    if (z2 & true) {
                        this.userList_ = Collections.unmodifiableList(this.userList_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<DataRes> getParserForType() {
            return PARSER;
        }

        public boolean hasUserNum() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getUserNum() {
            return this.userNum_;
        }

        public List<Im.UserInfo> getUserListList() {
            return this.userList_;
        }

        public List<? extends ah> getUserListOrBuilderList() {
            return this.userList_;
        }

        public int getUserListCount() {
            return this.userList_.size();
        }

        public Im.UserInfo getUserList(int i) {
            return this.userList_.get(i);
        }

        public ah getUserListOrBuilder(int i) {
            return this.userList_.get(i);
        }

        public boolean hasMaxUserNum() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getMaxUserNum() {
            return this.maxUserNum_;
        }

        public boolean hasStatus() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getStatus() {
            return this.status_;
        }

        public boolean hasLeftTime() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getLeftTime() {
            return this.leftTime_;
        }

        public boolean hasTitle() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.title_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasContent() {
            return (this.bitField0_ & 32) == 32;
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

        public boolean hasLastMsgId() {
            return (this.bitField0_ & 64) == 64;
        }

        public long getLastMsgId() {
            return this.lastMsgId_;
        }

        private void a() {
            this.userNum_ = 0;
            this.userList_ = Collections.emptyList();
            this.maxUserNum_ = 0;
            this.status_ = 0;
            this.leftTime_ = 0;
            this.title_ = "";
            this.content_ = "";
            this.lastMsgId_ = 0L;
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
                codedOutputStream.writeInt32(1, this.userNum_);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.userList_.size()) {
                    break;
                }
                codedOutputStream.writeMessage(2, this.userList_.get(i2));
                i = i2 + 1;
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(3, this.maxUserNum_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(4, this.status_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.leftTime_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(6, getTitleBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(7, getContentBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt64(8, this.lastMsgId_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 == -1) {
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.userNum_) + 0 : 0;
                while (true) {
                    i2 = computeInt32Size;
                    if (i >= this.userList_.size()) {
                        break;
                    }
                    computeInt32Size = CodedOutputStream.computeMessageSize(2, this.userList_.get(i)) + i2;
                    i++;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += CodedOutputStream.computeInt32Size(3, this.maxUserNum_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i2 += CodedOutputStream.computeInt32Size(4, this.status_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i2 += CodedOutputStream.computeInt32Size(5, this.leftTime_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    i2 += CodedOutputStream.computeBytesSize(6, getTitleBytes());
                }
                if ((this.bitField0_ & 32) == 32) {
                    i2 += CodedOutputStream.computeBytesSize(7, getContentBytes());
                }
                if ((this.bitField0_ & 64) == 64) {
                    i2 += CodedOutputStream.computeInt64Size(8, this.lastMsgId_);
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

        public static DataRes parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static DataRes parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DataRes parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static DataRes parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static DataRes parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static DataRes parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static DataRes parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static DataRes parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static DataRes parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static DataRes parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static j newBuilder() {
            return j.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public j newBuilderForType() {
            return newBuilder();
        }

        public static j newBuilder(DataRes dataRes) {
            return newBuilder().mergeFrom(dataRes);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public j toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class QueryChatroomInfoResIdl extends GeneratedMessageLite implements n {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryChatroomInfoResIdl> PARSER = new l();
        private static final QueryChatroomInfoResIdl a = new QueryChatroomInfoResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private QueryChatroomInfoResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryChatroomInfoResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryChatroomInfoResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public QueryChatroomInfoResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryChatroomInfoResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                protobuf.c builder = (this.bitField0_ & 1) == 1 ? this.error_.toBuilder() : null;
                                this.error_ = (Im.Error) codedInputStream.readMessage(Im.Error.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.error_);
                                    this.error_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                z = z2;
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                j builder2 = (this.bitField0_ & 2) == 2 ? this.data_.toBuilder() : null;
                                this.data_ = (DataRes) codedInputStream.readMessage(DataRes.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.data_);
                                    this.data_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
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
        public Parser<QueryChatroomInfoResIdl> getParserForType() {
            return PARSER;
        }

        public boolean hasError() {
            return (this.bitField0_ & 1) == 1;
        }

        public Im.Error getError() {
            return this.error_;
        }

        public boolean hasData() {
            return (this.bitField0_ & 2) == 2;
        }

        public DataRes getData() {
            return this.data_;
        }

        private void a() {
            this.error_ = Im.Error.getDefaultInstance();
            this.data_ = DataRes.getDefaultInstance();
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
                codedOutputStream.writeMessage(1, this.error_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.data_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.error_) : 0;
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

        public static QueryChatroomInfoResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static QueryChatroomInfoResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QueryChatroomInfoResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static QueryChatroomInfoResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QueryChatroomInfoResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static QueryChatroomInfoResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QueryChatroomInfoResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QueryChatroomInfoResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QueryChatroomInfoResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QueryChatroomInfoResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static m newBuilder() {
            return m.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m newBuilderForType() {
            return newBuilder();
        }

        public static m newBuilder(QueryChatroomInfoResIdl queryChatroomInfoResIdl) {
            return newBuilder().mergeFrom(queryChatroomInfoResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m toBuilder() {
            return newBuilder(this);
        }
    }
}
