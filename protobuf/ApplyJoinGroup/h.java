package protobuf.ApplyJoinGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.ApplyJoinGroup.ApplyJoinGroupRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<ApplyJoinGroupRes.ApplyJoinGroupResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private ApplyJoinGroupRes.DataRes c = ApplyJoinGroupRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        ApplyJoinGroupRes.ApplyJoinGroupResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return ApplyJoinGroupRes.ApplyJoinGroupResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return ApplyJoinGroupRes.ApplyJoinGroupResIdl.getDefaultInstance();
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
        this.c = ApplyJoinGroupRes.DataRes.getDefaultInstance();
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
    public ApplyJoinGroupRes.ApplyJoinGroupResIdl buildPartial() {
        ApplyJoinGroupRes.ApplyJoinGroupResIdl applyJoinGroupResIdl = new ApplyJoinGroupRes.ApplyJoinGroupResIdl(this, (ApplyJoinGroupRes.ApplyJoinGroupResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        applyJoinGroupResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        applyJoinGroupResIdl.data_ = this.c;
        applyJoinGroupResIdl.bitField0_ = i2;
        return applyJoinGroupResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(ApplyJoinGroupRes.ApplyJoinGroupResIdl applyJoinGroupResIdl) {
        if (applyJoinGroupResIdl != ApplyJoinGroupRes.ApplyJoinGroupResIdl.getDefaultInstance()) {
            if (applyJoinGroupResIdl.hasError()) {
                Im.Error error = applyJoinGroupResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (applyJoinGroupResIdl.hasData()) {
                ApplyJoinGroupRes.DataRes data = applyJoinGroupResIdl.getData();
                if ((this.a & 2) != 2 || this.c == ApplyJoinGroupRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = ApplyJoinGroupRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
        ApplyJoinGroupRes.ApplyJoinGroupResIdl applyJoinGroupResIdl;
        Throwable th;
        try {
            try {
                ApplyJoinGroupRes.ApplyJoinGroupResIdl parsePartialFrom = ApplyJoinGroupRes.ApplyJoinGroupResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                applyJoinGroupResIdl = null;
                if (applyJoinGroupResIdl != null) {
                    mergeFrom(applyJoinGroupResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            ApplyJoinGroupRes.ApplyJoinGroupResIdl applyJoinGroupResIdl2 = (ApplyJoinGroupRes.ApplyJoinGroupResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                applyJoinGroupResIdl = applyJoinGroupResIdl2;
                th = th3;
                if (applyJoinGroupResIdl != null) {
                }
                throw th;
            }
        }
    }
}
