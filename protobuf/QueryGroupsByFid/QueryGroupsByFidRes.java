package protobuf.QueryGroupsByFid;

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
import protobuf.q;
/* loaded from: classes.dex */
public final class QueryGroupsByFidRes {

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements i {
        public static final int GROUPPERM_FIELD_NUMBER = 2;
        public static final int GROUPS_FIELD_NUMBER = 1;
        public static Parser<DataRes> PARSER = new g();
        private static final DataRes a = new DataRes(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Im.GroupPermission groupPerm_;
        private List<Im.GroupInfo> groups_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

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
            q qVar;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z = false;
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
                                case 10:
                                    if (!(z2 & true)) {
                                        this.groups_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.groups_.add((Im.GroupInfo) codedInputStream.readMessage(Im.GroupInfo.PARSER, extensionRegistryLite));
                                    break;
                                case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                    if ((this.bitField0_ & 1) != 1) {
                                        qVar = null;
                                    } else {
                                        qVar = this.groupPerm_.toBuilder();
                                    }
                                    this.groupPerm_ = (Im.GroupPermission) codedInputStream.readMessage(Im.GroupPermission.PARSER, extensionRegistryLite);
                                    if (qVar != null) {
                                        qVar.mergeFrom(this.groupPerm_);
                                        this.groupPerm_ = qVar.buildPartial();
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.groups_ = Collections.unmodifiableList(this.groups_);
                    }
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

        public List<Im.GroupInfo> getGroupsList() {
            return this.groups_;
        }

        public List<? extends protobuf.l> getGroupsOrBuilderList() {
            return this.groups_;
        }

        public int getGroupsCount() {
            return this.groups_.size();
        }

        public Im.GroupInfo getGroups(int i) {
            return this.groups_.get(i);
        }

        public protobuf.l getGroupsOrBuilder(int i) {
            return this.groups_.get(i);
        }

        public boolean hasGroupPerm() {
            return (this.bitField0_ & 1) == 1;
        }

        public Im.GroupPermission getGroupPerm() {
            return this.groupPerm_;
        }

        private void a() {
            this.groups_ = Collections.emptyList();
            this.groupPerm_ = Im.GroupPermission.getDefaultInstance();
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
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.groups_.size()) {
                    break;
                }
                codedOutputStream.writeMessage(1, this.groups_.get(i2));
                i = i2 + 1;
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(2, this.groupPerm_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                for (int i2 = 0; i2 < this.groups_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(1, this.groups_.get(i2));
                }
                if ((this.bitField0_ & 1) == 1) {
                    i += CodedOutputStream.computeMessageSize(2, this.groupPerm_);
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

        public static h newBuilder() {
            return h.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public h newBuilderForType() {
            return newBuilder();
        }

        public static h newBuilder(DataRes dataRes) {
            return newBuilder().mergeFrom(dataRes);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public h toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class QueryGroupsByFidResIdl extends GeneratedMessageLite implements l {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryGroupsByFidResIdl> PARSER = new j();
        private static final QueryGroupsByFidResIdl a = new QueryGroupsByFidResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ QueryGroupsByFidResIdl(GeneratedMessageLite.Builder builder, QueryGroupsByFidResIdl queryGroupsByFidResIdl) {
            this(builder);
        }

        private QueryGroupsByFidResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryGroupsByFidResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryGroupsByFidResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public QueryGroupsByFidResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryGroupsByFidResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                h builder2 = (this.bitField0_ & 2) == 2 ? this.data_.toBuilder() : null;
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
        public /* synthetic */ QueryGroupsByFidResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, QueryGroupsByFidResIdl queryGroupsByFidResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<QueryGroupsByFidResIdl> getParserForType() {
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

        public static QueryGroupsByFidResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static QueryGroupsByFidResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QueryGroupsByFidResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static QueryGroupsByFidResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QueryGroupsByFidResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static QueryGroupsByFidResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupsByFidResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QueryGroupsByFidResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupsByFidResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QueryGroupsByFidResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static k newBuilder(QueryGroupsByFidResIdl queryGroupsByFidResIdl) {
            return newBuilder().mergeFrom(queryGroupsByFidResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public k toBuilder() {
            return newBuilder(this);
        }
    }
}
