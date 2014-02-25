package protobuf.QueryUserPermission;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryUserPermission.QueryUserPermissionRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryUserPermissionRes.QueryUserPermissionResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryUserPermissionRes.DataRes c = QueryUserPermissionRes.DataRes.getDefaultInstance();

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
        this.c = QueryUserPermissionRes.DataRes.getDefaultInstance();
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
    public QueryUserPermissionRes.QueryUserPermissionResIdl getDefaultInstanceForType() {
        return QueryUserPermissionRes.QueryUserPermissionResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryUserPermissionRes.QueryUserPermissionResIdl build() {
        QueryUserPermissionRes.QueryUserPermissionResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryUserPermissionRes.QueryUserPermissionResIdl buildPartial() {
        QueryUserPermissionRes.QueryUserPermissionResIdl queryUserPermissionResIdl = new QueryUserPermissionRes.QueryUserPermissionResIdl(this, (QueryUserPermissionRes.QueryUserPermissionResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryUserPermissionResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryUserPermissionResIdl.data_ = this.c;
        queryUserPermissionResIdl.bitField0_ = i2;
        return queryUserPermissionResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public k mergeFrom(QueryUserPermissionRes.QueryUserPermissionResIdl queryUserPermissionResIdl) {
        if (queryUserPermissionResIdl != QueryUserPermissionRes.QueryUserPermissionResIdl.getDefaultInstance()) {
            if (queryUserPermissionResIdl.hasError()) {
                a(queryUserPermissionResIdl.getError());
            }
            if (queryUserPermissionResIdl.hasData()) {
                a(queryUserPermissionResIdl.getData());
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
        QueryUserPermissionRes.QueryUserPermissionResIdl queryUserPermissionResIdl;
        Throwable th;
        try {
            try {
                QueryUserPermissionRes.QueryUserPermissionResIdl parsePartialFrom = QueryUserPermissionRes.QueryUserPermissionResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryUserPermissionResIdl = null;
                if (queryUserPermissionResIdl != null) {
                    mergeFrom(queryUserPermissionResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryUserPermissionRes.QueryUserPermissionResIdl queryUserPermissionResIdl2 = (QueryUserPermissionRes.QueryUserPermissionResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryUserPermissionResIdl = queryUserPermissionResIdl2;
                th = th3;
                if (queryUserPermissionResIdl != null) {
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

    public k a(QueryUserPermissionRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryUserPermissionRes.DataRes.getDefaultInstance()) {
            this.c = QueryUserPermissionRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
