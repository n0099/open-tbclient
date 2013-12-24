package protobuf.QueryGroupDetail;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryGroupDetail.QueryGroupDetailRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<QueryGroupDetailRes.QueryGroupDetailResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupDetailRes.DataRes c = QueryGroupDetailRes.DataRes.getDefaultInstance();

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
        this.c = QueryGroupDetailRes.DataRes.getDefaultInstance();
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
    public QueryGroupDetailRes.QueryGroupDetailResIdl getDefaultInstanceForType() {
        return QueryGroupDetailRes.QueryGroupDetailResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupDetailRes.QueryGroupDetailResIdl build() {
        QueryGroupDetailRes.QueryGroupDetailResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupDetailRes.QueryGroupDetailResIdl buildPartial() {
        QueryGroupDetailRes.QueryGroupDetailResIdl queryGroupDetailResIdl = new QueryGroupDetailRes.QueryGroupDetailResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryGroupDetailResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryGroupDetailResIdl.data_ = this.c;
        queryGroupDetailResIdl.bitField0_ = i2;
        return queryGroupDetailResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(QueryGroupDetailRes.QueryGroupDetailResIdl queryGroupDetailResIdl) {
        if (queryGroupDetailResIdl != QueryGroupDetailRes.QueryGroupDetailResIdl.getDefaultInstance()) {
            if (queryGroupDetailResIdl.hasError()) {
                a(queryGroupDetailResIdl.getError());
            }
            if (queryGroupDetailResIdl.hasData()) {
                a(queryGroupDetailResIdl.getData());
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
        QueryGroupDetailRes.QueryGroupDetailResIdl queryGroupDetailResIdl;
        Throwable th;
        try {
            try {
                QueryGroupDetailRes.QueryGroupDetailResIdl parsePartialFrom = QueryGroupDetailRes.QueryGroupDetailResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupDetailResIdl = null;
                if (queryGroupDetailResIdl != null) {
                    mergeFrom(queryGroupDetailResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupDetailRes.QueryGroupDetailResIdl queryGroupDetailResIdl2 = (QueryGroupDetailRes.QueryGroupDetailResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupDetailResIdl = queryGroupDetailResIdl2;
                th = th3;
                if (queryGroupDetailResIdl != null) {
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

    public m a(QueryGroupDetailRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryGroupDetailRes.DataRes.getDefaultInstance()) {
            this.c = QueryGroupDetailRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
