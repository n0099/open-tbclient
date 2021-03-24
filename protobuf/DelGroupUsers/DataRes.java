package protobuf.DelGroupUsers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final Long DEFAULT_GROUPID = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Long groupId;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.groupId = dataRes.groupId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }

    public DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
                return;
            } else {
                this.groupId = l;
                return;
            }
        }
        this.groupId = builder.groupId;
    }
}
