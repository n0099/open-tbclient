package protobuf.UpdateClientInfo;

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
/* loaded from: classes.dex */
public final class UpdateClientInfoReq {

    /* loaded from: classes.dex */
    public final class DataReq extends GeneratedMessageLite implements d {
        public static final int BDUSS_FIELD_NUMBER = 1;
        public static final int DEVICE_FIELD_NUMBER = 2;
        public static final int HEIGHT_FIELD_NUMBER = 7;
        public static final int LAT_FIELD_NUMBER = 4;
        public static final int LNG_FIELD_NUMBER = 5;
        public static final int SECRETKEY_FIELD_NUMBER = 3;
        public static final int UNREAD_MSG_FIELD_NUMBER = 8;
        public static final int WIDTH_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private Object bduss_;
        private int bitField0_;
        private Object device_;
        private int height_;
        private double lat_;
        private double lng_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ByteString secretKey_;
        private int unreadMsg_;
        private int width_;
        public static Parser<DataReq> PARSER = new b();
        private static final DataReq a = new DataReq(true);

        private DataReq(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private DataReq(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DataReq getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public DataReq getDefaultInstanceForType() {
            return a;
        }

        private DataReq(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.bduss_ = codedInputStream.readBytes();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.device_ = codedInputStream.readBytes();
                                    break;
                                case 26:
                                    this.bitField0_ |= 4;
                                    this.secretKey_ = codedInputStream.readBytes();
                                    break;
                                case 33:
                                    this.bitField0_ |= 8;
                                    this.lat_ = codedInputStream.readDouble();
                                    break;
                                case 41:
                                    this.bitField0_ |= 16;
                                    this.lng_ = codedInputStream.readDouble();
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.width_ = codedInputStream.readInt32();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.height_ = codedInputStream.readInt32();
                                    break;
                                case DERTags.APPLICATION /* 64 */:
                                    this.bitField0_ |= DERTags.TAGGED;
                                    this.unreadMsg_ = codedInputStream.readInt32();
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
        public Parser<DataReq> getParserForType() {
            return PARSER;
        }

        public boolean hasBduss() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getBduss() {
            Object obj = this.bduss_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.bduss_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getBdussBytes() {
            Object obj = this.bduss_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bduss_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasDevice() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getDevice() {
            Object obj = this.device_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.device_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getDeviceBytes() {
            Object obj = this.device_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.device_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasSecretKey() {
            return (this.bitField0_ & 4) == 4;
        }

        public ByteString getSecretKey() {
            return this.secretKey_;
        }

        public boolean hasLat() {
            return (this.bitField0_ & 8) == 8;
        }

        public double getLat() {
            return this.lat_;
        }

        public boolean hasLng() {
            return (this.bitField0_ & 16) == 16;
        }

        public double getLng() {
            return this.lng_;
        }

        public boolean hasWidth() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getWidth() {
            return this.width_;
        }

        public boolean hasHeight() {
            return (this.bitField0_ & 64) == 64;
        }

        public int getHeight() {
            return this.height_;
        }

        public boolean hasUnreadMsg() {
            return (this.bitField0_ & DERTags.TAGGED) == 128;
        }

        public int getUnreadMsg() {
            return this.unreadMsg_;
        }

        private void a() {
            this.bduss_ = "";
            this.device_ = "";
            this.secretKey_ = ByteString.EMPTY;
            this.lat_ = 0.0d;
            this.lng_ = 0.0d;
            this.width_ = 0;
            this.height_ = 0;
            this.unreadMsg_ = 0;
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
                codedOutputStream.writeBytes(1, getBdussBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getDeviceBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, this.secretKey_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeDouble(4, this.lat_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeDouble(5, this.lng_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.width_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(7, this.height_);
            }
            if ((this.bitField0_ & DERTags.TAGGED) == 128) {
                codedOutputStream.writeInt32(8, this.unreadMsg_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getBdussBytes()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getDeviceBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, this.secretKey_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeDoubleSize(4, this.lat_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeDoubleSize(5, this.lng_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeInt32Size(6, this.width_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeInt32Size(7, this.height_);
                }
                if ((this.bitField0_ & DERTags.TAGGED) == 128) {
                    i += CodedOutputStream.computeInt32Size(8, this.unreadMsg_);
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

        public static DataReq parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static DataReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DataReq parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static DataReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static DataReq parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static DataReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static DataReq parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static DataReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static DataReq parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static DataReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static c newBuilder() {
            return c.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public c newBuilderForType() {
            return newBuilder();
        }

        public static c newBuilder(DataReq dataReq) {
            return newBuilder().mergeFrom(dataReq);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public c toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class UpdateClientInfoReqIdl extends GeneratedMessageLite implements g {
        public static final int CUID_FIELD_NUMBER = 1;
        public static final int DATA_FIELD_NUMBER = 2;
        public static Parser<UpdateClientInfoReqIdl> PARSER = new e();
        private static final UpdateClientInfoReqIdl a = new UpdateClientInfoReqIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object cuid_;
        private DataReq data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private UpdateClientInfoReqIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UpdateClientInfoReqIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UpdateClientInfoReqIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public UpdateClientInfoReqIdl getDefaultInstanceForType() {
            return a;
        }

        private UpdateClientInfoReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            c cVar;
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
                                this.bitField0_ |= 1;
                                this.cuid_ = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case 18:
                                if ((this.bitField0_ & 2) != 2) {
                                    cVar = null;
                                } else {
                                    cVar = this.data_.toBuilder();
                                }
                                this.data_ = (DataReq) codedInputStream.readMessage(DataReq.PARSER, extensionRegistryLite);
                                if (cVar != null) {
                                    cVar.mergeFrom(this.data_);
                                    this.data_ = cVar.buildPartial();
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
        public Parser<UpdateClientInfoReqIdl> getParserForType() {
            return PARSER;
        }

        public boolean hasCuid() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getCuid() {
            Object obj = this.cuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.cuid_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCuidBytes() {
            Object obj = this.cuid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cuid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasData() {
            return (this.bitField0_ & 2) == 2;
        }

        public DataReq getData() {
            return this.data_;
        }

        private void a() {
            this.cuid_ = "";
            this.data_ = DataReq.getDefaultInstance();
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
                codedOutputStream.writeBytes(1, getCuidBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.data_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getCuidBytes()) : 0;
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

        public static UpdateClientInfoReqIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static UpdateClientInfoReqIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UpdateClientInfoReqIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static UpdateClientInfoReqIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UpdateClientInfoReqIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static UpdateClientInfoReqIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateClientInfoReqIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static UpdateClientInfoReqIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static UpdateClientInfoReqIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static UpdateClientInfoReqIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static f newBuilder() {
            return f.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public f newBuilderForType() {
            return newBuilder();
        }

        public static f newBuilder(UpdateClientInfoReqIdl updateClientInfoReqIdl) {
            return newBuilder().mergeFrom(updateClientInfoReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public f toBuilder() {
            return newBuilder(this);
        }
    }
}
