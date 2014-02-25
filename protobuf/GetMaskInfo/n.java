package protobuf.GetMaskInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<GetMaskInfoRes.UserInfo, n> implements o {
    private int a;
    private Object b = "";
    private Object c = "";
    private int d;

    private n() {
        g();
    }

    private void g() {
    }

    public static n h() {
        return new n();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public n clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public n clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public GetMaskInfoRes.UserInfo getDefaultInstanceForType() {
        return GetMaskInfoRes.UserInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetMaskInfoRes.UserInfo build() {
        GetMaskInfoRes.UserInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetMaskInfoRes.UserInfo buildPartial() {
        GetMaskInfoRes.UserInfo userInfo = new GetMaskInfoRes.UserInfo(this, (GetMaskInfoRes.UserInfo) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        userInfo.name_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        userInfo.portrait_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        userInfo.uid_ = this.d;
        userInfo.bitField0_ = i2;
        return userInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public n mergeFrom(GetMaskInfoRes.UserInfo userInfo) {
        Object obj;
        Object obj2;
        if (userInfo != GetMaskInfoRes.UserInfo.getDefaultInstance()) {
            if (userInfo.hasName()) {
                this.a |= 1;
                obj2 = userInfo.name_;
                this.b = obj2;
            }
            if (userInfo.hasPortrait()) {
                this.a |= 2;
                obj = userInfo.portrait_;
                this.c = obj;
            }
            if (userInfo.hasUid()) {
                a(userInfo.getUid());
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
        GetMaskInfoRes.UserInfo userInfo;
        Throwable th;
        try {
            try {
                GetMaskInfoRes.UserInfo parsePartialFrom = GetMaskInfoRes.UserInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                userInfo = null;
                if (userInfo != null) {
                    mergeFrom(userInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            GetMaskInfoRes.UserInfo userInfo2 = (GetMaskInfoRes.UserInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                userInfo = userInfo2;
                th = th3;
                if (userInfo != null) {
                }
                throw th;
            }
        }
    }

    public n a(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }
}
