package protobuf.PushNotify;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.PushNotify.PushNotifyReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<PushNotifyReq.PushNotifyReqIdl, b> implements c {
    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        PushNotifyReq.PushNotifyReqIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
        super.clear();
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder clear() {
        super.clear();
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return PushNotifyReq.PushNotifyReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return PushNotifyReq.PushNotifyReqIdl.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b a() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public PushNotifyReq.PushNotifyReqIdl buildPartial() {
        return new PushNotifyReq.PushNotifyReqIdl(this, (PushNotifyReq.PushNotifyReqIdl) null);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(PushNotifyReq.PushNotifyReqIdl pushNotifyReqIdl) {
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
