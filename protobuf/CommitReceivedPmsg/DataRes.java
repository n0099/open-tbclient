package protobuf.CommitReceivedPmsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
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

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Long groupId;
        public Long readMsgId;
        public Long toUid;
        public Integer toUserType;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.readMsgId = dataRes.readMsgId;
            this.groupId = dataRes.groupId;
            this.toUid = dataRes.toUid;
            this.toUserType = dataRes.toUserType;
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
            Long l = builder.readMsgId;
            if (l == null) {
                this.readMsgId = DEFAULT_READMSGID;
            } else {
                this.readMsgId = l;
            }
            Long l2 = builder.groupId;
            if (l2 == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l2;
            }
            Long l3 = builder.toUid;
            if (l3 == null) {
                this.toUid = DEFAULT_TOUID;
            } else {
                this.toUid = l3;
            }
            Integer num = builder.toUserType;
            if (num == null) {
                this.toUserType = DEFAULT_TOUSERTYPE;
                return;
            } else {
                this.toUserType = num;
                return;
            }
        }
        this.readMsgId = builder.readMsgId;
        this.groupId = builder.groupId;
        this.toUid = builder.toUid;
        this.toUserType = builder.toUserType;
    }
}
