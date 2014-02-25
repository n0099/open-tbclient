package protobuf.UpgradeMemberGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl, e> implements f {
    private int a;
    private UpgradeMemberGroupReq.DataReq b = UpgradeMemberGroupReq.DataReq.getDefaultInstance();

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
        this.b = UpgradeMemberGroupReq.DataReq.getDefaultInstance();
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
    public UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl getDefaultInstanceForType() {
        return UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl build() {
        UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl buildPartial() {
        UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl upgradeMemberGroupReqIdl = new UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl(this, (UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        upgradeMemberGroupReqIdl.data_ = this.b;
        upgradeMemberGroupReqIdl.bitField0_ = i;
        return upgradeMemberGroupReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl upgradeMemberGroupReqIdl) {
        if (upgradeMemberGroupReqIdl != UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl.getDefaultInstance() && upgradeMemberGroupReqIdl.hasData()) {
            b(upgradeMemberGroupReqIdl.getData());
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
        UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl upgradeMemberGroupReqIdl;
        Throwable th;
        try {
            try {
                UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl parsePartialFrom = UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                upgradeMemberGroupReqIdl = null;
                if (upgradeMemberGroupReqIdl != null) {
                    mergeFrom(upgradeMemberGroupReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl upgradeMemberGroupReqIdl2 = (UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                upgradeMemberGroupReqIdl = upgradeMemberGroupReqIdl2;
                th = th3;
                if (upgradeMemberGroupReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(UpgradeMemberGroupReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public e b(UpgradeMemberGroupReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != UpgradeMemberGroupReq.DataReq.getDefaultInstance()) {
            this.b = UpgradeMemberGroupReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
