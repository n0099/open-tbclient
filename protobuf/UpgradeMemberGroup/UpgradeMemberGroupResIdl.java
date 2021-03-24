package protobuf.UpgradeMemberGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class UpgradeMemberGroupResIdl extends Message {
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<UpgradeMemberGroupResIdl> {
        public Error error;

        public Builder() {
        }

        public Builder(UpgradeMemberGroupResIdl upgradeMemberGroupResIdl) {
            super(upgradeMemberGroupResIdl);
            if (upgradeMemberGroupResIdl == null) {
                return;
            }
            this.error = upgradeMemberGroupResIdl.error;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpgradeMemberGroupResIdl build(boolean z) {
            return new UpgradeMemberGroupResIdl(this, z);
        }
    }

    public UpgradeMemberGroupResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
        } else {
            this.error = builder.error;
        }
    }
}
