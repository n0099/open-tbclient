package protobuf.PushNotify;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<PushNotifyRes.PusherMsg, h> implements i {
    private int a;
    private int b;
    private Im.PusherMsgInfo c = Im.PusherMsgInfo.getDefaultInstance();

    private h() {
        g();
    }

    private void g() {
    }

    public static h h() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public h clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = Im.PusherMsgInfo.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public PushNotifyRes.PusherMsg getDefaultInstanceForType() {
        return PushNotifyRes.PusherMsg.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public PushNotifyRes.PusherMsg build() {
        PushNotifyRes.PusherMsg buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public PushNotifyRes.PusherMsg buildPartial() {
        PushNotifyRes.PusherMsg pusherMsg = new PushNotifyRes.PusherMsg(this, (PushNotifyRes.PusherMsg) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        pusherMsg.cmd_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        pusherMsg.data_ = this.c;
        pusherMsg.bitField0_ = i2;
        return pusherMsg;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(PushNotifyRes.PusherMsg pusherMsg) {
        if (pusherMsg != PushNotifyRes.PusherMsg.getDefaultInstance()) {
            if (pusherMsg.hasCmd()) {
                a(pusherMsg.getCmd());
            }
            if (pusherMsg.hasData()) {
                a(pusherMsg.getData());
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
        PushNotifyRes.PusherMsg pusherMsg;
        Throwable th;
        try {
            try {
                PushNotifyRes.PusherMsg parsePartialFrom = PushNotifyRes.PusherMsg.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                pusherMsg = null;
                if (pusherMsg != null) {
                    mergeFrom(pusherMsg);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            PushNotifyRes.PusherMsg pusherMsg2 = (PushNotifyRes.PusherMsg) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                pusherMsg = pusherMsg2;
                th = th3;
                if (pusherMsg != null) {
                }
                throw th;
            }
        }
    }

    public h a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public h a(Im.PusherMsgInfo pusherMsgInfo) {
        if ((this.a & 2) == 2 && this.c != Im.PusherMsgInfo.getDefaultInstance()) {
            this.c = Im.PusherMsgInfo.newBuilder(this.c).mergeFrom(pusherMsgInfo).buildPartial();
        } else {
            this.c = pusherMsgInfo;
        }
        this.a |= 2;
        return this;
    }
}
