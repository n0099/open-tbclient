package protobuf.SetLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class SetLocationReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ SetLocationReqIdl(Builder builder, boolean z, SetLocationReqIdl setLocationReqIdl) {
        this(builder, z);
    }

    private SetLocationReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<SetLocationReqIdl> {
        public DataReq data;

        public Builder(SetLocationReqIdl setLocationReqIdl) {
            super(setLocationReqIdl);
            if (setLocationReqIdl != null) {
                this.data = setLocationReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SetLocationReqIdl build(boolean z) {
            return new SetLocationReqIdl(this, z, null);
        }
    }
}
