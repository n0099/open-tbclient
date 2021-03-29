package protobuf.CommitPersonalMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.BlockInfo;
/* loaded from: classes7.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 6)
    public final BlockInfo blockInfo;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long recordId;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long toUid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer toUserType;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_RECORDID = 0L;
    public static final Long DEFAULT_TOUID = 0L;
    public static final Integer DEFAULT_TOUSERTYPE = 0;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public BlockInfo blockInfo;
        public Long groupId;
        public Long msgId;
        public Long recordId;
        public Long toUid;
        public Integer toUserType;

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
            this.toUid = dataRes.toUid;
            this.toUserType = dataRes.toUserType;
            this.blockInfo = dataRes.blockInfo;
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
            } else {
                this.recordId = l3;
            }
            Long l4 = builder.toUid;
            if (l4 == null) {
                this.toUid = DEFAULT_TOUID;
            } else {
                this.toUid = l4;
            }
            Integer num = builder.toUserType;
            if (num == null) {
                this.toUserType = DEFAULT_TOUSERTYPE;
            } else {
                this.toUserType = num;
            }
            this.blockInfo = builder.blockInfo;
            return;
        }
        this.msgId = builder.msgId;
        this.groupId = builder.groupId;
        this.recordId = builder.recordId;
        this.toUid = builder.toUid;
        this.toUserType = builder.toUserType;
        this.blockInfo = builder.blockInfo;
    }
}
