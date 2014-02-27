package protobuf.GetMaskInfo;

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
public final class GetMaskInfoRes {

    /* loaded from: classes.dex */
    public final class UserInfo extends GeneratedMessageLite implements o {
        public static final int NAME_FIELD_NUMBER = 1;
        public static Parser<UserInfo> PARSER = new m();
        public static final int PORTRAIT_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 3;
        private static final UserInfo a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private Object portrait_;
        private int uid_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ UserInfo(GeneratedMessageLite.Builder builder, UserInfo userInfo) {
            this(builder);
        }

        private UserInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UserInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UserInfo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final UserInfo getDefaultInstanceForType() {
            return a;
        }

        private UserInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                this.name_ = codedInputStream.readBytes();
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.portrait_ = codedInputStream.readBytes();
                                break;
                            case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.uid_ = codedInputStream.readUInt32();
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
        public /* synthetic */ UserInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UserInfo userInfo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            UserInfo userInfo = new UserInfo();
            a = userInfo;
            userInfo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<UserInfo> getParserForType() {
            return PARSER;
        }

        public final boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public final String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasPortrait() {
            return (this.bitField0_ & 2) == 2;
        }

        public final String getPortrait() {
            Object obj = this.portrait_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.portrait_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getPortraitBytes() {
            Object obj = this.portrait_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.portrait_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasUid() {
            return (this.bitField0_ & 4) == 4;
        }

        public final int getUid() {
            return this.uid_;
        }

        private void a() {
            this.name_ = "";
            this.portrait_ = "";
            this.uid_ = 0;
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
        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, getNameBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getPortraitBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeUInt32(3, this.uid_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeBytesSize(1, getNameBytes()) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getPortraitBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeUInt32Size(3, this.uid_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
            return super.writeReplace();
        }

        public static UserInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static UserInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static UserInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static UserInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static n newBuilder() {
            return n.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final n newBuilderForType() {
            return newBuilder();
        }

        public static n newBuilder(UserInfo userInfo) {
            return newBuilder().mergeFrom(userInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final n toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements i {
        public static final int ISMASK_FIELD_NUMBER = 1;
        public static final int LIST_FIELD_NUMBER = 2;
        public static Parser<DataRes> PARSER = new g();
        public static final int USERS_FIELD_NUMBER = 3;
        private static final DataRes a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int isMask_;
        private Object list_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<UserInfo> users_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ DataRes(GeneratedMessageLite.Builder builder, DataRes dataRes) {
            this(builder);
        }

        private DataRes(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private DataRes() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DataRes getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final DataRes getDefaultInstanceForType() {
            return a;
        }

        private DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.isMask_ = codedInputStream.readUInt32();
                                    break;
                                case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                    this.bitField0_ |= 2;
                                    this.list_ = codedInputStream.readBytes();
                                    break;
                                case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                    if (!(z2 & true)) {
                                        this.users_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.users_.add((UserInfo) codedInputStream.readMessage(UserInfo.PARSER, extensionRegistryLite));
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
                        this.users_ = Collections.unmodifiableList(this.users_);
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
            DataRes dataRes = new DataRes();
            a = dataRes;
            dataRes.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<DataRes> getParserForType() {
            return PARSER;
        }

        public final boolean hasIsMask() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getIsMask() {
            return this.isMask_;
        }

        public final boolean hasList() {
            return (this.bitField0_ & 2) == 2;
        }

        public final String getList() {
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

        public final ByteString getListBytes() {
            Object obj = this.list_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.list_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final List<UserInfo> getUsersList() {
            return this.users_;
        }

        public final List<? extends o> getUsersOrBuilderList() {
            return this.users_;
        }

        public final int getUsersCount() {
            return this.users_.size();
        }

        public final UserInfo getUsers(int i) {
            return this.users_.get(i);
        }

        public final o getUsersOrBuilder(int i) {
            return this.users_.get(i);
        }

        private void a() {
            this.isMask_ = 0;
            this.list_ = "";
            this.users_ = Collections.emptyList();
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
        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeUInt32(1, this.isMask_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getListBytes());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.users_.size()) {
                    codedOutputStream.writeMessage(3, this.users_.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 == -1) {
                int computeUInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeUInt32Size(1, this.isMask_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeUInt32Size += CodedOutputStream.computeBytesSize(2, getListBytes());
                }
                while (true) {
                    i2 = computeUInt32Size;
                    if (i >= this.users_.size()) {
                        break;
                    }
                    computeUInt32Size = CodedOutputStream.computeMessageSize(3, this.users_.get(i)) + i2;
                    i++;
                }
                this.memoizedSerializedSize = i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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
            return h.b();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final h newBuilderForType() {
            return newBuilder();
        }

        public static h newBuilder(DataRes dataRes) {
            return newBuilder().mergeFrom(dataRes);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final h toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class GetMaskInfoResIdl extends GeneratedMessageLite implements l {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<GetMaskInfoResIdl> PARSER = new j();
        private static final GetMaskInfoResIdl a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ GetMaskInfoResIdl(GeneratedMessageLite.Builder builder, GetMaskInfoResIdl getMaskInfoResIdl) {
            this(builder);
        }

        private GetMaskInfoResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GetMaskInfoResIdl() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GetMaskInfoResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final GetMaskInfoResIdl getDefaultInstanceForType() {
            return a;
        }

        private GetMaskInfoResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public /* synthetic */ GetMaskInfoResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, GetMaskInfoResIdl getMaskInfoResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            GetMaskInfoResIdl getMaskInfoResIdl = new GetMaskInfoResIdl();
            a = getMaskInfoResIdl;
            getMaskInfoResIdl.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<GetMaskInfoResIdl> getParserForType() {
            return PARSER;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 1) == 1;
        }

        public final Im.Error getError() {
            return this.error_;
        }

        public final boolean hasData() {
            return (this.bitField0_ & 2) == 2;
        }

        public final DataRes getData() {
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
        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.error_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.data_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeMessageSize(1, this.error_) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeMessageSize(2, this.data_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
            return super.writeReplace();
        }

        public static GetMaskInfoResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static GetMaskInfoResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GetMaskInfoResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static GetMaskInfoResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static GetMaskInfoResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static GetMaskInfoResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static GetMaskInfoResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static GetMaskInfoResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static GetMaskInfoResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static GetMaskInfoResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static k newBuilder() {
            return k.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final k newBuilderForType() {
            return newBuilder();
        }

        public static k newBuilder(GetMaskInfoResIdl getMaskInfoResIdl) {
            return newBuilder().mergeFrom(getMaskInfoResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final k toBuilder() {
            return newBuilder(this);
        }
    }
}
