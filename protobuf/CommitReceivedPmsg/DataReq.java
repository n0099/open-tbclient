package protobuf.CommitReceivedPmsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_ST_TYPE = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer msgType;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String st_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long toUid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer toUserType;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Long DEFAULT_TOUID = 0L;
    public static final Integer DEFAULT_MSGTYPE = 0;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Integer DEFAULT_TOUSERTYPE = 0;

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
            } else {
                this.toUserType = builder.toUserType;
            }
            if (builder.st_type == null) {
                this.st_type = "";
                return;
            } else {
                this.st_type = builder.st_type;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.toUid = builder.toUid;
        this.msgType = builder.msgType;
        this.msgId = builder.msgId;
        this.toUserType = builder.toUserType;
        this.st_type = builder.st_type;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer groupId;
        public Long msgId;
        public Integer msgType;
        public String st_type;
        public Long toUid;
        public Integer toUserType;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.toUid = dataReq.toUid;
                this.msgType = dataReq.msgType;
                this.msgId = dataReq.msgId;
                this.toUserType = dataReq.toUserType;
                this.st_type = dataReq.st_type;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
