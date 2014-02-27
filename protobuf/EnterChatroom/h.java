package protobuf.EnterChatroom;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.EnterChatroom.EnterChatroomRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<EnterChatroomRes.ChatroomTopic, h> implements i {
    private int a;
    private Object b = "";
    private Object c = "";

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        EnterChatroomRes.ChatroomTopic buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return EnterChatroomRes.ChatroomTopic.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return EnterChatroomRes.ChatroomTopic.getDefaultInstance();
    }

    private h() {
    }

    public static /* synthetic */ h a() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public EnterChatroomRes.ChatroomTopic buildPartial() {
        EnterChatroomRes.ChatroomTopic chatroomTopic = new EnterChatroomRes.ChatroomTopic(this, (EnterChatroomRes.ChatroomTopic) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        chatroomTopic.title_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        chatroomTopic.content_ = this.c;
        chatroomTopic.bitField0_ = i2;
        return chatroomTopic;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(EnterChatroomRes.ChatroomTopic chatroomTopic) {
        Object obj;
        Object obj2;
        if (chatroomTopic != EnterChatroomRes.ChatroomTopic.getDefaultInstance()) {
            if (chatroomTopic.hasTitle()) {
                this.a |= 1;
                obj2 = chatroomTopic.title_;
                this.b = obj2;
            }
            if (chatroomTopic.hasContent()) {
                this.a |= 2;
                obj = chatroomTopic.content_;
                this.c = obj;
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
        EnterChatroomRes.ChatroomTopic chatroomTopic;
        Throwable th;
        try {
            try {
                EnterChatroomRes.ChatroomTopic parsePartialFrom = EnterChatroomRes.ChatroomTopic.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                chatroomTopic = null;
                if (chatroomTopic != null) {
                    mergeFrom(chatroomTopic);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            EnterChatroomRes.ChatroomTopic chatroomTopic2 = (EnterChatroomRes.ChatroomTopic) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                chatroomTopic = chatroomTopic2;
                th = th3;
                if (chatroomTopic != null) {
                }
                throw th;
            }
        }
    }
}
