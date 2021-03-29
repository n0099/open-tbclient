package protobuf.AddGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class AddGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<AddGroupReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(AddGroupReqIdl addGroupReqIdl) {
            super(addGroupReqIdl);
            if (addGroupReqIdl == null) {
                return;
            }
            this.data = addGroupReqIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AddGroupReqIdl build(boolean z) {
            return new AddGroupReqIdl(this, z);
        }
    }

    public AddGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }
}
