package protobuf.QueryGroupUserList;

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
import protobuf.aj;
/* loaded from: classes.dex */
public final class QueryGroupUserListRes {

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements k {
        public static final int MEMBERNUM_FIELD_NUMBER = 1;
        public static final int PERMISSION_FIELD_NUMBER = 3;
        public static final int USERLIST_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int memberNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Im.UserPermission permission_;
        private List<Im.UserInfo> userList_;
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.util.List<protobuf.Im$UserInfo> */
        /* JADX WARN: Multi-variable type inference failed */
        private DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            aj ajVar;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = false;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z5 = false;
            while (!z4) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                z2 = z5;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.memberNum_ = codedInputStream.readInt32();
                                z = z4;
                                z2 = z5;
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                if (!(z5 & true)) {
                                    this.userList_ = new ArrayList();
                                    z3 = z5 | true;
                                } else {
                                    z3 = z5;
                                }
                                try {
                                    this.userList_.add(codedInputStream.readMessage(Im.UserInfo.PARSER, extensionRegistryLite));
                                    boolean z6 = z4;
                                    z2 = z3;
                                    z = z6;
                                    break;
                                } catch (InvalidProtocolBufferException e) {
                                    e = e;
                                    throw e.setUnfinishedMessage(this);
                                } catch (IOException e2) {
                                    e = e2;
                                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                                } catch (Throwable th) {
                                    z5 = z3;
                                    th = th;
                                    if (z5 & true) {
                                        this.userList_ = Collections.unmodifiableList(this.userList_);
                                    }
                                    makeExtensionsImmutable();
                                    throw th;
                                }
                            case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                if ((this.bitField0_ & 2) != 2) {
                                    ajVar = null;
                                } else {
                                    ajVar = this.permission_.toBuilder();
                                }
                                this.permission_ = (Im.UserPermission) codedInputStream.readMessage(Im.UserPermission.PARSER, extensionRegistryLite);
                                if (ajVar != null) {
                                    ajVar.mergeFrom(this.permission_);
                                    this.permission_ = ajVar.buildPartial();
                                }
                                this.bitField0_ |= 2;
                                z = z4;
                                z2 = z5;
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    z2 = z5;
                                    break;
                                } else {
                                    z = z4;
                                    z2 = z5;
                                    break;
                                }
                        }
                        z5 = z2;
                        z4 = z;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (InvalidProtocolBufferException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            }
            if (z5 & true) {
                this.userList_ = Collections.unmodifiableList(this.userList_);
            }
            makeExtensionsImmutable();
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<DataRes> getParserForType() {
            return PARSER;
        }

        public boolean hasMemberNum() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getMemberNum() {
            return this.memberNum_;
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

        public boolean hasPermission() {
            return (this.bitField0_ & 2) == 2;
        }

        public Im.UserPermission getPermission() {
            return this.permission_;
        }

        private void a() {
            this.memberNum_ = 0;
            this.userList_ = Collections.emptyList();
            this.permission_ = Im.UserPermission.getDefaultInstance();
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
                codedOutputStream.writeInt32(1, this.memberNum_);
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
                codedOutputStream.writeMessage(3, this.permission_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 == -1) {
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.memberNum_) + 0 : 0;
                while (true) {
                    i2 = computeInt32Size;
                    if (i >= this.userList_.size()) {
                        break;
                    }
                    computeInt32Size = CodedOutputStream.computeMessageSize(2, this.userList_.get(i)) + i2;
                    i++;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += CodedOutputStream.computeMessageSize(3, this.permission_);
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
    public final class QueryGroupUserListResIdl extends GeneratedMessageLite implements n {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryGroupUserListResIdl> PARSER = new l();
        private static final QueryGroupUserListResIdl a = new QueryGroupUserListResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private QueryGroupUserListResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryGroupUserListResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryGroupUserListResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public QueryGroupUserListResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryGroupUserListResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public Parser<QueryGroupUserListResIdl> getParserForType() {
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

        public static QueryGroupUserListResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static QueryGroupUserListResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QueryGroupUserListResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static QueryGroupUserListResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QueryGroupUserListResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static QueryGroupUserListResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupUserListResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QueryGroupUserListResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupUserListResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QueryGroupUserListResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static m newBuilder(QueryGroupUserListResIdl queryGroupUserListResIdl) {
            return newBuilder().mergeFrom(queryGroupUserListResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m toBuilder() {
            return newBuilder(this);
        }
    }
}
