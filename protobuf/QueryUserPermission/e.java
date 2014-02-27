package protobuf.QueryUserPermission;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryUserPermission.QueryUserPermissionReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryUserPermissionReq.QueryUserPermissionReqIdl, e> implements f {
    private int a;
    private QueryUserPermissionReq.DataReq b = QueryUserPermissionReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryUserPermissionReq.QueryUserPermissionReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryUserPermissionReq.QueryUserPermissionReqIdl.getDefaultInstance();
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
        this.b = QueryUserPermissionReq.DataReq.getDefaultInstance();
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
    public final QueryUserPermissionReq.QueryUserPermissionReqIdl build() {
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
    public final e mergeFrom(QueryUserPermissionReq.QueryUserPermissionReqIdl queryUserPermissionReqIdl) {
        if (queryUserPermissionReqIdl != QueryUserPermissionReq.QueryUserPermissionReqIdl.getDefaultInstance() && queryUserPermissionReqIdl.hasData()) {
            QueryUserPermissionReq.DataReq data = queryUserPermissionReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QueryUserPermissionReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QueryUserPermissionReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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

    public final e a(QueryUserPermissionReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
