package protobuf.DelGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes3.dex */
public final class DelGroupActivityReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private DelGroupActivityReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<DelGroupActivityReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(DelGroupActivityReqIdl delGroupActivityReqIdl) {
            super(delGroupActivityReqIdl);
            if (delGroupActivityReqIdl != null) {
                this.data = delGroupActivityReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DelGroupActivityReqIdl build(boolean z) {
            return new DelGroupActivityReqIdl(this, z);
        }
    }
}
