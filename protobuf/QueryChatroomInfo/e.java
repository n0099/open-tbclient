package protobuf.QueryChatroomInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryChatroomInfo.QueryChatroomInfoReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryChatroomInfoReq.QueryChatroomInfoReqIdl, e> implements f {
    private int a;
    private QueryChatroomInfoReq.DataReq b = QueryChatroomInfoReq.DataReq.getDefaultInstance();

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
        this.b = QueryChatroomInfoReq.DataReq.getDefaultInstance();
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
    public QueryChatroomInfoReq.QueryChatroomInfoReqIdl getDefaultInstanceForType() {
        return QueryChatroomInfoReq.QueryChatroomInfoReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryChatroomInfoReq.QueryChatroomInfoReqIdl build() {
        QueryChatroomInfoReq.QueryChatroomInfoReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryChatroomInfoReq.QueryChatroomInfoReqIdl buildPartial() {
        QueryChatroomInfoReq.QueryChatroomInfoReqIdl queryChatroomInfoReqIdl = new QueryChatroomInfoReq.QueryChatroomInfoReqIdl(this, (QueryChatroomInfoReq.QueryChatroomInfoReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryChatroomInfoReqIdl.data_ = this.b;
        queryChatroomInfoReqIdl.bitField0_ = i;
        return queryChatroomInfoReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(QueryChatroomInfoReq.QueryChatroomInfoReqIdl queryChatroomInfoReqIdl) {
        if (queryChatroomInfoReqIdl != QueryChatroomInfoReq.QueryChatroomInfoReqIdl.getDefaultInstance() && queryChatroomInfoReqIdl.hasData()) {
            b(queryChatroomInfoReqIdl.getData());
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
        QueryChatroomInfoReq.QueryChatroomInfoReqIdl queryChatroomInfoReqIdl;
        Throwable th;
        try {
            try {
                QueryChatroomInfoReq.QueryChatroomInfoReqIdl parsePartialFrom = QueryChatroomInfoReq.QueryChatroomInfoReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryChatroomInfoReqIdl = null;
                if (queryChatroomInfoReqIdl != null) {
                    mergeFrom(queryChatroomInfoReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryChatroomInfoReq.QueryChatroomInfoReqIdl queryChatroomInfoReqIdl2 = (QueryChatroomInfoReq.QueryChatroomInfoReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryChatroomInfoReqIdl = queryChatroomInfoReqIdl2;
                th = th3;
                if (queryChatroomInfoReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(QueryChatroomInfoReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public e b(QueryChatroomInfoReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QueryChatroomInfoReq.DataReq.getDefaultInstance()) {
            this.b = QueryChatroomInfoReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
