package protobuf.QueryGroupsByFid;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupsByFid.QueryGroupsByFidReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryGroupsByFidReq.QueryGroupsByFidReqIdl, e> implements f {
    private int a;
    private QueryGroupsByFidReq.DataReq b = QueryGroupsByFidReq.DataReq.getDefaultInstance();

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
        this.b = QueryGroupsByFidReq.DataReq.getDefaultInstance();
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
    public QueryGroupsByFidReq.QueryGroupsByFidReqIdl getDefaultInstanceForType() {
        return QueryGroupsByFidReq.QueryGroupsByFidReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupsByFidReq.QueryGroupsByFidReqIdl build() {
        QueryGroupsByFidReq.QueryGroupsByFidReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupsByFidReq.QueryGroupsByFidReqIdl buildPartial() {
        QueryGroupsByFidReq.QueryGroupsByFidReqIdl queryGroupsByFidReqIdl = new QueryGroupsByFidReq.QueryGroupsByFidReqIdl(this, (QueryGroupsByFidReq.QueryGroupsByFidReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryGroupsByFidReqIdl.data_ = this.b;
        queryGroupsByFidReqIdl.bitField0_ = i;
        return queryGroupsByFidReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(QueryGroupsByFidReq.QueryGroupsByFidReqIdl queryGroupsByFidReqIdl) {
        if (queryGroupsByFidReqIdl != QueryGroupsByFidReq.QueryGroupsByFidReqIdl.getDefaultInstance() && queryGroupsByFidReqIdl.hasData()) {
            b(queryGroupsByFidReqIdl.getData());
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
        QueryGroupsByFidReq.QueryGroupsByFidReqIdl queryGroupsByFidReqIdl;
        Throwable th;
        try {
            try {
                QueryGroupsByFidReq.QueryGroupsByFidReqIdl parsePartialFrom = QueryGroupsByFidReq.QueryGroupsByFidReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupsByFidReqIdl = null;
                if (queryGroupsByFidReqIdl != null) {
                    mergeFrom(queryGroupsByFidReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupsByFidReq.QueryGroupsByFidReqIdl queryGroupsByFidReqIdl2 = (QueryGroupsByFidReq.QueryGroupsByFidReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupsByFidReqIdl = queryGroupsByFidReqIdl2;
                th = th3;
                if (queryGroupsByFidReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(QueryGroupsByFidReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public e b(QueryGroupsByFidReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QueryGroupsByFidReq.DataReq.getDefaultInstance()) {
            this.b = QueryGroupsByFidReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
