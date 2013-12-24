package protobuf.QueryGroupDetail;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupDetail.QueryGroupDetailReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<QueryGroupDetailReq.QueryGroupDetailReqIdl, f> implements g {
    private int a;
    private QueryGroupDetailReq.DataReq b = QueryGroupDetailReq.DataReq.getDefaultInstance();

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
        this.b = QueryGroupDetailReq.DataReq.getDefaultInstance();
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
    public QueryGroupDetailReq.QueryGroupDetailReqIdl getDefaultInstanceForType() {
        return QueryGroupDetailReq.QueryGroupDetailReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupDetailReq.QueryGroupDetailReqIdl build() {
        QueryGroupDetailReq.QueryGroupDetailReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupDetailReq.QueryGroupDetailReqIdl buildPartial() {
        QueryGroupDetailReq.QueryGroupDetailReqIdl queryGroupDetailReqIdl = new QueryGroupDetailReq.QueryGroupDetailReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryGroupDetailReqIdl.data_ = this.b;
        queryGroupDetailReqIdl.bitField0_ = i;
        return queryGroupDetailReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(QueryGroupDetailReq.QueryGroupDetailReqIdl queryGroupDetailReqIdl) {
        if (queryGroupDetailReqIdl != QueryGroupDetailReq.QueryGroupDetailReqIdl.getDefaultInstance() && queryGroupDetailReqIdl.hasData()) {
            b(queryGroupDetailReqIdl.getData());
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
        QueryGroupDetailReq.QueryGroupDetailReqIdl queryGroupDetailReqIdl;
        Throwable th;
        try {
            try {
                QueryGroupDetailReq.QueryGroupDetailReqIdl parsePartialFrom = QueryGroupDetailReq.QueryGroupDetailReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupDetailReqIdl = null;
                if (queryGroupDetailReqIdl != null) {
                    mergeFrom(queryGroupDetailReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupDetailReq.QueryGroupDetailReqIdl queryGroupDetailReqIdl2 = (QueryGroupDetailReq.QueryGroupDetailReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupDetailReqIdl = queryGroupDetailReqIdl2;
                th = th3;
                if (queryGroupDetailReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public f a(QueryGroupDetailReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public f b(QueryGroupDetailReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QueryGroupDetailReq.DataReq.getDefaultInstance()) {
            this.b = QueryGroupDetailReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
