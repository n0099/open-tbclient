package protobuf.CheckMaskUser;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CheckMaskUser.CheckMaskUserReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<CheckMaskUserReq.CheckMaskUserIdl, b> implements c {
    private int a;
    private CheckMaskUserReq.DataReq b = CheckMaskUserReq.DataReq.getDefaultInstance();

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
        this.b = CheckMaskUserReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public CheckMaskUserReq.CheckMaskUserIdl getDefaultInstanceForType() {
        return CheckMaskUserReq.CheckMaskUserIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CheckMaskUserReq.CheckMaskUserIdl build() {
        CheckMaskUserReq.CheckMaskUserIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CheckMaskUserReq.CheckMaskUserIdl buildPartial() {
        CheckMaskUserReq.CheckMaskUserIdl checkMaskUserIdl = new CheckMaskUserReq.CheckMaskUserIdl(this, (CheckMaskUserReq.CheckMaskUserIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        checkMaskUserIdl.data_ = this.b;
        checkMaskUserIdl.bitField0_ = i;
        return checkMaskUserIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(CheckMaskUserReq.CheckMaskUserIdl checkMaskUserIdl) {
        if (checkMaskUserIdl != CheckMaskUserReq.CheckMaskUserIdl.getDefaultInstance() && checkMaskUserIdl.hasData()) {
            b(checkMaskUserIdl.getData());
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
        CheckMaskUserReq.CheckMaskUserIdl checkMaskUserIdl;
        Throwable th;
        try {
            try {
                CheckMaskUserReq.CheckMaskUserIdl parsePartialFrom = CheckMaskUserReq.CheckMaskUserIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                checkMaskUserIdl = null;
                if (checkMaskUserIdl != null) {
                    mergeFrom(checkMaskUserIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CheckMaskUserReq.CheckMaskUserIdl checkMaskUserIdl2 = (CheckMaskUserReq.CheckMaskUserIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                checkMaskUserIdl = checkMaskUserIdl2;
                th = th3;
                if (checkMaskUserIdl != null) {
                }
                throw th;
            }
        }
    }

    public b a(CheckMaskUserReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public b b(CheckMaskUserReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != CheckMaskUserReq.DataReq.getDefaultInstance()) {
            this.b = CheckMaskUserReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
