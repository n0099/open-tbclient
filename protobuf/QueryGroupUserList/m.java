package protobuf.QueryGroupUserList;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryGroupUserList.QueryGroupUserListRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<QueryGroupUserListRes.QueryGroupUserListResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupUserListRes.DataRes c = QueryGroupUserListRes.DataRes.getDefaultInstance();

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
        this.c = QueryGroupUserListRes.DataRes.getDefaultInstance();
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
    public QueryGroupUserListRes.QueryGroupUserListResIdl getDefaultInstanceForType() {
        return QueryGroupUserListRes.QueryGroupUserListResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupUserListRes.QueryGroupUserListResIdl build() {
        QueryGroupUserListRes.QueryGroupUserListResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupUserListRes.QueryGroupUserListResIdl buildPartial() {
        QueryGroupUserListRes.QueryGroupUserListResIdl queryGroupUserListResIdl = new QueryGroupUserListRes.QueryGroupUserListResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryGroupUserListResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryGroupUserListResIdl.data_ = this.c;
        queryGroupUserListResIdl.bitField0_ = i2;
        return queryGroupUserListResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(QueryGroupUserListRes.QueryGroupUserListResIdl queryGroupUserListResIdl) {
        if (queryGroupUserListResIdl != QueryGroupUserListRes.QueryGroupUserListResIdl.getDefaultInstance()) {
            if (queryGroupUserListResIdl.hasError()) {
                a(queryGroupUserListResIdl.getError());
            }
            if (queryGroupUserListResIdl.hasData()) {
                a(queryGroupUserListResIdl.getData());
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
        QueryGroupUserListRes.QueryGroupUserListResIdl queryGroupUserListResIdl;
        Throwable th;
        try {
            try {
                QueryGroupUserListRes.QueryGroupUserListResIdl parsePartialFrom = QueryGroupUserListRes.QueryGroupUserListResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupUserListResIdl = null;
                if (queryGroupUserListResIdl != null) {
                    mergeFrom(queryGroupUserListResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupUserListRes.QueryGroupUserListResIdl queryGroupUserListResIdl2 = (QueryGroupUserListRes.QueryGroupUserListResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupUserListResIdl = queryGroupUserListResIdl2;
                th = th3;
                if (queryGroupUserListResIdl != null) {
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

    public m a(QueryGroupUserListRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryGroupUserListRes.DataRes.getDefaultInstance()) {
            this.c = QueryGroupUserListRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
