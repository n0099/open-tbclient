package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class ad extends GeneratedMessageLite.Builder<Im.TshowInfo, ad> implements ae {
    private int a;
    private Object b = "";
    private Object c = "";
    private Object d = "";

    private ad() {
        g();
    }

    private void g() {
    }

    public static ad h() {
        return new ad();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public ad clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public ad clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.TshowInfo getDefaultInstanceForType() {
        return Im.TshowInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.TshowInfo build() {
        Im.TshowInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.TshowInfo buildPartial() {
        Im.TshowInfo tshowInfo = new Im.TshowInfo(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        tshowInfo.icon_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        tshowInfo.name_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        tshowInfo.url_ = this.d;
        tshowInfo.bitField0_ = i2;
        return tshowInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public ad mergeFrom(Im.TshowInfo tshowInfo) {
        Object obj;
        Object obj2;
        Object obj3;
        if (tshowInfo != Im.TshowInfo.getDefaultInstance()) {
            if (tshowInfo.hasIcon()) {
                this.a |= 1;
                obj3 = tshowInfo.icon_;
                this.b = obj3;
            }
            if (tshowInfo.hasName()) {
                this.a |= 2;
                obj2 = tshowInfo.name_;
                this.c = obj2;
            }
            if (tshowInfo.hasUrl()) {
                this.a |= 4;
                obj = tshowInfo.url_;
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
    public ad mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.TshowInfo tshowInfo;
        Throwable th;
        try {
            try {
                Im.TshowInfo parsePartialFrom = Im.TshowInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                tshowInfo = null;
                if (tshowInfo != null) {
                    mergeFrom(tshowInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.TshowInfo tshowInfo2 = (Im.TshowInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                tshowInfo = tshowInfo2;
                th = th3;
                if (tshowInfo != null) {
                }
                throw th;
            }
        }
    }
}
