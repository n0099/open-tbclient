package protobuf.QueryUserPermission;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryUserPermission.QueryUserPermissionReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryUserPermissionReq.QueryUserPermissionReqIdl, e> implements f {
    private int a;
    private QueryUserPermissionReq.DataReq b = QueryUserPermissionReq.DataReq.getDefaultInstance();

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
        this.b = QueryUserPermissionReq.DataReq.getDefaultInstance();
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
    public QueryUserPermissionReq.QueryUserPermissionReqIdl getDefaultInstanceForType() {
        return QueryUserPermissionReq.QueryUserPermissionReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryUserPermissionReq.QueryUserPermissionReqIdl build() {
        QueryUserPermissionReq.QueryUserPermissionReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryUserPermissionReq.QueryUserPermissionReqIdl buildPartial() {
        QueryUserPermissionReq.QueryUserPermissionReqIdl queryUserPermissionReqIdl = new QueryUserPermissionReq.QueryUserPermissionReqIdl(this, (QueryUserPermissionReq.QueryUserPermissionReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryUserPermissionReqIdl.data_ = this.b;
        queryUserPermissionReqIdl.bitField0_ = i;
        return queryUserPermissionReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(QueryUserPermissionReq.QueryUserPermissionReqIdl queryUserPermissionReqIdl) {
        if (queryUserPermissionReqIdl != QueryUserPermissionReq.QueryUserPermissionReqIdl.getDefaultInstance() && queryUserPermissionReqIdl.hasData()) {
            b(queryUserPermissionReqIdl.getData());
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
        QueryUserPermissionReq.QueryUserPermissionReqIdl queryUserPermissionReqIdl;
        Throwable th;
        try {
            try {
                QueryUserPermissionReq.QueryUserPermissionReqIdl parsePartialFrom = QueryUserPermissionReq.QueryUserPermissionReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryUserPermissionReqIdl = null;
                if (queryUserPermissionReqIdl != null) {
                    mergeFrom(queryUserPermissionReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryUserPermissionReq.QueryUserPermissionReqIdl queryUserPermissionReqIdl2 = (QueryUserPermissionReq.QueryUserPermissionReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryUserPermissionReqIdl = queryUserPermissionReqIdl2;
                th = th3;
                if (queryUserPermissionReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(QueryUserPermissionReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public e b(QueryUserPermissionReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QueryUserPermissionReq.DataReq.getDefaultInstance()) {
            this.b = QueryUserPermissionReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
