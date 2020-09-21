package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes21.dex */
public final class GroupLastId extends Message {
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> excludeMid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long lastMsgId;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_LASTMSGID = 0L;
    public static final List<Long> DEFAULT_EXCLUDEMID = Collections.emptyList();

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
            } else {
                this.lastMsgId = builder.lastMsgId;
            }
            if (builder.excludeMid == null) {
                this.excludeMid = DEFAULT_EXCLUDEMID;
                return;
            } else {
                this.excludeMid = immutableCopyOf(builder.excludeMid);
                return;
            }
        }
        this.groupId = builder.groupId;
        this.lastMsgId = builder.lastMsgId;
        this.excludeMid = immutableCopyOf(builder.excludeMid);
    }

    /* loaded from: classes21.dex */
    public static final class Builder extends Message.Builder<GroupLastId> {
        public List<Long> excludeMid;
        public Long groupId;
        public Long lastMsgId;

        public Builder() {
        }

        public Builder(GroupLastId groupLastId) {
            super(groupLastId);
            if (groupLastId != null) {
                this.groupId = groupLastId.groupId;
                this.lastMsgId = groupLastId.lastMsgId;
                this.excludeMid = GroupLastId.copyOf(groupLastId.excludeMid);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupLastId build(boolean z) {
            return new GroupLastId(this, z);
        }
    }
}
