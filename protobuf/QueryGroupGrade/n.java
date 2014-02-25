package protobuf.QueryGroupGrade;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<QueryGroupGradeRes.QueryGroupGradeResIdl, n> implements o {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupGradeRes.DataRes c = QueryGroupGradeRes.DataRes.getDefaultInstance();

    private n() {
        g();
    }

    private void g() {
    }

    public static n h() {
        return new n();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public n clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = QueryGroupGradeRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public n clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupGradeRes.QueryGroupGradeResIdl getDefaultInstanceForType() {
        return QueryGroupGradeRes.QueryGroupGradeResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupGradeRes.QueryGroupGradeResIdl build() {
        QueryGroupGradeRes.QueryGroupGradeResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupGradeRes.QueryGroupGradeResIdl buildPartial() {
        QueryGroupGradeRes.QueryGroupGradeResIdl queryGroupGradeResIdl = new QueryGroupGradeRes.QueryGroupGradeResIdl(this, (QueryGroupGradeRes.QueryGroupGradeResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryGroupGradeResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryGroupGradeResIdl.data_ = this.c;
        queryGroupGradeResIdl.bitField0_ = i2;
        return queryGroupGradeResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public n mergeFrom(QueryGroupGradeRes.QueryGroupGradeResIdl queryGroupGradeResIdl) {
        if (queryGroupGradeResIdl != QueryGroupGradeRes.QueryGroupGradeResIdl.getDefaultInstance()) {
            if (queryGroupGradeResIdl.hasError()) {
                a(queryGroupGradeResIdl.getError());
            }
            if (queryGroupGradeResIdl.hasData()) {
                a(queryGroupGradeResIdl.getData());
            }
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
    public n mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupGradeRes.QueryGroupGradeResIdl queryGroupGradeResIdl;
        Throwable th;
        try {
            try {
                QueryGroupGradeRes.QueryGroupGradeResIdl parsePartialFrom = QueryGroupGradeRes.QueryGroupGradeResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupGradeResIdl = null;
                if (queryGroupGradeResIdl != null) {
                    mergeFrom(queryGroupGradeResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupGradeRes.QueryGroupGradeResIdl queryGroupGradeResIdl2 = (QueryGroupGradeRes.QueryGroupGradeResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupGradeResIdl = queryGroupGradeResIdl2;
                th = th3;
                if (queryGroupGradeResIdl != null) {
                }
                throw th;
            }
        }
    }

    public n a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public n a(QueryGroupGradeRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryGroupGradeRes.DataRes.getDefaultInstance()) {
            this.c = QueryGroupGradeRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
