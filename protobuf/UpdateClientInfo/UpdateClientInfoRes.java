package protobuf.UpdateClientInfo;

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
import protobuf.ai;
import protobuf.t;
/* loaded from: classes.dex */
public final class UpdateClientInfoRes {

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements i {
        public static final int GROUPINFO_FIELD_NUMBER = 1;
        public static final int HEARTBEATINTERVAL_FIELD_NUMBER = 4;
        public static final int MASKINFO_FIELD_NUMBER = 3;
        public static Parser<DataRes> PARSER = new g();
        public static final int USERINFO_FIELD_NUMBER = 2;
        private static final DataRes a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<Im.GroupInfo> groupInfo_;
        private List<Integer> heartbeatInterval_;
        private Im.MaskInfo maskInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Im.UserInfo userInfo_;

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
                                case 10:
                                    if (!(z2 & true)) {
                                        this.groupInfo_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.groupInfo_.add((Im.GroupInfo) codedInputStream.readMessage(Im.GroupInfo.PARSER, extensionRegistryLite));
                                    break;
                                case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                    ai builder = (this.bitField0_ & 1) == 1 ? this.userInfo_.toBuilder() : null;
                                    this.userInfo_ = (Im.UserInfo) codedInputStream.readMessage(Im.UserInfo.PARSER, extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.userInfo_);
                                        this.userInfo_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                    break;
                                case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                    t builder2 = (this.bitField0_ & 2) == 2 ? this.maskInfo_.toBuilder() : null;
                                    this.maskInfo_ = (Im.MaskInfo) codedInputStream.readMessage(Im.MaskInfo.PARSER, extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom(this.maskInfo_);
                                        this.maskInfo_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                    break;
                                case 32:
                                    if (!(z2 & true)) {
                                        this.heartbeatInterval_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.heartbeatInterval_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    break;
                                case Im.GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.heartbeatInterval_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.heartbeatInterval_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
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
                        this.groupInfo_ = Collections.unmodifiableList(this.groupInfo_);
                    }
                    if (z2 & true) {
                        this.heartbeatInterval_ = Collections.unmodifiableList(this.heartbeatInterval_);
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

        public final List<Im.GroupInfo> getGroupInfoList() {
            return this.groupInfo_;
        }

        public final List<? extends protobuf.l> getGroupInfoOrBuilderList() {
            return this.groupInfo_;
        }

        public final int getGroupInfoCount() {
            return this.groupInfo_.size();
        }

        public final Im.GroupInfo getGroupInfo(int i) {
            return this.groupInfo_.get(i);
        }

        public final protobuf.l getGroupInfoOrBuilder(int i) {
            return this.groupInfo_.get(i);
        }

        public final boolean hasUserInfo() {
            return (this.bitField0_ & 1) == 1;
        }

        public final Im.UserInfo getUserInfo() {
            return this.userInfo_;
        }

        public final boolean hasMaskInfo() {
            return (this.bitField0_ & 2) == 2;
        }

        public final Im.MaskInfo getMaskInfo() {
            return this.maskInfo_;
        }

        public final List<Integer> getHeartbeatIntervalList() {
            return this.heartbeatInterval_;
        }

        public final int getHeartbeatIntervalCount() {
            return this.heartbeatInterval_.size();
        }

        public final int getHeartbeatInterval(int i) {
            return this.heartbeatInterval_.get(i).intValue();
        }

        private void a() {
            this.groupInfo_ = Collections.emptyList();
            this.userInfo_ = Im.UserInfo.getDefaultInstance();
            this.maskInfo_ = Im.MaskInfo.getDefaultInstance();
            this.heartbeatInterval_ = Collections.emptyList();
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
            for (int i = 0; i < this.groupInfo_.size(); i++) {
                codedOutputStream.writeMessage(1, this.groupInfo_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(2, this.userInfo_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, this.maskInfo_);
            }
            for (int i2 = 0; i2 < this.heartbeatInterval_.size(); i2++) {
                codedOutputStream.writeInt32(4, this.heartbeatInterval_.get(i2).intValue());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 == -1) {
                int i3 = 0;
                for (int i4 = 0; i4 < this.groupInfo_.size(); i4++) {
                    i3 += CodedOutputStream.computeMessageSize(1, this.groupInfo_.get(i4));
                }
                if ((this.bitField0_ & 1) == 1) {
                    i3 += CodedOutputStream.computeMessageSize(2, this.userInfo_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i3 += CodedOutputStream.computeMessageSize(3, this.maskInfo_);
                }
                int i5 = 0;
                while (i < this.heartbeatInterval_.size()) {
                    i++;
                    i5 = CodedOutputStream.computeInt32SizeNoTag(this.heartbeatInterval_.get(i).intValue()) + i5;
                }
                int size = i3 + i5 + (getHeartbeatIntervalList().size() * 1);
                this.memoizedSerializedSize = size;
                return size;
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
    public final class UpdateClientInfoResIdl extends GeneratedMessageLite implements l {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<UpdateClientInfoResIdl> PARSER = new j();
        private static final UpdateClientInfoResIdl a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ UpdateClientInfoResIdl(GeneratedMessageLite.Builder builder, UpdateClientInfoResIdl updateClientInfoResIdl) {
            this(builder);
        }

        private UpdateClientInfoResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UpdateClientInfoResIdl() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UpdateClientInfoResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final UpdateClientInfoResIdl getDefaultInstanceForType() {
            return a;
        }

        private UpdateClientInfoResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public /* synthetic */ UpdateClientInfoResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UpdateClientInfoResIdl updateClientInfoResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            UpdateClientInfoResIdl updateClientInfoResIdl = new UpdateClientInfoResIdl();
            a = updateClientInfoResIdl;
            updateClientInfoResIdl.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<UpdateClientInfoResIdl> getParserForType() {
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

        public static UpdateClientInfoResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static UpdateClientInfoResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UpdateClientInfoResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static UpdateClientInfoResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UpdateClientInfoResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static UpdateClientInfoResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateClientInfoResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static UpdateClientInfoResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateClientInfoResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static UpdateClientInfoResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static k newBuilder(UpdateClientInfoResIdl updateClientInfoResIdl) {
            return newBuilder().mergeFrom(updateClientInfoResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final k toBuilder() {
            return newBuilder(this);
        }
    }
}
