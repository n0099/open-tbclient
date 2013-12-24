package protobuf.PushNotify;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.PushNotify.PushNotifyReq;
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite.Builder<PushNotifyReq.PushNotifyReqIdl, c> implements d {
    private c() {
        g();
    }

    private void g() {
    }

    public static c h() {
        return new c();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public c clear() {
        super.clear();
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public c clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public PushNotifyReq.PushNotifyReqIdl getDefaultInstanceForType() {
        return PushNotifyReq.PushNotifyReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public PushNotifyReq.PushNotifyReqIdl build() {
        PushNotifyReq.PushNotifyReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public PushNotifyReq.PushNotifyReqIdl buildPartial() {
        return new PushNotifyReq.PushNotifyReqIdl(this);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public c mergeFrom(PushNotifyReq.PushNotifyReqIdl pushNotifyReqIdl) {
        if (pushNotifyReqIdl == PushNotifyReq.PushNotifyReqIdl.getDefaultInstance()) {
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
    public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        PushNotifyReq.PushNotifyReqIdl pushNotifyReqIdl;
        Throwable th;
        try {
            try {
                PushNotifyReq.PushNotifyReqIdl parsePartialFrom = PushNotifyReq.PushNotifyReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                pushNotifyReqIdl = null;
                if (pushNotifyReqIdl != null) {
                    mergeFrom(pushNotifyReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            PushNotifyReq.PushNotifyReqIdl pushNotifyReqIdl2 = (PushNotifyReq.PushNotifyReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                pushNotifyReqIdl = pushNotifyReqIdl2;
                th = th3;
                if (pushNotifyReqIdl != null) {
                }
                throw th;
            }
        }
    }
}
