package protobuf.CommitGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitGroupMsg.CommitGroupMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<CommitGroupMsgRes.CommitGroupMsgResIdl, j> implements k {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private CommitGroupMsgRes.DataRes c = CommitGroupMsgRes.DataRes.getDefaultInstance();

    private j() {
        g();
    }

    private void g() {
    }

    public static j h() {
        return new j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public j clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = CommitGroupMsgRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
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
        CommitGroupMsgRes.CommitGroupMsgResIdl commitGroupMsgResIdl = new CommitGroupMsgRes.CommitGroupMsgResIdl(this);
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
    public j mergeFrom(CommitGroupMsgRes.CommitGroupMsgResIdl commitGroupMsgResIdl) {
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
    public j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

    public j a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public j a(CommitGroupMsgRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != CommitGroupMsgRes.DataRes.getDefaultInstance()) {
            this.c = CommitGroupMsgRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
