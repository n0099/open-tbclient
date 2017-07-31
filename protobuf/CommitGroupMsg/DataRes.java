package protobuf.CommitGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long recordId;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Long DEFAULT_RECORDID = 0L;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.msgId == null) {
                this.msgId = DEFAULT_MSGID;
            } else {
                this.msgId = builder.msgId;
            }
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.recordId == null) {
                this.recordId = DEFAULT_RECORDID;
                return;
            } else {
                this.recordId = builder.recordId;
                return;
            }
        }
        this.msgId = builder.msgId;
        this.groupId = builder.groupId;
        this.recordId = builder.recordId;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer groupId;
        public Long msgId;
        public Long recordId;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.msgId = dataRes.msgId;
                this.groupId = dataRes.groupId;
                this.recordId = dataRes.recordId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
