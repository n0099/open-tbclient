package protobuf.QueryGroupCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<QueryGroupCountRes.QueryGroupCountResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupCountRes.DataRes c = QueryGroupCountRes.DataRes.getDefaultInstance();

    private m() {
        g();
    }

    private void g() {
    }

    public static m h() {
        return new m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public m clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = QueryGroupCountRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public m clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupCountRes.QueryGroupCountResIdl getDefaultInstanceForType() {
        return QueryGroupCountRes.QueryGroupCountResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupCountRes.QueryGroupCountResIdl build() {
        QueryGroupCountRes.QueryGroupCountResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupCountRes.QueryGroupCountResIdl buildPartial() {
        QueryGroupCountRes.QueryGroupCountResIdl queryGroupCountResIdl = new QueryGroupCountRes.QueryGroupCountResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryGroupCountResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryGroupCountResIdl.data_ = this.c;
        queryGroupCountResIdl.bitField0_ = i2;
        return queryGroupCountResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(QueryGroupCountRes.QueryGroupCountResIdl queryGroupCountResIdl) {
        if (queryGroupCountResIdl != QueryGroupCountRes.QueryGroupCountResIdl.getDefaultInstance()) {
            if (queryGroupCountResIdl.hasError()) {
                a(queryGroupCountResIdl.getError());
            }
            if (queryGroupCountResIdl.hasData()) {
                a(queryGroupCountResIdl.getData());
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
    public m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupCountRes.QueryGroupCountResIdl queryGroupCountResIdl;
        Throwable th;
        try {
            try {
                QueryGroupCountRes.QueryGroupCountResIdl parsePartialFrom = QueryGroupCountRes.QueryGroupCountResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupCountResIdl = null;
                if (queryGroupCountResIdl != null) {
                    mergeFrom(queryGroupCountResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupCountRes.QueryGroupCountResIdl queryGroupCountResIdl2 = (QueryGroupCountRes.QueryGroupCountResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupCountResIdl = queryGroupCountResIdl2;
                th = th3;
                if (queryGroupCountResIdl != null) {
                }
                throw th;
            }
        }
    }

    public m a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public m a(QueryGroupCountRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryGroupCountRes.DataRes.getDefaultInstance()) {
            this.c = QueryGroupCountRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
