package protobuf.CheckMaskUser;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CheckMaskUser.CheckMaskUserReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<CheckMaskUserReq.DataReq, e> implements f {
    private int a;
    private int b;

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
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public CheckMaskUserReq.DataReq getDefaultInstanceForType() {
        return CheckMaskUserReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CheckMaskUserReq.DataReq build() {
        CheckMaskUserReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CheckMaskUserReq.DataReq buildPartial() {
        CheckMaskUserReq.DataReq dataReq = new CheckMaskUserReq.DataReq(this, (CheckMaskUserReq.DataReq) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        dataReq.uid_ = this.b;
        dataReq.bitField0_ = i;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(CheckMaskUserReq.DataReq dataReq) {
        if (dataReq != CheckMaskUserReq.DataReq.getDefaultInstance() && dataReq.hasUid()) {
            a(dataReq.getUid());
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
        CheckMaskUserReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                CheckMaskUserReq.DataReq parsePartialFrom = CheckMaskUserReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            CheckMaskUserReq.DataReq dataReq2 = (CheckMaskUserReq.DataReq) e.getUnfinishedMessage();
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
}
