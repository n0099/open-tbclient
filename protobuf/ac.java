package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class ac extends GeneratedMessageLite.Builder<Im.PusherMsgInfo, ac> implements ad {
    private int a;
    private int b;
    private long c;
    private long d;
    private int e;

    private ac() {
        g();
    }

    private void g() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [protobuf.Im.PusherMsgInfo.newBuilder():protobuf.ac] */
    public static /* synthetic */ ac f() {
        return h();
    }

    public static ac h() {
        return new ac();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public ac clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0L;
        this.a &= -3;
        this.d = 0L;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public ac clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.PusherMsgInfo getDefaultInstanceForType() {
        return Im.PusherMsgInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.PusherMsgInfo build() {
        Im.PusherMsgInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.PusherMsgInfo buildPartial() {
        Im.PusherMsgInfo pusherMsgInfo = new Im.PusherMsgInfo(this, (Im.PusherMsgInfo) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        pusherMsgInfo.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        pusherMsgInfo.msgId_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        pusherMsgInfo.pushTime_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        pusherMsgInfo.type_ = this.e;
        pusherMsgInfo.bitField0_ = i2;
        return pusherMsgInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public ac mergeFrom(Im.PusherMsgInfo pusherMsgInfo) {
        if (pusherMsgInfo != Im.PusherMsgInfo.getDefaultInstance()) {
            if (pusherMsgInfo.hasGroupId()) {
                a(pusherMsgInfo.getGroupId());
            }
            if (pusherMsgInfo.hasMsgId()) {
                a(pusherMsgInfo.getMsgId());
            }
            if (pusherMsgInfo.hasPushTime()) {
                b(pusherMsgInfo.getPushTime());
            }
            if (pusherMsgInfo.hasType()) {
                b(pusherMsgInfo.getType());
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
    public ac mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.PusherMsgInfo pusherMsgInfo;
        Throwable th;
        try {
            try {
                Im.PusherMsgInfo parsePartialFrom = Im.PusherMsgInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                pusherMsgInfo = null;
                if (pusherMsgInfo != null) {
                    mergeFrom(pusherMsgInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.PusherMsgInfo pusherMsgInfo2 = (Im.PusherMsgInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                pusherMsgInfo = pusherMsgInfo2;
                th = th3;
                if (pusherMsgInfo != null) {
                }
                throw th;
            }
        }
    }

    public ac a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public ac a(long j) {
        this.a |= 2;
        this.c = j;
        return this;
    }

    public ac b(long j) {
        this.a |= 4;
        this.d = j;
        return this;
    }

    public ac b(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }
}
