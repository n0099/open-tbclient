package protobuf.QueryGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryGroupActivity.QueryGroupActivityReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryGroupActivityReq.QueryGroupActivityReqIdl, e> implements f {
    private int a;
    private QueryGroupActivityReq.DataReq b = QueryGroupActivityReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupActivityReq.QueryGroupActivityReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupActivityReq.QueryGroupActivityReqIdl.getDefaultInstance();
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
        this.b = QueryGroupActivityReq.DataReq.getDefaultInstance();
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
    public final QueryGroupActivityReq.QueryGroupActivityReqIdl build() {
        QueryGroupActivityReq.QueryGroupActivityReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupActivityReq.QueryGroupActivityReqIdl buildPartial() {
        QueryGroupActivityReq.QueryGroupActivityReqIdl queryGroupActivityReqIdl = new QueryGroupActivityReq.QueryGroupActivityReqIdl(this, (QueryGroupActivityReq.QueryGroupActivityReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryGroupActivityReqIdl.data_ = this.b;
        queryGroupActivityReqIdl.bitField0_ = i;
        return queryGroupActivityReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(QueryGroupActivityReq.QueryGroupActivityReqIdl queryGroupActivityReqIdl) {
        if (queryGroupActivityReqIdl != QueryGroupActivityReq.QueryGroupActivityReqIdl.getDefaultInstance() && queryGroupActivityReqIdl.hasData()) {
            QueryGroupActivityReq.DataReq data = queryGroupActivityReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QueryGroupActivityReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QueryGroupActivityReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        QueryGroupActivityReq.QueryGroupActivityReqIdl queryGroupActivityReqIdl;
        Throwable th;
        try {
            try {
                QueryGroupActivityReq.QueryGroupActivityReqIdl parsePartialFrom = QueryGroupActivityReq.QueryGroupActivityReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupActivityReqIdl = null;
                if (queryGroupActivityReqIdl != null) {
                    mergeFrom(queryGroupActivityReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupActivityReq.QueryGroupActivityReqIdl queryGroupActivityReqIdl2 = (QueryGroupActivityReq.QueryGroupActivityReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupActivityReqIdl = queryGroupActivityReqIdl2;
                th = th3;
                if (queryGroupActivityReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(QueryGroupActivityReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
