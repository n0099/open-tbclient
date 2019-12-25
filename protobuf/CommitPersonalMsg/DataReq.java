package protobuf.CommitPersonalMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes6.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_ST_TYPE = "";
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer duration;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer msgType;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long recordId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String st_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long toUid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer toUserType;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_TOUID = 0L;
    public static final Integer DEFAULT_MSGTYPE = 0;
    public static final Integer DEFAULT_DURATION = 0;
    public static final Long DEFAULT_RECORDID = 0L;
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
            if (builder.content == null) {
                this.content = "";
            } else {
                this.content = builder.content;
            }
            if (builder.duration == null) {
                this.duration = DEFAULT_DURATION;
            } else {
                this.duration = builder.duration;
            }
            if (builder.recordId == null) {
                this.recordId = DEFAULT_RECORDID;
            } else {
                this.recordId = builder.recordId;
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
        this.content = builder.content;
        this.duration = builder.duration;
        this.recordId = builder.recordId;
        this.toUserType = builder.toUserType;
        this.st_type = builder.st_type;
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String content;
        public Integer duration;
        public Long groupId;
        public Integer msgType;
        public Long recordId;
        public String st_type;
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
                this.content = dataReq.content;
                this.duration = dataReq.duration;
                this.recordId = dataReq.recordId;
                this.toUserType = dataReq.toUserType;
                this.st_type = dataReq.st_type;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
