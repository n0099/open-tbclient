package protobuf.QueryGroupsByUid;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryGroupsByUid.QueryGroupsByUidRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryGroupsByUidRes.QueryGroupsByUidResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupsByUidRes.DataRes c = QueryGroupsByUidRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupsByUidRes.QueryGroupsByUidResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupsByUidRes.QueryGroupsByUidResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupsByUidRes.QueryGroupsByUidResIdl.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k a() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = QueryGroupsByUidRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupsByUidRes.QueryGroupsByUidResIdl buildPartial() {
        QueryGroupsByUidRes.QueryGroupsByUidResIdl queryGroupsByUidResIdl = new QueryGroupsByUidRes.QueryGroupsByUidResIdl(this, (QueryGroupsByUidRes.QueryGroupsByUidResIdl) null);
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
    public final k mergeFrom(QueryGroupsByUidRes.QueryGroupsByUidResIdl queryGroupsByUidResIdl) {
        if (queryGroupsByUidResIdl != QueryGroupsByUidRes.QueryGroupsByUidResIdl.getDefaultInstance()) {
            if (queryGroupsByUidResIdl.hasError()) {
                Im.Error error = queryGroupsByUidResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryGroupsByUidResIdl.hasData()) {
                QueryGroupsByUidRes.DataRes data = queryGroupsByUidResIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryGroupsByUidRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryGroupsByUidRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
}
