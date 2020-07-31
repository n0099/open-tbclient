package protobuf.ApplyJoinGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes17.dex */
public final class DataReq extends Message {
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_INVITEUSERID = 0L;
    public static final Integer DEFAULT_JOINTYPE = 0;
    public static final String DEFAULT_USERMSG = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long inviteUserId;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer joinType;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userMsg;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.userMsg == null) {
                this.userMsg = "";
            } else {
                this.userMsg = builder.userMsg;
            }
            if (builder.inviteUserId == null) {
                this.inviteUserId = DEFAULT_INVITEUSERID;
            } else {
                this.inviteUserId = builder.inviteUserId;
            }
            if (builder.joinType == null) {
                this.joinType = DEFAULT_JOINTYPE;
                return;
            } else {
                this.joinType = builder.joinType;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.userMsg = builder.userMsg;
        this.inviteUserId = builder.inviteUserId;
        this.joinType = builder.joinType;
    }

    /* loaded from: classes17.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long groupId;
        public Long inviteUserId;
        public Integer joinType;
        public String userMsg;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.userMsg = dataReq.userMsg;
                this.inviteUserId = dataReq.inviteUserId;
                this.joinType = dataReq.joinType;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
