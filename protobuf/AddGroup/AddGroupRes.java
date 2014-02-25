package protobuf.AddGroup;

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
public final class AddGroupRes {

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements l {
        public static final int GROUP_FIELD_NUMBER = 1;
        public static Parser<DataRes> PARSER = new j();
        private static final DataRes a = new DataRes(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Im.GroupInfo group_;
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
            protobuf.k kVar;
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
                                    kVar = null;
                                } else {
                                    kVar = this.group_.toBuilder();
                                }
                                this.group_ = (Im.GroupInfo) codedInputStream.readMessage(Im.GroupInfo.PARSER, extensionRegistryLite);
                                if (kVar != null) {
                                    kVar.mergeFrom(this.group_);
                                    this.group_ = kVar.buildPartial();
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

        public boolean hasGroup() {
            return (this.bitField0_ & 1) == 1;
        }

        public Im.GroupInfo getGroup() {
            return this.group_;
        }

        private void a() {
            this.group_ = Im.GroupInfo.getDefaultInstance();
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
                codedOutputStream.writeMessage(1, this.group_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.group_) : 0;
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
    public final class AddGroupResIdl extends GeneratedMessageLite implements i {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<AddGroupResIdl> PARSER = new g();
        private static final AddGroupResIdl a = new AddGroupResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ AddGroupResIdl(GeneratedMessageLite.Builder builder, AddGroupResIdl addGroupResIdl) {
            this(builder);
        }

        private AddGroupResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private AddGroupResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AddGroupResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public AddGroupResIdl getDefaultInstanceForType() {
            return a;
        }

        private AddGroupResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public /* synthetic */ AddGroupResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AddGroupResIdl addGroupResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<AddGroupResIdl> getParserForType() {
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

        public static AddGroupResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static AddGroupResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AddGroupResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static AddGroupResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AddGroupResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static AddGroupResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static AddGroupResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static AddGroupResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static AddGroupResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static AddGroupResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static h newBuilder(AddGroupResIdl addGroupResIdl) {
            return newBuilder().mergeFrom(addGroupResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public h toBuilder() {
            return newBuilder(this);
        }
    }
}
