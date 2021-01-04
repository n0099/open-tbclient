package protobuf.AddGroupUsers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class AddGroupUsersResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private AddGroupUsersResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<AddGroupUsersResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(AddGroupUsersResIdl addGroupUsersResIdl) {
            super(addGroupUsersResIdl);
            if (addGroupUsersResIdl != null) {
                this.error = addGroupUsersResIdl.error;
                this.data = addGroupUsersResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AddGroupUsersResIdl build(boolean z) {
            return new AddGroupUsersResIdl(this, z);
        }
    }
}
