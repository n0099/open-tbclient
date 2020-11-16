package protobuf.AddGroupUsers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes20.dex */
public final class AddGroupUsersReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private AddGroupUsersReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes20.dex */
    public static final class Builder extends Message.Builder<AddGroupUsersReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(AddGroupUsersReqIdl addGroupUsersReqIdl) {
            super(addGroupUsersReqIdl);
            if (addGroupUsersReqIdl != null) {
                this.data = addGroupUsersReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AddGroupUsersReqIdl build(boolean z) {
            return new AddGroupUsersReqIdl(this, z);
        }
    }
}
