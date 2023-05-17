package protobuf.PullPcMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class GroupTypes extends Message {
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_GROUPTYPE = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer groupType;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<GroupTypes> {
        public Long groupId;
        public Integer groupType;

        public Builder() {
        }

        public Builder(GroupTypes groupTypes) {
            super(groupTypes);
            if (groupTypes == null) {
                return;
            }
            this.groupId = groupTypes.groupId;
            this.groupType = groupTypes.groupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupTypes build(boolean z) {
            return new GroupTypes(this, z);
        }
    }

    public GroupTypes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            Integer num = builder.groupType;
            if (num == null) {
                this.groupType = DEFAULT_GROUPTYPE;
                return;
            } else {
                this.groupType = num;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.groupType = builder.groupType;
    }
}
