package protobuf.QueryGroupDetail;

import com.baidu.zeus.bouncycastle.DERTags;
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
import protobuf.ae;
import protobuf.y;
/* loaded from: classes.dex */
public final class QueryGroupDetailRes {

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements k {
        public static final int CANJOINGROUPNUM_FIELD_NUMBER = 5;
        public static final int GROUP_FIELD_NUMBER = 1;
        public static final int HIDERECOMMENDGROUP_FIELD_NUMBER = 8;
        public static final int ISGROUPMANAGER_FIELD_NUMBER = 7;
        public static final int ISJOIN_FIELD_NUMBER = 6;
        public static final int JOINGROUPNUM_FIELD_NUMBER = 4;
        public static final int MEMBER_FIELD_NUMBER = 3;
        public static final int PHOTO_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int canJoinGroupNum_;
        private Im.GroupInfo group_;
        private int hideRecommendGroup_;
        private int isGroupManager_;
        private int isJoin_;
        private int joinGroupNum_;
        private List<Im.UserInfo> member_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Im.Photo> photo_;
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<protobuf.Im$UserInfo> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: java.util.List<protobuf.Im$Photo> */
        /* JADX WARN: Multi-variable type inference failed */
        private DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            protobuf.i iVar;
            boolean z5 = false;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z6 = false;
            while (!z5) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                z2 = z6;
                                continue;
                                z6 = z2;
                                z5 = z;
                            case 10:
                                if ((this.bitField0_ & 1) != 1) {
                                    iVar = null;
                                } else {
                                    iVar = this.group_.toBuilder();
                                }
                                this.group_ = (Im.GroupInfo) codedInputStream.readMessage(Im.GroupInfo.PARSER, extensionRegistryLite);
                                if (iVar != null) {
                                    iVar.mergeFrom(this.group_);
                                    this.group_ = iVar.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                z = z5;
                                z2 = z6;
                                continue;
                                z6 = z2;
                                z5 = z;
                            case 18:
                                if (!(z6 & true)) {
                                    this.photo_ = new ArrayList();
                                    z4 = z6 | true;
                                } else {
                                    z4 = z6;
                                }
                                try {
                                    this.photo_.add(codedInputStream.readMessage(Im.Photo.PARSER, extensionRegistryLite));
                                    boolean z7 = z5;
                                    z2 = z4;
                                    z = z7;
                                    continue;
                                    z6 = z2;
                                    z5 = z;
                                } catch (InvalidProtocolBufferException e) {
                                    e = e;
                                    throw e.setUnfinishedMessage(this);
                                } catch (IOException e2) {
                                    e = e2;
                                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                                } catch (Throwable th) {
                                    z6 = z4;
                                    th = th;
                                    if (z6 & true) {
                                        this.photo_ = Collections.unmodifiableList(this.photo_);
                                    }
                                    if (z6 & true) {
                                        this.member_ = Collections.unmodifiableList(this.member_);
                                    }
                                    makeExtensionsImmutable();
                                    throw th;
                                }
                            case 26:
                                if (!(z6 & true)) {
                                    this.member_ = new ArrayList();
                                    z3 = z6 | true;
                                } else {
                                    z3 = z6;
                                }
                                this.member_.add(codedInputStream.readMessage(Im.UserInfo.PARSER, extensionRegistryLite));
                                boolean z8 = z5;
                                z2 = z3;
                                z = z8;
                                continue;
                                z6 = z2;
                                z5 = z;
                            case 32:
                                this.bitField0_ |= 2;
                                this.joinGroupNum_ = codedInputStream.readInt32();
                                z = z5;
                                z2 = z6;
                                continue;
                                z6 = z2;
                                z5 = z;
                            case 40:
                                this.bitField0_ |= 4;
                                this.canJoinGroupNum_ = codedInputStream.readInt32();
                                z = z5;
                                z2 = z6;
                                continue;
                                z6 = z2;
                                z5 = z;
                            case 48:
                                this.bitField0_ |= 8;
                                this.isJoin_ = codedInputStream.readInt32();
                                z = z5;
                                z2 = z6;
                                continue;
                                z6 = z2;
                                z5 = z;
                            case 56:
                                this.bitField0_ |= 16;
                                this.isGroupManager_ = codedInputStream.readInt32();
                                z = z5;
                                z2 = z6;
                                continue;
                                z6 = z2;
                                z5 = z;
                            case DERTags.APPLICATION /* 64 */:
                                this.bitField0_ |= 32;
                                this.hideRecommendGroup_ = codedInputStream.readInt32();
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    z2 = z6;
                                    continue;
                                    z6 = z2;
                                    z5 = z;
                                }
                                break;
                        }
                        z = z5;
                        z2 = z6;
                        z6 = z2;
                        z5 = z;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (InvalidProtocolBufferException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            }
            if (z6 & true) {
                this.photo_ = Collections.unmodifiableList(this.photo_);
            }
            if (z6 & true) {
                this.member_ = Collections.unmodifiableList(this.member_);
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

        public boolean hasGroup() {
            return (this.bitField0_ & 1) == 1;
        }

        public Im.GroupInfo getGroup() {
            return this.group_;
        }

        public List<Im.Photo> getPhotoList() {
            return this.photo_;
        }

        public List<? extends y> getPhotoOrBuilderList() {
            return this.photo_;
        }

        public int getPhotoCount() {
            return this.photo_.size();
        }

        public Im.Photo getPhoto(int i) {
            return this.photo_.get(i);
        }

        public y getPhotoOrBuilder(int i) {
            return this.photo_.get(i);
        }

        public List<Im.UserInfo> getMemberList() {
            return this.member_;
        }

        public List<? extends ae> getMemberOrBuilderList() {
            return this.member_;
        }

        public int getMemberCount() {
            return this.member_.size();
        }

        public Im.UserInfo getMember(int i) {
            return this.member_.get(i);
        }

        public ae getMemberOrBuilder(int i) {
            return this.member_.get(i);
        }

        public boolean hasJoinGroupNum() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getJoinGroupNum() {
            return this.joinGroupNum_;
        }

        public boolean hasCanJoinGroupNum() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getCanJoinGroupNum() {
            return this.canJoinGroupNum_;
        }

        public boolean hasIsJoin() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getIsJoin() {
            return this.isJoin_;
        }

        public boolean hasIsGroupManager() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getIsGroupManager() {
            return this.isGroupManager_;
        }

        public boolean hasHideRecommendGroup() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getHideRecommendGroup() {
            return this.hideRecommendGroup_;
        }

        private void a() {
            this.group_ = Im.GroupInfo.getDefaultInstance();
            this.photo_ = Collections.emptyList();
            this.member_ = Collections.emptyList();
            this.joinGroupNum_ = 0;
            this.canJoinGroupNum_ = 0;
            this.isJoin_ = 0;
            this.isGroupManager_ = 0;
            this.hideRecommendGroup_ = 0;
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
            for (int i = 0; i < this.photo_.size(); i++) {
                codedOutputStream.writeMessage(2, this.photo_.get(i));
            }
            for (int i2 = 0; i2 < this.member_.size(); i2++) {
                codedOutputStream.writeMessage(3, this.member_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(4, this.joinGroupNum_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(5, this.canJoinGroupNum_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(6, this.isJoin_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(7, this.isGroupManager_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(8, this.hideRecommendGroup_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.group_) + 0 : 0;
                for (int i2 = 0; i2 < this.photo_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(2, this.photo_.get(i2));
                }
                for (int i3 = 0; i3 < this.member_.size(); i3++) {
                    i += CodedOutputStream.computeMessageSize(3, this.member_.get(i3));
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(4, this.joinGroupNum_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(5, this.canJoinGroupNum_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(6, this.isJoin_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeInt32Size(7, this.isGroupManager_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeInt32Size(8, this.hideRecommendGroup_);
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
    public final class QueryGroupDetailResIdl extends GeneratedMessageLite implements n {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryGroupDetailResIdl> PARSER = new l();
        private static final QueryGroupDetailResIdl a = new QueryGroupDetailResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private QueryGroupDetailResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryGroupDetailResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryGroupDetailResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public QueryGroupDetailResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryGroupDetailResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                            case 18:
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
        public Parser<QueryGroupDetailResIdl> getParserForType() {
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

        public static QueryGroupDetailResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static QueryGroupDetailResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QueryGroupDetailResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static QueryGroupDetailResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QueryGroupDetailResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static QueryGroupDetailResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupDetailResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QueryGroupDetailResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupDetailResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QueryGroupDetailResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static m newBuilder(QueryGroupDetailResIdl queryGroupDetailResIdl) {
            return newBuilder().mergeFrom(queryGroupDetailResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m toBuilder() {
            return newBuilder(this);
        }
    }
}
