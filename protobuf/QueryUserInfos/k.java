package protobuf.QueryUserInfos;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryUserInfosRes.IconInfo, k> implements l {
    private int a;
    private int c;
    private Object b = "";
    private Object d = "";

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryUserInfosRes.IconInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryUserInfosRes.IconInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryUserInfosRes.IconInfo.getDefaultInstance();
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
        this.b = "";
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryUserInfosRes.IconInfo buildPartial() {
        QueryUserInfosRes.IconInfo iconInfo = new QueryUserInfosRes.IconInfo(this, (QueryUserInfosRes.IconInfo) null);
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
    public final k mergeFrom(QueryUserInfosRes.IconInfo iconInfo) {
        Object obj;
        Object obj2;
        if (iconInfo != QueryUserInfosRes.IconInfo.getDefaultInstance()) {
            if (iconInfo.hasName()) {
                this.a |= 1;
                obj2 = iconInfo.name_;
                this.b = obj2;
            }
            if (iconInfo.hasWeight()) {
                int weight = iconInfo.getWeight();
                this.a |= 2;
                this.c = weight;
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
}
