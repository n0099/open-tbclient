package protobuf.UpdateGroup;

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
import protobuf.k;
/* loaded from: classes.dex */
public final class UpdateGroupReq {

    /* loaded from: classes.dex */
    public final class UpdateGroupReqIdl extends GeneratedMessageLite implements c {
        public static final int DATA_FIELD_NUMBER = 1;
        public static Parser<UpdateGroupReqIdl> PARSER = new a();
        private static final UpdateGroupReqIdl a = new UpdateGroupReqIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Im.GroupInfo data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ UpdateGroupReqIdl(GeneratedMessageLite.Builder builder, UpdateGroupReqIdl updateGroupReqIdl) {
            this(builder);
        }

        private UpdateGroupReqIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UpdateGroupReqIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UpdateGroupReqIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public UpdateGroupReqIdl getDefaultInstanceForType() {
            return a;
        }

        private UpdateGroupReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            k kVar;
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
                                    kVar = this.data_.toBuilder();
                                }
                                this.data_ = (Im.GroupInfo) codedInputStream.readMessage(Im.GroupInfo.PARSER, extensionRegistryLite);
                                if (kVar != null) {
                                    kVar.mergeFrom(this.data_);
                                    this.data_ = kVar.buildPartial();
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
        public /* synthetic */ UpdateGroupReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UpdateGroupReqIdl updateGroupReqIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<UpdateGroupReqIdl> getParserForType() {
            return PARSER;
        }

        public boolean hasData() {
            return (this.bitField0_ & 1) == 1;
        }

        public Im.GroupInfo getData() {
            return this.data_;
        }

        private void a() {
            this.data_ = Im.GroupInfo.getDefaultInstance();
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
                codedOutputStream.writeMessage(1, this.data_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.data_) : 0;
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() {
            return super.writeReplace();
        }

        public static UpdateGroupReqIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static UpdateGroupReqIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UpdateGroupReqIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static UpdateGroupReqIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UpdateGroupReqIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static UpdateGroupReqIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateGroupReqIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static UpdateGroupReqIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateGroupReqIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static UpdateGroupReqIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static b newBuilder() {
            return b.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public b newBuilderForType() {
            return newBuilder();
        }

        public static b newBuilder(UpdateGroupReqIdl updateGroupReqIdl) {
            return newBuilder().mergeFrom(updateGroupReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public b toBuilder() {
            return newBuilder(this);
        }
    }
}
