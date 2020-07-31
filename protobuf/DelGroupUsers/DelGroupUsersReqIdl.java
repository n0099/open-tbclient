package protobuf.DelGroupUsers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes15.dex */
public final class DelGroupUsersReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private DelGroupUsersReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes15.dex */
    public static final class Builder extends Message.Builder<DelGroupUsersReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(DelGroupUsersReqIdl delGroupUsersReqIdl) {
            super(delGroupUsersReqIdl);
            if (delGroupUsersReqIdl != null) {
                this.data = delGroupUsersReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DelGroupUsersReqIdl build(boolean z) {
            return new DelGroupUsersReqIdl(this, z);
        }
    }
}
