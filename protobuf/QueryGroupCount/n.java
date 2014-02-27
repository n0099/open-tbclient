package protobuf.QueryGroupCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<QueryGroupCountRes.QueryGroupCountResIdl, n> implements o {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupCountRes.DataRes c = QueryGroupCountRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupCountRes.QueryGroupCountResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupCountRes.QueryGroupCountResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupCountRes.QueryGroupCountResIdl.getDefaultInstance();
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
        this.c = QueryGroupCountRes.DataRes.getDefaultInstance();
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
    public QueryGroupCountRes.QueryGroupCountResIdl buildPartial() {
        QueryGroupCountRes.QueryGroupCountResIdl queryGroupCountResIdl = new QueryGroupCountRes.QueryGroupCountResIdl(this, (QueryGroupCountRes.QueryGroupCountResIdl) null);
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
    public final n mergeFrom(QueryGroupCountRes.QueryGroupCountResIdl queryGroupCountResIdl) {
        if (queryGroupCountResIdl != QueryGroupCountRes.QueryGroupCountResIdl.getDefaultInstance()) {
            if (queryGroupCountResIdl.hasError()) {
                Im.Error error = queryGroupCountResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryGroupCountResIdl.hasData()) {
                QueryGroupCountRes.DataRes data = queryGroupCountResIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryGroupCountRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryGroupCountRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
}
