package protobuf.QueryGroupGrade;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryGroupGrade.QueryGroupGradeReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryGroupGradeReq.QueryGroupGradeReqIdl, e> implements f {
    private int a;
    private QueryGroupGradeReq.DataReq b = QueryGroupGradeReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupGradeReq.QueryGroupGradeReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupGradeReq.QueryGroupGradeReqIdl.getDefaultInstance();
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
        this.b = QueryGroupGradeReq.DataReq.getDefaultInstance();
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
    public final QueryGroupGradeReq.QueryGroupGradeReqIdl build() {
        QueryGroupGradeReq.QueryGroupGradeReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupGradeReq.QueryGroupGradeReqIdl buildPartial() {
        QueryGroupGradeReq.QueryGroupGradeReqIdl queryGroupGradeReqIdl = new QueryGroupGradeReq.QueryGroupGradeReqIdl(this, (QueryGroupGradeReq.QueryGroupGradeReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        queryGroupGradeReqIdl.data_ = this.b;
        queryGroupGradeReqIdl.bitField0_ = i;
        return queryGroupGradeReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(QueryGroupGradeReq.QueryGroupGradeReqIdl queryGroupGradeReqIdl) {
        if (queryGroupGradeReqIdl != QueryGroupGradeReq.QueryGroupGradeReqIdl.getDefaultInstance() && queryGroupGradeReqIdl.hasData()) {
            QueryGroupGradeReq.DataReq data = queryGroupGradeReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QueryGroupGradeReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QueryGroupGradeReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        QueryGroupGradeReq.QueryGroupGradeReqIdl queryGroupGradeReqIdl;
        Throwable th;
        try {
            try {
                QueryGroupGradeReq.QueryGroupGradeReqIdl parsePartialFrom = QueryGroupGradeReq.QueryGroupGradeReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupGradeReqIdl = null;
                if (queryGroupGradeReqIdl != null) {
                    mergeFrom(queryGroupGradeReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupGradeReq.QueryGroupGradeReqIdl queryGroupGradeReqIdl2 = (QueryGroupGradeReq.QueryGroupGradeReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupGradeReqIdl = queryGroupGradeReqIdl2;
                th = th3;
                if (queryGroupGradeReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(QueryGroupGradeReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
