package protobuf.ApplyJoinGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes23.dex */
public final class ApplyJoinGroupResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private ApplyJoinGroupResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<ApplyJoinGroupResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(ApplyJoinGroupResIdl applyJoinGroupResIdl) {
            super(applyJoinGroupResIdl);
            if (applyJoinGroupResIdl != null) {
                this.error = applyJoinGroupResIdl.error;
                this.data = applyJoinGroupResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ApplyJoinGroupResIdl build(boolean z) {
            return new ApplyJoinGroupResIdl(this, z);
        }
    }
}
