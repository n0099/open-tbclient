package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<GroupLastId> {
        public List<Long> excludeMid;
        public Long groupId;
        public Long lastMsgId;

        public Builder() {
        }

        public Builder(GroupLastId groupLastId) {
            super(groupLastId);
            if (groupLastId == null) {
                return;
            }
            this.groupId = groupLastId.groupId;
            this.lastMsgId = groupLastId.lastMsgId;
            this.excludeMid = Message.copyOf(groupLastId.excludeMid);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupLastId build(boolean z) {
            return new GroupLastId(this, z);
        }
    }

    public GroupLastId(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            Long l2 = builder.lastMsgId;
            if (l2 == null) {
                this.lastMsgId = DEFAULT_LASTMSGID;
            } else {
                this.lastMsgId = l2;
            }
            List<Long> list = builder.excludeMid;
            if (list == null) {
                this.excludeMid = DEFAULT_EXCLUDEMID;
                return;
            } else {
                this.excludeMid = Message.immutableCopyOf(list);
                return;
            }
        }
        this.groupId = builder.groupId;
        this.lastMsgId = builder.lastMsgId;
        this.excludeMid = Message.immutableCopyOf(builder.excludeMid);
    }
}
