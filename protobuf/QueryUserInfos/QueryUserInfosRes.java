package protobuf.QueryUserInfos;

import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
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
/* loaded from: classes.dex */
public final class QueryUserInfosRes {

    /* loaded from: classes.dex */
    public final class IconInfo extends GeneratedMessageLite implements n {
        public static final int ICONURL_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int WEIGHT_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object iconUrl_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int weight_;
        public static Parser<IconInfo> PARSER = new l();
        private static final IconInfo a = new IconInfo(true);

        private IconInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private IconInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static IconInfo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public IconInfo getDefaultInstanceForType() {
            return a;
        }

        private IconInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.name_ = codedInputStream.readBytes();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.weight_ = codedInputStream.readInt32();
                                    break;
                                case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                    this.bitField0_ |= 4;
                                    this.iconUrl_ = codedInputStream.readBytes();
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
        public Parser<IconInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
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

        public boolean hasWeight() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getWeight() {
            return this.weight_;
        }

        public boolean hasIconUrl() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getIconUrl() {
            Object obj = this.iconUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.iconUrl_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getIconUrlBytes() {
            Object obj = this.iconUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.iconUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void a() {
            this.name_ = "";
            this.weight_ = 0;
            this.iconUrl_ = "";
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
                codedOutputStream.writeBytes(1, getNameBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.weight_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getIconUrlBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNameBytes()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.weight_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getIconUrlBytes());
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

        public static IconInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static IconInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static IconInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static IconInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static IconInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static IconInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static IconInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static IconInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static IconInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static IconInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static m newBuilder(IconInfo iconInfo) {
            return newBuilder().mergeFrom(iconInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements k {
        public static final int HASCONCERNED_FIELD_NUMBER = 8;
        public static final int ICONINFO_FIELD_NUMBER = 15;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int INTRO_FIELD_NUMBER = 6;
        public static final int ISBLACKLIST_FIELD_NUMBER = 9;
        public static final int ISCOREUSER_FIELD_NUMBER = 12;
        public static final int ISINTERESTMAN_FIELD_NUMBER = 14;
        public static final int MEIZHILEVEL_FIELD_NUMBER = 10;
        public static final int NAMESHOW_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int PORTRAITH_FIELD_NUMBER = 5;
        public static final int PORTRAIT_FIELD_NUMBER = 4;
        public static final int SEX_FIELD_NUMBER = 7;
        public static final int SUPERBOY_FIELD_NUMBER = 13;
        public static final int USERTYPE_FIELD_NUMBER = 11;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int hasConcerned_;
        private List<IconInfo> iconInfo_;
        private long id_;
        private Object intro_;
        private int isBlacklist_;
        private int isCoreuser_;
        private int isInterestman_;
        private int meizhiLevel_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object nameShow_;
        private Object name_;
        private Object portrait_;
        private Object portraith_;
        private int sex_;
        private int superboy_;
        private int userType_;
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<protobuf.QueryUserInfos.QueryUserInfosRes$IconInfo> */
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
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.id_ = codedInputStream.readInt64();
                                    break;
                                case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                    this.bitField0_ |= 2;
                                    this.name_ = codedInputStream.readBytes();
                                    break;
                                case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                    this.bitField0_ |= 4;
                                    this.nameShow_ = codedInputStream.readBytes();
                                    break;
                                case Im.GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                    this.bitField0_ |= 8;
                                    this.portrait_ = codedInputStream.readBytes();
                                    break;
                                case 42:
                                    this.bitField0_ |= 16;
                                    this.portraith_ = codedInputStream.readBytes();
                                    break;
                                case 50:
                                    this.bitField0_ |= 32;
                                    this.intro_ = codedInputStream.readBytes();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.sex_ = codedInputStream.readInt32();
                                    break;
                                case 64:
                                    this.bitField0_ |= 128;
                                    this.hasConcerned_ = codedInputStream.readInt32();
                                    break;
                                case 72:
                                    this.bitField0_ |= 256;
                                    this.isBlacklist_ = codedInputStream.readInt32();
                                    break;
                                case com.baidu.loginshare.e.i /* 80 */:
                                    this.bitField0_ |= 512;
                                    this.meizhiLevel_ = codedInputStream.readInt32();
                                    break;
                                case 88:
                                    this.bitField0_ |= 1024;
                                    this.userType_ = codedInputStream.readInt32();
                                    break;
                                case 96:
                                    this.bitField0_ |= 2048;
                                    this.isCoreuser_ = codedInputStream.readInt32();
                                    break;
                                case SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE /* 104 */:
                                    this.bitField0_ |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                                    this.superboy_ = codedInputStream.readInt32();
                                    break;
                                case SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY /* 112 */:
                                    this.bitField0_ |= 8192;
                                    this.isInterestman_ = codedInputStream.readInt32();
                                    break;
                                case SocialAPIErrorCodes.ERROR_SESSION_EXPIRED /* 122 */:
                                    if (!(z2 & true)) {
                                        this.iconInfo_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.iconInfo_.add(codedInputStream.readMessage(IconInfo.PARSER, extensionRegistryLite));
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
                        this.iconInfo_ = Collections.unmodifiableList(this.iconInfo_);
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

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public long getId() {
            return this.id_;
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

        public boolean hasNameShow() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getNameShow() {
            Object obj = this.nameShow_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.nameShow_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNameShowBytes() {
            Object obj = this.nameShow_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nameShow_ = copyFromUtf8;
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

        public boolean hasPortraith() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getPortraith() {
            Object obj = this.portraith_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.portraith_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPortraithBytes() {
            Object obj = this.portraith_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.portraith_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasIntro() {
            return (this.bitField0_ & 32) == 32;
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

        public boolean hasSex() {
            return (this.bitField0_ & 64) == 64;
        }

        public int getSex() {
            return this.sex_;
        }

        public boolean hasHasConcerned() {
            return (this.bitField0_ & 128) == 128;
        }

        public int getHasConcerned() {
            return this.hasConcerned_;
        }

        public boolean hasIsBlacklist() {
            return (this.bitField0_ & 256) == 256;
        }

        public int getIsBlacklist() {
            return this.isBlacklist_;
        }

        public boolean hasMeizhiLevel() {
            return (this.bitField0_ & 512) == 512;
        }

        public int getMeizhiLevel() {
            return this.meizhiLevel_;
        }

        public boolean hasUserType() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public int getUserType() {
            return this.userType_;
        }

        public boolean hasIsCoreuser() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public int getIsCoreuser() {
            return this.isCoreuser_;
        }

        public boolean hasSuperboy() {
            return (this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096;
        }

        public int getSuperboy() {
            return this.superboy_;
        }

        public boolean hasIsInterestman() {
            return (this.bitField0_ & 8192) == 8192;
        }

        public int getIsInterestman() {
            return this.isInterestman_;
        }

        public List<IconInfo> getIconInfoList() {
            return this.iconInfo_;
        }

        public List<? extends n> getIconInfoOrBuilderList() {
            return this.iconInfo_;
        }

        public int getIconInfoCount() {
            return this.iconInfo_.size();
        }

        public IconInfo getIconInfo(int i) {
            return this.iconInfo_.get(i);
        }

        public n getIconInfoOrBuilder(int i) {
            return this.iconInfo_.get(i);
        }

        private void a() {
            this.id_ = 0L;
            this.name_ = "";
            this.nameShow_ = "";
            this.portrait_ = "";
            this.portraith_ = "";
            this.intro_ = "";
            this.sex_ = 0;
            this.hasConcerned_ = 0;
            this.isBlacklist_ = 0;
            this.meizhiLevel_ = 0;
            this.userType_ = 0;
            this.isCoreuser_ = 0;
            this.superboy_ = 0;
            this.isInterestman_ = 0;
            this.iconInfo_ = Collections.emptyList();
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
                codedOutputStream.writeInt64(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getNameShowBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getPortraitBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(5, getPortraithBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getIntroBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(7, this.sex_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(8, this.hasConcerned_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(9, this.isBlacklist_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(10, this.meizhiLevel_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeInt32(11, this.userType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt32(12, this.isCoreuser_);
            }
            if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                codedOutputStream.writeInt32(13, this.superboy_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.writeInt32(14, this.isInterestman_);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iconInfo_.size()) {
                    codedOutputStream.writeMessage(15, this.iconInfo_.get(i2));
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
                int computeInt64Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.id_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(2, getNameBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(3, getNameShowBytes());
                }
                if ((this.bitField0_ & 8) == 8) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(4, getPortraitBytes());
                }
                if ((this.bitField0_ & 16) == 16) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(5, getPortraithBytes());
                }
                if ((this.bitField0_ & 32) == 32) {
                    computeInt64Size += CodedOutputStream.computeBytesSize(6, getIntroBytes());
                }
                if ((this.bitField0_ & 64) == 64) {
                    computeInt64Size += CodedOutputStream.computeInt32Size(7, this.sex_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    computeInt64Size += CodedOutputStream.computeInt32Size(8, this.hasConcerned_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    computeInt64Size += CodedOutputStream.computeInt32Size(9, this.isBlacklist_);
                }
                if ((this.bitField0_ & 512) == 512) {
                    computeInt64Size += CodedOutputStream.computeInt32Size(10, this.meizhiLevel_);
                }
                if ((this.bitField0_ & 1024) == 1024) {
                    computeInt64Size += CodedOutputStream.computeInt32Size(11, this.userType_);
                }
                if ((this.bitField0_ & 2048) == 2048) {
                    computeInt64Size += CodedOutputStream.computeInt32Size(12, this.isCoreuser_);
                }
                if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                    computeInt64Size += CodedOutputStream.computeInt32Size(13, this.superboy_);
                }
                if ((this.bitField0_ & 8192) == 8192) {
                    computeInt64Size += CodedOutputStream.computeInt32Size(14, this.isInterestman_);
                }
                while (true) {
                    i2 = computeInt64Size;
                    if (i >= this.iconInfo_.size()) {
                        break;
                    }
                    computeInt64Size = CodedOutputStream.computeMessageSize(15, this.iconInfo_.get(i)) + i2;
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
    public final class QueryUserInfosResIdl extends GeneratedMessageLite implements q {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryUserInfosResIdl> PARSER = new o();
        private static final QueryUserInfosResIdl a = new QueryUserInfosResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private QueryUserInfosResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryUserInfosResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryUserInfosResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public QueryUserInfosResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryUserInfosResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public Parser<QueryUserInfosResIdl> getParserForType() {
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

        public static QueryUserInfosResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static QueryUserInfosResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QueryUserInfosResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static QueryUserInfosResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QueryUserInfosResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static QueryUserInfosResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QueryUserInfosResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QueryUserInfosResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QueryUserInfosResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QueryUserInfosResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static p newBuilder(QueryUserInfosResIdl queryUserInfosResIdl) {
            return newBuilder().mergeFrom(queryUserInfosResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public p toBuilder() {
            return newBuilder(this);
        }
    }
}
