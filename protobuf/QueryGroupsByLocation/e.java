package protobuf.QueryGroupsByLocation;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl, e> implements f {
    private int a;
    private QueryGroupsByLocationReq.DataReq b = QueryGroupsByLocationReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl.getDefaultInstance();
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
        this.b = QueryGroupsByLocationReq.DataReq.getDefaultInstance();
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
    public final QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl build() {
        QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl buildPartial() {
        QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl queryGroupsByLocationReqIdl = new QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl(this, (QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryGroupsByLocationReqIdl.data_ = this.b;
        queryGroupsByLocationReqIdl.bitField0_ = i;
        return queryGroupsByLocationReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl queryGroupsByLocationReqIdl) {
        if (queryGroupsByLocationReqIdl != QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl.getDefaultInstance() && queryGroupsByLocationReqIdl.hasData()) {
            QueryGroupsByLocationReq.DataReq data = queryGroupsByLocationReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QueryGroupsByLocationReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QueryGroupsByLocationReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl queryGroupsByLocationReqIdl;
        Throwable th;
        try {
            try {
                QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl parsePartialFrom = QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupsByLocationReqIdl = null;
                if (queryGroupsByLocationReqIdl != null) {
                    mergeFrom(queryGroupsByLocationReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl queryGroupsByLocationReqIdl2 = (QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupsByLocationReqIdl = queryGroupsByLocationReqIdl2;
                th = th3;
                if (queryGroupsByLocationReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(QueryGroupsByLocationReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
