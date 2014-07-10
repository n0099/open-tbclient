package protobuf.LivegroupOwnerGag;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final String DEFAULT_USERIDS = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String userIds;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = builder.type;
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
        this.type = builder.type;
        this.userIds = builder.userIds;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer groupId;
        public Integer type;
        public String userIds;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.type = dataReq.type;
                this.userIds = dataReq.userIds;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
