package protobuf.QueryForumDetail;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryForumDetail.QueryForumDetailRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryForumDetailRes.QueryForumDetailResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryForumDetailRes.DataRes c = QueryForumDetailRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryForumDetailRes.QueryForumDetailResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryForumDetailRes.QueryForumDetailResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryForumDetailRes.QueryForumDetailResIdl.getDefaultInstance();
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
        this.c = QueryForumDetailRes.DataRes.getDefaultInstance();
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
    public QueryForumDetailRes.QueryForumDetailResIdl buildPartial() {
        QueryForumDetailRes.QueryForumDetailResIdl queryForumDetailResIdl = new QueryForumDetailRes.QueryForumDetailResIdl(this, (QueryForumDetailRes.QueryForumDetailResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryForumDetailResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryForumDetailResIdl.data_ = this.c;
        queryForumDetailResIdl.bitField0_ = i2;
        return queryForumDetailResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(QueryForumDetailRes.QueryForumDetailResIdl queryForumDetailResIdl) {
        if (queryForumDetailResIdl != QueryForumDetailRes.QueryForumDetailResIdl.getDefaultInstance()) {
            if (queryForumDetailResIdl.hasError()) {
                Im.Error error = queryForumDetailResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryForumDetailResIdl.hasData()) {
                QueryForumDetailRes.DataRes data = queryForumDetailResIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryForumDetailRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryForumDetailRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
        QueryForumDetailRes.QueryForumDetailResIdl queryForumDetailResIdl;
        Throwable th;
        try {
            try {
                QueryForumDetailRes.QueryForumDetailResIdl parsePartialFrom = QueryForumDetailRes.QueryForumDetailResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryForumDetailResIdl = null;
                if (queryForumDetailResIdl != null) {
                    mergeFrom(queryForumDetailResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryForumDetailRes.QueryForumDetailResIdl queryForumDetailResIdl2 = (QueryForumDetailRes.QueryForumDetailResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryForumDetailResIdl = queryForumDetailResIdl2;
                th = th3;
                if (queryForumDetailResIdl != null) {
                }
                throw th;
            }
        }
    }
}
