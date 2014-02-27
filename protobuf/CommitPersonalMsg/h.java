package protobuf.CommitPersonalMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<CommitPersonalMsgRes.CommitPersonalMsgResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private CommitPersonalMsgRes.DataRes c = CommitPersonalMsgRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        CommitPersonalMsgRes.CommitPersonalMsgResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return CommitPersonalMsgRes.CommitPersonalMsgResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return CommitPersonalMsgRes.CommitPersonalMsgResIdl.getDefaultInstance();
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
        this.c = CommitPersonalMsgRes.DataRes.getDefaultInstance();
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
    public CommitPersonalMsgRes.CommitPersonalMsgResIdl buildPartial() {
        CommitPersonalMsgRes.CommitPersonalMsgResIdl commitPersonalMsgResIdl = new CommitPersonalMsgRes.CommitPersonalMsgResIdl(this, (CommitPersonalMsgRes.CommitPersonalMsgResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        commitPersonalMsgResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        commitPersonalMsgResIdl.data_ = this.c;
        commitPersonalMsgResIdl.bitField0_ = i2;
        return commitPersonalMsgResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(CommitPersonalMsgRes.CommitPersonalMsgResIdl commitPersonalMsgResIdl) {
        if (commitPersonalMsgResIdl != CommitPersonalMsgRes.CommitPersonalMsgResIdl.getDefaultInstance()) {
            if (commitPersonalMsgResIdl.hasError()) {
                Im.Error error = commitPersonalMsgResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (commitPersonalMsgResIdl.hasData()) {
                CommitPersonalMsgRes.DataRes data = commitPersonalMsgResIdl.getData();
                if ((this.a & 2) != 2 || this.c == CommitPersonalMsgRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = CommitPersonalMsgRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
                }
                this.a |= 2;
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
        CommitPersonalMsgRes.CommitPersonalMsgResIdl commitPersonalMsgResIdl;
        Throwable th;
        try {
            try {
                CommitPersonalMsgRes.CommitPersonalMsgResIdl parsePartialFrom = CommitPersonalMsgRes.CommitPersonalMsgResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                commitPersonalMsgResIdl = null;
                if (commitPersonalMsgResIdl != null) {
                    mergeFrom(commitPersonalMsgResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitPersonalMsgRes.CommitPersonalMsgResIdl commitPersonalMsgResIdl2 = (CommitPersonalMsgRes.CommitPersonalMsgResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                commitPersonalMsgResIdl = commitPersonalMsgResIdl2;
                th = th3;
                if (commitPersonalMsgResIdl != null) {
                }
                throw th;
            }
        }
    }
}
