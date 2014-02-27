package protobuf.QueryGroupCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QueryGroupCountRes.Banner, h> implements i {
    private int a;
    private Object b = "";
    private Object c = "";

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupCountRes.Banner buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupCountRes.Banner.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupCountRes.Banner.getDefaultInstance();
    }

    private h() {
    }

    public static /* synthetic */ h b() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryGroupCountRes.Banner buildPartial() {
        QueryGroupCountRes.Banner banner = new QueryGroupCountRes.Banner(this, (QueryGroupCountRes.Banner) null);
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
    public final h mergeFrom(QueryGroupCountRes.Banner banner) {
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
