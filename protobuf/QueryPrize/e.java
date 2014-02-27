package protobuf.QueryPrize;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryPrize.QueryPrizeReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryPrizeReq.QueryPrizeReqIdl, e> implements f {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryPrizeReq.DataReq c = QueryPrizeReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryPrizeReq.QueryPrizeReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryPrizeReq.QueryPrizeReqIdl.getDefaultInstance();
    }

    private e() {
    }

    public static /* synthetic */ e b() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public e clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = QueryPrizeReq.DataReq.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public e clone() {
        return new e().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryPrizeReq.QueryPrizeReqIdl build() {
        QueryPrizeReq.QueryPrizeReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryPrizeReq.QueryPrizeReqIdl buildPartial() {
        QueryPrizeReq.QueryPrizeReqIdl queryPrizeReqIdl = new QueryPrizeReq.QueryPrizeReqIdl(this, (QueryPrizeReq.QueryPrizeReqIdl) null);
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
    public final e mergeFrom(QueryPrizeReq.QueryPrizeReqIdl queryPrizeReqIdl) {
        if (queryPrizeReqIdl != QueryPrizeReq.QueryPrizeReqIdl.getDefaultInstance()) {
            if (queryPrizeReqIdl.hasError()) {
                Im.Error error = queryPrizeReqIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryPrizeReqIdl.hasData()) {
                QueryPrizeReq.DataReq data = queryPrizeReqIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryPrizeReq.DataReq.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryPrizeReq.DataReq.newBuilder(this.c).mergeFrom(data).buildPartial();
                }
                this.a |= 2;
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
    public e mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

    public final e a(QueryPrizeReq.DataReq dataReq) {
        if (dataReq != null) {
            this.c = dataReq;
            this.a |= 2;
        }
        return this;
    }
}
