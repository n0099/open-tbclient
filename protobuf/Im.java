package protobuf;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
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
/* loaded from: classes.dex */
public final class Im {

    /* loaded from: classes.dex */
    public final class Error extends GeneratedMessageLite implements f {
        public static final int ERRORNO_FIELD_NUMBER = 1;
        public static Parser<Error> PARSER = new d();
        public static final int USERMSG_FIELD_NUMBER = 2;
        private static final Error a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errorno_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object usermsg_;

        public /* synthetic */ Error(GeneratedMessageLite.Builder builder, Error error) {
            this(builder);
        }

        private Error(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Error() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Error getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final Error getDefaultInstanceForType() {
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
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.errorno_ = codedInputStream.readInt32();
                                break;
                            case GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
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

        public /* synthetic */ Error(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Error error) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            Error error = new Error();
            a = error;
            error.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<Error> getParserForType() {
            return PARSER;
        }

        public final boolean hasErrorno() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getErrorno() {
            return this.errorno_;
        }

        public final boolean hasUsermsg() {
            return (this.bitField0_ & 2) == 2;
        }

        public final String getUsermsg() {
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

        public final ByteString getUsermsgBytes() {
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
        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.errorno_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getUsermsgBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt32Size(1, this.errorno_) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getUsermsgBytes());
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static e newBuilder() {
            return e.b();
        }

        @Override // com.google.protobuf.MessageLite
        public final e newBuilderForType() {
            return newBuilder();
        }

        public static e newBuilder(Error error) {
            return newBuilder().mergeFrom(error);
        }

        @Override // com.google.protobuf.MessageLite
        public final e toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class UserPermission extends GeneratedMessageLite implements am {
        public static final int ISGROUPMANAGER_FIELD_NUMBER = 2;
        public static final int ISGROUPOWNER_FIELD_NUMBER = 1;
        public static Parser<UserPermission> PARSER = new ak();
        private static final UserPermission a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int isGroupManager_;
        private int isGroupOwner_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        public /* synthetic */ UserPermission(GeneratedMessageLite.Builder builder, UserPermission userPermission) {
            this(builder);
        }

        private UserPermission(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UserPermission() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UserPermission getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final UserPermission getDefaultInstanceForType() {
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

        public /* synthetic */ UserPermission(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UserPermission userPermission) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            UserPermission userPermission = new UserPermission();
            a = userPermission;
            userPermission.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<UserPermission> getParserForType() {
            return PARSER;
        }

        public final boolean hasIsGroupOwner() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getIsGroupOwner() {
            return this.isGroupOwner_;
        }

        public final boolean hasIsGroupManager() {
            return (this.bitField0_ & 2) == 2;
        }

        public final int getIsGroupManager() {
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
        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.isGroupOwner_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.isGroupManager_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt32Size(1, this.isGroupOwner_) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.isGroupManager_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static al newBuilder() {
            return al.b();
        }

        @Override // com.google.protobuf.MessageLite
        public final al newBuilderForType() {
            return newBuilder();
        }

        public static al newBuilder(UserPermission userPermission) {
            return newBuilder().mergeFrom(userPermission);
        }

        @Override // com.google.protobuf.MessageLite
        public final al toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class GroupPermission extends GeneratedMessageLite implements r {
        public static final int CANCREATENORMALNUM_FIELD_NUMBER = 8;
        public static final int CANCREATENORMAL_FIELD_NUMBER = 2;
        public static final int CANCREATEOFFICIALNUM_FIELD_NUMBER = 9;
        public static final int CANCREATEOFFICIAL_FIELD_NUMBER = 3;
        public static final int CANCREATEPERSONALNUM_FIELD_NUMBER = 10;
        public static final int CANCREATEPERSONAL_FIELD_NUMBER = 4;
        public static final int CREATENORMALTIP_FIELD_NUMBER = 5;
        public static final int CREATEOFFICIALTIP_FIELD_NUMBER = 6;
        public static final int CREATEPERSONALTIP_FIELD_NUMBER = 7;
        public static final int ISFORUMMANAGER_FIELD_NUMBER = 1;
        public static Parser<GroupPermission> PARSER = new p();
        private static final GroupPermission a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int canCreateNormalNum_;
        private int canCreateNormal_;
        private int canCreateOfficialNum_;
        private int canCreateOfficial_;
        private int canCreatePersonalNum_;
        private int canCreatePersonal_;
        private Object createNormalTip_;
        private Object createOfficialTip_;
        private Object createPersonalTip_;
        private int isForumManager_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        public /* synthetic */ GroupPermission(GeneratedMessageLite.Builder builder, GroupPermission groupPermission) {
            this(builder);
        }

        private GroupPermission(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GroupPermission() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GroupPermission getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final GroupPermission getDefaultInstanceForType() {
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
                            case GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
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
                            case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /* 64 */:
                                this.bitField0_ |= 128;
                                this.canCreateNormalNum_ = codedInputStream.readInt32();
                                break;
                            case 72:
                                this.bitField0_ |= 256;
                                this.canCreateOfficialNum_ = codedInputStream.readInt32();
                                break;
                            case com.baidu.loginshare.e.i /* 80 */:
                                this.bitField0_ |= 512;
                                this.canCreatePersonalNum_ = codedInputStream.readInt32();
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

        public /* synthetic */ GroupPermission(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, GroupPermission groupPermission) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            GroupPermission groupPermission = new GroupPermission();
            a = groupPermission;
            groupPermission.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<GroupPermission> getParserForType() {
            return PARSER;
        }

        public final boolean hasIsForumManager() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getIsForumManager() {
            return this.isForumManager_;
        }

        public final boolean hasCanCreateNormal() {
            return (this.bitField0_ & 2) == 2;
        }

        public final int getCanCreateNormal() {
            return this.canCreateNormal_;
        }

        public final boolean hasCanCreateOfficial() {
            return (this.bitField0_ & 4) == 4;
        }

        public final int getCanCreateOfficial() {
            return this.canCreateOfficial_;
        }

        public final boolean hasCanCreatePersonal() {
            return (this.bitField0_ & 8) == 8;
        }

        public final int getCanCreatePersonal() {
            return this.canCreatePersonal_;
        }

        public final boolean hasCreateNormalTip() {
            return (this.bitField0_ & 16) == 16;
        }

        public final String getCreateNormalTip() {
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

        public final ByteString getCreateNormalTipBytes() {
            Object obj = this.createNormalTip_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.createNormalTip_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasCreateOfficialTip() {
            return (this.bitField0_ & 32) == 32;
        }

        public final String getCreateOfficialTip() {
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

        public final ByteString getCreateOfficialTipBytes() {
            Object obj = this.createOfficialTip_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.createOfficialTip_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasCreatePersonalTip() {
            return (this.bitField0_ & 64) == 64;
        }

        public final String getCreatePersonalTip() {
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

        public final ByteString getCreatePersonalTipBytes() {
            Object obj = this.createPersonalTip_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.createPersonalTip_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasCanCreateNormalNum() {
            return (this.bitField0_ & 128) == 128;
        }

        public final int getCanCreateNormalNum() {
            return this.canCreateNormalNum_;
        }

        public final boolean hasCanCreateOfficialNum() {
            return (this.bitField0_ & 256) == 256;
        }

        public final int getCanCreateOfficialNum() {
            return this.canCreateOfficialNum_;
        }

        public final boolean hasCanCreatePersonalNum() {
            return (this.bitField0_ & 512) == 512;
        }

        public final int getCanCreatePersonalNum() {
            return this.canCreatePersonalNum_;
        }

        private void a() {
            this.isForumManager_ = 0;
            this.canCreateNormal_ = 0;
            this.canCreateOfficial_ = 0;
            this.canCreatePersonal_ = 0;
            this.createNormalTip_ = "";
            this.createOfficialTip_ = "";
            this.createPersonalTip_ = "";
            this.canCreateNormalNum_ = 0;
            this.canCreateOfficialNum_ = 0;
            this.canCreatePersonalNum_ = 0;
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
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(8, this.canCreateNormalNum_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(9, this.canCreateOfficialNum_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(10, this.canCreatePersonalNum_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt32Size(1, this.isForumManager_) + 0;
                }
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
                if ((this.bitField0_ & 128) == 128) {
                    i += CodedOutputStream.computeInt32Size(8, this.canCreateNormalNum_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeInt32Size(9, this.canCreateOfficialNum_);
                }
                if ((this.bitField0_ & 512) == 512) {
                    i += CodedOutputStream.computeInt32Size(10, this.canCreatePersonalNum_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static q newBuilder() {
            return q.b();
        }

        @Override // com.google.protobuf.MessageLite
        public final q newBuilderForType() {
            return newBuilder();
        }

        public static q newBuilder(GroupPermission groupPermission) {
            return newBuilder().mergeFrom(groupPermission);
        }

        @Override // com.google.protobuf.MessageLite
        public final q toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class TshowInfo extends GeneratedMessageLite implements ag {
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        public static Parser<TshowInfo> PARSER = new ae();
        public static final int URL_FIELD_NUMBER = 3;
        private static final TshowInfo a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object icon_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private Object url_;

        public /* synthetic */ TshowInfo(GeneratedMessageLite.Builder builder, TshowInfo tshowInfo) {
            this(builder);
        }

        private TshowInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private TshowInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static TshowInfo getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final TshowInfo getDefaultInstanceForType() {
            return a;
        }

        private TshowInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                this.bitField0_ |= 1;
                                this.icon_ = codedInputStream.readBytes();
                                break;
                            case GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.name_ = codedInputStream.readBytes();
                                break;
                            case GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                this.bitField0_ |= 4;
                                this.url_ = codedInputStream.readBytes();
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

        public /* synthetic */ TshowInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, TshowInfo tshowInfo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            TshowInfo tshowInfo = new TshowInfo();
            a = tshowInfo;
            tshowInfo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<TshowInfo> getParserForType() {
            return PARSER;
        }

        public final boolean hasIcon() {
            return (this.bitField0_ & 1) == 1;
        }

        public final String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.icon_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public final String getName() {
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

        public final ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasUrl() {
            return (this.bitField0_ & 4) == 4;
        }

        public final String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.url_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void a() {
            this.icon_ = "";
            this.name_ = "";
            this.url_ = "";
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
                codedOutputStream.writeBytes(1, getIconBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getUrlBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeBytesSize(1, getIconBytes()) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getNameBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getUrlBytes());
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
            return super.writeReplace();
        }

        public static TshowInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static TshowInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static TshowInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static TshowInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static TshowInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static TshowInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static TshowInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static TshowInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static TshowInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static TshowInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static af newBuilder() {
            return af.a();
        }

        @Override // com.google.protobuf.MessageLite
        public final af newBuilderForType() {
            return newBuilder();
        }

        public static af newBuilder(TshowInfo tshowInfo) {
            return newBuilder().mergeFrom(tshowInfo);
        }

        @Override // com.google.protobuf.MessageLite
        public final af toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class UserInfo extends GeneratedMessageLite implements aj {
        public static final int INTIME_FIELD_NUMBER = 9;
        public static final int LASTREPLYTIME_FIELD_NUMBER = 11;
        public static final int LAT_FIELD_NUMBER = 8;
        public static final int LNG_FIELD_NUMBER = 7;
        public static final int LOGINTIME_FIELD_NUMBER = 10;
        public static final int NICKNAME_FIELD_NUMBER = 3;
        public static Parser<UserInfo> PARSER = new ah();
        public static final int PERMISSION_FIELD_NUMBER = 13;
        public static final int PORTRAIT_FIELD_NUMBER = 4;
        public static final int POSITION_FIELD_NUMBER = 6;
        public static final int SEX_FIELD_NUMBER = 5;
        public static final int SYSGROUPID_FIELD_NUMBER = 12;
        public static final int TSHOWICON_FIELD_NUMBER = 14;
        public static final int USERID_FIELD_NUMBER = 1;
        public static final int USERNAME_FIELD_NUMBER = 2;
        public static final int USERTYPE_FIELD_NUMBER = 15;
        private static final UserInfo a;
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
        private List<TshowInfo> tshowIcon_;
        private int userId_;
        private Object userName_;
        private int userType_;

        public /* synthetic */ UserInfo(GeneratedMessageLite.Builder builder, UserInfo userInfo) {
            this(builder);
        }

        private UserInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UserInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UserInfo getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final UserInfo getDefaultInstanceForType() {
            return a;
        }

        private UserInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            al alVar;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z = false;
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
                                this.userId_ = codedInputStream.readInt32();
                                break;
                            case GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.userName_ = codedInputStream.readBytes();
                                break;
                            case GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                this.bitField0_ |= 4;
                                this.nickName_ = codedInputStream.readBytes();
                                break;
                            case GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                this.bitField0_ |= 8;
                                this.portrait_ = codedInputStream.readBytes();
                                break;
                            case 40:
                                this.bitField0_ |= 16;
                                this.sex_ = codedInputStream.readInt32();
                                break;
                            case 50:
                                this.bitField0_ |= 32;
                                this.position_ = codedInputStream.readBytes();
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
                                this.inTime_ = codedInputStream.readInt32();
                                break;
                            case com.baidu.loginshare.e.i /* 80 */:
                                this.bitField0_ |= 512;
                                this.loginTime_ = codedInputStream.readInt32();
                                break;
                            case 88:
                                this.bitField0_ |= 1024;
                                this.lastReplyTime_ = codedInputStream.readInt32();
                                break;
                            case 96:
                                this.bitField0_ |= 2048;
                                this.sysGroupId_ = codedInputStream.readInt32();
                                break;
                            case 106:
                                if ((this.bitField0_ & 4096) != 4096) {
                                    alVar = null;
                                } else {
                                    alVar = this.permission_.toBuilder();
                                }
                                this.permission_ = (UserPermission) codedInputStream.readMessage(UserPermission.PARSER, extensionRegistryLite);
                                if (alVar != null) {
                                    alVar.mergeFrom(this.permission_);
                                    this.permission_ = alVar.buildPartial();
                                }
                                this.bitField0_ |= 4096;
                                break;
                            case 114:
                                if (!(z2 & true)) {
                                    this.tshowIcon_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.tshowIcon_.add((TshowInfo) codedInputStream.readMessage(TshowInfo.PARSER, extensionRegistryLite));
                                break;
                            case 120:
                                this.bitField0_ |= 8192;
                                this.userType_ = codedInputStream.readInt32();
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
                        this.tshowIcon_ = Collections.unmodifiableList(this.tshowIcon_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public /* synthetic */ UserInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UserInfo userInfo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            UserInfo userInfo = new UserInfo();
            a = userInfo;
            userInfo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<UserInfo> getParserForType() {
            return PARSER;
        }

        public final boolean hasUserId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getUserId() {
            return this.userId_;
        }

        public final boolean hasUserName() {
            return (this.bitField0_ & 2) == 2;
        }

        public final String getUserName() {
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

        public final ByteString getUserNameBytes() {
            Object obj = this.userName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasNickName() {
            return (this.bitField0_ & 4) == 4;
        }

        public final String getNickName() {
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

        public final ByteString getNickNameBytes() {
            Object obj = this.nickName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nickName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasPortrait() {
            return (this.bitField0_ & 8) == 8;
        }

        public final String getPortrait() {
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

        public final ByteString getPortraitBytes() {
            Object obj = this.portrait_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.portrait_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasSex() {
            return (this.bitField0_ & 16) == 16;
        }

        public final int getSex() {
            return this.sex_;
        }

        public final boolean hasPosition() {
            return (this.bitField0_ & 32) == 32;
        }

        public final String getPosition() {
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

        public final ByteString getPositionBytes() {
            Object obj = this.position_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.position_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasLng() {
            return (this.bitField0_ & 64) == 64;
        }

        public final double getLng() {
            return this.lng_;
        }

        public final boolean hasLat() {
            return (this.bitField0_ & 128) == 128;
        }

        public final double getLat() {
            return this.lat_;
        }

        public final boolean hasInTime() {
            return (this.bitField0_ & 256) == 256;
        }

        public final int getInTime() {
            return this.inTime_;
        }

        public final boolean hasLoginTime() {
            return (this.bitField0_ & 512) == 512;
        }

        public final int getLoginTime() {
            return this.loginTime_;
        }

        public final boolean hasLastReplyTime() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public final int getLastReplyTime() {
            return this.lastReplyTime_;
        }

        public final boolean hasSysGroupId() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public final int getSysGroupId() {
            return this.sysGroupId_;
        }

        public final boolean hasPermission() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public final UserPermission getPermission() {
            return this.permission_;
        }

        public final List<TshowInfo> getTshowIconList() {
            return this.tshowIcon_;
        }

        public final List<? extends ag> getTshowIconOrBuilderList() {
            return this.tshowIcon_;
        }

        public final int getTshowIconCount() {
            return this.tshowIcon_.size();
        }

        public final TshowInfo getTshowIcon(int i) {
            return this.tshowIcon_.get(i);
        }

        public final ag getTshowIconOrBuilder(int i) {
            return this.tshowIcon_.get(i);
        }

        public final boolean hasUserType() {
            return (this.bitField0_ & 8192) == 8192;
        }

        public final int getUserType() {
            return this.userType_;
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
            this.tshowIcon_ = Collections.emptyList();
            this.userType_ = 0;
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
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeDouble(8, this.lat_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(9, this.inTime_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(10, this.loginTime_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeInt32(11, this.lastReplyTime_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt32(12, this.sysGroupId_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeMessage(13, this.permission_);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.tshowIcon_.size()) {
                    break;
                }
                codedOutputStream.writeMessage(14, this.tshowIcon_.get(i2));
                i = i2 + 1;
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.writeInt32(15, this.userType_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 == -1) {
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.userId_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(2, getUserNameBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(3, getNickNameBytes());
                }
                if ((this.bitField0_ & 8) == 8) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(4, getPortraitBytes());
                }
                if ((this.bitField0_ & 16) == 16) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(5, this.sex_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    computeInt32Size += CodedOutputStream.computeBytesSize(6, getPositionBytes());
                }
                if ((this.bitField0_ & 64) == 64) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(7, this.lng_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(8, this.lat_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(9, this.inTime_);
                }
                if ((this.bitField0_ & 512) == 512) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(10, this.loginTime_);
                }
                if ((this.bitField0_ & 1024) == 1024) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(11, this.lastReplyTime_);
                }
                if ((this.bitField0_ & 2048) == 2048) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(12, this.sysGroupId_);
                }
                if ((this.bitField0_ & 4096) == 4096) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(13, this.permission_);
                }
                while (true) {
                    i2 = computeInt32Size;
                    if (i >= this.tshowIcon_.size()) {
                        break;
                    }
                    computeInt32Size = CodedOutputStream.computeMessageSize(14, this.tshowIcon_.get(i)) + i2;
                    i++;
                }
                if ((this.bitField0_ & 8192) == 8192) {
                    i2 += CodedOutputStream.computeInt32Size(15, this.userType_);
                }
                this.memoizedSerializedSize = i2;
            }
            return i2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static ai newBuilder() {
            return ai.b();
        }

        @Override // com.google.protobuf.MessageLite
        public final ai newBuilderForType() {
            return newBuilder();
        }

        public static ai newBuilder(UserInfo userInfo) {
            return newBuilder().mergeFrom(userInfo);
        }

        @Override // com.google.protobuf.MessageLite
        public final ai toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class MaskInfo extends GeneratedMessageLite implements u {
        public static final int MASKFIDS_FIELD_NUMBER = 6;
        public static final int MASKGIDS_FIELD_NUMBER = 2;
        public static final int MASKUIDS_FIELD_NUMBER = 4;
        public static Parser<MaskInfo> PARSER = new s();
        public static final int REMINDMASK_FIELD_NUMBER = 3;
        public static final int SHIELDSTATUS_FIELD_NUMBER = 5;
        public static final int USERID_FIELD_NUMBER = 1;
        private static final MaskInfo a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object maskFids_;
        private Object maskGids_;
        private Object maskUids_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int remindMask_;
        private int shieldStatus_;
        private long userId_;

        public /* synthetic */ MaskInfo(GeneratedMessageLite.Builder builder, MaskInfo maskInfo) {
            this(builder);
        }

        private MaskInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MaskInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MaskInfo getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final MaskInfo getDefaultInstanceForType() {
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
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.userId_ = codedInputStream.readInt64();
                                break;
                            case GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.maskGids_ = codedInputStream.readBytes();
                                break;
                            case GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.remindMask_ = codedInputStream.readInt32();
                                break;
                            case GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                this.bitField0_ |= 8;
                                this.maskUids_ = codedInputStream.readBytes();
                                break;
                            case 40:
                                this.bitField0_ |= 16;
                                this.shieldStatus_ = codedInputStream.readInt32();
                                break;
                            case 50:
                                this.bitField0_ |= 32;
                                this.maskFids_ = codedInputStream.readBytes();
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

        public /* synthetic */ MaskInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, MaskInfo maskInfo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            MaskInfo maskInfo = new MaskInfo();
            a = maskInfo;
            maskInfo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<MaskInfo> getParserForType() {
            return PARSER;
        }

        public final boolean hasUserId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final long getUserId() {
            return this.userId_;
        }

        public final boolean hasMaskGids() {
            return (this.bitField0_ & 2) == 2;
        }

        public final String getMaskGids() {
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

        public final ByteString getMaskGidsBytes() {
            Object obj = this.maskGids_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.maskGids_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasRemindMask() {
            return (this.bitField0_ & 4) == 4;
        }

        public final int getRemindMask() {
            return this.remindMask_;
        }

        public final boolean hasMaskUids() {
            return (this.bitField0_ & 8) == 8;
        }

        public final String getMaskUids() {
            Object obj = this.maskUids_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.maskUids_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMaskUidsBytes() {
            Object obj = this.maskUids_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.maskUids_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasShieldStatus() {
            return (this.bitField0_ & 16) == 16;
        }

        public final int getShieldStatus() {
            return this.shieldStatus_;
        }

        public final boolean hasMaskFids() {
            return (this.bitField0_ & 32) == 32;
        }

        public final String getMaskFids() {
            Object obj = this.maskFids_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.maskFids_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMaskFidsBytes() {
            Object obj = this.maskFids_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.maskFids_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void a() {
            this.userId_ = 0L;
            this.maskGids_ = "";
            this.remindMask_ = 0;
            this.maskUids_ = "";
            this.shieldStatus_ = 0;
            this.maskFids_ = "";
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
                codedOutputStream.writeInt64(1, this.userId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getMaskGidsBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.remindMask_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getMaskUidsBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.shieldStatus_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getMaskFidsBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt64Size(1, this.userId_) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getMaskGidsBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.remindMask_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getMaskUidsBytes());
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeInt32Size(5, this.shieldStatus_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getMaskFidsBytes());
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static t newBuilder() {
            return t.b();
        }

        @Override // com.google.protobuf.MessageLite
        public final t newBuilderForType() {
            return newBuilder();
        }

        public static t newBuilder(MaskInfo maskInfo) {
            return newBuilder().mergeFrom(maskInfo);
        }

        @Override // com.google.protobuf.MessageLite
        public final t toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class GroupInfo extends GeneratedMessageLite implements l {
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
        public static final int ISMEMBERGROUP_FIELD_NUMBER = 34;
        public static final int ISNEWLYCREATE_FIELD_NUMBER = 32;
        public static final int ISRECENTLYREPLY_FIELD_NUMBER = 33;
        public static final int LASTMSGID_FIELD_NUMBER = 21;
        public static final int LASTMSGTIME_FIELD_NUMBER = 30;
        public static final int LAT_FIELD_NUMBER = 9;
        public static final int LNG_FIELD_NUMBER = 8;
        public static final int MAXMEMBERNUM_FIELD_NUMBER = 18;
        public static final int MEMBERNUM_FIELD_NUMBER = 19;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int NICKNAME_FIELD_NUMBER = 26;
        public static final int NOTICE_FIELD_NUMBER = 10;
        public static Parser<GroupInfo> PARSER = new j();
        public static final int PORTRAIT_FIELD_NUMBER = 5;
        public static final int POSITION_FIELD_NUMBER = 6;
        public static final int STATUS_FIELD_NUMBER = 12;
        private static final GroupInfo a;
        private static final long serialVersionUID = 0;
        private int activeDay_;
        private Object album_;
        private int authorId_;
        private int authorIsMeizhi_;
        private Object authorName_;
        private Object authorPortrait_;
        private int bitField0_;
        private int bitField1_;
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
        private int isMemberGroup_;
        private int isNewlyCreate_;
        private int isRecentlyReply_;
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

        public /* synthetic */ GroupInfo(GeneratedMessageLite.Builder builder, GroupInfo groupInfo) {
            this(builder);
        }

        private GroupInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GroupInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GroupInfo getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final GroupInfo getDefaultInstanceForType() {
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
                            case NICKNAME_FIELD_NUMBER /* 26 */:
                                this.bitField0_ |= 4;
                                this.name_ = codedInputStream.readBytes();
                                break;
                            case ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
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
                                this.bitField0_ |= 128;
                                this.lng_ = codedInputStream.readDouble();
                                break;
                            case 73:
                                this.bitField0_ |= 256;
                                this.lat_ = codedInputStream.readDouble();
                                break;
                            case 82:
                                this.bitField0_ |= 512;
                                this.notice_ = codedInputStream.readBytes();
                                break;
                            case 90:
                                this.bitField0_ |= 1024;
                                this.album_ = codedInputStream.readBytes();
                                break;
                            case 96:
                                this.bitField0_ |= 2048;
                                this.status_ = codedInputStream.readInt32();
                                break;
                            case 104:
                                this.bitField0_ |= 4096;
                                this.flag_ = codedInputStream.readInt32();
                                break;
                            case 112:
                                this.bitField0_ |= 8192;
                                this.authorId_ = codedInputStream.readInt32();
                                break;
                            case 122:
                                this.bitField0_ |= 16384;
                                this.authorName_ = codedInputStream.readBytes();
                                break;
                            case 130:
                                this.bitField0_ |= 32768;
                                this.authorPortrait_ = codedInputStream.readBytes();
                                break;
                            case 136:
                                this.bitField0_ |= AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED;
                                this.createTime_ = codedInputStream.readInt32();
                                break;
                            case 144:
                                this.bitField0_ |= AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
                                this.maxMemberNum_ = codedInputStream.readInt32();
                                break;
                            case 152:
                                this.bitField0_ |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START;
                                this.memberNum_ = codedInputStream.readInt32();
                                break;
                            case 160:
                                this.bitField0_ |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
                                this.groupType_ = codedInputStream.readInt32();
                                break;
                            case 168:
                                this.bitField0_ |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START;
                                this.lastMsgId_ = codedInputStream.readInt64();
                                break;
                            case 176:
                                this.bitField0_ |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
                                this.grade_ = codedInputStream.readInt32();
                                break;
                            case 184:
                                this.bitField0_ |= 4194304;
                                this.distance_ = codedInputStream.readInt32();
                                break;
                            case 192:
                                this.bitField0_ |= GravityCompat.RELATIVE_LAYOUT_DIRECTION;
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
                            case 256:
                                this.bitField0_ |= Integer.MIN_VALUE;
                                this.isNewlyCreate_ = codedInputStream.readInt32();
                                break;
                            case 264:
                                this.bitField1_ |= 1;
                                this.isRecentlyReply_ = codedInputStream.readInt32();
                                break;
                            case 272:
                                this.bitField1_ |= 2;
                                this.isMemberGroup_ = codedInputStream.readInt32();
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

        public /* synthetic */ GroupInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, GroupInfo groupInfo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            GroupInfo groupInfo = new GroupInfo();
            a = groupInfo;
            groupInfo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<GroupInfo> getParserForType() {
            return PARSER;
        }

        public final boolean hasGroupId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getGroupId() {
            return this.groupId_;
        }

        public final boolean hasForumId() {
            return (this.bitField0_ & 2) == 2;
        }

        public final int getForumId() {
            return this.forumId_;
        }

        public final boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public final String getName() {
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

        public final ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasIntro() {
            return (this.bitField0_ & 8) == 8;
        }

        public final String getIntro() {
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

        public final ByteString getIntroBytes() {
            Object obj = this.intro_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.intro_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasPortrait() {
            return (this.bitField0_ & 16) == 16;
        }

        public final String getPortrait() {
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

        public final ByteString getPortraitBytes() {
            Object obj = this.portrait_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.portrait_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasPosition() {
            return (this.bitField0_ & 32) == 32;
        }

        public final String getPosition() {
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

        public final ByteString getPositionBytes() {
            Object obj = this.position_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.position_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasBusiness() {
            return (this.bitField0_ & 64) == 64;
        }

        public final String getBusiness() {
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

        public final ByteString getBusinessBytes() {
            Object obj = this.business_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.business_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasLng() {
            return (this.bitField0_ & 128) == 128;
        }

        public final double getLng() {
            return this.lng_;
        }

        public final boolean hasLat() {
            return (this.bitField0_ & 256) == 256;
        }

        public final double getLat() {
            return this.lat_;
        }

        public final boolean hasNotice() {
            return (this.bitField0_ & 512) == 512;
        }

        public final String getNotice() {
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

        public final ByteString getNoticeBytes() {
            Object obj = this.notice_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.notice_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasAlbum() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public final String getAlbum() {
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

        public final ByteString getAlbumBytes() {
            Object obj = this.album_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.album_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasStatus() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public final int getStatus() {
            return this.status_;
        }

        public final boolean hasFlag() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public final int getFlag() {
            return this.flag_;
        }

        public final boolean hasAuthorId() {
            return (this.bitField0_ & 8192) == 8192;
        }

        public final int getAuthorId() {
            return this.authorId_;
        }

        public final boolean hasAuthorName() {
            return (this.bitField0_ & 16384) == 16384;
        }

        public final String getAuthorName() {
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

        public final ByteString getAuthorNameBytes() {
            Object obj = this.authorName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.authorName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasAuthorPortrait() {
            return (this.bitField0_ & 32768) == 32768;
        }

        public final String getAuthorPortrait() {
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

        public final ByteString getAuthorPortraitBytes() {
            Object obj = this.authorPortrait_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.authorPortrait_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasCreateTime() {
            return (this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) == 65536;
        }

        public final int getCreateTime() {
            return this.createTime_;
        }

        public final boolean hasMaxMemberNum() {
            return (this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) == 131072;
        }

        public final int getMaxMemberNum() {
            return this.maxMemberNum_;
        }

        public final boolean hasMemberNum() {
            return (this.bitField0_ & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) == 262144;
        }

        public final int getMemberNum() {
            return this.memberNum_;
        }

        public final boolean hasGroupType() {
            return (this.bitField0_ & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END) == 524288;
        }

        public final int getGroupType() {
            return this.groupType_;
        }

        public final boolean hasLastMsgId() {
            return (this.bitField0_ & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) == 1048576;
        }

        public final long getLastMsgId() {
            return this.lastMsgId_;
        }

        public final boolean hasGrade() {
            return (this.bitField0_ & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END) == 2097152;
        }

        public final int getGrade() {
            return this.grade_;
        }

        public final boolean hasDistance() {
            return (this.bitField0_ & 4194304) == 4194304;
        }

        public final int getDistance() {
            return this.distance_;
        }

        public final boolean hasIsHidePosition() {
            return (this.bitField0_ & GravityCompat.RELATIVE_LAYOUT_DIRECTION) == 8388608;
        }

        public final int getIsHidePosition() {
            return this.isHidePosition_;
        }

        public final boolean hasForumName() {
            return (this.bitField0_ & 16777216) == 16777216;
        }

        public final String getForumName() {
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

        public final ByteString getForumNameBytes() {
            Object obj = this.forumName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.forumName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasNickName() {
            return (this.bitField0_ & 33554432) == 33554432;
        }

        public final String getNickName() {
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

        public final ByteString getNickNameBytes() {
            Object obj = this.nickName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nickName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasActiveDay() {
            return (this.bitField0_ & 67108864) == 67108864;
        }

        public final int getActiveDay() {
            return this.activeDay_;
        }

        public final boolean hasIsGroupManager() {
            return (this.bitField0_ & 134217728) == 134217728;
        }

        public final int getIsGroupManager() {
            return this.isGroupManager_;
        }

        public final boolean hasAuthorIsMeizhi() {
            return (this.bitField0_ & 268435456) == 268435456;
        }

        public final int getAuthorIsMeizhi() {
            return this.authorIsMeizhi_;
        }

        public final boolean hasLastMsgTime() {
            return (this.bitField0_ & 536870912) == 536870912;
        }

        public final int getLastMsgTime() {
            return this.lastMsgTime_;
        }

        public final boolean hasForumShowName() {
            return (this.bitField0_ & 1073741824) == 1073741824;
        }

        public final String getForumShowName() {
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

        public final ByteString getForumShowNameBytes() {
            Object obj = this.forumShowName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.forumShowName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasIsNewlyCreate() {
            return (this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE;
        }

        public final int getIsNewlyCreate() {
            return this.isNewlyCreate_;
        }

        public final boolean hasIsRecentlyReply() {
            return (this.bitField1_ & 1) == 1;
        }

        public final int getIsRecentlyReply() {
            return this.isRecentlyReply_;
        }

        public final boolean hasIsMemberGroup() {
            return (this.bitField1_ & 2) == 2;
        }

        public final int getIsMemberGroup() {
            return this.isMemberGroup_;
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
            this.isNewlyCreate_ = 0;
            this.isRecentlyReply_ = 0;
            this.isMemberGroup_ = 0;
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
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeDouble(8, this.lng_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeDouble(9, this.lat_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeBytes(10, getNoticeBytes());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeBytes(11, getAlbumBytes());
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt32(12, this.status_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
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
            if ((this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) == 65536) {
                codedOutputStream.writeInt32(17, this.createTime_);
            }
            if ((this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) == 131072) {
                codedOutputStream.writeInt32(18, this.maxMemberNum_);
            }
            if ((this.bitField0_ & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) == 262144) {
                codedOutputStream.writeInt32(19, this.memberNum_);
            }
            if ((this.bitField0_ & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END) == 524288) {
                codedOutputStream.writeInt32(20, this.groupType_);
            }
            if ((this.bitField0_ & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) == 1048576) {
                codedOutputStream.writeInt64(21, this.lastMsgId_);
            }
            if ((this.bitField0_ & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END) == 2097152) {
                codedOutputStream.writeInt32(22, this.grade_);
            }
            if ((this.bitField0_ & 4194304) == 4194304) {
                codedOutputStream.writeInt32(23, this.distance_);
            }
            if ((this.bitField0_ & GravityCompat.RELATIVE_LAYOUT_DIRECTION) == 8388608) {
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
            if ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                codedOutputStream.writeInt32(32, this.isNewlyCreate_);
            }
            if ((this.bitField1_ & 1) == 1) {
                codedOutputStream.writeInt32(33, this.isRecentlyReply_);
            }
            if ((this.bitField1_ & 2) == 2) {
                codedOutputStream.writeInt32(34, this.isMemberGroup_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt32Size(1, this.groupId_) + 0;
                }
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
                if ((this.bitField0_ & 128) == 128) {
                    i += CodedOutputStream.computeDoubleSize(8, this.lng_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeDoubleSize(9, this.lat_);
                }
                if ((this.bitField0_ & 512) == 512) {
                    i += CodedOutputStream.computeBytesSize(10, getNoticeBytes());
                }
                if ((this.bitField0_ & 1024) == 1024) {
                    i += CodedOutputStream.computeBytesSize(11, getAlbumBytes());
                }
                if ((this.bitField0_ & 2048) == 2048) {
                    i += CodedOutputStream.computeInt32Size(12, this.status_);
                }
                if ((this.bitField0_ & 4096) == 4096) {
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
                if ((this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) == 65536) {
                    i += CodedOutputStream.computeInt32Size(17, this.createTime_);
                }
                if ((this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) == 131072) {
                    i += CodedOutputStream.computeInt32Size(18, this.maxMemberNum_);
                }
                if ((this.bitField0_ & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) == 262144) {
                    i += CodedOutputStream.computeInt32Size(19, this.memberNum_);
                }
                if ((this.bitField0_ & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END) == 524288) {
                    i += CodedOutputStream.computeInt32Size(20, this.groupType_);
                }
                if ((this.bitField0_ & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) == 1048576) {
                    i += CodedOutputStream.computeInt64Size(21, this.lastMsgId_);
                }
                if ((this.bitField0_ & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END) == 2097152) {
                    i += CodedOutputStream.computeInt32Size(22, this.grade_);
                }
                if ((this.bitField0_ & 4194304) == 4194304) {
                    i += CodedOutputStream.computeInt32Size(23, this.distance_);
                }
                if ((this.bitField0_ & GravityCompat.RELATIVE_LAYOUT_DIRECTION) == 8388608) {
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
                if ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                    i += CodedOutputStream.computeInt32Size(32, this.isNewlyCreate_);
                }
                if ((this.bitField1_ & 1) == 1) {
                    i += CodedOutputStream.computeInt32Size(33, this.isRecentlyReply_);
                }
                if ((this.bitField1_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(34, this.isMemberGroup_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static k newBuilder() {
            return k.c();
        }

        @Override // com.google.protobuf.MessageLite
        public final k newBuilderForType() {
            return newBuilder();
        }

        public static k newBuilder(GroupInfo groupInfo) {
            return newBuilder().mergeFrom(groupInfo);
        }

        @Override // com.google.protobuf.MessageLite
        public final k toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class GradeInfo extends GeneratedMessageLite implements i {
        public static final int GRADE_FIELD_NUMBER = 1;
        public static final int INTRO_FIELD_NUMBER = 2;
        public static final int MAXMEMBERNUM_FIELD_NUMBER = 4;
        public static Parser<GradeInfo> PARSER = new g();
        public static final int THRESHOLDDAY_FIELD_NUMBER = 3;
        private static final GradeInfo a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int grade_;
        private Object intro_;
        private int maxMemberNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int thresholdDay_;

        public /* synthetic */ GradeInfo(GeneratedMessageLite.Builder builder, GradeInfo gradeInfo) {
            this(builder);
        }

        private GradeInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GradeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GradeInfo getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final GradeInfo getDefaultInstanceForType() {
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
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.grade_ = codedInputStream.readInt32();
                                break;
                            case GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.intro_ = codedInputStream.readBytes();
                                break;
                            case GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
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

        public /* synthetic */ GradeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, GradeInfo gradeInfo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            GradeInfo gradeInfo = new GradeInfo();
            a = gradeInfo;
            gradeInfo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<GradeInfo> getParserForType() {
            return PARSER;
        }

        public final boolean hasGrade() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getGrade() {
            return this.grade_;
        }

        public final boolean hasIntro() {
            return (this.bitField0_ & 2) == 2;
        }

        public final String getIntro() {
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

        public final ByteString getIntroBytes() {
            Object obj = this.intro_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.intro_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasThresholdDay() {
            return (this.bitField0_ & 4) == 4;
        }

        public final int getThresholdDay() {
            return this.thresholdDay_;
        }

        public final boolean hasMaxMemberNum() {
            return (this.bitField0_ & 8) == 8;
        }

        public final int getMaxMemberNum() {
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
        public final void writeTo(CodedOutputStream codedOutputStream) {
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
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt32Size(1, this.grade_) + 0;
                }
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static h newBuilder() {
            return h.a();
        }

        @Override // com.google.protobuf.MessageLite
        public final h newBuilderForType() {
            return newBuilder();
        }

        public static h newBuilder(GradeInfo gradeInfo) {
            return newBuilder().mergeFrom(gradeInfo);
        }

        @Override // com.google.protobuf.MessageLite
        public final h toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class MsgInfo extends GeneratedMessageLite implements x {
        public static final int CONTENT_FIELD_NUMBER = 5;
        public static final int CREATETIME_FIELD_NUMBER = 8;
        public static final int DURATION_FIELD_NUMBER = 7;
        public static final int GROUPID_FIELD_NUMBER = 2;
        public static final int LINK_FIELD_NUMBER = 13;
        public static final int MSGID_FIELD_NUMBER = 1;
        public static final int MSGTYPE_FIELD_NUMBER = 3;
        public static Parser<MsgInfo> PARSER = new v();
        public static final int RECORDID_FIELD_NUMBER = 9;
        public static final int STATUS_FIELD_NUMBER = 6;
        public static final int STAT_FIELD_NUMBER = 14;
        public static final int TASKID_FIELD_NUMBER = 15;
        public static final int TOUID_FIELD_NUMBER = 11;
        public static final int TOUSERINFO_FIELD_NUMBER = 12;
        public static final int USERID_FIELD_NUMBER = 4;
        public static final int USERINFO_FIELD_NUMBER = 10;
        private static final MsgInfo a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object content_;
        private int createTime_;
        private int duration_;
        private int groupId_;
        private Object link_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long msgId_;
        private int msgType_;
        private long recordId_;
        private Object stat_;
        private int status_;
        private long taskId_;
        private long toUid_;
        private UserInfo toUserInfo_;
        private long userId_;
        private UserInfo userInfo_;

        public /* synthetic */ MsgInfo(GeneratedMessageLite.Builder builder, MsgInfo msgInfo) {
            this(builder);
        }

        private MsgInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MsgInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MsgInfo getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final MsgInfo getDefaultInstanceForType() {
            return a;
        }

        private MsgInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                            case 8:
                                this.bitField0_ |= 1;
                                this.msgId_ = codedInputStream.readInt64();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.groupId_ = codedInputStream.readInt32();
                                break;
                            case GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.msgType_ = codedInputStream.readInt32();
                                break;
                            case 32:
                                this.bitField0_ |= 8;
                                this.userId_ = codedInputStream.readInt64();
                                break;
                            case 42:
                                this.bitField0_ |= 16;
                                this.content_ = codedInputStream.readBytes();
                                break;
                            case 48:
                                this.bitField0_ |= 32;
                                this.status_ = codedInputStream.readInt32();
                                break;
                            case 56:
                                this.bitField0_ |= 64;
                                this.duration_ = codedInputStream.readInt32();
                                break;
                            case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /* 64 */:
                                this.bitField0_ |= 128;
                                this.createTime_ = codedInputStream.readInt32();
                                break;
                            case 72:
                                this.bitField0_ |= 256;
                                this.recordId_ = codedInputStream.readInt64();
                                break;
                            case 82:
                                ai builder = (this.bitField0_ & 512) == 512 ? this.userInfo_.toBuilder() : null;
                                this.userInfo_ = (UserInfo) codedInputStream.readMessage(UserInfo.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.userInfo_);
                                    this.userInfo_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 512;
                                break;
                            case 88:
                                this.bitField0_ |= 1024;
                                this.toUid_ = codedInputStream.readInt64();
                                break;
                            case 98:
                                ai builder2 = (this.bitField0_ & 2048) == 2048 ? this.toUserInfo_.toBuilder() : null;
                                this.toUserInfo_ = (UserInfo) codedInputStream.readMessage(UserInfo.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.toUserInfo_);
                                    this.toUserInfo_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2048;
                                break;
                            case 106:
                                this.bitField0_ |= 4096;
                                this.link_ = codedInputStream.readBytes();
                                break;
                            case 114:
                                this.bitField0_ |= 8192;
                                this.stat_ = codedInputStream.readBytes();
                                break;
                            case 120:
                                this.bitField0_ |= 16384;
                                this.taskId_ = codedInputStream.readInt64();
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

        public /* synthetic */ MsgInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, MsgInfo msgInfo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            MsgInfo msgInfo = new MsgInfo();
            a = msgInfo;
            msgInfo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<MsgInfo> getParserForType() {
            return PARSER;
        }

        public final boolean hasMsgId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final long getMsgId() {
            return this.msgId_;
        }

        public final boolean hasGroupId() {
            return (this.bitField0_ & 2) == 2;
        }

        public final int getGroupId() {
            return this.groupId_;
        }

        public final boolean hasMsgType() {
            return (this.bitField0_ & 4) == 4;
        }

        public final int getMsgType() {
            return this.msgType_;
        }

        public final boolean hasUserId() {
            return (this.bitField0_ & 8) == 8;
        }

        public final long getUserId() {
            return this.userId_;
        }

        public final boolean hasContent() {
            return (this.bitField0_ & 16) == 16;
        }

        public final String getContent() {
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

        public final ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasStatus() {
            return (this.bitField0_ & 32) == 32;
        }

        public final int getStatus() {
            return this.status_;
        }

        public final boolean hasDuration() {
            return (this.bitField0_ & 64) == 64;
        }

        public final int getDuration() {
            return this.duration_;
        }

        public final boolean hasCreateTime() {
            return (this.bitField0_ & 128) == 128;
        }

        public final int getCreateTime() {
            return this.createTime_;
        }

        public final boolean hasRecordId() {
            return (this.bitField0_ & 256) == 256;
        }

        public final long getRecordId() {
            return this.recordId_;
        }

        public final boolean hasUserInfo() {
            return (this.bitField0_ & 512) == 512;
        }

        public final UserInfo getUserInfo() {
            return this.userInfo_;
        }

        public final boolean hasToUid() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public final long getToUid() {
            return this.toUid_;
        }

        public final boolean hasToUserInfo() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public final UserInfo getToUserInfo() {
            return this.toUserInfo_;
        }

        public final boolean hasLink() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public final String getLink() {
            Object obj = this.link_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.link_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasStat() {
            return (this.bitField0_ & 8192) == 8192;
        }

        public final String getStat() {
            Object obj = this.stat_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.stat_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getStatBytes() {
            Object obj = this.stat_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.stat_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasTaskId() {
            return (this.bitField0_ & 16384) == 16384;
        }

        public final long getTaskId() {
            return this.taskId_;
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
            this.link_ = "";
            this.stat_ = "";
            this.taskId_ = 0L;
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
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(8, this.createTime_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt64(9, this.recordId_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeMessage(10, this.userInfo_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeInt64(11, this.toUid_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeMessage(12, this.toUserInfo_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeBytes(13, getLinkBytes());
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.writeBytes(14, getStatBytes());
            }
            if ((this.bitField0_ & 16384) == 16384) {
                codedOutputStream.writeInt64(15, this.taskId_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt64Size(1, this.msgId_) + 0;
                }
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
                if ((this.bitField0_ & 128) == 128) {
                    i += CodedOutputStream.computeInt32Size(8, this.createTime_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeInt64Size(9, this.recordId_);
                }
                if ((this.bitField0_ & 512) == 512) {
                    i += CodedOutputStream.computeMessageSize(10, this.userInfo_);
                }
                if ((this.bitField0_ & 1024) == 1024) {
                    i += CodedOutputStream.computeInt64Size(11, this.toUid_);
                }
                if ((this.bitField0_ & 2048) == 2048) {
                    i += CodedOutputStream.computeMessageSize(12, this.toUserInfo_);
                }
                if ((this.bitField0_ & 4096) == 4096) {
                    i += CodedOutputStream.computeBytesSize(13, getLinkBytes());
                }
                if ((this.bitField0_ & 8192) == 8192) {
                    i += CodedOutputStream.computeBytesSize(14, getStatBytes());
                }
                if ((this.bitField0_ & 16384) == 16384) {
                    i += CodedOutputStream.computeInt64Size(15, this.taskId_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static w newBuilder() {
            return w.a();
        }

        @Override // com.google.protobuf.MessageLite
        public final w newBuilderForType() {
            return newBuilder();
        }

        public static w newBuilder(MsgInfo msgInfo) {
            return newBuilder().mergeFrom(msgInfo);
        }

        @Override // com.google.protobuf.MessageLite
        public final w toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class PusherMsgInfo extends GeneratedMessageLite implements ad {
        public static final int GROUPID_FIELD_NUMBER = 1;
        public static final int MSGID_FIELD_NUMBER = 2;
        public static Parser<PusherMsgInfo> PARSER = new ab();
        public static final int PUSHTIME_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 4;
        private static final PusherMsgInfo a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int groupId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long msgId_;
        private long pushTime_;
        private int type_;

        public /* synthetic */ PusherMsgInfo(GeneratedMessageLite.Builder builder, PusherMsgInfo pusherMsgInfo) {
            this(builder);
        }

        private PusherMsgInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private PusherMsgInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static PusherMsgInfo getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final PusherMsgInfo getDefaultInstanceForType() {
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
                            case GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.pushTime_ = codedInputStream.readInt64();
                                break;
                            case 32:
                                this.bitField0_ |= 8;
                                this.type_ = codedInputStream.readInt32();
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

        public /* synthetic */ PusherMsgInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, PusherMsgInfo pusherMsgInfo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            PusherMsgInfo pusherMsgInfo = new PusherMsgInfo();
            a = pusherMsgInfo;
            pusherMsgInfo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<PusherMsgInfo> getParserForType() {
            return PARSER;
        }

        public final boolean hasGroupId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getGroupId() {
            return this.groupId_;
        }

        public final boolean hasMsgId() {
            return (this.bitField0_ & 2) == 2;
        }

        public final long getMsgId() {
            return this.msgId_;
        }

        public final boolean hasPushTime() {
            return (this.bitField0_ & 4) == 4;
        }

        public final long getPushTime() {
            return this.pushTime_;
        }

        public final boolean hasType() {
            return (this.bitField0_ & 8) == 8;
        }

        public final int getType() {
            return this.type_;
        }

        private void a() {
            this.groupId_ = 0;
            this.msgId_ = 0L;
            this.pushTime_ = 0L;
            this.type_ = 0;
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
                codedOutputStream.writeInt32(1, this.groupId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt64(2, this.msgId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.pushTime_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.type_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt32Size(1, this.groupId_) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.msgId_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.pushTime_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(4, this.type_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static ac newBuilder() {
            return ac.b();
        }

        @Override // com.google.protobuf.MessageLite
        public final ac newBuilderForType() {
            return newBuilder();
        }

        public static ac newBuilder(PusherMsgInfo pusherMsgInfo) {
            return newBuilder().mergeFrom(pusherMsgInfo);
        }

        @Override // com.google.protobuf.MessageLite
        public final ac toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class GroupLastId extends GeneratedMessageLite implements o {
        public static final int GROUPID_FIELD_NUMBER = 1;
        public static final int LASTMSGID_FIELD_NUMBER = 2;
        public static Parser<GroupLastId> PARSER = new m();
        private static final GroupLastId a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int groupId_;
        private long lastMsgId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        public /* synthetic */ GroupLastId(GeneratedMessageLite.Builder builder, GroupLastId groupLastId) {
            this(builder);
        }

        private GroupLastId(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private GroupLastId() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static GroupLastId getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final GroupLastId getDefaultInstanceForType() {
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

        public /* synthetic */ GroupLastId(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, GroupLastId groupLastId) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            GroupLastId groupLastId = new GroupLastId();
            a = groupLastId;
            groupLastId.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<GroupLastId> getParserForType() {
            return PARSER;
        }

        public final boolean hasGroupId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getGroupId() {
            return this.groupId_;
        }

        public final boolean hasLastMsgId() {
            return (this.bitField0_ & 2) == 2;
        }

        public final long getLastMsgId() {
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
        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.groupId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt64(2, this.lastMsgId_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt32Size(1, this.groupId_) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.lastMsgId_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static n newBuilder() {
            return n.b();
        }

        @Override // com.google.protobuf.MessageLite
        public final n newBuilderForType() {
            return newBuilder();
        }

        public static n newBuilder(GroupLastId groupLastId) {
            return newBuilder().mergeFrom(groupLastId);
        }

        @Override // com.google.protobuf.MessageLite
        public final n toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class Photo extends GeneratedMessageLite implements aa {
        public static final int BIGURL_FIELD_NUMBER = 2;
        public static Parser<Photo> PARSER = new y();
        public static final int PICID_FIELD_NUMBER = 3;
        public static final int SMALLURL_FIELD_NUMBER = 1;
        private static final Photo a;
        private static final long serialVersionUID = 0;
        private Object bigurl_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object picId_;
        private Object smallurl_;

        public /* synthetic */ Photo(GeneratedMessageLite.Builder builder, Photo photo) {
            this(builder);
        }

        private Photo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Photo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Photo getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final Photo getDefaultInstanceForType() {
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
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 10:
                                this.bitField0_ |= 1;
                                this.smallurl_ = codedInputStream.readBytes();
                                break;
                            case GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.bigurl_ = codedInputStream.readBytes();
                                break;
                            case GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
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

        public /* synthetic */ Photo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Photo photo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            Photo photo = new Photo();
            a = photo;
            photo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<Photo> getParserForType() {
            return PARSER;
        }

        public final boolean hasSmallurl() {
            return (this.bitField0_ & 1) == 1;
        }

        public final String getSmallurl() {
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

        public final ByteString getSmallurlBytes() {
            Object obj = this.smallurl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.smallurl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasBigurl() {
            return (this.bitField0_ & 2) == 2;
        }

        public final String getBigurl() {
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

        public final ByteString getBigurlBytes() {
            Object obj = this.bigurl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bigurl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasPicId() {
            return (this.bitField0_ & 4) == 4;
        }

        public final String getPicId() {
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

        public final ByteString getPicIdBytes() {
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
        public final void writeTo(CodedOutputStream codedOutputStream) {
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
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeBytesSize(1, getSmallurlBytes()) + 0;
                }
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
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

        public static z newBuilder() {
            return z.a();
        }

        @Override // com.google.protobuf.MessageLite
        public final z newBuilderForType() {
            return newBuilder();
        }

        public static z newBuilder(Photo photo) {
            return newBuilder().mergeFrom(photo);
        }

        @Override // com.google.protobuf.MessageLite
        public final z toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class ActivityInfo extends GeneratedMessageLite implements c {
        public static final int ACTIVITYID_FIELD_NUMBER = 1;
        public static final int ACTIVITYTITLE_FIELD_NUMBER = 2;
        public static final int ISEND_FIELD_NUMBER = 3;
        public static Parser<ActivityInfo> PARSER = new a();
        private static final ActivityInfo a;
        private static final long serialVersionUID = 0;
        private int activityId_;
        private Object activityTitle_;
        private int bitField0_;
        private int isEnd_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        public /* synthetic */ ActivityInfo(GeneratedMessageLite.Builder builder, ActivityInfo activityInfo) {
            this(builder);
        }

        private ActivityInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ActivityInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ActivityInfo getDefaultInstance() {
            return a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final ActivityInfo getDefaultInstanceForType() {
            return a;
        }

        private ActivityInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                            case 8:
                                this.bitField0_ |= 1;
                                this.activityId_ = codedInputStream.readInt32();
                                break;
                            case GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.activityTitle_ = codedInputStream.readBytes();
                                break;
                            case GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.isEnd_ = codedInputStream.readInt32();
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

        public /* synthetic */ ActivityInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ActivityInfo activityInfo) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            ActivityInfo activityInfo = new ActivityInfo();
            a = activityInfo;
            activityInfo.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<ActivityInfo> getParserForType() {
            return PARSER;
        }

        public final boolean hasActivityId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getActivityId() {
            return this.activityId_;
        }

        public final boolean hasActivityTitle() {
            return (this.bitField0_ & 2) == 2;
        }

        public final String getActivityTitle() {
            Object obj = this.activityTitle_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.activityTitle_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getActivityTitleBytes() {
            Object obj = this.activityTitle_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.activityTitle_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasIsEnd() {
            return (this.bitField0_ & 4) == 4;
        }

        public final int getIsEnd() {
            return this.isEnd_;
        }

        private void a() {
            this.activityId_ = 0;
            this.activityTitle_ = "";
            this.isEnd_ = 0;
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
                codedOutputStream.writeInt32(1, this.activityId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getActivityTitleBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.isEnd_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt32Size(1, this.activityId_) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getActivityTitleBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.isEnd_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object writeReplace() {
            return super.writeReplace();
        }

        public static ActivityInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static ActivityInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ActivityInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static ActivityInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ActivityInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static ActivityInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ActivityInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ActivityInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ActivityInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ActivityInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static b newBuilder() {
            return b.a();
        }

        @Override // com.google.protobuf.MessageLite
        public final b newBuilderForType() {
            return newBuilder();
        }

        public static b newBuilder(ActivityInfo activityInfo) {
            return newBuilder().mergeFrom(activityInfo);
        }

        @Override // com.google.protobuf.MessageLite
        public final b toBuilder() {
            return newBuilder(this);
        }
    }
}
