package protobuf.CommitInviteMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitInviteMsg.CommitInviteMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<CommitInviteMsgRes.CommitInviteMsgResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private CommitInviteMsgRes.DataRes c = CommitInviteMsgRes.DataRes.getDefaultInstance();

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
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = CommitInviteMsgRes.DataRes.getDefaultInstance();
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
    public CommitInviteMsgRes.CommitInviteMsgResIdl getDefaultInstanceForType() {
        return CommitInviteMsgRes.CommitInviteMsgResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CommitInviteMsgRes.CommitInviteMsgResIdl build() {
        CommitInviteMsgRes.CommitInviteMsgResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitInviteMsgRes.CommitInviteMsgResIdl buildPartial() {
        CommitInviteMsgRes.CommitInviteMsgResIdl commitInviteMsgResIdl = new CommitInviteMsgRes.CommitInviteMsgResIdl(this, (CommitInviteMsgRes.CommitInviteMsgResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        commitInviteMsgResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        commitInviteMsgResIdl.data_ = this.c;
        commitInviteMsgResIdl.bitField0_ = i2;
        return commitInviteMsgResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(CommitInviteMsgRes.CommitInviteMsgResIdl commitInviteMsgResIdl) {
        if (commitInviteMsgResIdl != CommitInviteMsgRes.CommitInviteMsgResIdl.getDefaultInstance()) {
            if (commitInviteMsgResIdl.hasError()) {
                a(commitInviteMsgResIdl.getError());
            }
            if (commitInviteMsgResIdl.hasData()) {
                a(commitInviteMsgResIdl.getData());
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
        CommitInviteMsgRes.CommitInviteMsgResIdl commitInviteMsgResIdl;
        Throwable th;
        try {
            try {
                CommitInviteMsgRes.CommitInviteMsgResIdl parsePartialFrom = CommitInviteMsgRes.CommitInviteMsgResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                commitInviteMsgResIdl = null;
                if (commitInviteMsgResIdl != null) {
                    mergeFrom(commitInviteMsgResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitInviteMsgRes.CommitInviteMsgResIdl commitInviteMsgResIdl2 = (CommitInviteMsgRes.CommitInviteMsgResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                commitInviteMsgResIdl = commitInviteMsgResIdl2;
                th = th3;
                if (commitInviteMsgResIdl != null) {
                }
                throw th;
            }
        }
    }

    public h a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public h a(CommitInviteMsgRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != CommitInviteMsgRes.DataRes.getDefaultInstance()) {
            this.c = CommitInviteMsgRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
