package protobuf.CommitReceivedPmsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
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

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.toUid == null) {
                this.toUid = DEFAULT_TOUID;
            } else {
                this.toUid = builder.toUid;
            }
            if (builder.msgType == null) {
                this.msgType = DEFAULT_MSGTYPE;
            } else {
                this.msgType = builder.msgType;
            }
            if (builder.msgId == null) {
                this.msgId = DEFAULT_MSGID;
            } else {
                this.msgId = builder.msgId;
            }
            if (builder.toUserType == null) {
                this.toUserType = DEFAULT_TOUSERTYPE;
                return;
            } else {
                this.toUserType = builder.toUserType;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.toUid = builder.toUid;
        this.msgType = builder.msgType;
        this.msgId = builder.msgId;
        this.toUserType = builder.toUserType;
    }

    /* loaded from: classes22.dex */
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
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.toUid = dataReq.toUid;
                this.msgType = dataReq.msgType;
                this.msgId = dataReq.msgId;
                this.toUserType = dataReq.toUserType;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
