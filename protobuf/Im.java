package protobuf;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.BDLocation;
import com.baidu.zeus.NotificationProxy;
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
public final class Im {

    /* loaded from: classes.dex */
    public final class Error extends GeneratedMessageLite implements d {
        public static final int ERRORNO_FIELD_NUMBER = 1;
        public static final int USERMSG_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errorno_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object usermsg_;
        public static Parser<Error> PARSER = new b();
        private static final Error a = new Error(true);

        private Error(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Error(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Error getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Error getDefaultInstanceForType() {
            return a;
        }

        private Error(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.errorno_ = codedInputStream.readInt32();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.usermsg_ = codedInputStream.readBytes();
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
        public Parser<Error> getParserForType() {
            return PARSER;
        }

        public boolean hasErrorno() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getErrorno() {
            return this.errorno_;
        }

        public boolean hasUsermsg() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getUsermsg() {
            Object obj = this.usermsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.usermsg_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getUsermsgBytes() {
            Object obj = this.usermsg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.usermsg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void a() {
            this.errorno_ = 0;
            this.usermsg_ = "";
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
                codedOutputStream.writeInt32(1, this.errorno_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getUsermsgBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.errorno_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getUsermsgBytes());
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

        public static Error parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static Error parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Error parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static Error parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Error parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static Error parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Error parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Error parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Error parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Error parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static c newBuilder(Error error) {
            return newBuilder().mergeFrom(error);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public c toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class UserPermission extends GeneratedMessageLite implements ah {
        public static final int ISGROUPMANAGER_FIELD_NUMBER = 2;
        public static final int ISGROUPOWNER_FIELD_NUMBER = 1;
        public static Parser<UserPermission> PARSER = new af();
        private static final UserPermission a = new UserPermission(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int isGroupManager_;
        private int isGroupOwner_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private UserPermission(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UserPermission(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UserPermission getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public UserPermission getDefaultInstanceForType() {
            return a;
        }

        private UserPermission(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.isGroupOwner_ = codedInputStream.readInt32();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.isGroupManager_ = codedInputStream.readInt32();
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
        public Parser<UserPermission> getParserForType() {
            return PARSER;
        }

        public boolean hasIsGroupOwner() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getIsGroupOwner() {
            return this.isGroupOwner_;
        }

        public boolean hasIsGroupManager() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getIsGroupManager() {
            return this.isGroupManager_;
        }

        private void a() {
            this.isGroupOwner_ = 0;
            this.isGroupManager_ = 0;
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
                codedOutputStream.writeInt32(1, this.isGroupOwner_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.isGroupManager_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.isGroupOwner_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.isGroupManager_);
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

        public static UserPermission parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static UserPermission parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserPermission parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static UserPermission parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserPermission parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static UserPermission parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static UserPermission parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static UserPermission parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static UserPermission parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static UserPermission parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ag newBuilder() {
            return ag.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public ag newBuilderForType() {
            return newBuilder();
        }

        public static ag newBuilder(UserPermission userPermission) {
            return newBuilder().mergeFrom(userPermission);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public ag toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class GroupPermission extends GeneratedMessageLite implements p {
        public static final int CANCREATENORMAL_FIELD_NUMBER = 2;
        public static final int CANCREATEOFFICIAL_FIELD_NUMBER = 3;
        public static final int CANCREATEPERSONAL_FIELD_NUMBER = 4;
        public static final int CREATENORMALTIP_FIELD_NUMBER = 5;
        public static final int CREATEOFFICIALTIP_FIELD_NUMBER = 6;
        public static final int CREATEPERSONALTIP_FIELD_NUMBER = 7;
        public static final int ISFORUMMANAGER_FIELD_NUMBER = 1;
        public static Parser<GroupPermission> PARSER = new n();
        private static final GroupPermission a = new GroupPermission(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int canCreateNormal_;
        private int canCreateOfficial_;
        private int canCreatePersonal_;
        private Object createNormalTip_;
        private Object createOfficialTip_;
        private Object createPersonalTip_;
        private int isForumManager_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private GroupPermission(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GroupPermission(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GroupPermission getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public GroupPermission getDefaultInstanceForType() {
            return a;
        }

        private GroupPermission(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.isForumManager_ = codedInputStream.readInt32();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.canCreateNormal_ = codedInputStream.readInt32();
                                    break;
                                case 24:
                                    this.bitField0_ |= 4;
                                    this.canCreateOfficial_ = codedInputStream.readInt32();
                                    break;
                                case 32:
                                    this.bitField0_ |= 8;
                                    this.canCreatePersonal_ = codedInputStream.readInt32();
                                    break;
                                case 42:
                                    this.bitField0_ |= 16;
                                    this.createNormalTip_ = codedInputStream.readBytes();
                                    break;
                                case 50:
                                    this.bitField0_ |= 32;
                                    this.createOfficialTip_ = codedInputStream.readBytes();
                                    break;
                                case 58:
                                    this.bitField0_ |= 64;
                                    this.createPersonalTip_ = codedInputStream.readBytes();
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
        public Parser<GroupPermission> getParserForType() {
            return PARSER;
        }

        public boolean hasIsForumManager() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getIsForumManager() {
            return this.isForumManager_;
        }

        public boolean hasCanCreateNormal() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getCanCreateNormal() {
            return this.canCreateNormal_;
        }

        public boolean hasCanCreateOfficial() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getCanCreateOfficial() {
            return this.canCreateOfficial_;
        }

        public boolean hasCanCreatePersonal() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getCanCreatePersonal() {
            return this.canCreatePersonal_;
        }

        public boolean hasCreateNormalTip() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getCreateNormalTip() {
            Object obj = this.createNormalTip_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.createNormalTip_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCreateNormalTipBytes() {
            Object obj = this.createNormalTip_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.createNormalTip_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasCreateOfficialTip() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getCreateOfficialTip() {
            Object obj = this.createOfficialTip_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.createOfficialTip_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCreateOfficialTipBytes() {
            Object obj = this.createOfficialTip_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.createOfficialTip_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasCreatePersonalTip() {
            return (this.bitField0_ & 64) == 64;
        }

        public String getCreatePersonalTip() {
            Object obj = this.createPersonalTip_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.createPersonalTip_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCreatePersonalTipBytes() {
            Object obj = this.createPersonalTip_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.createPersonalTip_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void a() {
            this.isForumManager_ = 0;
            this.canCreateNormal_ = 0;
            this.canCreateOfficial_ = 0;
            this.canCreatePersonal_ = 0;
            this.createNormalTip_ = "";
            this.createOfficialTip_ = "";
            this.createPersonalTip_ = "";
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
                codedOutputStream.writeInt32(1, this.isForumManager_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.canCreateNormal_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.canCreateOfficial_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.canCreatePersonal_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(5, getCreateNormalTipBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getCreateOfficialTipBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBytes(7, getCreatePersonalTipBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.isForumManager_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.canCreateNormal_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.canCreateOfficial_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(4, this.canCreatePersonal_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, getCreateNormalTipBytes());
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getCreateOfficialTipBytes());
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeBytesSize(7, getCreatePersonalTipBytes());
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

        public static GroupPermission parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static GroupPermission parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GroupPermission parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static GroupPermission parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static GroupPermission parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static GroupPermission parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static GroupPermission parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static GroupPermission parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static GroupPermission parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static GroupPermission parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static o newBuilder() {
            return o.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public o newBuilderForType() {
            return newBuilder();
        }

        public static o newBuilder(GroupPermission groupPermission) {
            return newBuilder().mergeFrom(groupPermission);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public o toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class UserInfo extends GeneratedMessageLite implements ae {
        public static final int INTIME_FIELD_NUMBER = 9;
        public static final int LASTREPLYTIME_FIELD_NUMBER = 11;
        public static final int LAT_FIELD_NUMBER = 8;
        public static final int LNG_FIELD_NUMBER = 7;
        public static final int LOGINTIME_FIELD_NUMBER = 10;
        public static final int NICKNAME_FIELD_NUMBER = 3;
        public static final int PERMISSION_FIELD_NUMBER = 13;
        public static final int PORTRAIT_FIELD_NUMBER = 4;
        public static final int POSITION_FIELD_NUMBER = 6;
        public static final int SEX_FIELD_NUMBER = 5;
        public static final int SYSGROUPID_FIELD_NUMBER = 12;
        public static final int USERID_FIELD_NUMBER = 1;
        public static final int USERNAME_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int inTime_;
        private int lastReplyTime_;
        private double lat_;
        private double lng_;
        private int loginTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object nickName_;
        private UserPermission permission_;
        private Object portrait_;
        private Object position_;
        private int sex_;
        private int sysGroupId_;
        private int userId_;
        private Object userName_;
        public static Parser<UserInfo> PARSER = new ac();
        private static final UserInfo a = new UserInfo(true);

        private UserInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UserInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UserInfo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public UserInfo getDefaultInstanceForType() {
            return a;
        }

        private UserInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ag agVar;
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
                                this.userId_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case 18:
                                this.bitField0_ |= 2;
                                this.userName_ = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case 26:
                                this.bitField0_ |= 4;
                                this.nickName_ = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case 34:
                                this.bitField0_ |= 8;
                                this.portrait_ = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case 40:
                                this.bitField0_ |= 16;
                                this.sex_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case 50:
                                this.bitField0_ |= 32;
                                this.position_ = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case 57:
                                this.bitField0_ |= 64;
                                this.lng_ = codedInputStream.readDouble();
                                z = z2;
                                break;
                            case BDLocation.TypeCacheLocation /* 65 */:
                                this.bitField0_ |= DERTags.TAGGED;
                                this.lat_ = codedInputStream.readDouble();
                                z = z2;
                                break;
                            case 72:
                                this.bitField0_ |= 256;
                                this.inTime_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case com.baidu.loginshare.e.i /* 80 */:
                                this.bitField0_ |= ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
                                this.loginTime_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case 88:
                                this.bitField0_ |= NotificationProxy.MAX_URL_LENGTH;
                                this.lastReplyTime_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case 96:
                                this.bitField0_ |= 2048;
                                this.sysGroupId_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE_ALGORITHM /* 106 */:
                                if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 4096) {
                                    agVar = null;
                                } else {
                                    agVar = this.permission_.toBuilder();
                                }
                                this.permission_ = (UserPermission) codedInputStream.readMessage(UserPermission.PARSER, extensionRegistryLite);
                                if (agVar != null) {
                                    agVar.mergeFrom(this.permission_);
                                    this.permission_ = agVar.buildPartial();
                                }
                                this.bitField0_ |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
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
        public Parser<UserInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasUserId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getUserId() {
            return this.userId_;
        }

        public boolean hasUserName() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getUserName() {
            Object obj = this.userName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.userName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getUserNameBytes() {
            Object obj = this.userName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasNickName() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getNickName() {
            Object obj = this.nickName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.nickName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNickNameBytes() {
            Object obj = this.nickName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nickName_ = copyFromUtf8;
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

        public boolean hasSex() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getSex() {
            return this.sex_;
        }

        public boolean hasPosition() {
            return (this.bitField0_ & 32) == 32;
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

        public boolean hasLng() {
            return (this.bitField0_ & 64) == 64;
        }

        public double getLng() {
            return this.lng_;
        }

        public boolean hasLat() {
            return (this.bitField0_ & DERTags.TAGGED) == 128;
        }

        public double getLat() {
            return this.lat_;
        }

        public boolean hasInTime() {
            return (this.bitField0_ & 256) == 256;
        }

        public int getInTime() {
            return this.inTime_;
        }

        public boolean hasLoginTime() {
            return (this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512;
        }

        public int getLoginTime() {
            return this.loginTime_;
        }

        public boolean hasLastReplyTime() {
            return (this.bitField0_ & NotificationProxy.MAX_URL_LENGTH) == 1024;
        }

        public int getLastReplyTime() {
            return this.lastReplyTime_;
        }

        public boolean hasSysGroupId() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public int getSysGroupId() {
            return this.sysGroupId_;
        }

        public boolean hasPermission() {
            return (this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096;
        }

        public UserPermission getPermission() {
            return this.permission_;
        }

        private void a() {
            this.userId_ = 0;
            this.userName_ = "";
            this.nickName_ = "";
            this.portrait_ = "";
            this.sex_ = 0;
            this.position_ = "";
            this.lng_ = 0.0d;
            this.lat_ = 0.0d;
            this.inTime_ = 0;
            this.loginTime_ = 0;
            this.lastReplyTime_ = 0;
            this.sysGroupId_ = 0;
            this.permission_ = UserPermission.getDefaultInstance();
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
                codedOutputStream.writeInt32(1, this.userId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getUserNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getNickNameBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getPortraitBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.sex_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getPositionBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeDouble(7, this.lng_);
            }
            if ((this.bitField0_ & DERTags.TAGGED) == 128) {
                codedOutputStream.writeDouble(8, this.lat_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(9, this.inTime_);
            }
            if ((this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512) {
                codedOutputStream.writeInt32(10, this.loginTime_);
            }
            if ((this.bitField0_ & NotificationProxy.MAX_URL_LENGTH) == 1024) {
                codedOutputStream.writeInt32(11, this.lastReplyTime_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt32(12, this.sysGroupId_);
            }
            if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                codedOutputStream.writeMessage(13, this.permission_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.userId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getUserNameBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getNickNameBytes());
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getPortraitBytes());
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeInt32Size(5, this.sex_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getPositionBytes());
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeDoubleSize(7, this.lng_);
                }
                if ((this.bitField0_ & DERTags.TAGGED) == 128) {
                    i += CodedOutputStream.computeDoubleSize(8, this.lat_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeInt32Size(9, this.inTime_);
                }
                if ((this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512) {
                    i += CodedOutputStream.computeInt32Size(10, this.loginTime_);
                }
                if ((this.bitField0_ & NotificationProxy.MAX_URL_LENGTH) == 1024) {
                    i += CodedOutputStream.computeInt32Size(11, this.lastReplyTime_);
                }
                if ((this.bitField0_ & 2048) == 2048) {
                    i += CodedOutputStream.computeInt32Size(12, this.sysGroupId_);
                }
                if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                    i += CodedOutputStream.computeMessageSize(13, this.permission_);
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

        public static UserInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static UserInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static UserInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static UserInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ad newBuilder() {
            return ad.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public ad newBuilderForType() {
            return newBuilder();
        }

        public static ad newBuilder(UserInfo userInfo) {
            return newBuilder().mergeFrom(userInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public ad toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class MaskInfo extends GeneratedMessageLite implements s {
        public static final int MASKGIDS_FIELD_NUMBER = 2;
        public static final int REMINDMASK_FIELD_NUMBER = 3;
        public static final int USERID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object maskGids_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int remindMask_;
        private long userId_;
        public static Parser<MaskInfo> PARSER = new q();
        private static final MaskInfo a = new MaskInfo(true);

        private MaskInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MaskInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MaskInfo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MaskInfo getDefaultInstanceForType() {
            return a;
        }

        private MaskInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.userId_ = codedInputStream.readInt64();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.maskGids_ = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.bitField0_ |= 4;
                                    this.remindMask_ = codedInputStream.readInt32();
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
        public Parser<MaskInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasUserId() {
            return (this.bitField0_ & 1) == 1;
        }

        public long getUserId() {
            return this.userId_;
        }

        public boolean hasMaskGids() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getMaskGids() {
            Object obj = this.maskGids_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.maskGids_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getMaskGidsBytes() {
            Object obj = this.maskGids_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.maskGids_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasRemindMask() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getRemindMask() {
            return this.remindMask_;
        }

        private void a() {
            this.userId_ = 0L;
            this.maskGids_ = "";
            this.remindMask_ = 0;
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
                codedOutputStream.writeInt64(1, this.userId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getMaskGidsBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.remindMask_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.userId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getMaskGidsBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.remindMask_);
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

        public static MaskInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static MaskInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MaskInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static MaskInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MaskInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static MaskInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static MaskInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static MaskInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static MaskInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static MaskInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static r newBuilder() {
            return r.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public r newBuilderForType() {
            return newBuilder();
        }

        public static r newBuilder(MaskInfo maskInfo) {
            return newBuilder().mergeFrom(maskInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public r toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class GroupInfo extends GeneratedMessageLite implements j {
        public static final int ACTIVEDAY_FIELD_NUMBER = 27;
        public static final int ALBUM_FIELD_NUMBER = 11;
        public static final int AUTHORID_FIELD_NUMBER = 14;
        public static final int AUTHORISMEIZHI_FIELD_NUMBER = 29;
        public static final int AUTHORNAME_FIELD_NUMBER = 15;
        public static final int AUTHORPORTRAIT_FIELD_NUMBER = 16;
        public static final int BUSINESS_FIELD_NUMBER = 7;
        public static final int CREATETIME_FIELD_NUMBER = 17;
        public static final int DISTANCE_FIELD_NUMBER = 23;
        public static final int FLAG_FIELD_NUMBER = 13;
        public static final int FORUMID_FIELD_NUMBER = 2;
        public static final int FORUMNAME_FIELD_NUMBER = 25;
        public static final int FORUMSHOWNAME_FIELD_NUMBER = 31;
        public static final int GRADE_FIELD_NUMBER = 22;
        public static final int GROUPID_FIELD_NUMBER = 1;
        public static final int GROUPTYPE_FIELD_NUMBER = 20;
        public static final int INTRO_FIELD_NUMBER = 4;
        public static final int ISGROUPMANAGER_FIELD_NUMBER = 28;
        public static final int ISHIDEPOSITION_FIELD_NUMBER = 24;
        public static final int LASTMSGID_FIELD_NUMBER = 21;
        public static final int LASTMSGTIME_FIELD_NUMBER = 30;
        public static final int LAT_FIELD_NUMBER = 9;
        public static final int LNG_FIELD_NUMBER = 8;
        public static final int MAXMEMBERNUM_FIELD_NUMBER = 18;
        public static final int MEMBERNUM_FIELD_NUMBER = 19;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int NICKNAME_FIELD_NUMBER = 26;
        public static final int NOTICE_FIELD_NUMBER = 10;
        public static final int PORTRAIT_FIELD_NUMBER = 5;
        public static final int POSITION_FIELD_NUMBER = 6;
        public static final int STATUS_FIELD_NUMBER = 12;
        private static final long serialVersionUID = 0;
        private int activeDay_;
        private Object album_;
        private int authorId_;
        private int authorIsMeizhi_;
        private Object authorName_;
        private Object authorPortrait_;
        private int bitField0_;
        private Object business_;
        private int createTime_;
        private int distance_;
        private int flag_;
        private int forumId_;
        private Object forumName_;
        private Object forumShowName_;
        private int grade_;
        private int groupId_;
        private int groupType_;
        private Object intro_;
        private int isGroupManager_;
        private int isHidePosition_;
        private long lastMsgId_;
        private int lastMsgTime_;
        private double lat_;
        private double lng_;
        private int maxMemberNum_;
        private int memberNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private Object nickName_;
        private Object notice_;
        private Object portrait_;
        private Object position_;
        private int status_;
        public static Parser<GroupInfo> PARSER = new h();
        private static final GroupInfo a = new GroupInfo(true);

        private GroupInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GroupInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GroupInfo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public GroupInfo getDefaultInstanceForType() {
            return a;
        }

        private GroupInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.groupId_ = codedInputStream.readInt32();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.forumId_ = codedInputStream.readInt32();
                                    break;
                                case 26:
                                    this.bitField0_ |= 4;
                                    this.name_ = codedInputStream.readBytes();
                                    break;
                                case 34:
                                    this.bitField0_ |= 8;
                                    this.intro_ = codedInputStream.readBytes();
                                    break;
                                case 42:
                                    this.bitField0_ |= 16;
                                    this.portrait_ = codedInputStream.readBytes();
                                    break;
                                case 50:
                                    this.bitField0_ |= 32;
                                    this.position_ = codedInputStream.readBytes();
                                    break;
                                case 58:
                                    this.bitField0_ |= 64;
                                    this.business_ = codedInputStream.readBytes();
                                    break;
                                case BDLocation.TypeCacheLocation /* 65 */:
                                    this.bitField0_ |= DERTags.TAGGED;
                                    this.lng_ = codedInputStream.readDouble();
                                    break;
                                case 73:
                                    this.bitField0_ |= 256;
                                    this.lat_ = codedInputStream.readDouble();
                                    break;
                                case 82:
                                    this.bitField0_ |= ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
                                    this.notice_ = codedInputStream.readBytes();
                                    break;
                                case 90:
                                    this.bitField0_ |= NotificationProxy.MAX_URL_LENGTH;
                                    this.album_ = codedInputStream.readBytes();
                                    break;
                                case 96:
                                    this.bitField0_ |= 2048;
                                    this.status_ = codedInputStream.readInt32();
                                    break;
                                case 104:
                                    this.bitField0_ |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                                    this.flag_ = codedInputStream.readInt32();
                                    break;
                                case SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY /* 112 */:
                                    this.bitField0_ |= 8192;
                                    this.authorId_ = codedInputStream.readInt32();
                                    break;
                                case SocialAPIErrorCodes.ERROR_SESSION_EXPIRED /* 122 */:
                                    this.bitField0_ |= 16384;
                                    this.authorName_ = codedInputStream.readBytes();
                                    break;
                                case 130:
                                    this.bitField0_ |= 32768;
                                    this.authorPortrait_ = codedInputStream.readBytes();
                                    break;
                                case 136:
                                    this.bitField0_ |= 65536;
                                    this.createTime_ = codedInputStream.readInt32();
                                    break;
                                case 144:
                                    this.bitField0_ |= 131072;
                                    this.maxMemberNum_ = codedInputStream.readInt32();
                                    break;
                                case 152:
                                    this.bitField0_ |= 262144;
                                    this.memberNum_ = codedInputStream.readInt32();
                                    break;
                                case 160:
                                    this.bitField0_ |= 524288;
                                    this.groupType_ = codedInputStream.readInt32();
                                    break;
                                case 168:
                                    this.bitField0_ |= 1048576;
                                    this.lastMsgId_ = codedInputStream.readInt64();
                                    break;
                                case 176:
                                    this.bitField0_ |= 2097152;
                                    this.grade_ = codedInputStream.readInt32();
                                    break;
                                case 184:
                                    this.bitField0_ |= 4194304;
                                    this.distance_ = codedInputStream.readInt32();
                                    break;
                                case 192:
                                    this.bitField0_ |= 8388608;
                                    this.isHidePosition_ = codedInputStream.readInt32();
                                    break;
                                case 202:
                                    this.bitField0_ |= 16777216;
                                    this.forumName_ = codedInputStream.readBytes();
                                    break;
                                case 210:
                                    this.bitField0_ |= 33554432;
                                    this.nickName_ = codedInputStream.readBytes();
                                    break;
                                case 216:
                                    this.bitField0_ |= 67108864;
                                    this.activeDay_ = codedInputStream.readInt32();
                                    break;
                                case 224:
                                    this.bitField0_ |= 134217728;
                                    this.isGroupManager_ = codedInputStream.readInt32();
                                    break;
                                case 232:
                                    this.bitField0_ |= 268435456;
                                    this.authorIsMeizhi_ = codedInputStream.readInt32();
                                    break;
                                case 240:
                                    this.bitField0_ |= 536870912;
                                    this.lastMsgTime_ = codedInputStream.readInt32();
                                    break;
                                case 250:
                                    this.bitField0_ |= 1073741824;
                                    this.forumShowName_ = codedInputStream.readBytes();
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
        public Parser<GroupInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasGroupId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getGroupId() {
            return this.groupId_;
        }

        public boolean hasForumId() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getForumId() {
            return this.forumId_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
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
            return (this.bitField0_ & 8) == 8;
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
            return (this.bitField0_ & 16) == 16;
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
            return (this.bitField0_ & 32) == 32;
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
            return (this.bitField0_ & 64) == 64;
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
            return (this.bitField0_ & DERTags.TAGGED) == 128;
        }

        public double getLng() {
            return this.lng_;
        }

        public boolean hasLat() {
            return (this.bitField0_ & 256) == 256;
        }

        public double getLat() {
            return this.lat_;
        }

        public boolean hasNotice() {
            return (this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512;
        }

        public String getNotice() {
            Object obj = this.notice_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.notice_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNoticeBytes() {
            Object obj = this.notice_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.notice_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasAlbum() {
            return (this.bitField0_ & NotificationProxy.MAX_URL_LENGTH) == 1024;
        }

        public String getAlbum() {
            Object obj = this.album_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.album_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAlbumBytes() {
            Object obj = this.album_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.album_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasStatus() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public int getStatus() {
            return this.status_;
        }

        public boolean hasFlag() {
            return (this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096;
        }

        public int getFlag() {
            return this.flag_;
        }

        public boolean hasAuthorId() {
            return (this.bitField0_ & 8192) == 8192;
        }

        public int getAuthorId() {
            return this.authorId_;
        }

        public boolean hasAuthorName() {
            return (this.bitField0_ & 16384) == 16384;
        }

        public String getAuthorName() {
            Object obj = this.authorName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.authorName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAuthorNameBytes() {
            Object obj = this.authorName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.authorName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasAuthorPortrait() {
            return (this.bitField0_ & 32768) == 32768;
        }

        public String getAuthorPortrait() {
            Object obj = this.authorPortrait_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.authorPortrait_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAuthorPortraitBytes() {
            Object obj = this.authorPortrait_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.authorPortrait_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasCreateTime() {
            return (this.bitField0_ & 65536) == 65536;
        }

        public int getCreateTime() {
            return this.createTime_;
        }

        public boolean hasMaxMemberNum() {
            return (this.bitField0_ & 131072) == 131072;
        }

        public int getMaxMemberNum() {
            return this.maxMemberNum_;
        }

        public boolean hasMemberNum() {
            return (this.bitField0_ & 262144) == 262144;
        }

        public int getMemberNum() {
            return this.memberNum_;
        }

        public boolean hasGroupType() {
            return (this.bitField0_ & 524288) == 524288;
        }

        public int getGroupType() {
            return this.groupType_;
        }

        public boolean hasLastMsgId() {
            return (this.bitField0_ & 1048576) == 1048576;
        }

        public long getLastMsgId() {
            return this.lastMsgId_;
        }

        public boolean hasGrade() {
            return (this.bitField0_ & 2097152) == 2097152;
        }

        public int getGrade() {
            return this.grade_;
        }

        public boolean hasDistance() {
            return (this.bitField0_ & 4194304) == 4194304;
        }

        public int getDistance() {
            return this.distance_;
        }

        public boolean hasIsHidePosition() {
            return (this.bitField0_ & 8388608) == 8388608;
        }

        public int getIsHidePosition() {
            return this.isHidePosition_;
        }

        public boolean hasForumName() {
            return (this.bitField0_ & 16777216) == 16777216;
        }

        public String getForumName() {
            Object obj = this.forumName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.forumName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getForumNameBytes() {
            Object obj = this.forumName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.forumName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasNickName() {
            return (this.bitField0_ & 33554432) == 33554432;
        }

        public String getNickName() {
            Object obj = this.nickName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.nickName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNickNameBytes() {
            Object obj = this.nickName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nickName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasActiveDay() {
            return (this.bitField0_ & 67108864) == 67108864;
        }

        public int getActiveDay() {
            return this.activeDay_;
        }

        public boolean hasIsGroupManager() {
            return (this.bitField0_ & 134217728) == 134217728;
        }

        public int getIsGroupManager() {
            return this.isGroupManager_;
        }

        public boolean hasAuthorIsMeizhi() {
            return (this.bitField0_ & 268435456) == 268435456;
        }

        public int getAuthorIsMeizhi() {
            return this.authorIsMeizhi_;
        }

        public boolean hasLastMsgTime() {
            return (this.bitField0_ & 536870912) == 536870912;
        }

        public int getLastMsgTime() {
            return this.lastMsgTime_;
        }

        public boolean hasForumShowName() {
            return (this.bitField0_ & 1073741824) == 1073741824;
        }

        public String getForumShowName() {
            Object obj = this.forumShowName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.forumShowName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getForumShowNameBytes() {
            Object obj = this.forumShowName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.forumShowName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void a() {
            this.groupId_ = 0;
            this.forumId_ = 0;
            this.name_ = "";
            this.intro_ = "";
            this.portrait_ = "";
            this.position_ = "";
            this.business_ = "";
            this.lng_ = 0.0d;
            this.lat_ = 0.0d;
            this.notice_ = "";
            this.album_ = "";
            this.status_ = 0;
            this.flag_ = 0;
            this.authorId_ = 0;
            this.authorName_ = "";
            this.authorPortrait_ = "";
            this.createTime_ = 0;
            this.maxMemberNum_ = 0;
            this.memberNum_ = 0;
            this.groupType_ = 0;
            this.lastMsgId_ = 0L;
            this.grade_ = 0;
            this.distance_ = 0;
            this.isHidePosition_ = 0;
            this.forumName_ = "";
            this.nickName_ = "";
            this.activeDay_ = 0;
            this.isGroupManager_ = 0;
            this.authorIsMeizhi_ = 0;
            this.lastMsgTime_ = 0;
            this.forumShowName_ = "";
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
                codedOutputStream.writeInt32(2, this.forumId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getNameBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getIntroBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(5, getPortraitBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getPositionBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBytes(7, getBusinessBytes());
            }
            if ((this.bitField0_ & DERTags.TAGGED) == 128) {
                codedOutputStream.writeDouble(8, this.lng_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeDouble(9, this.lat_);
            }
            if ((this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512) {
                codedOutputStream.writeBytes(10, getNoticeBytes());
            }
            if ((this.bitField0_ & NotificationProxy.MAX_URL_LENGTH) == 1024) {
                codedOutputStream.writeBytes(11, getAlbumBytes());
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt32(12, this.status_);
            }
            if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                codedOutputStream.writeInt32(13, this.flag_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.writeInt32(14, this.authorId_);
            }
            if ((this.bitField0_ & 16384) == 16384) {
                codedOutputStream.writeBytes(15, getAuthorNameBytes());
            }
            if ((this.bitField0_ & 32768) == 32768) {
                codedOutputStream.writeBytes(16, getAuthorPortraitBytes());
            }
            if ((this.bitField0_ & 65536) == 65536) {
                codedOutputStream.writeInt32(17, this.createTime_);
            }
            if ((this.bitField0_ & 131072) == 131072) {
                codedOutputStream.writeInt32(18, this.maxMemberNum_);
            }
            if ((this.bitField0_ & 262144) == 262144) {
                codedOutputStream.writeInt32(19, this.memberNum_);
            }
            if ((this.bitField0_ & 524288) == 524288) {
                codedOutputStream.writeInt32(20, this.groupType_);
            }
            if ((this.bitField0_ & 1048576) == 1048576) {
                codedOutputStream.writeInt64(21, this.lastMsgId_);
            }
            if ((this.bitField0_ & 2097152) == 2097152) {
                codedOutputStream.writeInt32(22, this.grade_);
            }
            if ((this.bitField0_ & 4194304) == 4194304) {
                codedOutputStream.writeInt32(23, this.distance_);
            }
            if ((this.bitField0_ & 8388608) == 8388608) {
                codedOutputStream.writeInt32(24, this.isHidePosition_);
            }
            if ((this.bitField0_ & 16777216) == 16777216) {
                codedOutputStream.writeBytes(25, getForumNameBytes());
            }
            if ((this.bitField0_ & 33554432) == 33554432) {
                codedOutputStream.writeBytes(26, getNickNameBytes());
            }
            if ((this.bitField0_ & 67108864) == 67108864) {
                codedOutputStream.writeInt32(27, this.activeDay_);
            }
            if ((this.bitField0_ & 134217728) == 134217728) {
                codedOutputStream.writeInt32(28, this.isGroupManager_);
            }
            if ((this.bitField0_ & 268435456) == 268435456) {
                codedOutputStream.writeInt32(29, this.authorIsMeizhi_);
            }
            if ((this.bitField0_ & 536870912) == 536870912) {
                codedOutputStream.writeInt32(30, this.lastMsgTime_);
            }
            if ((this.bitField0_ & 1073741824) == 1073741824) {
                codedOutputStream.writeBytes(31, getForumShowNameBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.groupId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.forumId_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getNameBytes());
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getIntroBytes());
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, getPortraitBytes());
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getPositionBytes());
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeBytesSize(7, getBusinessBytes());
                }
                if ((this.bitField0_ & DERTags.TAGGED) == 128) {
                    i += CodedOutputStream.computeDoubleSize(8, this.lng_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeDoubleSize(9, this.lat_);
                }
                if ((this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512) {
                    i += CodedOutputStream.computeBytesSize(10, getNoticeBytes());
                }
                if ((this.bitField0_ & NotificationProxy.MAX_URL_LENGTH) == 1024) {
                    i += CodedOutputStream.computeBytesSize(11, getAlbumBytes());
                }
                if ((this.bitField0_ & 2048) == 2048) {
                    i += CodedOutputStream.computeInt32Size(12, this.status_);
                }
                if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                    i += CodedOutputStream.computeInt32Size(13, this.flag_);
                }
                if ((this.bitField0_ & 8192) == 8192) {
                    i += CodedOutputStream.computeInt32Size(14, this.authorId_);
                }
                if ((this.bitField0_ & 16384) == 16384) {
                    i += CodedOutputStream.computeBytesSize(15, getAuthorNameBytes());
                }
                if ((this.bitField0_ & 32768) == 32768) {
                    i += CodedOutputStream.computeBytesSize(16, getAuthorPortraitBytes());
                }
                if ((this.bitField0_ & 65536) == 65536) {
                    i += CodedOutputStream.computeInt32Size(17, this.createTime_);
                }
                if ((this.bitField0_ & 131072) == 131072) {
                    i += CodedOutputStream.computeInt32Size(18, this.maxMemberNum_);
                }
                if ((this.bitField0_ & 262144) == 262144) {
                    i += CodedOutputStream.computeInt32Size(19, this.memberNum_);
                }
                if ((this.bitField0_ & 524288) == 524288) {
                    i += CodedOutputStream.computeInt32Size(20, this.groupType_);
                }
                if ((this.bitField0_ & 1048576) == 1048576) {
                    i += CodedOutputStream.computeInt64Size(21, this.lastMsgId_);
                }
                if ((this.bitField0_ & 2097152) == 2097152) {
                    i += CodedOutputStream.computeInt32Size(22, this.grade_);
                }
                if ((this.bitField0_ & 4194304) == 4194304) {
                    i += CodedOutputStream.computeInt32Size(23, this.distance_);
                }
                if ((this.bitField0_ & 8388608) == 8388608) {
                    i += CodedOutputStream.computeInt32Size(24, this.isHidePosition_);
                }
                if ((this.bitField0_ & 16777216) == 16777216) {
                    i += CodedOutputStream.computeBytesSize(25, getForumNameBytes());
                }
                if ((this.bitField0_ & 33554432) == 33554432) {
                    i += CodedOutputStream.computeBytesSize(26, getNickNameBytes());
                }
                if ((this.bitField0_ & 67108864) == 67108864) {
                    i += CodedOutputStream.computeInt32Size(27, this.activeDay_);
                }
                if ((this.bitField0_ & 134217728) == 134217728) {
                    i += CodedOutputStream.computeInt32Size(28, this.isGroupManager_);
                }
                if ((this.bitField0_ & 268435456) == 268435456) {
                    i += CodedOutputStream.computeInt32Size(29, this.authorIsMeizhi_);
                }
                if ((this.bitField0_ & 536870912) == 536870912) {
                    i += CodedOutputStream.computeInt32Size(30, this.lastMsgTime_);
                }
                if ((this.bitField0_ & 1073741824) == 1073741824) {
                    i += CodedOutputStream.computeBytesSize(31, getForumShowNameBytes());
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

        public static GroupInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static GroupInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GroupInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static GroupInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static GroupInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static GroupInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static GroupInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static GroupInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static GroupInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static GroupInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static i newBuilder() {
            i h;
            h = i.h();
            return h;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public i newBuilderForType() {
            return newBuilder();
        }

        public static i newBuilder(GroupInfo groupInfo) {
            return newBuilder().mergeFrom(groupInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public i toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class GradeInfo extends GeneratedMessageLite implements g {
        public static final int GRADE_FIELD_NUMBER = 1;
        public static final int INTRO_FIELD_NUMBER = 2;
        public static final int MAXMEMBERNUM_FIELD_NUMBER = 4;
        public static final int THRESHOLDDAY_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int grade_;
        private Object intro_;
        private int maxMemberNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int thresholdDay_;
        public static Parser<GradeInfo> PARSER = new e();
        private static final GradeInfo a = new GradeInfo(true);

        private GradeInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GradeInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GradeInfo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public GradeInfo getDefaultInstanceForType() {
            return a;
        }

        private GradeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.grade_ = codedInputStream.readInt32();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.intro_ = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.bitField0_ |= 4;
                                    this.thresholdDay_ = codedInputStream.readInt32();
                                    break;
                                case 32:
                                    this.bitField0_ |= 8;
                                    this.maxMemberNum_ = codedInputStream.readInt32();
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
        public Parser<GradeInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasGrade() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getGrade() {
            return this.grade_;
        }

        public boolean hasIntro() {
            return (this.bitField0_ & 2) == 2;
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

        public boolean hasThresholdDay() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getThresholdDay() {
            return this.thresholdDay_;
        }

        public boolean hasMaxMemberNum() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getMaxMemberNum() {
            return this.maxMemberNum_;
        }

        private void a() {
            this.grade_ = 0;
            this.intro_ = "";
            this.thresholdDay_ = 0;
            this.maxMemberNum_ = 0;
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
                codedOutputStream.writeInt32(1, this.grade_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getIntroBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.thresholdDay_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.maxMemberNum_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.grade_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getIntroBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.thresholdDay_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(4, this.maxMemberNum_);
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

        public static GradeInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static GradeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GradeInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static GradeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static GradeInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static GradeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static GradeInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static GradeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static GradeInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static GradeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static f newBuilder(GradeInfo gradeInfo) {
            return newBuilder().mergeFrom(gradeInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public f toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class MsgInfo extends GeneratedMessageLite implements v {
        public static final int CONTENT_FIELD_NUMBER = 5;
        public static final int CREATETIME_FIELD_NUMBER = 8;
        public static final int DURATION_FIELD_NUMBER = 7;
        public static final int GROUPID_FIELD_NUMBER = 2;
        public static final int MSGID_FIELD_NUMBER = 1;
        public static final int MSGTYPE_FIELD_NUMBER = 3;
        public static final int RECORDID_FIELD_NUMBER = 9;
        public static final int STATUS_FIELD_NUMBER = 6;
        public static final int TOUID_FIELD_NUMBER = 11;
        public static final int TOUSERINFO_FIELD_NUMBER = 12;
        public static final int USERID_FIELD_NUMBER = 4;
        public static final int USERINFO_FIELD_NUMBER = 10;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object content_;
        private int createTime_;
        private int duration_;
        private int groupId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long msgId_;
        private int msgType_;
        private long recordId_;
        private int status_;
        private long toUid_;
        private UserInfo toUserInfo_;
        private long userId_;
        private UserInfo userInfo_;
        public static Parser<MsgInfo> PARSER = new t();
        private static final MsgInfo a = new MsgInfo(true);

        private MsgInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MsgInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MsgInfo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MsgInfo getDefaultInstanceForType() {
            return a;
        }

        private MsgInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                this.msgId_ = codedInputStream.readInt64();
                                z = z2;
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.groupId_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case 24:
                                this.bitField0_ |= 4;
                                this.msgType_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case 32:
                                this.bitField0_ |= 8;
                                this.userId_ = codedInputStream.readInt64();
                                z = z2;
                                break;
                            case 42:
                                this.bitField0_ |= 16;
                                this.content_ = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case 48:
                                this.bitField0_ |= 32;
                                this.status_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case 56:
                                this.bitField0_ |= 64;
                                this.duration_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case DERTags.APPLICATION /* 64 */:
                                this.bitField0_ |= DERTags.TAGGED;
                                this.createTime_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case 72:
                                this.bitField0_ |= 256;
                                this.recordId_ = codedInputStream.readInt64();
                                z = z2;
                                break;
                            case 82:
                                ad builder = (this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512 ? this.userInfo_.toBuilder() : null;
                                this.userInfo_ = (UserInfo) codedInputStream.readMessage(UserInfo.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.userInfo_);
                                    this.userInfo_ = builder.buildPartial();
                                }
                                this.bitField0_ |= ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
                                z = z2;
                                break;
                            case 88:
                                this.bitField0_ |= NotificationProxy.MAX_URL_LENGTH;
                                this.toUid_ = codedInputStream.readInt64();
                                z = z2;
                                break;
                            case 98:
                                ad builder2 = (this.bitField0_ & 2048) == 2048 ? this.toUserInfo_.toBuilder() : null;
                                this.toUserInfo_ = (UserInfo) codedInputStream.readMessage(UserInfo.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.toUserInfo_);
                                    this.toUserInfo_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2048;
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
        public Parser<MsgInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasMsgId() {
            return (this.bitField0_ & 1) == 1;
        }

        public long getMsgId() {
            return this.msgId_;
        }

        public boolean hasGroupId() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getGroupId() {
            return this.groupId_;
        }

        public boolean hasMsgType() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getMsgType() {
            return this.msgType_;
        }

        public boolean hasUserId() {
            return (this.bitField0_ & 8) == 8;
        }

        public long getUserId() {
            return this.userId_;
        }

        public boolean hasContent() {
            return (this.bitField0_ & 16) == 16;
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

        public boolean hasStatus() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getStatus() {
            return this.status_;
        }

        public boolean hasDuration() {
            return (this.bitField0_ & 64) == 64;
        }

        public int getDuration() {
            return this.duration_;
        }

        public boolean hasCreateTime() {
            return (this.bitField0_ & DERTags.TAGGED) == 128;
        }

        public int getCreateTime() {
            return this.createTime_;
        }

        public boolean hasRecordId() {
            return (this.bitField0_ & 256) == 256;
        }

        public long getRecordId() {
            return this.recordId_;
        }

        public boolean hasUserInfo() {
            return (this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512;
        }

        public UserInfo getUserInfo() {
            return this.userInfo_;
        }

        public boolean hasToUid() {
            return (this.bitField0_ & NotificationProxy.MAX_URL_LENGTH) == 1024;
        }

        public long getToUid() {
            return this.toUid_;
        }

        public boolean hasToUserInfo() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public UserInfo getToUserInfo() {
            return this.toUserInfo_;
        }

        private void a() {
            this.msgId_ = 0L;
            this.groupId_ = 0;
            this.msgType_ = 0;
            this.userId_ = 0L;
            this.content_ = "";
            this.status_ = 0;
            this.duration_ = 0;
            this.createTime_ = 0;
            this.recordId_ = 0L;
            this.userInfo_ = UserInfo.getDefaultInstance();
            this.toUid_ = 0L;
            this.toUserInfo_ = UserInfo.getDefaultInstance();
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
                codedOutputStream.writeInt64(1, this.msgId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.groupId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.msgType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.userId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(5, getContentBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.status_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(7, this.duration_);
            }
            if ((this.bitField0_ & DERTags.TAGGED) == 128) {
                codedOutputStream.writeInt32(8, this.createTime_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt64(9, this.recordId_);
            }
            if ((this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512) {
                codedOutputStream.writeMessage(10, this.userInfo_);
            }
            if ((this.bitField0_ & NotificationProxy.MAX_URL_LENGTH) == 1024) {
                codedOutputStream.writeInt64(11, this.toUid_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeMessage(12, this.toUserInfo_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.msgId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.groupId_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.msgType_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.userId_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, getContentBytes());
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeInt32Size(6, this.status_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeInt32Size(7, this.duration_);
                }
                if ((this.bitField0_ & DERTags.TAGGED) == 128) {
                    i += CodedOutputStream.computeInt32Size(8, this.createTime_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeInt64Size(9, this.recordId_);
                }
                if ((this.bitField0_ & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512) {
                    i += CodedOutputStream.computeMessageSize(10, this.userInfo_);
                }
                if ((this.bitField0_ & NotificationProxy.MAX_URL_LENGTH) == 1024) {
                    i += CodedOutputStream.computeInt64Size(11, this.toUid_);
                }
                if ((this.bitField0_ & 2048) == 2048) {
                    i += CodedOutputStream.computeMessageSize(12, this.toUserInfo_);
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

        public static MsgInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static MsgInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MsgInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static MsgInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MsgInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static MsgInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static MsgInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static MsgInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static MsgInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static MsgInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static u newBuilder() {
            return u.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public u newBuilderForType() {
            return newBuilder();
        }

        public static u newBuilder(MsgInfo msgInfo) {
            return newBuilder().mergeFrom(msgInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public u toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class PusherMsgInfo extends GeneratedMessageLite implements ab {
        public static final int GROUPID_FIELD_NUMBER = 1;
        public static final int MSGID_FIELD_NUMBER = 2;
        public static final int PUSHTIME_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int groupId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long msgId_;
        private long pushTime_;
        public static Parser<PusherMsgInfo> PARSER = new z();
        private static final PusherMsgInfo a = new PusherMsgInfo(true);

        private PusherMsgInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private PusherMsgInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static PusherMsgInfo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public PusherMsgInfo getDefaultInstanceForType() {
            return a;
        }

        private PusherMsgInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.groupId_ = codedInputStream.readInt32();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.msgId_ = codedInputStream.readInt64();
                                    break;
                                case 24:
                                    this.bitField0_ |= 4;
                                    this.pushTime_ = codedInputStream.readInt64();
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
        public Parser<PusherMsgInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasGroupId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getGroupId() {
            return this.groupId_;
        }

        public boolean hasMsgId() {
            return (this.bitField0_ & 2) == 2;
        }

        public long getMsgId() {
            return this.msgId_;
        }

        public boolean hasPushTime() {
            return (this.bitField0_ & 4) == 4;
        }

        public long getPushTime() {
            return this.pushTime_;
        }

        private void a() {
            this.groupId_ = 0;
            this.msgId_ = 0L;
            this.pushTime_ = 0L;
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
                codedOutputStream.writeInt64(2, this.msgId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.pushTime_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.groupId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.msgId_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.pushTime_);
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

        public static PusherMsgInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static PusherMsgInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PusherMsgInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static PusherMsgInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PusherMsgInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static PusherMsgInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static PusherMsgInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static PusherMsgInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static PusherMsgInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static PusherMsgInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static aa newBuilder() {
            return aa.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public aa newBuilderForType() {
            return newBuilder();
        }

        public static aa newBuilder(PusherMsgInfo pusherMsgInfo) {
            return newBuilder().mergeFrom(pusherMsgInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public aa toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class GroupLastId extends GeneratedMessageLite implements m {
        public static final int GROUPID_FIELD_NUMBER = 1;
        public static final int LASTMSGID_FIELD_NUMBER = 2;
        public static Parser<GroupLastId> PARSER = new k();
        private static final GroupLastId a = new GroupLastId(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int groupId_;
        private long lastMsgId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private GroupLastId(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GroupLastId(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GroupLastId getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public GroupLastId getDefaultInstanceForType() {
            return a;
        }

        private GroupLastId(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.groupId_ = codedInputStream.readInt32();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
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
        public Parser<GroupLastId> getParserForType() {
            return PARSER;
        }

        public boolean hasGroupId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getGroupId() {
            return this.groupId_;
        }

        public boolean hasLastMsgId() {
            return (this.bitField0_ & 2) == 2;
        }

        public long getLastMsgId() {
            return this.lastMsgId_;
        }

        private void a() {
            this.groupId_ = 0;
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
                codedOutputStream.writeInt64(2, this.lastMsgId_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.groupId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.lastMsgId_);
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

        public static GroupLastId parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static GroupLastId parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GroupLastId parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static GroupLastId parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static GroupLastId parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static GroupLastId parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static GroupLastId parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static GroupLastId parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static GroupLastId parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static GroupLastId parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static l newBuilder() {
            return l.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public l newBuilderForType() {
            return newBuilder();
        }

        public static l newBuilder(GroupLastId groupLastId) {
            return newBuilder().mergeFrom(groupLastId);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public l toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class Photo extends GeneratedMessageLite implements y {
        public static final int BIGURL_FIELD_NUMBER = 2;
        public static final int PICID_FIELD_NUMBER = 3;
        public static final int SMALLURL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private Object bigurl_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object picId_;
        private Object smallurl_;
        public static Parser<Photo> PARSER = new w();
        private static final Photo a = new Photo(true);

        private Photo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Photo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Photo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Photo getDefaultInstanceForType() {
            return a;
        }

        private Photo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.smallurl_ = codedInputStream.readBytes();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.bigurl_ = codedInputStream.readBytes();
                                    break;
                                case 26:
                                    this.bitField0_ |= 4;
                                    this.picId_ = codedInputStream.readBytes();
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
        public Parser<Photo> getParserForType() {
            return PARSER;
        }

        public boolean hasSmallurl() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getSmallurl() {
            Object obj = this.smallurl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.smallurl_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getSmallurlBytes() {
            Object obj = this.smallurl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.smallurl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasBigurl() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getBigurl() {
            Object obj = this.bigurl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.bigurl_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getBigurlBytes() {
            Object obj = this.bigurl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bigurl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasPicId() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getPicId() {
            Object obj = this.picId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.picId_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPicIdBytes() {
            Object obj = this.picId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.picId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void a() {
            this.smallurl_ = "";
            this.bigurl_ = "";
            this.picId_ = "";
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
                codedOutputStream.writeBytes(1, getSmallurlBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getBigurlBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getPicIdBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getSmallurlBytes()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getBigurlBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getPicIdBytes());
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

        public static Photo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static Photo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Photo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static Photo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Photo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static Photo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Photo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Photo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Photo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Photo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static x newBuilder() {
            return x.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public x newBuilderForType() {
            return newBuilder();
        }

        public static x newBuilder(Photo photo) {
            return newBuilder().mergeFrom(photo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public x toBuilder() {
            return newBuilder(this);
        }
    }
}
