package protobuf.QueryHotGroups;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryHotGroups.QueryHotGroupsReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryHotGroupsReq.QueryHotGroupsReqIdl, e> implements f {
    private int a;
    private QueryHotGroupsReq.DataReq b = QueryHotGroupsReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryHotGroupsReq.QueryHotGroupsReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryHotGroupsReq.QueryHotGroupsReqIdl.getDefaultInstance();
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
        this.b = QueryHotGroupsReq.DataReq.getDefaultInstance();
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
    public final QueryHotGroupsReq.QueryHotGroupsReqIdl build() {
        QueryHotGroupsReq.QueryHotGroupsReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryHotGroupsReq.QueryHotGroupsReqIdl buildPartial() {
        QueryHotGroupsReq.QueryHotGroupsReqIdl queryHotGroupsReqIdl = new QueryHotGroupsReq.QueryHotGroupsReqIdl(this, (QueryHotGroupsReq.QueryHotGroupsReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryHotGroupsReqIdl.data_ = this.b;
        queryHotGroupsReqIdl.bitField0_ = i;
        return queryHotGroupsReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(QueryHotGroupsReq.QueryHotGroupsReqIdl queryHotGroupsReqIdl) {
        if (queryHotGroupsReqIdl != QueryHotGroupsReq.QueryHotGroupsReqIdl.getDefaultInstance() && queryHotGroupsReqIdl.hasData()) {
            QueryHotGroupsReq.DataReq data = queryHotGroupsReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QueryHotGroupsReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QueryHotGroupsReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        QueryHotGroupsReq.QueryHotGroupsReqIdl queryHotGroupsReqIdl;
        Throwable th;
        try {
            try {
                QueryHotGroupsReq.QueryHotGroupsReqIdl parsePartialFrom = QueryHotGroupsReq.QueryHotGroupsReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryHotGroupsReqIdl = null;
                if (queryHotGroupsReqIdl != null) {
                    mergeFrom(queryHotGroupsReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryHotGroupsReq.QueryHotGroupsReqIdl queryHotGroupsReqIdl2 = (QueryHotGroupsReq.QueryHotGroupsReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryHotGroupsReqIdl = queryHotGroupsReqIdl2;
                th = th3;
                if (queryHotGroupsReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(QueryHotGroupsReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
