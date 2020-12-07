package protobuf.DelGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes21.dex */
public final class DataRes extends Message {
    public static final Long DEFAULT_GROUPID = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
                return;
            } else {
                this.groupId = builder.groupId;
                return;
            }
        }
        this.groupId = builder.groupId;
    }

    /* loaded from: classes21.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Long groupId;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groupId = dataRes.groupId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
