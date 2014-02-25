package protobuf.QueryGroupLocation;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryGroupLocation.QueryGroupLocationRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryGroupLocationRes.QueryGroupLocationResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupLocationRes.DataRes c = QueryGroupLocationRes.DataRes.getDefaultInstance();

    private k() {
        g();
    }

    private void g() {
    }

    public static k h() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public k clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = QueryGroupLocationRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupLocationRes.QueryGroupLocationResIdl getDefaultInstanceForType() {
        return QueryGroupLocationRes.QueryGroupLocationResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupLocationRes.QueryGroupLocationResIdl build() {
        QueryGroupLocationRes.QueryGroupLocationResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupLocationRes.QueryGroupLocationResIdl buildPartial() {
        QueryGroupLocationRes.QueryGroupLocationResIdl queryGroupLocationResIdl = new QueryGroupLocationRes.QueryGroupLocationResIdl(this, (QueryGroupLocationRes.QueryGroupLocationResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryGroupLocationResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryGroupLocationResIdl.data_ = this.c;
        queryGroupLocationResIdl.bitField0_ = i2;
        return queryGroupLocationResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public k mergeFrom(QueryGroupLocationRes.QueryGroupLocationResIdl queryGroupLocationResIdl) {
        if (queryGroupLocationResIdl != QueryGroupLocationRes.QueryGroupLocationResIdl.getDefaultInstance()) {
            if (queryGroupLocationResIdl.hasError()) {
                a(queryGroupLocationResIdl.getError());
            }
            if (queryGroupLocationResIdl.hasData()) {
                a(queryGroupLocationResIdl.getData());
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupLocationRes.QueryGroupLocationResIdl queryGroupLocationResIdl;
        Throwable th;
        try {
            try {
                QueryGroupLocationRes.QueryGroupLocationResIdl parsePartialFrom = QueryGroupLocationRes.QueryGroupLocationResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupLocationResIdl = null;
                if (queryGroupLocationResIdl != null) {
                    mergeFrom(queryGroupLocationResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupLocationRes.QueryGroupLocationResIdl queryGroupLocationResIdl2 = (QueryGroupLocationRes.QueryGroupLocationResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupLocationResIdl = queryGroupLocationResIdl2;
                th = th3;
                if (queryGroupLocationResIdl != null) {
                }
                throw th;
            }
        }
    }

    public k a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public k a(QueryGroupLocationRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryGroupLocationRes.DataRes.getDefaultInstance()) {
            this.c = QueryGroupLocationRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
