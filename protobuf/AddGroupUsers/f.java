package protobuf.AddGroupUsers;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.AddGroupUsers.AddGroupUsersReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<AddGroupUsersReq.DataReq, f> implements g {
    private int a;
    private int b;
    private Object c = "";
    private int d;
    private int e;
    private int f;
    private long g;
    private int h;

    private f() {
        g();
    }

    private void g() {
    }

    public static f h() {
        return new f();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public f clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        this.f = 0;
        this.a &= -17;
        this.g = 0L;
        this.a &= -33;
        this.h = 0;
        this.a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public AddGroupUsersReq.DataReq getDefaultInstanceForType() {
        return AddGroupUsersReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public AddGroupUsersReq.DataReq build() {
        AddGroupUsersReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public AddGroupUsersReq.DataReq buildPartial() {
        AddGroupUsersReq.DataReq dataReq = new AddGroupUsersReq.DataReq(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.userIds_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.sysMsgId_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.sysGroupId_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.decision_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataReq.inviteUserId_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        dataReq.joinType_ = this.h;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(AddGroupUsersReq.DataReq dataReq) {
        Object obj;
        if (dataReq != AddGroupUsersReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasUserIds()) {
                this.a |= 2;
                obj = dataReq.userIds_;
                this.c = obj;
            }
            if (dataReq.hasSysMsgId()) {
                b(dataReq.getSysMsgId());
            }
            if (dataReq.hasSysGroupId()) {
                c(dataReq.getSysGroupId());
            }
            if (dataReq.hasDecision()) {
                d(dataReq.getDecision());
            }
            if (dataReq.hasInviteUserId()) {
                a(dataReq.getInviteUserId());
            }
            if (dataReq.hasJoinType()) {
                e(dataReq.getJoinType());
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
    public f mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        AddGroupUsersReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                AddGroupUsersReq.DataReq parsePartialFrom = AddGroupUsersReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            AddGroupUsersReq.DataReq dataReq2 = (AddGroupUsersReq.DataReq) e.getUnfinishedMessage();
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

    public f a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public f a(String str) {
        if (str != null) {
            this.a |= 2;
            this.c = str;
        }
        return this;
    }

    public f b(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public f c(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }

    public f d(int i) {
        this.a |= 16;
        this.f = i;
        return this;
    }

    public f a(long j) {
        this.a |= 32;
        this.g = j;
        return this;
    }

    public f e(int i) {
        this.a |= 64;
        this.h = i;
        return this;
    }
}
