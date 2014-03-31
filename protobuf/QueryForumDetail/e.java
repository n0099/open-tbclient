package protobuf.QueryForumDetail;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryForumDetail.QueryForumDetailReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryForumDetailReq.QueryForumDetailReqIdl, e> implements f {
    private int a;
    private QueryForumDetailReq.DataReq b = QueryForumDetailReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryForumDetailReq.QueryForumDetailReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryForumDetailReq.QueryForumDetailReqIdl.getDefaultInstance();
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
        this.b = QueryForumDetailReq.DataReq.getDefaultInstance();
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
    public final QueryForumDetailReq.QueryForumDetailReqIdl build() {
        QueryForumDetailReq.QueryForumDetailReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryForumDetailReq.QueryForumDetailReqIdl buildPartial() {
        QueryForumDetailReq.QueryForumDetailReqIdl queryForumDetailReqIdl = new QueryForumDetailReq.QueryForumDetailReqIdl(this, (QueryForumDetailReq.QueryForumDetailReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryForumDetailReqIdl.data_ = this.b;
        queryForumDetailReqIdl.bitField0_ = i;
        return queryForumDetailReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(QueryForumDetailReq.QueryForumDetailReqIdl queryForumDetailReqIdl) {
        if (queryForumDetailReqIdl != QueryForumDetailReq.QueryForumDetailReqIdl.getDefaultInstance() && queryForumDetailReqIdl.hasData()) {
            QueryForumDetailReq.DataReq data = queryForumDetailReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QueryForumDetailReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QueryForumDetailReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        QueryForumDetailReq.QueryForumDetailReqIdl queryForumDetailReqIdl;
        Throwable th;
        try {
            try {
                QueryForumDetailReq.QueryForumDetailReqIdl parsePartialFrom = QueryForumDetailReq.QueryForumDetailReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryForumDetailReqIdl = null;
                if (queryForumDetailReqIdl != null) {
                    mergeFrom(queryForumDetailReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryForumDetailReq.QueryForumDetailReqIdl queryForumDetailReqIdl2 = (QueryForumDetailReq.QueryForumDetailReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryForumDetailReqIdl = queryForumDetailReqIdl2;
                th = th3;
                if (queryForumDetailReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(QueryForumDetailReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
