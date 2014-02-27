package protobuf.QueryGroupGrade;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<QueryGroupGradeRes.QueryGroupGradeResIdl, n> implements o {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupGradeRes.DataRes c = QueryGroupGradeRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupGradeRes.QueryGroupGradeResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupGradeRes.QueryGroupGradeResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupGradeRes.QueryGroupGradeResIdl.getDefaultInstance();
    }

    private n() {
    }

    public static /* synthetic */ n a() {
        return new n();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public n clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = QueryGroupGradeRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public n clone() {
        return new n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
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
    public final n mergeFrom(QueryGroupGradeRes.QueryGroupGradeResIdl queryGroupGradeResIdl) {
        if (queryGroupGradeResIdl != QueryGroupGradeRes.QueryGroupGradeResIdl.getDefaultInstance()) {
            if (queryGroupGradeResIdl.hasError()) {
                Im.Error error = queryGroupGradeResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryGroupGradeResIdl.hasData()) {
                QueryGroupGradeRes.DataRes data = queryGroupGradeResIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryGroupGradeRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryGroupGradeRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
                }
                this.a |= 2;
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
}
