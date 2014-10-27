package protobuf.GetOnlineInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class Gift extends Message {
    public static final Integer DEFAULT_VERSION = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer version;

    /* synthetic */ Gift(Builder builder, boolean z, Gift gift) {
        this(builder, z);
    }

    private Gift(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.version == null) {
                this.version = DEFAULT_VERSION;
                return;
            } else {
                this.version = builder.version;
                return;
            }
        }
        this.version = builder.version;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<Gift> {
        public Integer version;

        public Builder(Gift gift) {
            super(gift);
            if (gift != null) {
                this.version = gift.version;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Gift build(boolean z) {
            return new Gift(this, z, null);
        }
    }
}
