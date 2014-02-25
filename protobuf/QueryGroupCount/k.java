package protobuf.QueryGroupCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryGroupCountRes.DataRes, k> implements l {
    private int a;
    private int b;
    private int c;
    private QueryGroupCountRes.Banner d = QueryGroupCountRes.Banner.getDefaultInstance();

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
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = QueryGroupCountRes.Banner.getDefaultInstance();
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupCountRes.DataRes getDefaultInstanceForType() {
        return QueryGroupCountRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupCountRes.DataRes build() {
        QueryGroupCountRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupCountRes.DataRes buildPartial() {
        QueryGroupCountRes.DataRes dataRes = new QueryGroupCountRes.DataRes(this, (QueryGroupCountRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.userGroupCount_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataRes.localGroupCount_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataRes.banner_ = this.d;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public k mergeFrom(QueryGroupCountRes.DataRes dataRes) {
        if (dataRes != QueryGroupCountRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasUserGroupCount()) {
                a(dataRes.getUserGroupCount());
            }
            if (dataRes.hasLocalGroupCount()) {
                b(dataRes.getLocalGroupCount());
            }
            if (dataRes.hasBanner()) {
                a(dataRes.getBanner());
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
        QueryGroupCountRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryGroupCountRes.DataRes parsePartialFrom = QueryGroupCountRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataRes = null;
                if (dataRes != null) {
                    mergeFrom(dataRes);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupCountRes.DataRes dataRes2 = (QueryGroupCountRes.DataRes) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataRes = dataRes2;
                th = th3;
                if (dataRes != null) {
                }
                throw th;
            }
        }
    }

    public k a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public k b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public k a(QueryGroupCountRes.Banner banner) {
        if ((this.a & 4) == 4 && this.d != QueryGroupCountRes.Banner.getDefaultInstance()) {
            this.d = QueryGroupCountRes.Banner.newBuilder(this.d).mergeFrom(banner).buildPartial();
        } else {
            this.d = banner;
        }
        this.a |= 4;
        return this;
    }
}
