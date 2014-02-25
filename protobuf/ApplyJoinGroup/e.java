package protobuf.ApplyJoinGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.ApplyJoinGroup.ApplyJoinGroupReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<ApplyJoinGroupReq.DataReq, e> implements f {
    private int a;
    private int b;
    private Object c = "";
    private long d;
    private int e;

    private e() {
        g();
    }

    private void g() {
    }

    public static e h() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public e clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = 0L;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public ApplyJoinGroupReq.DataReq getDefaultInstanceForType() {
        return ApplyJoinGroupReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ApplyJoinGroupReq.DataReq build() {
        ApplyJoinGroupReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public ApplyJoinGroupReq.DataReq buildPartial() {
        ApplyJoinGroupReq.DataReq dataReq = new ApplyJoinGroupReq.DataReq(this, (ApplyJoinGroupReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.userMsg_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.inviteUserId_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.joinType_ = this.e;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(ApplyJoinGroupReq.DataReq dataReq) {
        Object obj;
        if (dataReq != ApplyJoinGroupReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasUserMsg()) {
                this.a |= 2;
                obj = dataReq.userMsg_;
                this.c = obj;
            }
            if (dataReq.hasInviteUserId()) {
                a(dataReq.getInviteUserId());
            }
            if (dataReq.hasJoinType()) {
                b(dataReq.getJoinType());
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
    public e mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ApplyJoinGroupReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                ApplyJoinGroupReq.DataReq parsePartialFrom = ApplyJoinGroupReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            ApplyJoinGroupReq.DataReq dataReq2 = (ApplyJoinGroupReq.DataReq) e.getUnfinishedMessage();
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

    public e a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public e a(String str) {
        if (str != null) {
            this.a |= 2;
            this.c = str;
        }
        return this;
    }

    public e a(long j) {
        this.a |= 4;
        this.d = j;
        return this;
    }

    public e b(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }
}
