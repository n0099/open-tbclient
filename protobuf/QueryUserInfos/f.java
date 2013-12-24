package protobuf.QueryUserInfos;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryUserInfos.QueryUserInfosReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<QueryUserInfosReq.QueryUserInfosReqIdl, f> implements g {
    private int a;
    private QueryUserInfosReq.DataReq b = QueryUserInfosReq.DataReq.getDefaultInstance();

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
        this.b = QueryUserInfosReq.DataReq.getDefaultInstance();
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
    public QueryUserInfosReq.QueryUserInfosReqIdl getDefaultInstanceForType() {
        return QueryUserInfosReq.QueryUserInfosReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryUserInfosReq.QueryUserInfosReqIdl build() {
        QueryUserInfosReq.QueryUserInfosReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryUserInfosReq.QueryUserInfosReqIdl buildPartial() {
        QueryUserInfosReq.QueryUserInfosReqIdl queryUserInfosReqIdl = new QueryUserInfosReq.QueryUserInfosReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryUserInfosReqIdl.data_ = this.b;
        queryUserInfosReqIdl.bitField0_ = i;
        return queryUserInfosReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(QueryUserInfosReq.QueryUserInfosReqIdl queryUserInfosReqIdl) {
        if (queryUserInfosReqIdl != QueryUserInfosReq.QueryUserInfosReqIdl.getDefaultInstance() && queryUserInfosReqIdl.hasData()) {
            b(queryUserInfosReqIdl.getData());
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
        QueryUserInfosReq.QueryUserInfosReqIdl queryUserInfosReqIdl;
        Throwable th;
        try {
            try {
                QueryUserInfosReq.QueryUserInfosReqIdl parsePartialFrom = QueryUserInfosReq.QueryUserInfosReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryUserInfosReqIdl = null;
                if (queryUserInfosReqIdl != null) {
                    mergeFrom(queryUserInfosReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryUserInfosReq.QueryUserInfosReqIdl queryUserInfosReqIdl2 = (QueryUserInfosReq.QueryUserInfosReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryUserInfosReqIdl = queryUserInfosReqIdl2;
                th = th3;
                if (queryUserInfosReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public f a(QueryUserInfosReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public f b(QueryUserInfosReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QueryUserInfosReq.DataReq.getDefaultInstance()) {
            this.b = QueryUserInfosReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
