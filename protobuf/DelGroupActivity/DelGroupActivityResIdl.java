package protobuf.DelGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes23.dex */
public final class DelGroupActivityResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private DelGroupActivityResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<DelGroupActivityResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(DelGroupActivityResIdl delGroupActivityResIdl) {
            super(delGroupActivityResIdl);
            if (delGroupActivityResIdl != null) {
                this.error = delGroupActivityResIdl.error;
                this.data = delGroupActivityResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DelGroupActivityResIdl build(boolean z) {
            return new DelGroupActivityResIdl(this, z);
        }
    }
}
