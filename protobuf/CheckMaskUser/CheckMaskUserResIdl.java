package protobuf.CheckMaskUser;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class CheckMaskUserResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ CheckMaskUserResIdl(Builder builder, boolean z, CheckMaskUserResIdl checkMaskUserResIdl) {
        this(builder, z);
    }

    private CheckMaskUserResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<CheckMaskUserResIdl> {
        public DataRes data;
        public Error error;

        public Builder(CheckMaskUserResIdl checkMaskUserResIdl) {
            super(checkMaskUserResIdl);
            if (checkMaskUserResIdl != null) {
                this.error = checkMaskUserResIdl.error;
                this.data = checkMaskUserResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CheckMaskUserResIdl build(boolean z) {
            return new CheckMaskUserResIdl(this, z, null);
        }
    }
}
