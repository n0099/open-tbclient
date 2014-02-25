package protobuf.QueryGroupCount;

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
public final class QueryGroupCountRes {

    /* loaded from: classes.dex */
    public final class Banner extends GeneratedMessageLite implements i {
        public static final int LINK_FIELD_NUMBER = 1;
        public static final int PICURL_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object link_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object picUrl_;
        public static Parser<Banner> PARSER = new g();
        private static final Banner a = new Banner(true);

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Banner(GeneratedMessageLite.Builder builder, Banner banner) {
            this(builder);
        }

        private Banner(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Banner(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Banner getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Banner getDefaultInstanceForType() {
            return a;
        }

        private Banner(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                this.link_ = codedInputStream.readBytes();
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.picUrl_ = codedInputStream.readBytes();
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
        public /* synthetic */ Banner(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Banner banner) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Banner> getParserForType() {
            return PARSER;
        }

        public boolean hasLink() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getLink() {
            Object obj = this.link_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.link_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasPicUrl() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getPicUrl() {
            Object obj = this.picUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.picUrl_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPicUrlBytes() {
            Object obj = this.picUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.picUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void a() {
            this.link_ = "";
            this.picUrl_ = "";
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
                codedOutputStream.writeBytes(1, getLinkBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getPicUrlBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getLinkBytes()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getPicUrlBytes());
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

        public static Banner parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static Banner parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Banner parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static Banner parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Banner parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static Banner parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Banner parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Banner parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Banner parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Banner parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static h newBuilder() {
            return h.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public h newBuilderForType() {
            return newBuilder();
        }

        public static h newBuilder(Banner banner) {
            return newBuilder().mergeFrom(banner);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public h toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements l {
        public static final int BANNER_FIELD_NUMBER = 3;
        public static final int LOCALGROUPCOUNT_FIELD_NUMBER = 2;
        public static final int USERGROUPCOUNT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private Banner banner_;
        private int bitField0_;
        private int localGroupCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int userGroupCount_;
        public static Parser<DataRes> PARSER = new j();
        private static final DataRes a = new DataRes(true);

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ DataRes(GeneratedMessageLite.Builder builder, DataRes dataRes) {
            this(builder);
        }

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

        private DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            h hVar;
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
                                this.userGroupCount_ = codedInputStream.readInt32();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.localGroupCount_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                if ((this.bitField0_ & 4) != 4) {
                                    hVar = null;
                                } else {
                                    hVar = this.banner_.toBuilder();
                                }
                                this.banner_ = (Banner) codedInputStream.readMessage(Banner.PARSER, extensionRegistryLite);
                                if (hVar != null) {
                                    hVar.mergeFrom(this.banner_);
                                    this.banner_ = hVar.buildPartial();
                                }
                                this.bitField0_ |= 4;
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
        public /* synthetic */ DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DataRes dataRes) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<DataRes> getParserForType() {
            return PARSER;
        }

        public boolean hasUserGroupCount() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getUserGroupCount() {
            return this.userGroupCount_;
        }

        public boolean hasLocalGroupCount() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getLocalGroupCount() {
            return this.localGroupCount_;
        }

        public boolean hasBanner() {
            return (this.bitField0_ & 4) == 4;
        }

        public Banner getBanner() {
            return this.banner_;
        }

        private void a() {
            this.userGroupCount_ = 0;
            this.localGroupCount_ = 0;
            this.banner_ = Banner.getDefaultInstance();
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
                codedOutputStream.writeInt32(1, this.userGroupCount_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.localGroupCount_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.banner_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.userGroupCount_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.localGroupCount_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(3, this.banner_);
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

        public static k newBuilder() {
            return k.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public k newBuilderForType() {
            return newBuilder();
        }

        public static k newBuilder(DataRes dataRes) {
            return newBuilder().mergeFrom(dataRes);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public k toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class QueryGroupCountResIdl extends GeneratedMessageLite implements o {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryGroupCountResIdl> PARSER = new m();
        private static final QueryGroupCountResIdl a = new QueryGroupCountResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ QueryGroupCountResIdl(GeneratedMessageLite.Builder builder, QueryGroupCountResIdl queryGroupCountResIdl) {
            this(builder);
        }

        private QueryGroupCountResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryGroupCountResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryGroupCountResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public QueryGroupCountResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryGroupCountResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                protobuf.e builder = (this.bitField0_ & 1) == 1 ? this.error_.toBuilder() : null;
                                this.error_ = (Im.Error) codedInputStream.readMessage(Im.Error.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.error_);
                                    this.error_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                k builder2 = (this.bitField0_ & 2) == 2 ? this.data_.toBuilder() : null;
                                this.data_ = (DataRes) codedInputStream.readMessage(DataRes.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.data_);
                                    this.data_ = builder2.buildPartial();
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
        public /* synthetic */ QueryGroupCountResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, QueryGroupCountResIdl queryGroupCountResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<QueryGroupCountResIdl> getParserForType() {
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

        public static QueryGroupCountResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static QueryGroupCountResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QueryGroupCountResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static QueryGroupCountResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QueryGroupCountResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static QueryGroupCountResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupCountResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QueryGroupCountResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupCountResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QueryGroupCountResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static n newBuilder() {
            return n.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public n newBuilderForType() {
            return newBuilder();
        }

        public static n newBuilder(QueryGroupCountResIdl queryGroupCountResIdl) {
            return newBuilder().mergeFrom(queryGroupCountResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public n toBuilder() {
            return newBuilder(this);
        }
    }
}
