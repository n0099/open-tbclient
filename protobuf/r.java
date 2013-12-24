package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class r extends GeneratedMessageLite.Builder<Im.MaskInfo, r> implements s {
    private int a;
    private long b;
    private Object c = "";
    private int d;

    /* JADX DEBUG: Method not inlined, still used in: [protobuf.Im.MaskInfo.newBuilder():protobuf.r] */
    public static /* synthetic */ r f() {
        return h();
    }

    private r() {
        g();
    }

    private void g() {
    }

    public static r h() {
        return new r();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public r clear() {
        super.clear();
        this.b = 0L;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public r clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.MaskInfo getDefaultInstanceForType() {
        return Im.MaskInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.MaskInfo build() {
        Im.MaskInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.MaskInfo buildPartial() {
        Im.MaskInfo maskInfo = new Im.MaskInfo(this);
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
        maskInfo.bitField0_ = i2;
        return maskInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public r mergeFrom(Im.MaskInfo maskInfo) {
        Object obj;
        if (maskInfo != Im.MaskInfo.getDefaultInstance()) {
            if (maskInfo.hasUserId()) {
                a(maskInfo.getUserId());
            }
            if (maskInfo.hasMaskGids()) {
                this.a |= 2;
                obj = maskInfo.maskGids_;
                this.c = obj;
            }
            if (maskInfo.hasRemindMask()) {
                a(maskInfo.getRemindMask());
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
    public r mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

    public r a(long j) {
        this.a |= 1;
        this.b = j;
        return this;
    }

    public r a(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }
}
