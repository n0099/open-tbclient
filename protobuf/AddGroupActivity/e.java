package protobuf.AddGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.AddGroupActivity.AddGroupActivityReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<AddGroupActivityReq.DataReq, e> implements f {
    private int a;
    private int b;
    private int c;
    private Object d = "";
    private Object e = "";
    private Object f = "";
    private long g;
    private int h;

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
        this.c = 0;
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        this.e = "";
        this.a &= -9;
        this.f = "";
        this.a &= -17;
        this.g = 0L;
        this.a &= -33;
        this.h = 0;
        this.a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public AddGroupActivityReq.DataReq getDefaultInstanceForType() {
        return AddGroupActivityReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public AddGroupActivityReq.DataReq build() {
        AddGroupActivityReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public AddGroupActivityReq.DataReq buildPartial() {
        AddGroupActivityReq.DataReq dataReq = new AddGroupActivityReq.DataReq(this, (AddGroupActivityReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.activityId_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.gActivityTitle_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.gActivityContent_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.gActivityArea_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataReq.gActivityTime_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        dataReq.commitType_ = this.h;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(AddGroupActivityReq.DataReq dataReq) {
        Object obj;
        Object obj2;
        Object obj3;
        if (dataReq != AddGroupActivityReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasActivityId()) {
                b(dataReq.getActivityId());
            }
            if (dataReq.hasGActivityTitle()) {
                this.a |= 4;
                obj3 = dataReq.gActivityTitle_;
                this.d = obj3;
            }
            if (dataReq.hasGActivityContent()) {
                this.a |= 8;
                obj2 = dataReq.gActivityContent_;
                this.e = obj2;
            }
            if (dataReq.hasGActivityArea()) {
                this.a |= 16;
                obj = dataReq.gActivityArea_;
                this.f = obj;
            }
            if (dataReq.hasGActivityTime()) {
                a(dataReq.getGActivityTime());
            }
            if (dataReq.hasCommitType()) {
                c(dataReq.getCommitType());
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
        AddGroupActivityReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                AddGroupActivityReq.DataReq parsePartialFrom = AddGroupActivityReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            AddGroupActivityReq.DataReq dataReq2 = (AddGroupActivityReq.DataReq) e.getUnfinishedMessage();
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

    public e b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public e a(String str) {
        if (str != null) {
            this.a |= 4;
            this.d = str;
        }
        return this;
    }

    public e b(String str) {
        if (str != null) {
            this.a |= 8;
            this.e = str;
        }
        return this;
    }

    public e c(String str) {
        if (str != null) {
            this.a |= 16;
            this.f = str;
        }
        return this;
    }

    public e a(long j) {
        this.a |= 32;
        this.g = j;
        return this;
    }

    public e c(int i) {
        this.a |= 64;
        this.h = i;
        return this;
    }
}
