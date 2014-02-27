package protobuf.QueryUserInfos;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<QueryUserInfosRes.QueryUserInfosResIdl, n> implements o {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryUserInfosRes.DataRes c = QueryUserInfosRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryUserInfosRes.QueryUserInfosResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryUserInfosRes.QueryUserInfosResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryUserInfosRes.QueryUserInfosResIdl.getDefaultInstance();
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
        this.c = QueryUserInfosRes.DataRes.getDefaultInstance();
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
    public QueryUserInfosRes.QueryUserInfosResIdl buildPartial() {
        QueryUserInfosRes.QueryUserInfosResIdl queryUserInfosResIdl = new QueryUserInfosRes.QueryUserInfosResIdl(this, (QueryUserInfosRes.QueryUserInfosResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryUserInfosResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryUserInfosResIdl.data_ = this.c;
        queryUserInfosResIdl.bitField0_ = i2;
        return queryUserInfosResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final n mergeFrom(QueryUserInfosRes.QueryUserInfosResIdl queryUserInfosResIdl) {
        if (queryUserInfosResIdl != QueryUserInfosRes.QueryUserInfosResIdl.getDefaultInstance()) {
            if (queryUserInfosResIdl.hasError()) {
                Im.Error error = queryUserInfosResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryUserInfosResIdl.hasData()) {
                QueryUserInfosRes.DataRes data = queryUserInfosResIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryUserInfosRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryUserInfosRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
        QueryUserInfosRes.QueryUserInfosResIdl queryUserInfosResIdl;
        Throwable th;
        try {
            try {
                QueryUserInfosRes.QueryUserInfosResIdl parsePartialFrom = QueryUserInfosRes.QueryUserInfosResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryUserInfosResIdl = null;
                if (queryUserInfosResIdl != null) {
                    mergeFrom(queryUserInfosResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryUserInfosRes.QueryUserInfosResIdl queryUserInfosResIdl2 = (QueryUserInfosRes.QueryUserInfosResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryUserInfosResIdl = queryUserInfosResIdl2;
                th = th3;
                if (queryUserInfosResIdl != null) {
                }
                throw th;
            }
        }
    }
}
