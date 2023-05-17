package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class Ecom extends Message {
    public static final Integer DEFAULT_ISSELLER = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer isSeller;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<Ecom> {
        public Integer isSeller;

        public Builder() {
        }

        public Builder(Ecom ecom) {
            super(ecom);
            if (ecom == null) {
                return;
            }
            this.isSeller = ecom.isSeller;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Ecom build(boolean z) {
            return new Ecom(this, z);
        }
    }

    public Ecom(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isSeller;
            if (num == null) {
                this.isSeller = DEFAULT_ISSELLER;
                return;
            } else {
                this.isSeller = num;
                return;
            }
        }
        this.isSeller = builder.isSeller;
    }
}
