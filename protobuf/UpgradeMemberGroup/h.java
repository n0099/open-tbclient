package protobuf.UpgradeMemberGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<UpgradeMemberGroupRes.UpgradeMemberGroupResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        UpgradeMemberGroupRes.UpgradeMemberGroupResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return UpgradeMemberGroupRes.UpgradeMemberGroupResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return UpgradeMemberGroupRes.UpgradeMemberGroupResIdl.getDefaultInstance();
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
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpgradeMemberGroupRes.UpgradeMemberGroupResIdl buildPartial() {
        UpgradeMemberGroupRes.UpgradeMemberGroupResIdl upgradeMemberGroupResIdl = new UpgradeMemberGroupRes.UpgradeMemberGroupResIdl(this, (UpgradeMemberGroupRes.UpgradeMemberGroupResIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        upgradeMemberGroupResIdl.error_ = this.b;
        upgradeMemberGroupResIdl.bitField0_ = i;
        return upgradeMemberGroupResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(UpgradeMemberGroupRes.UpgradeMemberGroupResIdl upgradeMemberGroupResIdl) {
        if (upgradeMemberGroupResIdl != UpgradeMemberGroupRes.UpgradeMemberGroupResIdl.getDefaultInstance() && upgradeMemberGroupResIdl.hasError()) {
            Im.Error error = upgradeMemberGroupResIdl.getError();
            if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                this.b = error;
            } else {
                this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
            }
            this.a |= 1;
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
        UpgradeMemberGroupRes.UpgradeMemberGroupResIdl upgradeMemberGroupResIdl;
        Throwable th;
        try {
            try {
                UpgradeMemberGroupRes.UpgradeMemberGroupResIdl parsePartialFrom = UpgradeMemberGroupRes.UpgradeMemberGroupResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                upgradeMemberGroupResIdl = null;
                if (upgradeMemberGroupResIdl != null) {
                    mergeFrom(upgradeMemberGroupResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpgradeMemberGroupRes.UpgradeMemberGroupResIdl upgradeMemberGroupResIdl2 = (UpgradeMemberGroupRes.UpgradeMemberGroupResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                upgradeMemberGroupResIdl = upgradeMemberGroupResIdl2;
                th = th3;
                if (upgradeMemberGroupResIdl != null) {
                }
                throw th;
            }
        }
    }
}
