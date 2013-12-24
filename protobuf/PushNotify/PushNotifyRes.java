package protobuf.PushNotify;

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
import protobuf.aa;
/* loaded from: classes.dex */
public final class PushNotifyRes {

    /* loaded from: classes.dex */
    public final class PusherMsg extends GeneratedMessageLite implements k {
        public static final int CMD_FIELD_NUMBER = 1;
        public static final int DATA_FIELD_NUMBER = 2;
        public static Parser<PusherMsg> PARSER = new i();
        private static final PusherMsg a = new PusherMsg(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int cmd_;
        private Im.PusherMsgInfo data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private PusherMsg(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private PusherMsg(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static PusherMsg getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public PusherMsg getDefaultInstanceForType() {
            return a;
        }

        private PusherMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            aa aaVar;
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
                            case 8:
                                this.bitField0_ |= 1;
                                this.cmd_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case 18:
                                if ((this.bitField0_ & 2) != 2) {
                                    aaVar = null;
                                } else {
                                    aaVar = this.data_.toBuilder();
                                }
                                this.data_ = (Im.PusherMsgInfo) codedInputStream.readMessage(Im.PusherMsgInfo.PARSER, extensionRegistryLite);
                                if (aaVar != null) {
                                    aaVar.mergeFrom(this.data_);
                                    this.data_ = aaVar.buildPartial();
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
        public Parser<PusherMsg> getParserForType() {
            return PARSER;
        }

        public boolean hasCmd() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getCmd() {
            return this.cmd_;
        }

        public boolean hasData() {
            return (this.bitField0_ & 2) == 2;
        }

        public Im.PusherMsgInfo getData() {
            return this.data_;
        }

        private void a() {
            this.cmd_ = 0;
            this.data_ = Im.PusherMsgInfo.getDefaultInstance();
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
                codedOutputStream.writeInt32(1, this.cmd_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.data_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.cmd_) : 0;
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

        public static PusherMsg parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static PusherMsg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PusherMsg parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static PusherMsg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PusherMsg parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static PusherMsg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static PusherMsg parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static PusherMsg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static PusherMsg parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static PusherMsg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static j newBuilder(PusherMsg pusherMsg) {
            return newBuilder().mergeFrom(pusherMsg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public j toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class PushNotifyResIdl extends GeneratedMessageLite implements h {
        public static final int MULTIMSG_FIELD_NUMBER = 2;
        public static final int PUSHTIME_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<PusherMsg> multiMsg_;
        private long pushTime_;
        public static Parser<PushNotifyResIdl> PARSER = new f();
        private static final PushNotifyResIdl a = new PushNotifyResIdl(true);

        private PushNotifyResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private PushNotifyResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static PushNotifyResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public PushNotifyResIdl getDefaultInstanceForType() {
            return a;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<protobuf.PushNotify.PushNotifyRes$PusherMsg> */
        /* JADX WARN: Multi-variable type inference failed */
        private PushNotifyResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.pushTime_ = codedInputStream.readInt64();
                                    break;
                                case 18:
                                    if (!(z2 & true)) {
                                        this.multiMsg_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.multiMsg_.add(codedInputStream.readMessage(PusherMsg.PARSER, extensionRegistryLite));
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
                        this.multiMsg_ = Collections.unmodifiableList(this.multiMsg_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<PushNotifyResIdl> getParserForType() {
            return PARSER;
        }

        public boolean hasPushTime() {
            return (this.bitField0_ & 1) == 1;
        }

        public long getPushTime() {
            return this.pushTime_;
        }

        public List<PusherMsg> getMultiMsgList() {
            return this.multiMsg_;
        }

        public List<? extends k> getMultiMsgOrBuilderList() {
            return this.multiMsg_;
        }

        public int getMultiMsgCount() {
            return this.multiMsg_.size();
        }

        public PusherMsg getMultiMsg(int i) {
            return this.multiMsg_.get(i);
        }

        public k getMultiMsgOrBuilder(int i) {
            return this.multiMsg_.get(i);
        }

        private void a() {
            this.pushTime_ = 0L;
            this.multiMsg_ = Collections.emptyList();
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
                codedOutputStream.writeInt64(1, this.pushTime_);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.multiMsg_.size()) {
                    codedOutputStream.writeMessage(2, this.multiMsg_.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 == -1) {
                int computeInt64Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.pushTime_) + 0 : 0;
                while (true) {
                    i2 = computeInt64Size;
                    if (i >= this.multiMsg_.size()) {
                        break;
                    }
                    computeInt64Size = CodedOutputStream.computeMessageSize(2, this.multiMsg_.get(i)) + i2;
                    i++;
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

        public static PushNotifyResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static PushNotifyResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PushNotifyResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static PushNotifyResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PushNotifyResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static PushNotifyResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static PushNotifyResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static PushNotifyResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static PushNotifyResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static PushNotifyResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static g newBuilder() {
            return g.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public g newBuilderForType() {
            return newBuilder();
        }

        public static g newBuilder(PushNotifyResIdl pushNotifyResIdl) {
            return newBuilder().mergeFrom(pushNotifyResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public g toBuilder() {
            return newBuilder(this);
        }
    }
}
