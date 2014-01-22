package protobuf.EnterChatroom;

import com.baidu.location.BDLocation;
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
public final class EnterChatroomRes {

    /* loaded from: classes.dex */
    public final class ChatroomTopic extends GeneratedMessageLite implements k {
        public static final int CONTENT_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object content_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object title_;
        public static Parser<ChatroomTopic> PARSER = new i();
        private static final ChatroomTopic a = new ChatroomTopic(true);

        private ChatroomTopic(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ChatroomTopic(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ChatroomTopic getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public ChatroomTopic getDefaultInstanceForType() {
            return a;
        }

        private ChatroomTopic(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z = false;
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
                                    this.bitField0_ |= 1;
                                    this.title_ = codedInputStream.readBytes();
                                    break;
                                case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                    this.bitField0_ |= 2;
                                    this.content_ = codedInputStream.readBytes();
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
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ChatroomTopic> getParserForType() {
            return PARSER;
        }

        public boolean hasTitle() {
            return (this.bitField0_ & 1) == 1;
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
            return (this.bitField0_ & 2) == 2;
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

        private void a() {
            this.title_ = "";
            this.content_ = "";
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
                codedOutputStream.writeBytes(1, getTitleBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getContentBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTitleBytes()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getContentBytes());
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

        public static ChatroomTopic parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static ChatroomTopic parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ChatroomTopic parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static ChatroomTopic parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ChatroomTopic parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static ChatroomTopic parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ChatroomTopic parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ChatroomTopic parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ChatroomTopic parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ChatroomTopic parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static j newBuilder(ChatroomTopic chatroomTopic) {
            return newBuilder().mergeFrom(chatroomTopic);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public j toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements n {
        public static final int AVERAGEWAITTIME_FIELD_NUMBER = 7;
        public static final int CONTENT_FIELD_NUMBER = 9;
        public static final int DURATIONTIME_FIELD_NUMBER = 5;
        public static final int GROUPID_FIELD_NUMBER = 1;
        public static final int LASTMSGID_FIELD_NUMBER = 11;
        public static final int MAXUSERNUM_FIELD_NUMBER = 3;
        public static final int SILENCETIME_FIELD_NUMBER = 6;
        public static final int TITLE_FIELD_NUMBER = 8;
        public static final int TOPICLIST_FIELD_NUMBER = 10;
        public static final int USERLIST_FIELD_NUMBER = 4;
        public static final int USERNUM_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int averageWaitTime_;
        private int bitField0_;
        private Object content_;
        private int durationTime_;
        private int groupId_;
        private long lastMsgId_;
        private int maxUserNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int silenceTime_;
        private Object title_;
        private List<ChatroomTopic> topicList_;
        private List<Im.UserInfo> userList_;
        private int userNum_;
        public static Parser<DataRes> PARSER = new l();
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v24, resolved type: java.util.List<protobuf.Im$UserInfo> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.util.List<protobuf.EnterChatroom.EnterChatroomRes$ChatroomTopic> */
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
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.groupId_ = codedInputStream.readInt32();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.userNum_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.maxUserNum_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                if (!(z2 & true)) {
                                    this.userList_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.userList_.add(codedInputStream.readMessage(Im.UserInfo.PARSER, extensionRegistryLite));
                                break;
                            case 40:
                                this.bitField0_ |= 8;
                                this.durationTime_ = codedInputStream.readInt32();
                                break;
                            case 48:
                                this.bitField0_ |= 16;
                                this.silenceTime_ = codedInputStream.readInt32();
                                break;
                            case 56:
                                this.bitField0_ |= 32;
                                this.averageWaitTime_ = codedInputStream.readInt32();
                                break;
                            case BDLocation.TypeOffLineLocation /* 66 */:
                                this.bitField0_ |= 64;
                                this.title_ = codedInputStream.readBytes();
                                break;
                            case 74:
                                this.bitField0_ |= 128;
                                this.content_ = codedInputStream.readBytes();
                                break;
                            case 82:
                                if (!(z2 & true)) {
                                    this.topicList_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.topicList_.add(codedInputStream.readMessage(ChatroomTopic.PARSER, extensionRegistryLite));
                                break;
                            case 88:
                                this.bitField0_ |= 256;
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.userList_ = Collections.unmodifiableList(this.userList_);
                    }
                    if (z2 & true) {
                        this.topicList_ = Collections.unmodifiableList(this.topicList_);
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

        public boolean hasGroupId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getGroupId() {
            return this.groupId_;
        }

        public boolean hasUserNum() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getUserNum() {
            return this.userNum_;
        }

        public boolean hasMaxUserNum() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getMaxUserNum() {
            return this.maxUserNum_;
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

        public boolean hasDurationTime() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getDurationTime() {
            return this.durationTime_;
        }

        public boolean hasSilenceTime() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getSilenceTime() {
            return this.silenceTime_;
        }

        public boolean hasAverageWaitTime() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getAverageWaitTime() {
            return this.averageWaitTime_;
        }

        public boolean hasTitle() {
            return (this.bitField0_ & 64) == 64;
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
            return (this.bitField0_ & 128) == 128;
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

        public List<ChatroomTopic> getTopicListList() {
            return this.topicList_;
        }

        public List<? extends k> getTopicListOrBuilderList() {
            return this.topicList_;
        }

        public int getTopicListCount() {
            return this.topicList_.size();
        }

        public ChatroomTopic getTopicList(int i) {
            return this.topicList_.get(i);
        }

        public k getTopicListOrBuilder(int i) {
            return this.topicList_.get(i);
        }

        public boolean hasLastMsgId() {
            return (this.bitField0_ & 256) == 256;
        }

        public long getLastMsgId() {
            return this.lastMsgId_;
        }

        private void a() {
            this.groupId_ = 0;
            this.userNum_ = 0;
            this.maxUserNum_ = 0;
            this.userList_ = Collections.emptyList();
            this.durationTime_ = 0;
            this.silenceTime_ = 0;
            this.averageWaitTime_ = 0;
            this.title_ = "";
            this.content_ = "";
            this.topicList_ = Collections.emptyList();
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
                codedOutputStream.writeInt32(1, this.groupId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.userNum_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.maxUserNum_);
            }
            for (int i = 0; i < this.userList_.size(); i++) {
                codedOutputStream.writeMessage(4, this.userList_.get(i));
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.durationTime_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(6, this.silenceTime_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.averageWaitTime_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBytes(8, getTitleBytes());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeBytes(9, getContentBytes());
            }
            for (int i2 = 0; i2 < this.topicList_.size(); i2++) {
                codedOutputStream.writeMessage(10, this.topicList_.get(i2));
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt64(11, this.lastMsgId_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.groupId_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.userNum_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(3, this.maxUserNum_);
                }
                i = computeInt32Size;
                for (int i2 = 0; i2 < this.userList_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(4, this.userList_.get(i2));
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(5, this.durationTime_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeInt32Size(6, this.silenceTime_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeInt32Size(7, this.averageWaitTime_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeBytesSize(8, getTitleBytes());
                }
                if ((this.bitField0_ & 128) == 128) {
                    i += CodedOutputStream.computeBytesSize(9, getContentBytes());
                }
                for (int i3 = 0; i3 < this.topicList_.size(); i3++) {
                    i += CodedOutputStream.computeMessageSize(10, this.topicList_.get(i3));
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeInt64Size(11, this.lastMsgId_);
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

        public static m newBuilder() {
            return m.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m newBuilderForType() {
            return newBuilder();
        }

        public static m newBuilder(DataRes dataRes) {
            return newBuilder().mergeFrom(dataRes);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class EnterChatroomResIdl extends GeneratedMessageLite implements q {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<EnterChatroomResIdl> PARSER = new o();
        private static final EnterChatroomResIdl a = new EnterChatroomResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private EnterChatroomResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private EnterChatroomResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static EnterChatroomResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public EnterChatroomResIdl getDefaultInstanceForType() {
            return a;
        }

        private EnterChatroomResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                m builder2 = (this.bitField0_ & 2) == 2 ? this.data_.toBuilder() : null;
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
        public Parser<EnterChatroomResIdl> getParserForType() {
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

        public static EnterChatroomResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static EnterChatroomResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static EnterChatroomResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static EnterChatroomResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static EnterChatroomResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static EnterChatroomResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static EnterChatroomResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static EnterChatroomResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static EnterChatroomResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static EnterChatroomResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static p newBuilder() {
            return p.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public p newBuilderForType() {
            return newBuilder();
        }

        public static p newBuilder(EnterChatroomResIdl enterChatroomResIdl) {
            return newBuilder().mergeFrom(enterChatroomResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public p toBuilder() {
            return newBuilder(this);
        }
    }
}
