package protobuf.QueryGroupCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<QueryGroupCountRes.Banner, j> implements k {
    private int a;
    private Object b = "";
    private Object c = "";

    private j() {
        g();
    }

    private void g() {
    }

    public static j h() {
        return new j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public j clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupCountRes.Banner getDefaultInstanceForType() {
        return QueryGroupCountRes.Banner.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupCountRes.Banner build() {
        QueryGroupCountRes.Banner buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupCountRes.Banner buildPartial() {
        QueryGroupCountRes.Banner banner = new QueryGroupCountRes.Banner(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        banner.link_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        banner.picUrl_ = this.c;
        banner.bitField0_ = i2;
        return banner;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(QueryGroupCountRes.Banner banner) {
        Object obj;
        Object obj2;
        if (banner != QueryGroupCountRes.Banner.getDefaultInstance()) {
            if (banner.hasLink()) {
                this.a |= 1;
                obj2 = banner.link_;
                this.b = obj2;
            }
            if (banner.hasPicUrl()) {
                this.a |= 2;
                obj = banner.picUrl_;
                this.c = obj;
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
    public j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupCountRes.Banner banner;
        Throwable th;
        try {
            try {
                QueryGroupCountRes.Banner parsePartialFrom = QueryGroupCountRes.Banner.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                banner = null;
                if (banner != null) {
                    mergeFrom(banner);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupCountRes.Banner banner2 = (QueryGroupCountRes.Banner) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                banner = banner2;
                th = th3;
                if (banner != null) {
                }
                throw th;
            }
        }
    }
}
