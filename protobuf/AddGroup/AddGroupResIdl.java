package protobuf.AddGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes15.dex */
public final class AddGroupResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private AddGroupResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes15.dex */
    public static final class Builder extends Message.Builder<AddGroupResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(AddGroupResIdl addGroupResIdl) {
            super(addGroupResIdl);
            if (addGroupResIdl != null) {
                this.error = addGroupResIdl.error;
                this.data = addGroupResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AddGroupResIdl build(boolean z) {
            return new AddGroupResIdl(this, z);
        }
    }
}
