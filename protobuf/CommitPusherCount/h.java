package protobuf.CommitPusherCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.CommitPusherCount.CommitPusherCountRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<CommitPusherCountRes.CommitPusherCountResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private CommitPusherCountRes.DataRes c = CommitPusherCountRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        CommitPusherCountRes.CommitPusherCountResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return CommitPusherCountRes.CommitPusherCountResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return CommitPusherCountRes.CommitPusherCountResIdl.getDefaultInstance();
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
        this.c = CommitPusherCountRes.DataRes.getDefaultInstance();
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
    public CommitPusherCountRes.CommitPusherCountResIdl buildPartial() {
        CommitPusherCountRes.CommitPusherCountResIdl commitPusherCountResIdl = new CommitPusherCountRes.CommitPusherCountResIdl(this, (CommitPusherCountRes.CommitPusherCountResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        commitPusherCountResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        commitPusherCountResIdl.data_ = this.c;
        commitPusherCountResIdl.bitField0_ = i2;
        return commitPusherCountResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(CommitPusherCountRes.CommitPusherCountResIdl commitPusherCountResIdl) {
        if (commitPusherCountResIdl != CommitPusherCountRes.CommitPusherCountResIdl.getDefaultInstance()) {
            if (commitPusherCountResIdl.hasError()) {
                Im.Error error = commitPusherCountResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (commitPusherCountResIdl.hasData()) {
                CommitPusherCountRes.DataRes data = commitPusherCountResIdl.getData();
                if ((this.a & 2) != 2 || this.c == CommitPusherCountRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = CommitPusherCountRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
        CommitPusherCountRes.CommitPusherCountResIdl commitPusherCountResIdl;
        Throwable th;
        try {
            try {
                CommitPusherCountRes.CommitPusherCountResIdl parsePartialFrom = CommitPusherCountRes.CommitPusherCountResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                commitPusherCountResIdl = null;
                if (commitPusherCountResIdl != null) {
                    mergeFrom(commitPusherCountResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitPusherCountRes.CommitPusherCountResIdl commitPusherCountResIdl2 = (CommitPusherCountRes.CommitPusherCountResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                commitPusherCountResIdl = commitPusherCountResIdl2;
                th = th3;
                if (commitPusherCountResIdl != null) {
                }
                throw th;
            }
        }
    }
}
