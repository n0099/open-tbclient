package protobuf.DelGroupUsers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class DelGroupUsersResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ DelGroupUsersResIdl(Builder builder, boolean z, DelGroupUsersResIdl delGroupUsersResIdl) {
        this(builder, z);
    }

    private DelGroupUsersResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<DelGroupUsersResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(DelGroupUsersResIdl delGroupUsersResIdl) {
            super(delGroupUsersResIdl);
            if (delGroupUsersResIdl != null) {
                this.error = delGroupUsersResIdl.error;
                this.data = delGroupUsersResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DelGroupUsersResIdl build(boolean z) {
            return new DelGroupUsersResIdl(this, z, null);
        }
    }
}
