package protobuf.CheckMaskUser;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CheckMaskUser.CheckMaskUserRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<CheckMaskUserRes.CheckMaskUserResIdl, j> implements k {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private CheckMaskUserRes.DataRes c = CheckMaskUserRes.DataRes.getDefaultInstance();

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
        this.c = CheckMaskUserRes.DataRes.getDefaultInstance();
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
    public CheckMaskUserRes.CheckMaskUserResIdl getDefaultInstanceForType() {
        return CheckMaskUserRes.CheckMaskUserResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CheckMaskUserRes.CheckMaskUserResIdl build() {
        CheckMaskUserRes.CheckMaskUserResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CheckMaskUserRes.CheckMaskUserResIdl buildPartial() {
        CheckMaskUserRes.CheckMaskUserResIdl checkMaskUserResIdl = new CheckMaskUserRes.CheckMaskUserResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        checkMaskUserResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        checkMaskUserResIdl.data_ = this.c;
        checkMaskUserResIdl.bitField0_ = i2;
        return checkMaskUserResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(CheckMaskUserRes.CheckMaskUserResIdl checkMaskUserResIdl) {
        if (checkMaskUserResIdl != CheckMaskUserRes.CheckMaskUserResIdl.getDefaultInstance()) {
            if (checkMaskUserResIdl.hasError()) {
                a(checkMaskUserResIdl.getError());
            }
            if (checkMaskUserResIdl.hasData()) {
                a(checkMaskUserResIdl.getData());
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
        CheckMaskUserRes.CheckMaskUserResIdl checkMaskUserResIdl;
        Throwable th;
        try {
            try {
                CheckMaskUserRes.CheckMaskUserResIdl parsePartialFrom = CheckMaskUserRes.CheckMaskUserResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                checkMaskUserResIdl = null;
                if (checkMaskUserResIdl != null) {
                    mergeFrom(checkMaskUserResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CheckMaskUserRes.CheckMaskUserResIdl checkMaskUserResIdl2 = (CheckMaskUserRes.CheckMaskUserResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                checkMaskUserResIdl = checkMaskUserResIdl2;
                th = th3;
                if (checkMaskUserResIdl != null) {
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

    public j a(CheckMaskUserRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != CheckMaskUserRes.DataRes.getDefaultInstance()) {
            this.c = CheckMaskUserRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
