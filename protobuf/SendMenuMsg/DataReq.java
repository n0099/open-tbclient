package protobuf.SendMenuMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_FORUM_ID = "";
    public static final Integer DEFAULT_RID = 0;
    public static final Integer DEFAULT_USER_ID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String forum_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer user_id;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.rid == null) {
                this.rid = DEFAULT_RID;
            } else {
                this.rid = builder.rid;
            }
            if (builder.user_id == null) {
                this.user_id = DEFAULT_USER_ID;
            } else {
                this.user_id = builder.user_id;
            }
            if (builder.forum_id == null) {
                this.forum_id = "";
                return;
            } else {
                this.forum_id = builder.forum_id;
                return;
            }
        }
        this.rid = builder.rid;
        this.user_id = builder.user_id;
        this.forum_id = builder.forum_id;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public String forum_id;
        public Integer rid;
        public Integer user_id;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.rid = dataReq.rid;
                this.user_id = dataReq.user_id;
                this.forum_id = dataReq.forum_id;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
