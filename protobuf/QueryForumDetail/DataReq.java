package protobuf.QueryForumDetail;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class DataReq extends Message {
    public static final Integer DEFAULT_FORUMID = 0;
    public static final String DEFAULT_FORUMNAME = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String forumName;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer forumId;
        public String forumName;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.forumId = dataReq.forumId;
            this.forumName = dataReq.forumName;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }

    public DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.forumId;
            if (num == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = num;
            }
            String str = builder.forumName;
            if (str == null) {
                this.forumName = "";
                return;
            } else {
                this.forumName = str;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.forumName = builder.forumName;
    }
}
