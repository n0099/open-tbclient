package protobuf.CommitGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitGroupMsg.CommitGroupMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<CommitGroupMsgRes.CommitGroupMsgResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private CommitGroupMsgRes.DataRes c = CommitGroupMsgRes.DataRes.getDefaultInstance();

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
        this.c = CommitGroupMsgRes.DataRes.getDefaultInstance();
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
    public CommitGroupMsgRes.CommitGroupMsgResIdl getDefaultInstanceForType() {
        return CommitGroupMsgRes.CommitGroupMsgResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CommitGroupMsgRes.CommitGroupMsgResIdl build() {
        CommitGroupMsgRes.CommitGroupMsgResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitGroupMsgRes.CommitGroupMsgResIdl buildPartial() {
        CommitGroupMsgRes.CommitGroupMsgResIdl commitGroupMsgResIdl = new CommitGroupMsgRes.CommitGroupMsgResIdl(this, (CommitGroupMsgRes.CommitGroupMsgResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        commitGroupMsgResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        commitGroupMsgResIdl.data_ = this.c;
        commitGroupMsgResIdl.bitField0_ = i2;
        return commitGroupMsgResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(CommitGroupMsgRes.CommitGroupMsgResIdl commitGroupMsgResIdl) {
        if (commitGroupMsgResIdl != CommitGroupMsgRes.CommitGroupMsgResIdl.getDefaultInstance()) {
            if (commitGroupMsgResIdl.hasError()) {
                a(commitGroupMsgResIdl.getError());
            }
            if (commitGroupMsgResIdl.hasData()) {
                a(commitGroupMsgResIdl.getData());
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
        CommitGroupMsgRes.CommitGroupMsgResIdl commitGroupMsgResIdl;
        Throwable th;
        try {
            try {
                CommitGroupMsgRes.CommitGroupMsgResIdl parsePartialFrom = CommitGroupMsgRes.CommitGroupMsgResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                commitGroupMsgResIdl = null;
                if (commitGroupMsgResIdl != null) {
                    mergeFrom(commitGroupMsgResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitGroupMsgRes.CommitGroupMsgResIdl commitGroupMsgResIdl2 = (CommitGroupMsgRes.CommitGroupMsgResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                commitGroupMsgResIdl = commitGroupMsgResIdl2;
                th = th3;
                if (commitGroupMsgResIdl != null) {
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

    public h a(CommitGroupMsgRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != CommitGroupMsgRes.DataRes.getDefaultInstance()) {
            this.c = CommitGroupMsgRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
