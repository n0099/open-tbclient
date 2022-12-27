package protobuf.CommitInviteMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long recordId;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_RECORDID = 0L;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Long groupId;
        public Long msgId;
        public Long recordId;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.msgId = dataRes.msgId;
            this.groupId = dataRes.groupId;
            this.recordId = dataRes.recordId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }

    public DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.msgId;
            if (l == null) {
                this.msgId = DEFAULT_MSGID;
            } else {
                this.msgId = l;
            }
            Long l2 = builder.groupId;
            if (l2 == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l2;
            }
            Long l3 = builder.recordId;
            if (l3 == null) {
                this.recordId = DEFAULT_RECORDID;
                return;
            } else {
                this.recordId = l3;
                return;
            }
        }
        this.msgId = builder.msgId;
        this.groupId = builder.groupId;
        this.recordId = builder.recordId;
    }
}
