package protobuf.QueryPrize;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import protobuf.Im;
/* loaded from: classes.dex */
public final class QueryPrizeRes {

    /* loaded from: classes.dex */
    public final class PrizeInfo extends GeneratedMessageLite implements n {
        public static final int ABSTRACT_FIELD_NUMBER = 6;
        public static final int LINK_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIME_FIELD_NUMBER = 8;
        public static final int PICLIST_FIELD_NUMBER = 4;
        public static final int PRIZEID_FIELD_NUMBER = 7;
        public static final int SUBTYPE_FIELD_NUMBER = 5;
        public static final int TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private Object abstract_;
        private int bitField0_;
        private Object link_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int opTime_;
        private LazyStringList picList_;
        private int prizeId_;
        private int subType_;
        private int type_;
        public static Parser<PrizeInfo> PARSER = new l();
        private static final PrizeInfo a = new PrizeInfo(true);

        private PrizeInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private PrizeInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static PrizeInfo getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public PrizeInfo getDefaultInstanceForType() {
            return a;
        }

        private PrizeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            boolean z = false;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            a();
            boolean z2 = false;
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
                                this.name_ = codedInputStream.readBytes();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.type_ = codedInputStream.readInt32();
                                break;
                            case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                this.bitField0_ |= 4;
                                this.link_ = codedInputStream.readBytes();
                                break;
                            case Im.GroupInfo.ISMEMBERGROUP_FIELD_NUMBER /* 34 */:
                                if (!(z2 & true)) {
                                    this.picList_ = new LazyStringArrayList();
                                    z2 |= true;
                                }
                                this.picList_.add(codedInputStream.readBytes());
                                break;
                            case 40:
                                this.bitField0_ |= 8;
                                this.subType_ = codedInputStream.readInt32();
                                break;
                            case 50:
                                this.bitField0_ |= 16;
                                this.abstract_ = codedInputStream.readBytes();
                                break;
                            case 56:
                                this.bitField0_ |= 32;
                                this.prizeId_ = codedInputStream.readInt32();
                                break;
                            case 64:
                                this.bitField0_ |= 64;
                                this.opTime_ = codedInputStream.readInt32();
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
                        this.picList_ = new UnmodifiableLazyStringList(this.picList_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            a.a();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<PrizeInfo> getParserForType() {
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

        public boolean hasType() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasLink() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getLink() {
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

        public ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public List<String> getPicListList() {
            return this.picList_;
        }

        public int getPicListCount() {
            return this.picList_.size();
        }

        public String getPicList(int i) {
            return this.picList_.get(i);
        }

        public ByteString getPicListBytes(int i) {
            return this.picList_.getByteString(i);
        }

        public boolean hasSubType() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getSubType() {
            return this.subType_;
        }

        public boolean hasAbstract() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getAbstract() {
            Object obj = this.abstract_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.abstract_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAbstractBytes() {
            Object obj = this.abstract_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.abstract_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasPrizeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getPrizeId() {
            return this.prizeId_;
        }

        public boolean hasOpTime() {
            return (this.bitField0_ & 64) == 64;
        }

        public int getOpTime() {
            return this.opTime_;
        }

        private void a() {
            this.name_ = "";
            this.type_ = 0;
            this.link_ = "";
            this.picList_ = LazyStringArrayList.EMPTY;
            this.subType_ = 0;
            this.abstract_ = "";
            this.prizeId_ = 0;
            this.opTime_ = 0;
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
                codedOutputStream.writeInt32(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getLinkBytes());
            }
            for (int i = 0; i < this.picList_.size(); i++) {
                codedOutputStream.writeBytes(4, this.picList_.getByteString(i));
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.subType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(6, getAbstractBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.prizeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(8, this.opTime_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                int computeBytesSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBytesSize(1, getNameBytes()) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeBytesSize += CodedOutputStream.computeInt32Size(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeBytesSize += CodedOutputStream.computeBytesSize(3, getLinkBytes());
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.picList_.size(); i3++) {
                    i2 += CodedOutputStream.computeBytesSizeNoTag(this.picList_.getByteString(i3));
                }
                i = computeBytesSize + i2 + (getPicListList().size() * 1);
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt32Size(5, this.subType_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(6, getAbstractBytes());
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeInt32Size(7, this.prizeId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeInt32Size(8, this.opTime_);
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

        public static PrizeInfo parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static PrizeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PrizeInfo parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static PrizeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PrizeInfo parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static PrizeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static PrizeInfo parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static PrizeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static PrizeInfo parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static PrizeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static m newBuilder(PrizeInfo prizeInfo) {
            return newBuilder().mergeFrom(prizeInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public m toBuilder() {
            return newBuilder(this);
        }
    }

    /* loaded from: classes.dex */
    public final class DataRes extends GeneratedMessageLite implements k {
        public static final int MSGINONEDAY_FIELD_NUMBER = 1;
        public static final int NOSENDMSGTIP_FIELD_NUMBER = 2;
        public static final int PRIZE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int msgInOneDay_;
        private Object noSendMsgTip_;
        private PrizeInfo prize_;
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

        private DataRes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            m mVar;
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
                                this.msgInOneDay_ = codedInputStream.readInt32();
                                z = z2;
                                break;
                            case Im.GroupInfo.MAXMEMBERNUM_FIELD_NUMBER /* 18 */:
                                this.bitField0_ |= 2;
                                this.noSendMsgTip_ = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case Im.GroupInfo.NICKNAME_FIELD_NUMBER /* 26 */:
                                if ((this.bitField0_ & 4) != 4) {
                                    mVar = null;
                                } else {
                                    mVar = this.prize_.toBuilder();
                                }
                                this.prize_ = (PrizeInfo) codedInputStream.readMessage(PrizeInfo.PARSER, extensionRegistryLite);
                                if (mVar != null) {
                                    mVar.mergeFrom(this.prize_);
                                    this.prize_ = mVar.buildPartial();
                                }
                                this.bitField0_ |= 4;
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
        public Parser<DataRes> getParserForType() {
            return PARSER;
        }

        public boolean hasMsgInOneDay() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getMsgInOneDay() {
            return this.msgInOneDay_;
        }

        public boolean hasNoSendMsgTip() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getNoSendMsgTip() {
            Object obj = this.noSendMsgTip_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.noSendMsgTip_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNoSendMsgTipBytes() {
            Object obj = this.noSendMsgTip_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.noSendMsgTip_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasPrize() {
            return (this.bitField0_ & 4) == 4;
        }

        public PrizeInfo getPrize() {
            return this.prize_;
        }

        private void a() {
            this.msgInOneDay_ = 0;
            this.noSendMsgTip_ = "";
            this.prize_ = PrizeInfo.getDefaultInstance();
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
                codedOutputStream.writeInt32(1, this.msgInOneDay_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getNoSendMsgTipBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.prize_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.msgInOneDay_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getNoSendMsgTipBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(3, this.prize_);
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
    public final class QueryPrizeResIdl extends GeneratedMessageLite implements q {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static Parser<QueryPrizeResIdl> PARSER = new o();
        private static final QueryPrizeResIdl a = new QueryPrizeResIdl(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private DataRes data_;
        private Im.Error error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private QueryPrizeResIdl(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private QueryPrizeResIdl(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static QueryPrizeResIdl getDefaultInstance() {
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public QueryPrizeResIdl getDefaultInstanceForType() {
            return a;
        }

        private QueryPrizeResIdl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        public Parser<QueryPrizeResIdl> getParserForType() {
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

        public static QueryPrizeResIdl parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        public static QueryPrizeResIdl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QueryPrizeResIdl parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        public static QueryPrizeResIdl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QueryPrizeResIdl parseFrom(InputStream inputStream) {
            return PARSER.parseFrom(inputStream);
        }

        public static QueryPrizeResIdl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QueryPrizeResIdl parseDelimitedFrom(InputStream inputStream) {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QueryPrizeResIdl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QueryPrizeResIdl parseFrom(CodedInputStream codedInputStream) {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QueryPrizeResIdl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

        public static p newBuilder(QueryPrizeResIdl queryPrizeResIdl) {
            return newBuilder().mergeFrom(queryPrizeResIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public p toBuilder() {
            return newBuilder(this);
        }
    }
}
