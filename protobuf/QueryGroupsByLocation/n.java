package protobuf.QueryGroupsByLocation;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<QueryGroupsByLocationRes.QueryGroupsByLocationResIdl, n> implements o {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupsByLocationRes.DataRes c = QueryGroupsByLocationRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupsByLocationRes.QueryGroupsByLocationResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupsByLocationRes.QueryGroupsByLocationResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupsByLocationRes.QueryGroupsByLocationResIdl.getDefaultInstance();
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
        this.c = QueryGroupsByLocationRes.DataRes.getDefaultInstance();
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
    public QueryGroupsByLocationRes.QueryGroupsByLocationResIdl buildPartial() {
        QueryGroupsByLocationRes.QueryGroupsByLocationResIdl queryGroupsByLocationResIdl = new QueryGroupsByLocationRes.QueryGroupsByLocationResIdl(this, (QueryGroupsByLocationRes.QueryGroupsByLocationResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryGroupsByLocationResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryGroupsByLocationResIdl.data_ = this.c;
        queryGroupsByLocationResIdl.bitField0_ = i2;
        return queryGroupsByLocationResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final n mergeFrom(QueryGroupsByLocationRes.QueryGroupsByLocationResIdl queryGroupsByLocationResIdl) {
        if (queryGroupsByLocationResIdl != QueryGroupsByLocationRes.QueryGroupsByLocationResIdl.getDefaultInstance()) {
            if (queryGroupsByLocationResIdl.hasError()) {
                Im.Error error = queryGroupsByLocationResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryGroupsByLocationResIdl.hasData()) {
                QueryGroupsByLocationRes.DataRes data = queryGroupsByLocationResIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryGroupsByLocationRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryGroupsByLocationRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
        QueryGroupsByLocationRes.QueryGroupsByLocationResIdl queryGroupsByLocationResIdl;
        Throwable th;
        try {
            try {
                QueryGroupsByLocationRes.QueryGroupsByLocationResIdl parsePartialFrom = QueryGroupsByLocationRes.QueryGroupsByLocationResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupsByLocationResIdl = null;
                if (queryGroupsByLocationResIdl != null) {
                    mergeFrom(queryGroupsByLocationResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupsByLocationRes.QueryGroupsByLocationResIdl queryGroupsByLocationResIdl2 = (QueryGroupsByLocationRes.QueryGroupsByLocationResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupsByLocationResIdl = queryGroupsByLocationResIdl2;
                th = th3;
                if (queryGroupsByLocationResIdl != null) {
                }
                throw th;
            }
        }
    }
}
