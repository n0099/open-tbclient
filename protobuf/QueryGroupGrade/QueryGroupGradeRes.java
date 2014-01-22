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
    public final class MemberPerm extends GeneratedMessageLite implements n {
        public static final int ALREADYCREATENUM_FIELD_NUMBER = 3;
        public static final int CANCREATEMEMBER_FIELD_NUMBER = 2;
        public static final int ISAUTHOR_FIELD_NUMBER = 1;
        public static final int LEFTCREATENUM_FIELD_NUMBER = 4;
        public static Parser<MemberPerm> PARSER = new l();
        private static final MemberPerm a = new MemberPerm(true);
        private static final long serialVersionUID = 0;
        private int alreadyCreateNum_;
        private int bitField0_;
        private int canCreateMember_;
        private int isAuthor_;
        private int leftCreateNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private MemberPerm(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MemberPerm(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MemberPerm getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MemberPerm getDefaultInstanceForType() {
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
                                case Im.GroupInfo.ISNEWLYCREATE_FIELD_NUMBER /* 32 */:
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
        public Parser<MemberPerm> getParserForType() {
            return PARSER;
        }

        public boolean hasIsAuthor() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getIsAuthor() {
            return this.isAuthor_;
        }

        public boolean hasCanCreateMember() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getCanCreateMember() {
            return this.canCreateMember_;
        }

        public boolean hasAlreadyCreateNum() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getAlreadyCreateNum() {
            return this.alreadyCreateNum_;
        }

        public boolean hasLeftCreateNum() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getLeftCreateNum() {
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
        public void writeTo(CodedOutputStream codedOutputStream) {
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
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.isAuthor_) : 0;
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
        public Object writeReplace() {
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

        public static m newBuilder() {
            return m.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m newBuilderForType() {
            return newBuilder();
        }

        public static m newBuilder(MemberPerm memberPerm) {
            return newBuilder().mergeFrom(memberPerm);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements k {
        public static final int GRADEINFOS_FIELD_NUMBER = 2;
        public static final int GROUPINFO_FIELD_NUMBER = 1;
        public static final int MEMBERGRADEINFOS_FIELD_NUMBER = 4;
        public static final int MEMBERPERM_FIELD_NUMBER = 3;
        public static Parser<DataRes> PARSER = new i();
        private static final DataRes a = new DataRes(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<Im.GradeInfo> gradeInfos_;
        private Im.GroupInfo groupInfo_;
        private List<Im.GradeInfo> memberGradeInfos_;
        private MemberPerm memberPerm_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

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

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<protobuf.Im$GradeInfo> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: java.util.List<protobuf.Im$GradeInfo> */
        /* JADX WARN: Multi-variable type inference failed */
        private DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            boolean z;
            boolean z2;
            boolean z3;
            m mVar;
            boolean z4;
            protobuf.i iVar;
            boolean z5 = false;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z6 = false;
            while (!z5) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z3 = true;
                                z2 = z6;
                                break;
                            case 10:
                                if ((this.bitField0_ & 1) != 1) {
                                    iVar = null;
                                } else {
                                    iVar = this.groupInfo_.toBuilder();
                                }
                                this.groupInfo_ = (Im.GroupInfo) codedInputStream.readMessage(Im.GroupInfo.PARSER, extensionRegistryLite);
                                if (iVar != null) {
                                    iVar.mergeFrom(this.groupInfo_);
                                    this.groupInfo_ = iVar.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                z3 = z5;
                                z2 = z6;
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                if (!(z6 & true)) {
                                    this.gradeInfos_ = new ArrayList();
                                    z4 = z6 | true;
                                } else {
                                    z4 = z6;
                                }
                                try {
                                    this.gradeInfos_.add(codedInputStream.readMessage(Im.GradeInfo.PARSER, extensionRegistryLite));
                                    boolean z7 = z5;
                                    z2 = z4;
                                    z3 = z7;
                                    break;
                                } catch (InvalidProtocolBufferException e) {
                                    e = e;
                                    throw e.setUnfinishedMessage(this);
                                } catch (IOException e2) {
                                    e = e2;
                                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                                } catch (Throwable th) {
                                    z6 = z4;
                                    th = th;
                                    if (z6 & true) {
                                        this.gradeInfos_ = Collections.unmodifiableList(this.gradeInfos_);
                                    }
                                    if (z6 & true) {
                                        this.memberGradeInfos_ = Collections.unmodifiableList(this.memberGradeInfos_);
                                    }
                                    makeExtensionsImmutable();
                                    throw th;
                                }
                            case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                if ((this.bitField0_ & 2) != 2) {
                                    mVar = null;
                                } else {
                                    mVar = this.memberPerm_.toBuilder();
                                }
                                this.memberPerm_ = (MemberPerm) codedInputStream.readMessage(MemberPerm.PARSER, extensionRegistryLite);
                                if (mVar != null) {
                                    mVar.mergeFrom(this.memberPerm_);
                                    this.memberPerm_ = mVar.buildPartial();
                                }
                                this.bitField0_ |= 2;
                                z3 = z5;
                                z2 = z6;
                                break;
                            case Im.GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                if (!(z6 & true)) {
                                    this.memberGradeInfos_ = new ArrayList();
                                    z = z6 | true;
                                } else {
                                    z = z6;
                                }
                                this.memberGradeInfos_.add(codedInputStream.readMessage(Im.GradeInfo.PARSER, extensionRegistryLite));
                                boolean z8 = z5;
                                z2 = z;
                                z3 = z8;
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z3 = true;
                                    z2 = z6;
                                    break;
                                } else {
                                    z3 = z5;
                                    z2 = z6;
                                    break;
                                }
                        }
                        z6 = z2;
                        z5 = z3;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (InvalidProtocolBufferException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            }
            if (z6 & true) {
                this.gradeInfos_ = Collections.unmodifiableList(this.gradeInfos_);
            }
            if (z6 & true) {
                this.memberGradeInfos_ = Collections.unmodifiableList(this.memberGradeInfos_);
            }
            makeExtensionsImmutable();
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<DataRes> getParserForType() {
            return PARSER;
        }

        public boolean hasGroupInfo() {
            return (this.bitField0_ & 1) == 1;
        }

        public Im.GroupInfo getGroupInfo() {
            return this.groupInfo_;
        }

        public List<Im.GradeInfo> getGradeInfosList() {
            return this.gradeInfos_;
        }

        public List<? extends protobuf.g> getGradeInfosOrBuilderList() {
            return this.gradeInfos_;
        }

        public int getGradeInfosCount() {
            return this.gradeInfos_.size();
        }

        public Im.GradeInfo getGradeInfos(int i) {
            return this.gradeInfos_.get(i);
        }

        public protobuf.g getGradeInfosOrBuilder(int i) {
            return this.gradeInfos_.get(i);
        }

        public boolean hasMemberPerm() {
            return (this.bitField0_ & 2) == 2;
        }

        public MemberPerm getMemberPerm() {
            return this.memberPerm_;
        }

        public List<Im.GradeInfo> getMemberGradeInfosList() {
            return this.memberGradeInfos_;
        }

        public List<? extends protobuf.g> getMemberGradeInfosOrBuilderList() {
            return this.memberGradeInfos_;
        }

        public int getMemberGradeInfosCount() {
            return this.memberGradeInfos_.size();
        }

        public Im.GradeInfo getMemberGradeInfos(int i) {
            return this.memberGradeInfos_.get(i);
        }

        public protobuf.g getMemberGradeInfosOrBuilder(int i) {
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
        public void writeTo(CodedOutputStream codedOutputStream) {
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
        public int getSerializedSize() {
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
    public final class QueryGroupGradeResIdl extends GeneratedMessageLite implements q {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryGroupGradeResIdl> PARSER = new o();
        private static final QueryGroupGradeResIdl a = new QueryGroupGradeResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private QueryGroupGradeResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryGroupGradeResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryGroupGradeResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public QueryGroupGradeResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryGroupGradeResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public Parser<QueryGroupGradeResIdl> getParserForType() {
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

        public static p newBuilder() {
            return p.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public p newBuilderForType() {
            return newBuilder();
        }

        public static p newBuilder(QueryGroupGradeResIdl queryGroupGradeResIdl) {
            return newBuilder().mergeFrom(queryGroupGradeResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public p toBuilder() {
            return newBuilder(this);
        }
    }
}
