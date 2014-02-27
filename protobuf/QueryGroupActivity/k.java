package protobuf.QueryGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryGroupActivity.QueryGroupActivityRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryGroupActivityRes.QueryGroupActivityResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryGroupActivityRes.DataRes c = QueryGroupActivityRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupActivityRes.QueryGroupActivityResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupActivityRes.QueryGroupActivityResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupActivityRes.QueryGroupActivityResIdl.getDefaultInstance();
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
        this.c = QueryGroupActivityRes.DataRes.getDefaultInstance();
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
    public QueryGroupActivityRes.QueryGroupActivityResIdl buildPartial() {
        QueryGroupActivityRes.QueryGroupActivityResIdl queryGroupActivityResIdl = new QueryGroupActivityRes.QueryGroupActivityResIdl(this, (QueryGroupActivityRes.QueryGroupActivityResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryGroupActivityResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryGroupActivityResIdl.data_ = this.c;
        queryGroupActivityResIdl.bitField0_ = i2;
        return queryGroupActivityResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(QueryGroupActivityRes.QueryGroupActivityResIdl queryGroupActivityResIdl) {
        if (queryGroupActivityResIdl != QueryGroupActivityRes.QueryGroupActivityResIdl.getDefaultInstance()) {
            if (queryGroupActivityResIdl.hasError()) {
                Im.Error error = queryGroupActivityResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryGroupActivityResIdl.hasData()) {
                QueryGroupActivityRes.DataRes data = queryGroupActivityResIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryGroupActivityRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryGroupActivityRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
        QueryGroupActivityRes.QueryGroupActivityResIdl queryGroupActivityResIdl;
        Throwable th;
        try {
            try {
                QueryGroupActivityRes.QueryGroupActivityResIdl parsePartialFrom = QueryGroupActivityRes.QueryGroupActivityResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryGroupActivityResIdl = null;
                if (queryGroupActivityResIdl != null) {
                    mergeFrom(queryGroupActivityResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupActivityRes.QueryGroupActivityResIdl queryGroupActivityResIdl2 = (QueryGroupActivityRes.QueryGroupActivityResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryGroupActivityResIdl = queryGroupActivityResIdl2;
                th = th3;
                if (queryGroupActivityResIdl != null) {
                }
                throw th;
            }
        }
    }
}
