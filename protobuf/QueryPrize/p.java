package protobuf.QueryPrize;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
public final class p extends GeneratedMessageLite.Builder<QueryPrizeRes.QueryPrizeResIdl, p> implements q {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryPrizeRes.DataRes c = QueryPrizeRes.DataRes.getDefaultInstance();

    private p() {
        g();
    }

    private void g() {
    }

    public static p h() {
        return new p();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public p clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = QueryPrizeRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public p clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryPrizeRes.QueryPrizeResIdl getDefaultInstanceForType() {
        return QueryPrizeRes.QueryPrizeResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryPrizeRes.QueryPrizeResIdl build() {
        QueryPrizeRes.QueryPrizeResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryPrizeRes.QueryPrizeResIdl buildPartial() {
        QueryPrizeRes.QueryPrizeResIdl queryPrizeResIdl = new QueryPrizeRes.QueryPrizeResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryPrizeResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryPrizeResIdl.data_ = this.c;
        queryPrizeResIdl.bitField0_ = i2;
        return queryPrizeResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public p mergeFrom(QueryPrizeRes.QueryPrizeResIdl queryPrizeResIdl) {
        if (queryPrizeResIdl != QueryPrizeRes.QueryPrizeResIdl.getDefaultInstance()) {
            if (queryPrizeResIdl.hasError()) {
                a(queryPrizeResIdl.getError());
            }
            if (queryPrizeResIdl.hasData()) {
                a(queryPrizeResIdl.getData());
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
    public p mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryPrizeRes.QueryPrizeResIdl queryPrizeResIdl;
        Throwable th;
        try {
            try {
                QueryPrizeRes.QueryPrizeResIdl parsePartialFrom = QueryPrizeRes.QueryPrizeResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryPrizeResIdl = null;
                if (queryPrizeResIdl != null) {
                    mergeFrom(queryPrizeResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryPrizeRes.QueryPrizeResIdl queryPrizeResIdl2 = (QueryPrizeRes.QueryPrizeResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryPrizeResIdl = queryPrizeResIdl2;
                th = th3;
                if (queryPrizeResIdl != null) {
                }
                throw th;
            }
        }
    }

    public p a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public p a(QueryPrizeRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryPrizeRes.DataRes.getDefaultInstance()) {
            this.c = QueryPrizeRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
