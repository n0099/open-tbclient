package protobuf.QueryHotGroups;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryHotGroups.QueryHotGroupsRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<QueryHotGroupsRes.QueryHotGroupsResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryHotGroupsRes.DataRes c = QueryHotGroupsRes.DataRes.getDefaultInstance();

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
        this.c = QueryHotGroupsRes.DataRes.getDefaultInstance();
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
    public QueryHotGroupsRes.QueryHotGroupsResIdl getDefaultInstanceForType() {
        return QueryHotGroupsRes.QueryHotGroupsResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryHotGroupsRes.QueryHotGroupsResIdl build() {
        QueryHotGroupsRes.QueryHotGroupsResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryHotGroupsRes.QueryHotGroupsResIdl buildPartial() {
        QueryHotGroupsRes.QueryHotGroupsResIdl queryHotGroupsResIdl = new QueryHotGroupsRes.QueryHotGroupsResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryHotGroupsResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryHotGroupsResIdl.data_ = this.c;
        queryHotGroupsResIdl.bitField0_ = i2;
        return queryHotGroupsResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(QueryHotGroupsRes.QueryHotGroupsResIdl queryHotGroupsResIdl) {
        if (queryHotGroupsResIdl != QueryHotGroupsRes.QueryHotGroupsResIdl.getDefaultInstance()) {
            if (queryHotGroupsResIdl.hasError()) {
                a(queryHotGroupsResIdl.getError());
            }
            if (queryHotGroupsResIdl.hasData()) {
                a(queryHotGroupsResIdl.getData());
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
        QueryHotGroupsRes.QueryHotGroupsResIdl queryHotGroupsResIdl;
        Throwable th;
        try {
            try {
                QueryHotGroupsRes.QueryHotGroupsResIdl parsePartialFrom = QueryHotGroupsRes.QueryHotGroupsResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryHotGroupsResIdl = null;
                if (queryHotGroupsResIdl != null) {
                    mergeFrom(queryHotGroupsResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryHotGroupsRes.QueryHotGroupsResIdl queryHotGroupsResIdl2 = (QueryHotGroupsRes.QueryHotGroupsResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryHotGroupsResIdl = queryHotGroupsResIdl2;
                th = th3;
                if (queryHotGroupsResIdl != null) {
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

    public m a(QueryHotGroupsRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != QueryHotGroupsRes.DataRes.getDefaultInstance()) {
            this.c = QueryHotGroupsRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
