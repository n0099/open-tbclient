package protobuf.UpdateChatroomTopic;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl, e> implements f {
    private int a;
    private UpdateChatroomTopicReq.DataReq b = UpdateChatroomTopicReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl.getDefaultInstance();
    }

    private e() {
    }

    public static /* synthetic */ e b() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public e clear() {
        super.clear();
        this.b = UpdateChatroomTopicReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public e clone() {
        return new e().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl build() {
        UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl buildPartial() {
        UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl updateChatroomTopicReqIdl = new UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl(this, (UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        updateChatroomTopicReqIdl.data_ = this.b;
        updateChatroomTopicReqIdl.bitField0_ = i;
        return updateChatroomTopicReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl updateChatroomTopicReqIdl) {
        if (updateChatroomTopicReqIdl != UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl.getDefaultInstance() && updateChatroomTopicReqIdl.hasData()) {
            UpdateChatroomTopicReq.DataReq data = updateChatroomTopicReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == UpdateChatroomTopicReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = UpdateChatroomTopicReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
            }
            this.a |= 1;
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
        UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl updateChatroomTopicReqIdl;
        Throwable th;
        try {
            try {
                UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl parsePartialFrom = UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                updateChatroomTopicReqIdl = null;
                if (updateChatroomTopicReqIdl != null) {
                    mergeFrom(updateChatroomTopicReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl updateChatroomTopicReqIdl2 = (UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                updateChatroomTopicReqIdl = updateChatroomTopicReqIdl2;
                th = th3;
                if (updateChatroomTopicReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(UpdateChatroomTopicReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
