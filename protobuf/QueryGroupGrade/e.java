package protobuf.QueryGroupGrade;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupGrade.QueryGroupGradeReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QueryGroupGradeReq.QueryGroupGradeReqIdl, e> implements f {
    private int a;
    private QueryGroupGradeReq.DataReq b = QueryGroupGradeReq.DataReq.getDefaultInstance();

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
        this.b = QueryGroupGradeReq.DataReq.getDefaultInstance();
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
    public QueryGroupGradeReq.QueryGroupGradeReqIdl getDefaultInstanceForType() {
        return QueryGroupGradeReq.QueryGroupGradeReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupGradeReq.QueryGroupGradeReqIdl build() {
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
    public e mergeFrom(QueryGroupGradeReq.QueryGroupGradeReqIdl queryGroupGradeReqIdl) {
        if (queryGroupGradeReqIdl != QueryGroupGradeReq.QueryGroupGradeReqIdl.getDefaultInstance() && queryGroupGradeReqIdl.hasData()) {
            b(queryGroupGradeReqIdl.getData());
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

    public e a(QueryGroupGradeReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public e b(QueryGroupGradeReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QueryGroupGradeReq.DataReq.getDefaultInstance()) {
            this.b = QueryGroupGradeReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
