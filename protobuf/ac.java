package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
/* loaded from: classes.dex */
public final class ac extends GeneratedMessageLite.Builder<Im.PusherMsgInfo, ac> implements ad {
    private int a;
    private int b;
    private long c;
    private long d;
    private int e;

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        Im.PusherMsgInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.PusherMsgInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.PusherMsgInfo.getDefaultInstance();
    }

    private ac() {
    }

    public static /* synthetic */ ac b() {
        return new ac();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
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
    /* renamed from: d */
    public ac clone() {
        return new ac().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final Im.PusherMsgInfo buildPartial() {
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
    public final ac mergeFrom(Im.PusherMsgInfo pusherMsgInfo) {
        if (pusherMsgInfo != Im.PusherMsgInfo.getDefaultInstance()) {
            if (pusherMsgInfo.hasGroupId()) {
                int groupId = pusherMsgInfo.getGroupId();
                this.a |= 1;
                this.b = groupId;
            }
            if (pusherMsgInfo.hasMsgId()) {
                long msgId = pusherMsgInfo.getMsgId();
                this.a |= 2;
                this.c = msgId;
            }
            if (pusherMsgInfo.hasPushTime()) {
                long pushTime = pusherMsgInfo.getPushTime();
                this.a |= 4;
                this.d = pushTime;
            }
            if (pusherMsgInfo.hasType()) {
                int type = pusherMsgInfo.getType();
                this.a |= 8;
                this.e = type;
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
}
