package protobuf.CheckMaskUser;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class CheckMaskUserIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ CheckMaskUserIdl(Builder builder, boolean z, CheckMaskUserIdl checkMaskUserIdl) {
        this(builder, z);
    }

    private CheckMaskUserIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<CheckMaskUserIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(CheckMaskUserIdl checkMaskUserIdl) {
            super(checkMaskUserIdl);
            if (checkMaskUserIdl != null) {
                this.data = checkMaskUserIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CheckMaskUserIdl build(boolean z) {
            return new CheckMaskUserIdl(this, z, null);
        }
    }
}
