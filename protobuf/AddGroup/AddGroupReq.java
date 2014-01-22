package protobuf.AddGroup;

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
import protobuf.Im;
/* loaded from: classes.dex */
public final class AddGroupReq {

    /* loaded from: classes.dex */
    public final class DataReq extends GeneratedMessageLite implements g {
        public static final int BUSINESS_FIELD_NUMBER = 6;
        public static final int FLAG_FIELD_NUMBER = 10;
        public static final int FORUMID_FIELD_NUMBER = 1;
        public static final int GROUPTYPE_FIELD_NUMBER = 9;
        public static final int INTRO_FIELD_NUMBER = 3;
        public static final int LAT_FIELD_NUMBER = 8;
        public static final int LNG_FIELD_NUMBER = 7;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int PORTRAIT_FIELD_NUMBER = 4;
        public static final int POSITION_FIELD_NUMBER = 5;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object business_;
        private int flag_;
        private int forumId_;
        private int groupType_;
        private Object intro_;
        private double lat_;
        private double lng_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private Object portrait_;
        private Object position_;
        public static Parser<DataReq> PARSER = new e();
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
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.forumId_ = codedInputStream.readInt32();
                                    break;
                                case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                    this.bitField0_ |= 2;
                                    this.name_ = codedInputStream.readBytes();
                                    break;
                                case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                    this.bitField0_ |= 4;
                                    this.intro_ = codedInputStream.readBytes();
                                    break;
                                case Im.GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                    this.bitField0_ |= 8;
                                    this.portrait_ = codedInputStream.readBytes();
                                    break;
                                case 42:
                                    this.bitField0_ |= 16;
                                    this.position_ = codedInputStream.readBytes();
                                    break;
                                case 50:
                                    this.bitField0_ |= 32;
                                    this.business_ = codedInputStream.readBytes();
                                    break;
                                case 57:
                                    this.bitField0_ |= 64;
                                    this.lng_ = codedInputStream.readDouble();
                                    break;
                                case BDLocation.TypeCacheLocation /* 65 */:
                                    this.bitField0_ |= 128;
                                    this.lat_ = codedInputStream.readDouble();
                                    break;
                                case 72:
                                    this.bitField0_ |= 256;
                                    this.groupType_ = codedInputStream.readInt32();
                                    break;
                                case com.baidu.loginshare.e.i /* 80 */:
                                    this.bitField0_ |= 512;
                                    this.flag_ = codedInputStream.readInt32();
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

        public boolean hasForumId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getForumId() {
            return this.forumId_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getName() {
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

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasIntro() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getIntro() {
            Object obj = this.intro_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.intro_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getIntroBytes() {
            Object obj = this.intro_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.intro_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasPortrait() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getPortrait() {
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

        public ByteString getPortraitBytes() {
            Object obj = this.portrait_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.portrait_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasPosition() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getPosition() {
            Object obj = this.position_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.position_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPositionBytes() {
            Object obj = this.position_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.position_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasBusiness() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getBusiness() {
            Object obj = this.business_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.business_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getBusinessBytes() {
            Object obj = this.business_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.business_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasLng() {
            return (this.bitField0_ & 64) == 64;
        }

        public double getLng() {
            return this.lng_;
        }

        public boolean hasLat() {
            return (this.bitField0_ & 128) == 128;
        }

        public double getLat() {
            return this.lat_;
        }

        public boolean hasGroupType() {
            return (this.bitField0_ & 256) == 256;
        }

        public int getGroupType() {
            return this.groupType_;
        }

        public boolean hasFlag() {
            return (this.bitField0_ & 512) == 512;
        }

        public int getFlag() {
            return this.flag_;
        }

        private void a() {
            this.forumId_ = 0;
            this.name_ = "";
            this.intro_ = "";
            this.portrait_ = "";
            this.position_ = "";
            this.business_ = "";
            this.lng_ = 0.0d;
            this.lat_ = 0.0d;
            this.groupType_ = 0;
            this.flag_ = 0;
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
                codedOutputStream.writeInt32(1, this.forumId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getIntroBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getPortraitBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(5, getPositionBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getBusinessBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeDouble(7, this.lng_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeDouble(8, this.lat_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(9, this.groupType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(10, this.flag_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.forumId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getNameBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getIntroBytes());
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getPortraitBytes());
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, getPositionBytes());
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getBusinessBytes());
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeDoubleSize(7, this.lng_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    i += CodedOutputStream.computeDoubleSize(8, this.lat_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeInt32Size(9, this.groupType_);
                }
                if ((this.bitField0_ & 512) == 512) {
                    i += CodedOutputStream.computeInt32Size(10, this.flag_);
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

        public static f newBuilder() {
            return f.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public f newBuilderForType() {
            return newBuilder();
        }

        public static f newBuilder(DataReq dataReq) {
            return newBuilder().mergeFrom(dataReq);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public f toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class AddGroupReqIdl extends GeneratedMessageLite implements d {
        public static final int DATA_FIELD_NUMBER = 1;
        public static Parser<AddGroupReqIdl> PARSER = new b();
        private static final AddGroupReqIdl a = new AddGroupReqIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataReq data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private AddGroupReqIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private AddGroupReqIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AddGroupReqIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public AddGroupReqIdl getDefaultInstanceForType() {
            return a;
        }

        private AddGroupReqIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            f fVar;
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
                                if ((this.bitField0_ & 1) != 1) {
                                    fVar = null;
                                } else {
                                    fVar = this.data_.toBuilder();
                                }
                                this.data_ = (DataReq) codedInputStream.readMessage(DataReq.PARSER, extensionRegistryLite);
                                if (fVar != null) {
                                    fVar.mergeFrom(this.data_);
                                    this.data_ = fVar.buildPartial();
                                }
                                this.bitField0_ |= 1;
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
        public Parser<AddGroupReqIdl> getParserForType() {
            return PARSER;
        }

        public boolean hasData() {
            return (this.bitField0_ & 1) == 1;
        }

        public DataReq getData() {
            return this.data_;
        }

        private void a() {
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

        public static AddGroupReqIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static AddGroupReqIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AddGroupReqIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static AddGroupReqIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AddGroupReqIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static AddGroupReqIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static AddGroupReqIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static AddGroupReqIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static AddGroupReqIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static AddGroupReqIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static c newBuilder(AddGroupReqIdl addGroupReqIdl) {
            return newBuilder().mergeFrom(addGroupReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public c toBuilder() {
            return newBuilder(this);
        }
    }
}
