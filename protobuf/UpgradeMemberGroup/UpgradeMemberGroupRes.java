package protobuf.UpgradeMemberGroup;

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
public final class UpgradeMemberGroupRes {

    /* loaded from: classes.dex */
    public final class UpgradeMemberGroupResIdl extends GeneratedMessageLite implements i {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<UpgradeMemberGroupResIdl> PARSER = new g();
        private static final UpgradeMemberGroupResIdl a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ UpgradeMemberGroupResIdl(GeneratedMessageLite.Builder builder, UpgradeMemberGroupResIdl upgradeMemberGroupResIdl) {
            this(builder);
        }

        private UpgradeMemberGroupResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UpgradeMemberGroupResIdl() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UpgradeMemberGroupResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final UpgradeMemberGroupResIdl getDefaultInstanceForType() {
            return a;
        }

        private UpgradeMemberGroupResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            protobuf.e eVar;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.error_ = Im.Error.getDefaultInstance();
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
        public /* synthetic */ UpgradeMemberGroupResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UpgradeMemberGroupResIdl upgradeMemberGroupResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            UpgradeMemberGroupResIdl upgradeMemberGroupResIdl = new UpgradeMemberGroupResIdl();
            a = upgradeMemberGroupResIdl;
            upgradeMemberGroupResIdl.error_ = Im.Error.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<UpgradeMemberGroupResIdl> getParserForType() {
            return PARSER;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 1) == 1;
        }

        public final Im.Error getError() {
            return this.error_;
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
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeMessageSize(1, this.error_) + 0;
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

        public static UpgradeMemberGroupResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static UpgradeMemberGroupResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UpgradeMemberGroupResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static UpgradeMemberGroupResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UpgradeMemberGroupResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static UpgradeMemberGroupResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static UpgradeMemberGroupResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static UpgradeMemberGroupResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static UpgradeMemberGroupResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static UpgradeMemberGroupResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static h newBuilder() {
            return h.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final h newBuilderForType() {
            return newBuilder();
        }

        public static h newBuilder(UpgradeMemberGroupResIdl upgradeMemberGroupResIdl) {
            return newBuilder().mergeFrom(upgradeMemberGroupResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final h toBuilder() {
            return newBuilder(this);
        }
    }
}
