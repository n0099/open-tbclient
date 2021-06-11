package protobuf.DelGroupUsers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class DataReq extends Message {
    public static final Long DEFAULT_GROUPID = 0L;
    public static final String DEFAULT_USERIDS = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userIds;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long groupId;
        public String userIds;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.groupId = dataReq.groupId;
            this.userIds = dataReq.userIds;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }

    public DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            String str = builder.userIds;
            if (str == null) {
                this.userIds = "";
                return;
            } else {
                this.userIds = str;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.userIds = builder.userIds;
    }
}
