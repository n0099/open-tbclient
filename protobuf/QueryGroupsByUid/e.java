package protobuf.QueryGroupsByUid;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryGroupsByUid.QueryGroupsByUidReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryGroupsByUidReq.QueryGroupsByUidReqIdl, e> implements f {
    private int a;
    private QueryGroupsByUidReq.DataReq b = QueryGroupsByUidReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupsByUidReq.QueryGroupsByUidReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupsByUidReq.QueryGroupsByUidReqIdl.getDefaultInstance();
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
        this.b = QueryGroupsByUidReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public e clone() {
        return new e().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryGroupsByUidReq.QueryGroupsByUidReqIdl build() {
        QueryGroupsByUidReq.QueryGroupsByUidReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupsByUidReq.QueryGroupsByUidReqIdl buildPartial() {
        QueryGroupsByUidReq.QueryGroupsByUidReqIdl queryGroupsByUidReqIdl = new QueryGroupsByUidReq.QueryGroupsByUidReqIdl(this, (QueryGroupsByUidReq.QueryGroupsByUidReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryGroupsByUidReqIdl.data_ = this.b;
        queryGroupsByUidReqIdl.bitField0_ = i;
        return queryGroupsByUidReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(QueryGroupsByUidReq.QueryGroupsByUidReqIdl queryGroupsByUidReqIdl) {
        if (queryGroupsByUidReqIdl != QueryGroupsByUidReq.QueryGroupsByUidReqIdl.getDefaultInstance() && queryGroupsByUidReqIdl.hasData()) {
            QueryGroupsByUidReq.DataReq data = queryGroupsByUidReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QueryGroupsByUidReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QueryGroupsByUidReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
            }
            this.a |= 1;
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
        QueryGroupsByUidReq.QueryGroupsByUidReqIdl queryGroupsByUidReqIdl;
        Throwable th;
        try {
            try {
                QueryGroupsByUidReq.QueryGroupsByUidReqIdl parsePartialFrom = QueryGroupsByUidReq.QueryGroupsByUidReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupsByUidReqIdl = null;
                if (queryGroupsByUidReqIdl != null) {
                    mergeFrom(queryGroupsByUidReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupsByUidReq.QueryGroupsByUidReqIdl queryGroupsByUidReqIdl2 = (QueryGroupsByUidReq.QueryGroupsByUidReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupsByUidReqIdl = queryGroupsByUidReqIdl2;
                th = th3;
                if (queryGroupsByUidReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(QueryGroupsByUidReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
