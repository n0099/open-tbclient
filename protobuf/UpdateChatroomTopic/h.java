package protobuf.UpdateChatroomTopic;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<UpdateChatroomTopicRes.UpdateChatroomTopicResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        UpdateChatroomTopicRes.UpdateChatroomTopicResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return UpdateChatroomTopicRes.UpdateChatroomTopicResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return UpdateChatroomTopicRes.UpdateChatroomTopicResIdl.getDefaultInstance();
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
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpdateChatroomTopicRes.UpdateChatroomTopicResIdl buildPartial() {
        UpdateChatroomTopicRes.UpdateChatroomTopicResIdl updateChatroomTopicResIdl = new UpdateChatroomTopicRes.UpdateChatroomTopicResIdl(this, (UpdateChatroomTopicRes.UpdateChatroomTopicResIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        updateChatroomTopicResIdl.error_ = this.b;
        updateChatroomTopicResIdl.bitField0_ = i;
        return updateChatroomTopicResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(UpdateChatroomTopicRes.UpdateChatroomTopicResIdl updateChatroomTopicResIdl) {
        if (updateChatroomTopicResIdl != UpdateChatroomTopicRes.UpdateChatroomTopicResIdl.getDefaultInstance() && updateChatroomTopicResIdl.hasError()) {
            Im.Error error = updateChatroomTopicResIdl.getError();
            if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                this.b = error;
            } else {
                this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UpdateChatroomTopicRes.UpdateChatroomTopicResIdl updateChatroomTopicResIdl;
        Throwable th;
        try {
            try {
                UpdateChatroomTopicRes.UpdateChatroomTopicResIdl parsePartialFrom = UpdateChatroomTopicRes.UpdateChatroomTopicResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                updateChatroomTopicResIdl = null;
                if (updateChatroomTopicResIdl != null) {
                    mergeFrom(updateChatroomTopicResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpdateChatroomTopicRes.UpdateChatroomTopicResIdl updateChatroomTopicResIdl2 = (UpdateChatroomTopicRes.UpdateChatroomTopicResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                updateChatroomTopicResIdl = updateChatroomTopicResIdl2;
                th = th3;
                if (updateChatroomTopicResIdl != null) {
                }
                throw th;
            }
        }
    }
}
