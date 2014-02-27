package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
/* loaded from: classes.dex */
public final class t extends GeneratedMessageLite.Builder<Im.MaskInfo, t> implements u {
    private int a;
    private long b;
    private int d;
    private int f;
    private Object c = "";
    private Object e = "";

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        Im.MaskInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.MaskInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.MaskInfo.getDefaultInstance();
    }

    private t() {
    }

    public static /* synthetic */ t b() {
        return new t();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public t clear() {
        super.clear();
        this.b = 0L;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = "";
        this.a &= -9;
        this.f = 0;
        this.a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public t clone() {
        return new t().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final Im.MaskInfo buildPartial() {
        Im.MaskInfo maskInfo = new Im.MaskInfo(this, (Im.MaskInfo) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        maskInfo.userId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        maskInfo.maskGids_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        maskInfo.remindMask_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        maskInfo.maskUids_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        maskInfo.shieldStatus_ = this.f;
        maskInfo.bitField0_ = i2;
        return maskInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final t mergeFrom(Im.MaskInfo maskInfo) {
        Object obj;
        Object obj2;
        if (maskInfo != Im.MaskInfo.getDefaultInstance()) {
            if (maskInfo.hasUserId()) {
                long userId = maskInfo.getUserId();
                this.a |= 1;
                this.b = userId;
            }
            if (maskInfo.hasMaskGids()) {
                this.a |= 2;
                obj2 = maskInfo.maskGids_;
                this.c = obj2;
            }
            if (maskInfo.hasRemindMask()) {
                int remindMask = maskInfo.getRemindMask();
                this.a |= 4;
                this.d = remindMask;
            }
            if (maskInfo.hasMaskUids()) {
                this.a |= 8;
                obj = maskInfo.maskUids_;
                this.e = obj;
            }
            if (maskInfo.hasShieldStatus()) {
                int shieldStatus = maskInfo.getShieldStatus();
                this.a |= 16;
                this.f = shieldStatus;
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
    public t mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.MaskInfo maskInfo;
        Throwable th;
        try {
            try {
                Im.MaskInfo parsePartialFrom = Im.MaskInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                maskInfo = null;
                if (maskInfo != null) {
                    mergeFrom(maskInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.MaskInfo maskInfo2 = (Im.MaskInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                maskInfo = maskInfo2;
                th = th3;
                if (maskInfo != null) {
                }
                throw th;
            }
        }
    }
}
