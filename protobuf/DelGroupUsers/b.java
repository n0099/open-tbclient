package protobuf.DelGroupUsers;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.DelGroupUsers.DelGroupUsersReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<DelGroupUsersReq.DataReq, b> implements c {
    private int a;
    private int b;
    private Object c = "";

    private b() {
        g();
    }

    private void g() {
    }

    public static b h() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public b clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public DelGroupUsersReq.DataReq getDefaultInstanceForType() {
        return DelGroupUsersReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupUsersReq.DataReq build() {
        DelGroupUsersReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupUsersReq.DataReq buildPartial() {
        DelGroupUsersReq.DataReq dataReq = new DelGroupUsersReq.DataReq(this, (DelGroupUsersReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.userIds_ = this.c;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(DelGroupUsersReq.DataReq dataReq) {
        Object obj;
        if (dataReq != DelGroupUsersReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasUserIds()) {
                this.a |= 2;
                obj = dataReq.userIds_;
                this.c = obj;
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DelGroupUsersReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                DelGroupUsersReq.DataReq parsePartialFrom = DelGroupUsersReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            DelGroupUsersReq.DataReq dataReq2 = (DelGroupUsersReq.DataReq) e.getUnfinishedMessage();
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

    public b a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public b a(String str) {
        if (str != null) {
            this.a |= 2;
            this.c = str;
        }
        return this;
    }
}
