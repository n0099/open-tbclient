package protobuf.QueryPrize;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryPrize.QueryPrizeReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<QueryPrizeReq.QueryPrizeReqIdl, f> implements g {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryPrizeReq.DataReq c = QueryPrizeReq.DataReq.getDefaultInstance();

    private f() {
        g();
    }

    private void g() {
    }

    public static f h() {
        return new f();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public f clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = QueryPrizeReq.DataReq.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryPrizeReq.QueryPrizeReqIdl getDefaultInstanceForType() {
        return QueryPrizeReq.QueryPrizeReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryPrizeReq.QueryPrizeReqIdl build() {
        QueryPrizeReq.QueryPrizeReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryPrizeReq.QueryPrizeReqIdl buildPartial() {
        QueryPrizeReq.QueryPrizeReqIdl queryPrizeReqIdl = new QueryPrizeReq.QueryPrizeReqIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryPrizeReqIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryPrizeReqIdl.data_ = this.c;
        queryPrizeReqIdl.bitField0_ = i2;
        return queryPrizeReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(QueryPrizeReq.QueryPrizeReqIdl queryPrizeReqIdl) {
        if (queryPrizeReqIdl != QueryPrizeReq.QueryPrizeReqIdl.getDefaultInstance()) {
            if (queryPrizeReqIdl.hasError()) {
                a(queryPrizeReqIdl.getError());
            }
            if (queryPrizeReqIdl.hasData()) {
                b(queryPrizeReqIdl.getData());
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
    public f mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryPrizeReq.QueryPrizeReqIdl queryPrizeReqIdl;
        Throwable th;
        try {
            try {
                QueryPrizeReq.QueryPrizeReqIdl parsePartialFrom = QueryPrizeReq.QueryPrizeReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryPrizeReqIdl = null;
                if (queryPrizeReqIdl != null) {
                    mergeFrom(queryPrizeReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryPrizeReq.QueryPrizeReqIdl queryPrizeReqIdl2 = (QueryPrizeReq.QueryPrizeReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryPrizeReqIdl = queryPrizeReqIdl2;
                th = th3;
                if (queryPrizeReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public f a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public f a(QueryPrizeReq.DataReq dataReq) {
        if (dataReq != null) {
            this.c = dataReq;
            this.a |= 2;
        }
        return this;
    }

    public f b(QueryPrizeReq.DataReq dataReq) {
        if ((this.a & 2) == 2 && this.c != QueryPrizeReq.DataReq.getDefaultInstance()) {
            this.c = QueryPrizeReq.DataReq.newBuilder(this.c).mergeFrom(dataReq).buildPartial();
        } else {
            this.c = dataReq;
        }
        this.a |= 2;
        return this;
    }
}
