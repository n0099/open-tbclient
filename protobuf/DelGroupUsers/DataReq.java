package protobuf.DelGroupUsers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes15.dex */
public final class DataReq extends Message {
    public static final Long DEFAULT_GROUPID = 0L;
    public static final String DEFAULT_USERIDS = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userIds;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.userIds == null) {
                this.userIds = "";
                return;
            } else {
                this.userIds = builder.userIds;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.userIds = builder.userIds;
    }

    /* loaded from: classes15.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long groupId;
        public String userIds;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.userIds = dataReq.userIds;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
