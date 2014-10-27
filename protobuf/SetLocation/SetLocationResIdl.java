package protobuf.SetLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class SetLocationResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ SetLocationResIdl(Builder builder, boolean z, SetLocationResIdl setLocationResIdl) {
        this(builder, z);
    }

    private SetLocationResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<SetLocationResIdl> {
        public DataRes data;
        public Error error;

        public Builder(SetLocationResIdl setLocationResIdl) {
            super(setLocationResIdl);
            if (setLocationResIdl != null) {
                this.error = setLocationResIdl.error;
                this.data = setLocationResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SetLocationResIdl build(boolean z) {
            return new SetLocationResIdl(this, z, null);
        }
    }
}
