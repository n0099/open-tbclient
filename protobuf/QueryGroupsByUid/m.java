package protobuf.QueryGroupsByUid;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryGroupsByUid.QueryGroupsByUidRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<QueryGroupsByUidRes.QueryGroupsByUidResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupsByUidRes.DataRes c = QueryGroupsByUidRes.DataRes.getDefaultInstance();

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
        this.c = QueryGroupsByUidRes.DataRes.getDefaultInstance();
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
    public QueryGroupsByUidRes.QueryGroupsByUidResIdl getDefaultInstanceForType() {
        return QueryGroupsByUidRes.QueryGroupsByUidResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupsByUidRes.QueryGroupsByUidResIdl build() {
        QueryGroupsByUidRes.QueryGroupsByUidResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupsByUidRes.QueryGroupsByUidResIdl buildPartial() {
        QueryGroupsByUidRes.QueryGroupsByUidResIdl queryGroupsByUidResIdl = new QueryGroupsByUidRes.QueryGroupsByUidResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryGroupsByUidResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryGroupsByUidResIdl.data_ = this.c;
        queryGroupsByUidResIdl.bitField0_ = i2;
        return queryGroupsByUidResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(QueryGroupsByUidRes.QueryGroupsByUidResIdl queryGroupsByUidResIdl) {
        if (queryGroupsByUidResIdl != QueryGroupsByUidRes.QueryGroupsByUidResIdl.getDefaultInstance()) {
            if (queryGroupsByUidResIdl.hasError()) {
                a(queryGroupsByUidResIdl.getError());
            }
            if (queryGroupsByUidResIdl.hasData()) {
                a(queryGroupsByUidResIdl.getData());
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
        QueryGroupsByUidRes.QueryGroupsByUidResIdl queryGroupsByUidResIdl;
        Throwable th;
        try {
            try {
                QueryGroupsByUidRes.QueryGroupsByUidResIdl parsePartialFrom = QueryGroupsByUidRes.QueryGroupsByUidResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupsByUidResIdl = null;
                if (queryGroupsByUidResIdl != null) {
                    mergeFrom(queryGroupsByUidResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupsByUidRes.QueryGroupsByUidResIdl queryGroupsByUidResIdl2 = (QueryGroupsByUidRes.QueryGroupsByUidResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupsByUidResIdl = queryGroupsByUidResIdl2;
                th = th3;
                if (queryGroupsByUidResIdl != null) {
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

    public m a(QueryGroupsByUidRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryGroupsByUidRes.DataRes.getDefaultInstance()) {
            this.c = QueryGroupsByUidRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
