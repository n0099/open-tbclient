package protobuf.QueryHotGroups;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryHotGroups.QueryHotGroupsReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<QueryHotGroupsReq.QueryHotGroupsReqIdl, f> implements g {
    private int a;
    private QueryHotGroupsReq.DataReq b = QueryHotGroupsReq.DataReq.getDefaultInstance();

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
        this.b = QueryHotGroupsReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryHotGroupsReq.QueryHotGroupsReqIdl getDefaultInstanceForType() {
        return QueryHotGroupsReq.QueryHotGroupsReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryHotGroupsReq.QueryHotGroupsReqIdl build() {
        QueryHotGroupsReq.QueryHotGroupsReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryHotGroupsReq.QueryHotGroupsReqIdl buildPartial() {
        QueryHotGroupsReq.QueryHotGroupsReqIdl queryHotGroupsReqIdl = new QueryHotGroupsReq.QueryHotGroupsReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryHotGroupsReqIdl.data_ = this.b;
        queryHotGroupsReqIdl.bitField0_ = i;
        return queryHotGroupsReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(QueryHotGroupsReq.QueryHotGroupsReqIdl queryHotGroupsReqIdl) {
        if (queryHotGroupsReqIdl != QueryHotGroupsReq.QueryHotGroupsReqIdl.getDefaultInstance() && queryHotGroupsReqIdl.hasData()) {
            b(queryHotGroupsReqIdl.getData());
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

    public f a(QueryHotGroupsReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public f b(QueryHotGroupsReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QueryHotGroupsReq.DataReq.getDefaultInstance()) {
            this.b = QueryHotGroupsReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
