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
import protobuf.x;
/* loaded from: classes.dex */
public final class GetGroupMsgRes {

    /* loaded from: classes.dex */
    public final class GroupMsg extends GeneratedMessageLite implements o {
        public static final int GROUPINFO_FIELD_NUMBER = 1;
        public static final int MSGLIST_FIELD_NUMBER = 2;
        public static Parser<GroupMsg> PARSER = new m();
        private static final GroupMsg a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Im.GroupInfo groupInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Im.MsgInfo> msgList_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ GroupMsg(GeneratedMessageLite.Builder builder, GroupMsg groupMsg) {
            this(builder);
        }

        private GroupMsg(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GroupMsg() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GroupMsg getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final GroupMsg getDefaultInstanceForType() {
            return a;
        }

        private GroupMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            protobuf.k kVar;
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
                                    if ((this.bitField0_ & 1) != 1) {
                                        kVar = null;
                                    } else {
                                        kVar = this.groupInfo_.toBuilder();
                                    }
                                    this.groupInfo_ = (Im.GroupInfo) codedInputStream.readMessage(Im.GroupInfo.PARSER, extensionRegistryLite);
                                    if (kVar != null) {
                                        kVar.mergeFrom(this.groupInfo_);
                                        this.groupInfo_ = kVar.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                    break;
                                case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                    if (!(z2 & true)) {
                                        this.msgList_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.msgList_.add((Im.MsgInfo) codedInputStream.readMessage(Im.MsgInfo.PARSER, extensionRegistryLite));
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
                        this.msgList_ = Collections.unmodifiableList(this.msgList_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ GroupMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, GroupMsg groupMsg) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            GroupMsg groupMsg = new GroupMsg();
            a = groupMsg;
            groupMsg.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<GroupMsg> getParserForType() {
            return PARSER;
        }

        public final boolean hasGroupInfo() {
            return (this.bitField0_ & 1) == 1;
        }

        public final Im.GroupInfo getGroupInfo() {
            return this.groupInfo_;
        }

        public final List<Im.MsgInfo> getMsgListList() {
            return this.msgList_;
        }

        public final List<? extends x> getMsgListOrBuilderList() {
            return this.msgList_;
        }

        public final int getMsgListCount() {
            return this.msgList_.size();
        }

        public final Im.MsgInfo getMsgList(int i) {
            return this.msgList_.get(i);
        }

        public final x getMsgListOrBuilder(int i) {
            return this.msgList_.get(i);
        }

        private void a() {
            this.groupInfo_ = Im.GroupInfo.getDefaultInstance();
            this.msgList_ = Collections.emptyList();
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
                codedOutputStream.writeMessage(1, this.groupInfo_);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.msgList_.size()) {
                    codedOutputStream.writeMessage(2, this.msgList_.get(i2));
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
                int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.groupInfo_) + 0 : 0;
                while (true) {
                    i2 = computeMessageSize;
                    if (i >= this.msgList_.size()) {
                        break;
                    }
                    computeMessageSize = CodedOutputStream.computeMessageSize(2, this.msgList_.get(i)) + i2;
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

        public static GroupMsg parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static GroupMsg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GroupMsg parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static GroupMsg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static GroupMsg parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static GroupMsg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static GroupMsg parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static GroupMsg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static GroupMsg parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static GroupMsg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static n newBuilder(GroupMsg groupMsg) {
            return newBuilder().mergeFrom(groupMsg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final n toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements i {
        public static final int ALLOWEGGS_FIELD_NUMBER = 2;
        public static final int GROUPMSG_FIELD_NUMBER = 1;
        public static Parser<DataRes> PARSER = new g();
        private static final DataRes a;
        private static final long serialVersionUID = 0;
        private int allowEggs_;
        private int bitField0_;
        private List<GroupMsg> groupMsg_;
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
                                        this.groupMsg_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.groupMsg_.add((GroupMsg) codedInputStream.readMessage(GroupMsg.PARSER, extensionRegistryLite));
                                    break;
                                case 16:
                                    this.bitField0_ |= 1;
                                    this.allowEggs_ = codedInputStream.readInt32();
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
                        this.groupMsg_ = Collections.unmodifiableList(this.groupMsg_);
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

        public final List<GroupMsg> getGroupMsgList() {
            return this.groupMsg_;
        }

        public final List<? extends o> getGroupMsgOrBuilderList() {
            return this.groupMsg_;
        }

        public final int getGroupMsgCount() {
            return this.groupMsg_.size();
        }

        public final GroupMsg getGroupMsg(int i) {
            return this.groupMsg_.get(i);
        }

        public final o getGroupMsgOrBuilder(int i) {
            return this.groupMsg_.get(i);
        }

        public final boolean hasAllowEggs() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getAllowEggs() {
            return this.allowEggs_;
        }

        private void a() {
            this.groupMsg_ = Collections.emptyList();
            this.allowEggs_ = 0;
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
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.groupMsg_.size()) {
                    break;
                }
                codedOutputStream.writeMessage(1, this.groupMsg_.get(i2));
                i = i2 + 1;
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(2, this.allowEggs_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                for (int i2 = 0; i2 < this.groupMsg_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(1, this.groupMsg_.get(i2));
                }
                if ((this.bitField0_ & 1) == 1) {
                    i += CodedOutputStream.computeInt32Size(2, this.allowEggs_);
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
    public final class GetGroupMsgResIdl extends GeneratedMessageLite implements l {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<GetGroupMsgResIdl> PARSER = new j();
        private static final GetGroupMsgResIdl a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ GetGroupMsgResIdl(GeneratedMessageLite.Builder builder, GetGroupMsgResIdl getGroupMsgResIdl) {
            this(builder);
        }

        private GetGroupMsgResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GetGroupMsgResIdl() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GetGroupMsgResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final GetGroupMsgResIdl getDefaultInstanceForType() {
            return a;
        }

        private GetGroupMsgResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public /* synthetic */ GetGroupMsgResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, GetGroupMsgResIdl getGroupMsgResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            GetGroupMsgResIdl getGroupMsgResIdl = new GetGroupMsgResIdl();
            a = getGroupMsgResIdl;
            getGroupMsgResIdl.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<GetGroupMsgResIdl> getParserForType() {
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

        public static GetGroupMsgResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static GetGroupMsgResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GetGroupMsgResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static GetGroupMsgResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static GetGroupMsgResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static GetGroupMsgResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static GetGroupMsgResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static GetGroupMsgResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static GetGroupMsgResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static GetGroupMsgResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static k newBuilder(GetGroupMsgResIdl getGroupMsgResIdl) {
            return newBuilder().mergeFrom(getGroupMsgResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final k toBuilder() {
            return newBuilder(this);
        }
    }
}
