package protobuf.UpdateChatroomTopic;

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
public final class UpdateChatroomTopicRes {

    /* loaded from: classes.dex */
    public final class UpdateChatroomTopicResIdl extends GeneratedMessageLite implements i {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<UpdateChatroomTopicResIdl> PARSER = new g();
        private static final UpdateChatroomTopicResIdl a = new UpdateChatroomTopicResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ UpdateChatroomTopicResIdl(GeneratedMessageLite.Builder builder, UpdateChatroomTopicResIdl updateChatroomTopicResIdl) {
            this(builder);
        }

        private UpdateChatroomTopicResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UpdateChatroomTopicResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UpdateChatroomTopicResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public UpdateChatroomTopicResIdl getDefaultInstanceForType() {
            return a;
        }

        private UpdateChatroomTopicResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            protobuf.e eVar;
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
                                    eVar = null;
                                } else {
                                    eVar = this.error_.toBuilder();
                                }
                                this.error_ = (Im.Error) codedInputStream.readMessage(Im.Error.PARSER, extensionRegistryLite);
                                if (eVar != null) {
                                    eVar.mergeFrom(this.error_);
                                    this.error_ = eVar.buildPartial();
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
        public /* synthetic */ UpdateChatroomTopicResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UpdateChatroomTopicResIdl updateChatroomTopicResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<UpdateChatroomTopicResIdl> getParserForType() {
            return PARSER;
        }

        public boolean hasError() {
            return (this.bitField0_ & 1) == 1;
        }

        public Im.Error getError() {
            return this.error_;
        }

        private void a() {
            this.error_ = Im.Error.getDefaultInstance();
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
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.error_) : 0;
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() {
            return super.writeReplace();
        }

        public static UpdateChatroomTopicResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static UpdateChatroomTopicResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UpdateChatroomTopicResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static UpdateChatroomTopicResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UpdateChatroomTopicResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static UpdateChatroomTopicResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateChatroomTopicResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static UpdateChatroomTopicResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateChatroomTopicResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static UpdateChatroomTopicResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static h newBuilder(UpdateChatroomTopicResIdl updateChatroomTopicResIdl) {
            return newBuilder().mergeFrom(updateChatroomTopicResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public h toBuilder() {
            return newBuilder(this);
        }
    }
}
