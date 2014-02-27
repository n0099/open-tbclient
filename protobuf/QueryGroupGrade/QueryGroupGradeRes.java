package protobuf.QueryGroupGrade;

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
public final class QueryGroupGradeRes {

    /* loaded from: classes.dex */
    public final class MemberPerm extends GeneratedMessageLite implements l {
        public static final int ALREADYCREATENUM_FIELD_NUMBER = 3;
        public static final int CANCREATEMEMBER_FIELD_NUMBER = 2;
        public static final int ISAUTHOR_FIELD_NUMBER = 1;
        public static final int LEFTCREATENUM_FIELD_NUMBER = 4;
        public static Parser<MemberPerm> PARSER = new j();
        private static final MemberPerm a;
        private static final long serialVersionUID = 0;
        private int alreadyCreateNum_;
        private int bitField0_;
        private int canCreateMember_;
        private int isAuthor_;
        private int leftCreateNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ MemberPerm(GeneratedMessageLite.Builder builder, MemberPerm memberPerm) {
            this(builder);
        }

        private MemberPerm(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MemberPerm() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MemberPerm getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final MemberPerm getDefaultInstanceForType() {
            return a;
        }

        private MemberPerm(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                this.isAuthor_ = codedInputStream.readInt32();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.canCreateMember_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                                this.bitField0_ |= 4;
                                this.alreadyCreateNum_ = codedInputStream.readInt32();
                                break;
                            case 32:
                                this.bitField0_ |= 8;
                                this.leftCreateNum_ = codedInputStream.readInt32();
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
        public /* synthetic */ MemberPerm(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, MemberPerm memberPerm) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            MemberPerm memberPerm = new MemberPerm();
            a = memberPerm;
            memberPerm.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<MemberPerm> getParserForType() {
            return PARSER;
        }

        public final boolean hasIsAuthor() {
            return (this.bitField0_ & 1) == 1;
        }

        public final int getIsAuthor() {
            return this.isAuthor_;
        }

        public final boolean hasCanCreateMember() {
            return (this.bitField0_ & 2) == 2;
        }

        public final int getCanCreateMember() {
            return this.canCreateMember_;
        }

        public final boolean hasAlreadyCreateNum() {
            return (this.bitField0_ & 4) == 4;
        }

        public final int getAlreadyCreateNum() {
            return this.alreadyCreateNum_;
        }

        public final boolean hasLeftCreateNum() {
            return (this.bitField0_ & 8) == 8;
        }

        public final int getLeftCreateNum() {
            return this.leftCreateNum_;
        }

        private void a() {
            this.isAuthor_ = 0;
            this.canCreateMember_ = 0;
            this.alreadyCreateNum_ = 0;
            this.leftCreateNum_ = 0;
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
                codedOutputStream.writeInt32(1, this.isAuthor_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.canCreateMember_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.alreadyCreateNum_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.leftCreateNum_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.computeInt32Size(1, this.isAuthor_) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.canCreateMember_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeInt32Size(3, this.alreadyCreateNum_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(4, this.leftCreateNum_);
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

        public static MemberPerm parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static MemberPerm parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MemberPerm parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static MemberPerm parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MemberPerm parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static MemberPerm parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static MemberPerm parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static MemberPerm parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static MemberPerm parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static MemberPerm parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static k newBuilder() {
            return k.b();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final k newBuilderForType() {
            return newBuilder();
        }

        public static k newBuilder(MemberPerm memberPerm) {
            return newBuilder().mergeFrom(memberPerm);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final k toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements i {
        public static final int GRADEINFOS_FIELD_NUMBER = 2;
        public static final int GROUPINFO_FIELD_NUMBER = 1;
        public static final int MEMBERGRADEINFOS_FIELD_NUMBER = 4;
        public static final int MEMBERPERM_FIELD_NUMBER = 3;
        public static Parser<DataRes> PARSER = new g();
        private static final DataRes a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<Im.GradeInfo> gradeInfos_;
        private Im.GroupInfo groupInfo_;
        private List<Im.GradeInfo> memberGradeInfos_;
        private MemberPerm memberPerm_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

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
            k kVar;
            protobuf.k kVar2;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z = false;
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
                                case 10:
                                    if ((this.bitField0_ & 1) != 1) {
                                        kVar2 = null;
                                    } else {
                                        kVar2 = this.groupInfo_.toBuilder();
                                    }
                                    this.groupInfo_ = (Im.GroupInfo) codedInputStream.readMessage(Im.GroupInfo.PARSER, extensionRegistryLite);
                                    if (kVar2 != null) {
                                        kVar2.mergeFrom(this.groupInfo_);
                                        this.groupInfo_ = kVar2.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                    break;
                                case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                    if (!(z2 & true)) {
                                        this.gradeInfos_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.gradeInfos_.add((Im.GradeInfo) codedInputStream.readMessage(Im.GradeInfo.PARSER, extensionRegistryLite));
                                    break;
                                case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                    if ((this.bitField0_ & 2) != 2) {
                                        kVar = null;
                                    } else {
                                        kVar = this.memberPerm_.toBuilder();
                                    }
                                    this.memberPerm_ = (MemberPerm) codedInputStream.readMessage(MemberPerm.PARSER, extensionRegistryLite);
                                    if (kVar != null) {
                                        kVar.mergeFrom(this.memberPerm_);
                                        this.memberPerm_ = kVar.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                    break;
                                case Im.GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                    if (!(z2 & true)) {
                                        this.memberGradeInfos_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.memberGradeInfos_.add((Im.GradeInfo) codedInputStream.readMessage(Im.GradeInfo.PARSER, extensionRegistryLite));
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.gradeInfos_ = Collections.unmodifiableList(this.gradeInfos_);
                    }
                    if (z2 & true) {
                        this.memberGradeInfos_ = Collections.unmodifiableList(this.memberGradeInfos_);
                    }
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

        public final boolean hasGroupInfo() {
            return (this.bitField0_ & 1) == 1;
        }

        public final Im.GroupInfo getGroupInfo() {
            return this.groupInfo_;
        }

        public final List<Im.GradeInfo> getGradeInfosList() {
            return this.gradeInfos_;
        }

        public final List<? extends protobuf.i> getGradeInfosOrBuilderList() {
            return this.gradeInfos_;
        }

        public final int getGradeInfosCount() {
            return this.gradeInfos_.size();
        }

        public final Im.GradeInfo getGradeInfos(int i) {
            return this.gradeInfos_.get(i);
        }

        public final protobuf.i getGradeInfosOrBuilder(int i) {
            return this.gradeInfos_.get(i);
        }

        public final boolean hasMemberPerm() {
            return (this.bitField0_ & 2) == 2;
        }

        public final MemberPerm getMemberPerm() {
            return this.memberPerm_;
        }

        public final List<Im.GradeInfo> getMemberGradeInfosList() {
            return this.memberGradeInfos_;
        }

        public final List<? extends protobuf.i> getMemberGradeInfosOrBuilderList() {
            return this.memberGradeInfos_;
        }

        public final int getMemberGradeInfosCount() {
            return this.memberGradeInfos_.size();
        }

        public final Im.GradeInfo getMemberGradeInfos(int i) {
            return this.memberGradeInfos_.get(i);
        }

        public final protobuf.i getMemberGradeInfosOrBuilder(int i) {
            return this.memberGradeInfos_.get(i);
        }

        private void a() {
            this.groupInfo_ = Im.GroupInfo.getDefaultInstance();
            this.gradeInfos_ = Collections.emptyList();
            this.memberPerm_ = MemberPerm.getDefaultInstance();
            this.memberGradeInfos_ = Collections.emptyList();
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
                codedOutputStream.writeMessage(1, this.groupInfo_);
            }
            for (int i = 0; i < this.gradeInfos_.size(); i++) {
                codedOutputStream.writeMessage(2, this.gradeInfos_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, this.memberPerm_);
            }
            for (int i2 = 0; i2 < this.memberGradeInfos_.size(); i2++) {
                codedOutputStream.writeMessage(4, this.memberGradeInfos_.get(i2));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.groupInfo_) + 0 : 0;
                for (int i2 = 0; i2 < this.gradeInfos_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(2, this.gradeInfos_.get(i2));
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeMessageSize(3, this.memberPerm_);
                }
                for (int i3 = 0; i3 < this.memberGradeInfos_.size(); i3++) {
                    i += CodedOutputStream.computeMessageSize(4, this.memberGradeInfos_.get(i3));
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
    public final class QueryGroupGradeResIdl extends GeneratedMessageLite implements o {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryGroupGradeResIdl> PARSER = new m();
        private static final QueryGroupGradeResIdl a;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ QueryGroupGradeResIdl(GeneratedMessageLite.Builder builder, QueryGroupGradeResIdl queryGroupGradeResIdl) {
            this(builder);
        }

        private QueryGroupGradeResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryGroupGradeResIdl() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryGroupGradeResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final QueryGroupGradeResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryGroupGradeResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public /* synthetic */ QueryGroupGradeResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, QueryGroupGradeResIdl queryGroupGradeResIdl) {
            this(codedInputStream, extensionRegistryLite);
        }

        static {
            QueryGroupGradeResIdl queryGroupGradeResIdl = new QueryGroupGradeResIdl();
            a = queryGroupGradeResIdl;
            queryGroupGradeResIdl.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public final Parser<QueryGroupGradeResIdl> getParserForType() {
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

        public static QueryGroupGradeResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static QueryGroupGradeResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QueryGroupGradeResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static QueryGroupGradeResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QueryGroupGradeResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static QueryGroupGradeResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupGradeResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QueryGroupGradeResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QueryGroupGradeResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QueryGroupGradeResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static n newBuilder() {
            return n.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final n newBuilderForType() {
            return newBuilder();
        }

        public static n newBuilder(QueryGroupGradeResIdl queryGroupGradeResIdl) {
            return newBuilder().mergeFrom(queryGroupGradeResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public final n toBuilder() {
            return newBuilder(this);
        }
    }
}
