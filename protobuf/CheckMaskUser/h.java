package protobuf.CheckMaskUser;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.CheckMaskUser.CheckMaskUserRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<CheckMaskUserRes.CheckMaskUserResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private CheckMaskUserRes.DataRes c = CheckMaskUserRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        CheckMaskUserRes.CheckMaskUserResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return CheckMaskUserRes.CheckMaskUserResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return CheckMaskUserRes.CheckMaskUserResIdl.getDefaultInstance();
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
        this.c = CheckMaskUserRes.DataRes.getDefaultInstance();
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
    public CheckMaskUserRes.CheckMaskUserResIdl buildPartial() {
        CheckMaskUserRes.CheckMaskUserResIdl checkMaskUserResIdl = new CheckMaskUserRes.CheckMaskUserResIdl(this, (CheckMaskUserRes.CheckMaskUserResIdl) null);
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
    public final h mergeFrom(CheckMaskUserRes.CheckMaskUserResIdl checkMaskUserResIdl) {
        if (checkMaskUserResIdl != CheckMaskUserRes.CheckMaskUserResIdl.getDefaultInstance()) {
            if (checkMaskUserResIdl.hasError()) {
                Im.Error error = checkMaskUserResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (checkMaskUserResIdl.hasData()) {
                CheckMaskUserRes.DataRes data = checkMaskUserResIdl.getData();
                if ((this.a & 2) != 2 || this.c == CheckMaskUserRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = CheckMaskUserRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
}
