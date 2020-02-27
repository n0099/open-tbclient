package protobuf.QueryUserPermission;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.GroupPermission;
/* loaded from: classes8.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 1)
    public final GroupPermission groupPerm;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.groupPerm = builder.groupPerm;
        } else {
            this.groupPerm = builder.groupPerm;
        }
    }

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public GroupPermission groupPerm;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groupPerm = dataRes.groupPerm;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
