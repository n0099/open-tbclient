package protobuf.QueryGroupCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupCount.QueryGroupCountReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryGroupCountReq.QueryGroupCountReqIdl, e> implements f {
    private int a;
    private QueryGroupCountReq.DataReq b = QueryGroupCountReq.DataReq.getDefaultInstance();

    private e() {
        g();
    }

    private void g() {
    }

    public static e h() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public e clear() {
        super.clear();
        this.b = QueryGroupCountReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupCountReq.QueryGroupCountReqIdl getDefaultInstanceForType() {
        return QueryGroupCountReq.QueryGroupCountReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupCountReq.QueryGroupCountReqIdl build() {
        QueryGroupCountReq.QueryGroupCountReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupCountReq.QueryGroupCountReqIdl buildPartial() {
        QueryGroupCountReq.QueryGroupCountReqIdl queryGroupCountReqIdl = new QueryGroupCountReq.QueryGroupCountReqIdl(this, (QueryGroupCountReq.QueryGroupCountReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryGroupCountReqIdl.data_ = this.b;
        queryGroupCountReqIdl.bitField0_ = i;
        return queryGroupCountReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(QueryGroupCountReq.QueryGroupCountReqIdl queryGroupCountReqIdl) {
        if (queryGroupCountReqIdl != QueryGroupCountReq.QueryGroupCountReqIdl.getDefaultInstance() && queryGroupCountReqIdl.hasData()) {
            b(queryGroupCountReqIdl.getData());
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
        QueryGroupCountReq.QueryGroupCountReqIdl queryGroupCountReqIdl;
        Throwable th;
        try {
            try {
                QueryGroupCountReq.QueryGroupCountReqIdl parsePartialFrom = QueryGroupCountReq.QueryGroupCountReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupCountReqIdl = null;
                if (queryGroupCountReqIdl != null) {
                    mergeFrom(queryGroupCountReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupCountReq.QueryGroupCountReqIdl queryGroupCountReqIdl2 = (QueryGroupCountReq.QueryGroupCountReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupCountReqIdl = queryGroupCountReqIdl2;
                th = th3;
                if (queryGroupCountReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(QueryGroupCountReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public e b(QueryGroupCountReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QueryGroupCountReq.DataReq.getDefaultInstance()) {
            this.b = QueryGroupCountReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
