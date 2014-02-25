package protobuf.DelGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.DelGroupActivity.DelGroupActivityReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<DelGroupActivityReq.DataReq, b> implements c {
    private int a;
    private int b;
    private int c;

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
        this.c = 0;
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
    public DelGroupActivityReq.DataReq getDefaultInstanceForType() {
        return DelGroupActivityReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupActivityReq.DataReq build() {
        DelGroupActivityReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupActivityReq.DataReq buildPartial() {
        DelGroupActivityReq.DataReq dataReq = new DelGroupActivityReq.DataReq(this, (DelGroupActivityReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.activityId_ = this.c;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(DelGroupActivityReq.DataReq dataReq) {
        if (dataReq != DelGroupActivityReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasActivityId()) {
                b(dataReq.getActivityId());
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
        DelGroupActivityReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                DelGroupActivityReq.DataReq parsePartialFrom = DelGroupActivityReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            DelGroupActivityReq.DataReq dataReq2 = (DelGroupActivityReq.DataReq) e.getUnfinishedMessage();
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

    public b b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }
}
