package protobuf.EnterChatroom;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.EnterChatroom.EnterChatroomReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<EnterChatroomReq.DataReq, b> implements c {
    private int a;
    private int b;

    private b() {
        g();
    }

    private void g() {
    }

    public static b h() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public b clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public EnterChatroomReq.DataReq getDefaultInstanceForType() {
        return EnterChatroomReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public EnterChatroomReq.DataReq build() {
        EnterChatroomReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public EnterChatroomReq.DataReq buildPartial() {
        EnterChatroomReq.DataReq dataReq = new EnterChatroomReq.DataReq(this, (EnterChatroomReq.DataReq) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        dataReq.lastGroupId_ = this.b;
        dataReq.bitField0_ = i;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(EnterChatroomReq.DataReq dataReq) {
        if (dataReq != EnterChatroomReq.DataReq.getDefaultInstance() && dataReq.hasLastGroupId()) {
            a(dataReq.getLastGroupId());
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
        EnterChatroomReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                EnterChatroomReq.DataReq parsePartialFrom = EnterChatroomReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataReq = null;
                if (dataReq != null) {
                    mergeFrom(dataReq);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            EnterChatroomReq.DataReq dataReq2 = (EnterChatroomReq.DataReq) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataReq = dataReq2;
                th = th3;
                if (dataReq != null) {
                }
                throw th;
            }
        }
    }

    public b a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }
}
