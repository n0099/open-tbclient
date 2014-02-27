package protobuf.QueryGroupActivity;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
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
public final class QueryGroupActivityRes {

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements i {
        public static final int ACTIVITYID_FIELD_NUMBER = 1;
        public static final int ACTIVITYPORTRAIT_FIELD_NUMBER = 9;
        public static final int GACTIVITYAREA_FIELD_NUMBER = 7;
        public static final int GACTIVITYCONTENT_FIELD_NUMBER = 6;
        public static final int GACTIVITYTIME_FIELD_NUMBER = 5;
        public static final int GACTIVITYTITLE_FIELD_NUMBER = 4;
        public static final int GROUPID_FIELD_NUMBER = 2;
        public static final int ISEND_FIELD_NUMBER = 8;
        public static Parser<DataRes> PARSER = new g();
        public static final int USERID_FIELD_NUMBER = 3;
        public static final int USERNAME_FIELD_NUMBER = 10;
        private static final DataRes a;
        private static final long serialVersionUID = 0;
        private int activityId_;
        private Object activityPortrait_;
        private int bitField0_;
        private Object gActivityArea_;
        private Object gActivityContent_;
        private long gActivityTime_;
        private Object gActivityTitle_;
        private int groupId_;
        private int isEnd_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int userId_;
        private Object userName_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ DataRes(GeneratedMessageLite.Builder builder, DataRes dataRes) {
            this(builder);
        }

        private DataRes(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private DataRes() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DataRes getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final DataRes getDefaultInstanceForType() {
            return a;
        }

        private DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                            case 16:
                                this.bitField0_ |= 2;
                                this.groupId_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.userId_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                this.bitField0_ |= 8;
                                this.gActivityTitle_ = codedInputStream.readBytes();
                                break;
                            case 40:
                                this.bitField0_ |= 16;
                                this.gActivityTime_ = codedInputStream.readInt64();
                                break;
                            case 50:
                                this.bitField0_ |= 32;
                                this.gActivityContent_ = codedInputStream.readBytes();
                                break;
                            case 58:
                                this.bitField0_ |= 64;
                                this.gActivityArea_ = codedInputStream.readBytes();
                                break;
                            case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /* 64 */:
                                this.bitField0_ |= 128;
                                this.isEnd_ = codedInputStream.readInt32();
                                break;
                            case 74:
                                this.bitField0_ |= 256;
                                this.activityPortrait_ = codedInputStream.readBytes();
                                break;
                            case 82:
                                this.bitField0_ |= 512;
                                this.userName_ = codedInputStream.readBytes();
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
        public /* synthetic */ DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DataRes dataRes) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            DataRes dataRes = new DataRes();
            a = dataRes;
            dataRes.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<DataRes> getParserForType() {
            return PARSER;
        }

        public final boolean hasActivityId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getActivityId() {
            return this.activityId_;
        }

        public final boolean hasGroupId() {
            return (this.bitField0_ & 2) == 2;
        }

        public final int getGroupId() {
            return this.groupId_;
        }

        public final boolean hasUserId() {
            return (this.bitField0_ & 4) == 4;
        }

        public final int getUserId() {
            return this.userId_;
        }

        public final boolean hasGActivityTitle() {
            return (this.bitField0_ & 8) == 8;
        }

        public final String getGActivityTitle() {
            Object obj = this.gActivityTitle_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.gActivityTitle_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getGActivityTitleBytes() {
            Object obj = this.gActivityTitle_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.gActivityTitle_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasGActivityTime() {
            return (this.bitField0_ & 16) == 16;
        }

        public final long getGActivityTime() {
            return this.gActivityTime_;
        }

        public final boolean hasGActivityContent() {
            return (this.bitField0_ & 32) == 32;
        }

        public final String getGActivityContent() {
            Object obj = this.gActivityContent_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.gActivityContent_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getGActivityContentBytes() {
            Object obj = this.gActivityContent_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.gActivityContent_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasGActivityArea() {
            return (this.bitField0_ & 64) == 64;
        }

        public final String getGActivityArea() {
            Object obj = this.gActivityArea_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.gActivityArea_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getGActivityAreaBytes() {
            Object obj = this.gActivityArea_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.gActivityArea_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasIsEnd() {
            return (this.bitField0_ & 128) == 128;
        }

        public final int getIsEnd() {
            return this.isEnd_;
        }

        public final boolean hasActivityPortrait() {
            return (this.bitField0_ & 256) == 256;
        }

        public final String getActivityPortrait() {
            Object obj = this.activityPortrait_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.activityPortrait_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getActivityPortraitBytes() {
            Object obj = this.activityPortrait_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.activityPortrait_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final boolean hasUserName() {
            return (this.bitField0_ & 512) == 512;
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

        private void a() {
            this.activityId_ = 0;
            this.groupId_ = 0;
            this.userId_ = 0;
            this.gActivityTitle_ = "";
            this.gActivityTime_ = 0L;
            this.gActivityContent_ = "";
            this.gActivityArea_ = "";
            this.isEnd_ = 0;
            this.activityPortrait_ = "";
            this.userName_ = "";
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
                codedOutputStream.writeInt32(2, this.groupId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.userId_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getGActivityTitleBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(5, this.gActivityTime_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getGActivityContentBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBytes(7, getGActivityAreaBytes());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(8, this.isEnd_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeBytes(9, getActivityPortraitBytes());
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeBytes(10, getUserNameBytes());
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
                    i += CodedOutputStream.computeInt32Size(2, this.groupId_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.userId_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getGActivityTitleBytes());
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.gActivityTime_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getGActivityContentBytes());
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeBytesSize(7, getGActivityAreaBytes());
                }
                if ((this.bitField0_ & 128) == 128) {
                    i += CodedOutputStream.computeInt32Size(8, this.isEnd_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeBytesSize(9, getActivityPortraitBytes());
                }
                if ((this.bitField0_ & 512) == 512) {
                    i += CodedOutputStream.computeBytesSize(10, getUserNameBytes());
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

        public static h newBuilder() {
            return h.b();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final h newBuilderForType() {
            return newBuilder();
        }

        public static h newBuilder(DataRes dataRes) {
            return newBuilder().mergeFrom(dataRes);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final h toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class QueryGroupActivityResIdl extends GeneratedMessageLite implements l {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryGroupActivityResIdl> PARSER = new j();
        private static final QueryGroupActivityResIdl a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ QueryGroupActivityResIdl(GeneratedMessageLite.Builder builder, QueryGroupActivityResIdl queryGroupActivityResIdl) {
            this(builder);
        }

        private QueryGroupActivityResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryGroupActivityResIdl() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryGroupActivityResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final QueryGroupActivityResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryGroupActivityResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                protobuf.e builder = (this.bitField0_ & 1) == 1 ? this.error_.toBuilder() : null;
                                this.error_ = (Im.Error) codedInputStream.readMessage(Im.Error.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.error_);
                                    this.error_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                h builder2 = (this.bitField0_ & 2) == 2 ? this.data_.toBuilder() : null;
                                this.data_ = (DataRes) codedInputStream.readMessage(DataRes.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.data_);
                                    this.data_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
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
        public /* synthetic */ QueryGroupActivityResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, QueryGroupActivityResIdl queryGroupActivityResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            QueryGroupActivityResIdl queryGroupActivityResIdl = new QueryGroupActivityResIdl();
            a = queryGroupActivityResIdl;
            queryGroupActivityResIdl.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<QueryGroupActivityResIdl> getParserForType() {
            return PARSER;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 1) == 1;
        }

        public final Im.Error getError() {
            return this.error_;
        }

        public final boolean hasData() {
            return (this.bitField0_ & 2) == 2;
        }

        public final DataRes getData() {
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
        public final void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.error_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.data_);
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
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeMessageSize(2, this.data_);
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

        public static QueryGroupActivityResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static QueryGroupActivityResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QueryGroupActivityResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static QueryGroupActivityResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QueryGroupActivityResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static QueryGroupActivityResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupActivityResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QueryGroupActivityResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupActivityResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QueryGroupActivityResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static k newBuilder() {
            return k.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final k newBuilderForType() {
            return newBuilder();
        }

        public static k newBuilder(QueryGroupActivityResIdl queryGroupActivityResIdl) {
            return newBuilder().mergeFrom(queryGroupActivityResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final k toBuilder() {
            return newBuilder(this);
        }
    }
}
