package protobuf.QueryHistoryMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryHistoryMsg.QueryHistoryMsgReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryHistoryMsgReq.QueryHistoryMsgReqIdl, e> implements f {
    private int a;
    private QueryHistoryMsgReq.DataReq b = QueryHistoryMsgReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryHistoryMsgReq.QueryHistoryMsgReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryHistoryMsgReq.QueryHistoryMsgReqIdl.getDefaultInstance();
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
        this.b = QueryHistoryMsgReq.DataReq.getDefaultInstance();
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
    public final QueryHistoryMsgReq.QueryHistoryMsgReqIdl build() {
        QueryHistoryMsgReq.QueryHistoryMsgReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryHistoryMsgReq.QueryHistoryMsgReqIdl buildPartial() {
        QueryHistoryMsgReq.QueryHistoryMsgReqIdl queryHistoryMsgReqIdl = new QueryHistoryMsgReq.QueryHistoryMsgReqIdl(this, (QueryHistoryMsgReq.QueryHistoryMsgReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryHistoryMsgReqIdl.data_ = this.b;
        queryHistoryMsgReqIdl.bitField0_ = i;
        return queryHistoryMsgReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(QueryHistoryMsgReq.QueryHistoryMsgReqIdl queryHistoryMsgReqIdl) {
        if (queryHistoryMsgReqIdl != QueryHistoryMsgReq.QueryHistoryMsgReqIdl.getDefaultInstance() && queryHistoryMsgReqIdl.hasData()) {
            QueryHistoryMsgReq.DataReq data = queryHistoryMsgReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QueryHistoryMsgReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QueryHistoryMsgReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        QueryHistoryMsgReq.QueryHistoryMsgReqIdl queryHistoryMsgReqIdl;
        Throwable th;
        try {
            try {
                QueryHistoryMsgReq.QueryHistoryMsgReqIdl parsePartialFrom = QueryHistoryMsgReq.QueryHistoryMsgReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryHistoryMsgReqIdl = null;
                if (queryHistoryMsgReqIdl != null) {
                    mergeFrom(queryHistoryMsgReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryHistoryMsgReq.QueryHistoryMsgReqIdl queryHistoryMsgReqIdl2 = (QueryHistoryMsgReq.QueryHistoryMsgReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryHistoryMsgReqIdl = queryHistoryMsgReqIdl2;
                th = th3;
                if (queryHistoryMsgReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(QueryHistoryMsgReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
