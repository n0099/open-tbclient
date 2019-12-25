package protobuf.CommitReceivedPmsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes6.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long readMsgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long toUid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer toUserType;
    public static final Long DEFAULT_READMSGID = 0L;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_TOUID = 0L;
    public static final Integer DEFAULT_TOUSERTYPE = 0;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.readMsgId == null) {
                this.readMsgId = DEFAULT_READMSGID;
            } else {
                this.readMsgId = builder.readMsgId;
            }
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
            if (builder.toUserType == null) {
                this.toUserType = DEFAULT_TOUSERTYPE;
                return;
            } else {
                this.toUserType = builder.toUserType;
                return;
            }
        }
        this.readMsgId = builder.readMsgId;
        this.groupId = builder.groupId;
        this.toUid = builder.toUid;
        this.toUserType = builder.toUserType;
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Long groupId;
        public Long readMsgId;
        public Long toUid;
        public Integer toUserType;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.readMsgId = dataRes.readMsgId;
                this.groupId = dataRes.groupId;
                this.toUid = dataRes.toUid;
                this.toUserType = dataRes.toUserType;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
