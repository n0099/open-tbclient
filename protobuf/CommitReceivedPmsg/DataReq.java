package protobuf.CommitReceivedPmsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer msgType;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long toUid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer toUserType;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_TOUID = 0L;
    public static final Integer DEFAULT_MSGTYPE = 0;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Integer DEFAULT_TOUSERTYPE = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long groupId;
        public Long msgId;
        public Integer msgType;
        public Long toUid;
        public Integer toUserType;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.groupId = dataReq.groupId;
            this.toUid = dataReq.toUid;
            this.msgType = dataReq.msgType;
            this.msgId = dataReq.msgId;
            this.toUserType = dataReq.toUserType;
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
            Long l2 = builder.toUid;
            if (l2 == null) {
                this.toUid = DEFAULT_TOUID;
            } else {
                this.toUid = l2;
            }
            Integer num = builder.msgType;
            if (num == null) {
                this.msgType = DEFAULT_MSGTYPE;
            } else {
                this.msgType = num;
            }
            Long l3 = builder.msgId;
            if (l3 == null) {
                this.msgId = DEFAULT_MSGID;
            } else {
                this.msgId = l3;
            }
            Integer num2 = builder.toUserType;
            if (num2 == null) {
                this.toUserType = DEFAULT_TOUSERTYPE;
                return;
            } else {
                this.toUserType = num2;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.toUid = builder.toUid;
        this.msgType = builder.msgType;
        this.msgId = builder.msgId;
        this.toUserType = builder.toUserType;
    }
}
