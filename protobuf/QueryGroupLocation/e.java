package protobuf.QueryGroupLocation;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryGroupLocation.QueryGroupLocationReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryGroupLocationReq.QueryGroupLocationReqIdl, e> implements f {
    private int a;
    private QueryGroupLocationReq.DataReq b = QueryGroupLocationReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupLocationReq.QueryGroupLocationReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupLocationReq.QueryGroupLocationReqIdl.getDefaultInstance();
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
        this.b = QueryGroupLocationReq.DataReq.getDefaultInstance();
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
    public final QueryGroupLocationReq.QueryGroupLocationReqIdl build() {
        QueryGroupLocationReq.QueryGroupLocationReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupLocationReq.QueryGroupLocationReqIdl buildPartial() {
        QueryGroupLocationReq.QueryGroupLocationReqIdl queryGroupLocationReqIdl = new QueryGroupLocationReq.QueryGroupLocationReqIdl(this, (QueryGroupLocationReq.QueryGroupLocationReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryGroupLocationReqIdl.data_ = this.b;
        queryGroupLocationReqIdl.bitField0_ = i;
        return queryGroupLocationReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(QueryGroupLocationReq.QueryGroupLocationReqIdl queryGroupLocationReqIdl) {
        if (queryGroupLocationReqIdl != QueryGroupLocationReq.QueryGroupLocationReqIdl.getDefaultInstance() && queryGroupLocationReqIdl.hasData()) {
            QueryGroupLocationReq.DataReq data = queryGroupLocationReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QueryGroupLocationReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QueryGroupLocationReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        QueryGroupLocationReq.QueryGroupLocationReqIdl queryGroupLocationReqIdl;
        Throwable th;
        try {
            try {
                QueryGroupLocationReq.QueryGroupLocationReqIdl parsePartialFrom = QueryGroupLocationReq.QueryGroupLocationReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupLocationReqIdl = null;
                if (queryGroupLocationReqIdl != null) {
                    mergeFrom(queryGroupLocationReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupLocationReq.QueryGroupLocationReqIdl queryGroupLocationReqIdl2 = (QueryGroupLocationReq.QueryGroupLocationReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupLocationReqIdl = queryGroupLocationReqIdl2;
                th = th3;
                if (queryGroupLocationReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(QueryGroupLocationReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
