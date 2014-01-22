package protobuf.UpdateChatroomTopic;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicReq;
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite.Builder<UpdateChatroomTopicReq.DataReq, c> implements d {
    private int a;
    private int b;
    private Object c = "";
    private Object d = "";

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
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public c clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public UpdateChatroomTopicReq.DataReq getDefaultInstanceForType() {
        return UpdateChatroomTopicReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpdateChatroomTopicReq.DataReq build() {
        UpdateChatroomTopicReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateChatroomTopicReq.DataReq buildPartial() {
        UpdateChatroomTopicReq.DataReq dataReq = new UpdateChatroomTopicReq.DataReq(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.title_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.content_ = this.d;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public c mergeFrom(UpdateChatroomTopicReq.DataReq dataReq) {
        Object obj;
        Object obj2;
        if (dataReq != UpdateChatroomTopicReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasTitle()) {
                this.a |= 2;
                obj2 = dataReq.title_;
                this.c = obj2;
            }
            if (dataReq.hasContent()) {
                this.a |= 4;
                obj = dataReq.content_;
                this.d = obj;
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
    public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UpdateChatroomTopicReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                UpdateChatroomTopicReq.DataReq parsePartialFrom = UpdateChatroomTopicReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            UpdateChatroomTopicReq.DataReq dataReq2 = (UpdateChatroomTopicReq.DataReq) e.getUnfinishedMessage();
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

    public c a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public c a(String str) {
        if (str != null) {
            this.a |= 2;
            this.c = str;
        }
        return this;
    }

    public c b(String str) {
        if (str != null) {
            this.a |= 4;
            this.d = str;
        }
        return this;
    }
}
