package protobuf.ForumOwnerManageLivegroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final Integer DEFAULT_FORUMID = 0;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.forumId == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = builder.forumId;
            }
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
                return;
            } else {
                this.type = builder.type;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.groupId = builder.groupId;
        this.type = builder.type;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer forumId;
        public Integer groupId;
        public Integer type;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.forumId = dataReq.forumId;
                this.groupId = dataReq.groupId;
                this.type = dataReq.type;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
