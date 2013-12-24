package protobuf.QueryGroupUserList;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupUserList.QueryGroupUserListReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<QueryGroupUserListReq.QueryGroupUserListReqIdl, f> implements g {
    private int a;
    private QueryGroupUserListReq.DataReq b = QueryGroupUserListReq.DataReq.getDefaultInstance();

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
        this.b = QueryGroupUserListReq.DataReq.getDefaultInstance();
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
    public QueryGroupUserListReq.QueryGroupUserListReqIdl getDefaultInstanceForType() {
        return QueryGroupUserListReq.QueryGroupUserListReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupUserListReq.QueryGroupUserListReqIdl build() {
        QueryGroupUserListReq.QueryGroupUserListReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupUserListReq.QueryGroupUserListReqIdl buildPartial() {
        QueryGroupUserListReq.QueryGroupUserListReqIdl queryGroupUserListReqIdl = new QueryGroupUserListReq.QueryGroupUserListReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryGroupUserListReqIdl.data_ = this.b;
        queryGroupUserListReqIdl.bitField0_ = i;
        return queryGroupUserListReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(QueryGroupUserListReq.QueryGroupUserListReqIdl queryGroupUserListReqIdl) {
        if (queryGroupUserListReqIdl != QueryGroupUserListReq.QueryGroupUserListReqIdl.getDefaultInstance() && queryGroupUserListReqIdl.hasData()) {
            b(queryGroupUserListReqIdl.getData());
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
        QueryGroupUserListReq.QueryGroupUserListReqIdl queryGroupUserListReqIdl;
        Throwable th;
        try {
            try {
                QueryGroupUserListReq.QueryGroupUserListReqIdl parsePartialFrom = QueryGroupUserListReq.QueryGroupUserListReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupUserListReqIdl = null;
                if (queryGroupUserListReqIdl != null) {
                    mergeFrom(queryGroupUserListReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupUserListReq.QueryGroupUserListReqIdl queryGroupUserListReqIdl2 = (QueryGroupUserListReq.QueryGroupUserListReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupUserListReqIdl = queryGroupUserListReqIdl2;
                th = th3;
                if (queryGroupUserListReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public f a(QueryGroupUserListReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public f b(QueryGroupUserListReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QueryGroupUserListReq.DataReq.getDefaultInstance()) {
            this.b = QueryGroupUserListReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
