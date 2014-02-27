package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
/* loaded from: classes.dex */
public final class af extends GeneratedMessageLite.Builder<Im.TshowInfo, af> implements ag {
    private int a;
    private Object b = "";
    private Object c = "";
    private Object d = "";

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        Im.TshowInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.TshowInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.TshowInfo.getDefaultInstance();
    }

    private af() {
    }

    public static /* synthetic */ af a() {
        return new af();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public af clear() {
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
    /* renamed from: c */
    public af clone() {
        return new af().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.TshowInfo buildPartial() {
        Im.TshowInfo tshowInfo = new Im.TshowInfo(this, (Im.TshowInfo) null);
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
    public final af mergeFrom(Im.TshowInfo tshowInfo) {
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
    public af mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
