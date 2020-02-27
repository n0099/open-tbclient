package protobuf.AddGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class AddGroupActivityReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private AddGroupActivityReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<AddGroupActivityReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(AddGroupActivityReqIdl addGroupActivityReqIdl) {
            super(addGroupActivityReqIdl);
            if (addGroupActivityReqIdl != null) {
                this.data = addGroupActivityReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AddGroupActivityReqIdl build(boolean z) {
            return new AddGroupActivityReqIdl(this, z);
        }
    }
}
