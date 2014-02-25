package protobuf.QueryPrize;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QueryPrizeRes.DataRes, h> implements i {
    private int a;
    private int b;
    private Object c = "";
    private QueryPrizeRes.PrizeInfo d = QueryPrizeRes.PrizeInfo.getDefaultInstance();

    private h() {
        g();
    }

    private void g() {
    }

    public static h h() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public h clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = QueryPrizeRes.PrizeInfo.getDefaultInstance();
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryPrizeRes.DataRes getDefaultInstanceForType() {
        return QueryPrizeRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryPrizeRes.DataRes build() {
        QueryPrizeRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryPrizeRes.DataRes buildPartial() {
        QueryPrizeRes.DataRes dataRes = new QueryPrizeRes.DataRes(this, (QueryPrizeRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.msgInOneDay_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataRes.noSendMsgTip_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataRes.prize_ = this.d;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(QueryPrizeRes.DataRes dataRes) {
        Object obj;
        if (dataRes != QueryPrizeRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasMsgInOneDay()) {
                a(dataRes.getMsgInOneDay());
            }
            if (dataRes.hasNoSendMsgTip()) {
                this.a |= 2;
                obj = dataRes.noSendMsgTip_;
                this.c = obj;
            }
            if (dataRes.hasPrize()) {
                a(dataRes.getPrize());
            }
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x001e  */
    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryPrizeRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryPrizeRes.DataRes parsePartialFrom = QueryPrizeRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataRes = null;
                if (dataRes != null) {
                    mergeFrom(dataRes);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryPrizeRes.DataRes dataRes2 = (QueryPrizeRes.DataRes) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataRes = dataRes2;
                th = th3;
                if (dataRes != null) {
                }
                throw th;
            }
        }
    }

    public h a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public h a(QueryPrizeRes.PrizeInfo prizeInfo) {
        if ((this.a & 4) == 4 && this.d != QueryPrizeRes.PrizeInfo.getDefaultInstance()) {
            this.d = QueryPrizeRes.PrizeInfo.newBuilder(this.d).mergeFrom(prizeInfo).buildPartial();
        } else {
            this.d = prizeInfo;
        }
        this.a |= 4;
        return this;
    }
}
