package protobuf.UpgradeMemberGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class UpgradeMemberGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<UpgradeMemberGroupReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(UpgradeMemberGroupReqIdl upgradeMemberGroupReqIdl) {
            super(upgradeMemberGroupReqIdl);
            if (upgradeMemberGroupReqIdl == null) {
                return;
            }
            this.data = upgradeMemberGroupReqIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpgradeMemberGroupReqIdl build(boolean z) {
            return new UpgradeMemberGroupReqIdl(this, z);
        }
    }

    public UpgradeMemberGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }
}
