package protobuf.AddGroupUsers;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_USERIDS = "";
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer decision;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long inviteUserId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer joinType;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer sysGroupId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer sysMsgId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userIds;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_SYSMSGID = 0;
    public static final Integer DEFAULT_SYSGROUPID = 0;
    public static final Integer DEFAULT_DECISION = 0;
    public static final Long DEFAULT_INVITEUSERID = 0L;
    public static final Integer DEFAULT_JOINTYPE = 0;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer decision;
        public Long groupId;
        public Long inviteUserId;
        public Integer joinType;
        public Integer sysGroupId;
        public Integer sysMsgId;
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
            this.sysMsgId = dataReq.sysMsgId;
            this.sysGroupId = dataReq.sysGroupId;
            this.decision = dataReq.decision;
            this.inviteUserId = dataReq.inviteUserId;
            this.joinType = dataReq.joinType;
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
            } else {
                this.userIds = str;
            }
            Integer num = builder.sysMsgId;
            if (num == null) {
                this.sysMsgId = DEFAULT_SYSMSGID;
            } else {
                this.sysMsgId = num;
            }
            Integer num2 = builder.sysGroupId;
            if (num2 == null) {
                this.sysGroupId = DEFAULT_SYSGROUPID;
            } else {
                this.sysGroupId = num2;
            }
            Integer num3 = builder.decision;
            if (num3 == null) {
                this.decision = DEFAULT_DECISION;
            } else {
                this.decision = num3;
            }
            Long l2 = builder.inviteUserId;
            if (l2 == null) {
                this.inviteUserId = DEFAULT_INVITEUSERID;
            } else {
                this.inviteUserId = l2;
            }
            Integer num4 = builder.joinType;
            if (num4 == null) {
                this.joinType = DEFAULT_JOINTYPE;
                return;
            } else {
                this.joinType = num4;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.userIds = builder.userIds;
        this.sysMsgId = builder.sysMsgId;
        this.sysGroupId = builder.sysGroupId;
        this.decision = builder.decision;
        this.inviteUserId = builder.inviteUserId;
        this.joinType = builder.joinType;
    }
}
