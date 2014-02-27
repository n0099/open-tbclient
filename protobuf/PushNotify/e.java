package protobuf.PushNotify;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<PushNotifyRes.PushNotifyResIdl, e> implements f {
    private int a;
    private long b;
    private List<PushNotifyRes.PusherMsg> c = Collections.emptyList();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        PushNotifyRes.PushNotifyResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return PushNotifyRes.PushNotifyResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return PushNotifyRes.PushNotifyResIdl.getDefaultInstance();
    }

    private e() {
    }

    public static /* synthetic */ e a() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clear() {
        super.clear();
        this.b = 0L;
        this.a &= -2;
        this.c = Collections.emptyList();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public e clone() {
        return new e().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public PushNotifyRes.PushNotifyResIdl buildPartial() {
        PushNotifyRes.PushNotifyResIdl pushNotifyResIdl = new PushNotifyRes.PushNotifyResIdl(this, (PushNotifyRes.PushNotifyResIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        pushNotifyResIdl.pushTime_ = this.b;
        if ((this.a & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
            this.a &= -3;
        }
        pushNotifyResIdl.multiMsg_ = this.c;
        pushNotifyResIdl.bitField0_ = i;
        return pushNotifyResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(PushNotifyRes.PushNotifyResIdl pushNotifyResIdl) {
        List list;
        List list2;
        List<PushNotifyRes.PusherMsg> list3;
        if (pushNotifyResIdl != PushNotifyRes.PushNotifyResIdl.getDefaultInstance()) {
            if (pushNotifyResIdl.hasPushTime()) {
                long pushTime = pushNotifyResIdl.getPushTime();
                this.a |= 1;
                this.b = pushTime;
            }
            list = pushNotifyResIdl.multiMsg_;
            if (!list.isEmpty()) {
                if (this.c.isEmpty()) {
                    list3 = pushNotifyResIdl.multiMsg_;
                    this.c = list3;
                    this.a &= -3;
                } else {
                    if ((this.a & 2) != 2) {
                        this.c = new ArrayList(this.c);
                        this.a |= 2;
                    }
                    List<PushNotifyRes.PusherMsg> list4 = this.c;
                    list2 = pushNotifyResIdl.multiMsg_;
                    list4.addAll(list2);
                }
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
    public e mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        PushNotifyRes.PushNotifyResIdl pushNotifyResIdl;
        Throwable th;
        try {
            try {
                PushNotifyRes.PushNotifyResIdl parsePartialFrom = PushNotifyRes.PushNotifyResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                pushNotifyResIdl = null;
                if (pushNotifyResIdl != null) {
                    mergeFrom(pushNotifyResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            PushNotifyRes.PushNotifyResIdl pushNotifyResIdl2 = (PushNotifyRes.PushNotifyResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                pushNotifyResIdl = pushNotifyResIdl2;
                th = th3;
                if (pushNotifyResIdl != null) {
                }
                throw th;
            }
        }
    }
}
