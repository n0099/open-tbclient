package protobuf.CommitInviteMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes4.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_TOUIDS = "";
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
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String toUids;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_MSGTYPE = 0;
    public static final Integer DEFAULT_DURATION = 0;
    public static final Long DEFAULT_RECORDID = 0L;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.toUids == null) {
                this.toUids = "";
            } else {
                this.toUids = builder.toUids;
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
                return;
            } else {
                this.recordId = builder.recordId;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.toUids = builder.toUids;
        this.msgType = builder.msgType;
        this.content = builder.content;
        this.duration = builder.duration;
        this.recordId = builder.recordId;
    }

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String content;
        public Integer duration;
        public Long groupId;
        public Integer msgType;
        public Long recordId;
        public String toUids;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.toUids = dataReq.toUids;
                this.msgType = dataReq.msgType;
                this.content = dataReq.content;
                this.duration = dataReq.duration;
                this.recordId = dataReq.recordId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
