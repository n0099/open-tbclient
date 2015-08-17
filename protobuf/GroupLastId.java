package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GroupLastId extends Message {
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Long DEFAULT_LASTMSGID = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long lastMsgId;

    /* synthetic */ GroupLastId(Builder builder, boolean z, GroupLastId groupLastId) {
        this(builder, z);
    }

    private GroupLastId(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.lastMsgId == null) {
                this.lastMsgId = DEFAULT_LASTMSGID;
                return;
            } else {
                this.lastMsgId = builder.lastMsgId;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.lastMsgId = builder.lastMsgId;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<GroupLastId> {
        public Integer groupId;
        public Long lastMsgId;

        public Builder() {
        }

        public Builder(GroupLastId groupLastId) {
            super(groupLastId);
            if (groupLastId != null) {
                this.groupId = groupLastId.groupId;
                this.lastMsgId = groupLastId.lastMsgId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupLastId build(boolean z) {
            return new GroupLastId(this, z, null);
        }
    }
}
