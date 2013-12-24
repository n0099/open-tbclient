package protobuf.QueryGroupsByFid;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryGroupsByFid.QueryGroupsByFidRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<QueryGroupsByFidRes.QueryGroupsByFidResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupsByFidRes.DataRes c = QueryGroupsByFidRes.DataRes.getDefaultInstance();

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
        this.c = QueryGroupsByFidRes.DataRes.getDefaultInstance();
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
    public QueryGroupsByFidRes.QueryGroupsByFidResIdl getDefaultInstanceForType() {
        return QueryGroupsByFidRes.QueryGroupsByFidResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupsByFidRes.QueryGroupsByFidResIdl build() {
        QueryGroupsByFidRes.QueryGroupsByFidResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupsByFidRes.QueryGroupsByFidResIdl buildPartial() {
        QueryGroupsByFidRes.QueryGroupsByFidResIdl queryGroupsByFidResIdl = new QueryGroupsByFidRes.QueryGroupsByFidResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryGroupsByFidResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryGroupsByFidResIdl.data_ = this.c;
        queryGroupsByFidResIdl.bitField0_ = i2;
        return queryGroupsByFidResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(QueryGroupsByFidRes.QueryGroupsByFidResIdl queryGroupsByFidResIdl) {
        if (queryGroupsByFidResIdl != QueryGroupsByFidRes.QueryGroupsByFidResIdl.getDefaultInstance()) {
            if (queryGroupsByFidResIdl.hasError()) {
                a(queryGroupsByFidResIdl.getError());
            }
            if (queryGroupsByFidResIdl.hasData()) {
                a(queryGroupsByFidResIdl.getData());
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
        QueryGroupsByFidRes.QueryGroupsByFidResIdl queryGroupsByFidResIdl;
        Throwable th;
        try {
            try {
                QueryGroupsByFidRes.QueryGroupsByFidResIdl parsePartialFrom = QueryGroupsByFidRes.QueryGroupsByFidResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupsByFidResIdl = null;
                if (queryGroupsByFidResIdl != null) {
                    mergeFrom(queryGroupsByFidResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupsByFidRes.QueryGroupsByFidResIdl queryGroupsByFidResIdl2 = (QueryGroupsByFidRes.QueryGroupsByFidResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupsByFidResIdl = queryGroupsByFidResIdl2;
                th = th3;
                if (queryGroupsByFidResIdl != null) {
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

    public m a(QueryGroupsByFidRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryGroupsByFidRes.DataRes.getDefaultInstance()) {
            this.c = QueryGroupsByFidRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
