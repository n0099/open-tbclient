package protobuf.QueryUserInfos;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<QueryUserInfosRes.IconInfo, m> implements n {
    private int a;
    private int c;
    private Object b = "";
    private Object d = "";

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
        this.b = "";
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public m clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryUserInfosRes.IconInfo getDefaultInstanceForType() {
        return QueryUserInfosRes.IconInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryUserInfosRes.IconInfo build() {
        QueryUserInfosRes.IconInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryUserInfosRes.IconInfo buildPartial() {
        QueryUserInfosRes.IconInfo iconInfo = new QueryUserInfosRes.IconInfo(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        iconInfo.name_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        iconInfo.weight_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        iconInfo.iconUrl_ = this.d;
        iconInfo.bitField0_ = i2;
        return iconInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(QueryUserInfosRes.IconInfo iconInfo) {
        Object obj;
        Object obj2;
        if (iconInfo != QueryUserInfosRes.IconInfo.getDefaultInstance()) {
            if (iconInfo.hasName()) {
                this.a |= 1;
                obj2 = iconInfo.name_;
                this.b = obj2;
            }
            if (iconInfo.hasWeight()) {
                a(iconInfo.getWeight());
            }
            if (iconInfo.hasIconUrl()) {
                this.a |= 4;
                obj = iconInfo.iconUrl_;
                this.d = obj;
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
        QueryUserInfosRes.IconInfo iconInfo;
        Throwable th;
        try {
            try {
                QueryUserInfosRes.IconInfo parsePartialFrom = QueryUserInfosRes.IconInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                iconInfo = null;
                if (iconInfo != null) {
                    mergeFrom(iconInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryUserInfosRes.IconInfo iconInfo2 = (QueryUserInfosRes.IconInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                iconInfo = iconInfo2;
                th = th3;
                if (iconInfo != null) {
                }
                throw th;
            }
        }
    }

    public m a(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }
}
