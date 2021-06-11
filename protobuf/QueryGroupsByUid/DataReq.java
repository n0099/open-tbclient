package protobuf.QueryGroupsByUid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long friendId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer isGuest;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer width;
    public static final Integer DEFAULT_WIDTH = 0;
    public static final Integer DEFAULT_HEIGHT = 0;
    public static final Long DEFAULT_FRIENDID = 0L;
    public static final Integer DEFAULT_ISGUEST = 0;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long friendId;
        public Integer height;
        public Integer isGuest;
        public Integer width;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.width = dataReq.width;
            this.height = dataReq.height;
            this.friendId = dataReq.friendId;
            this.isGuest = dataReq.isGuest;
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
            Integer num = builder.width;
            if (num == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = num;
            }
            Integer num2 = builder.height;
            if (num2 == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = num2;
            }
            Long l = builder.friendId;
            if (l == null) {
                this.friendId = DEFAULT_FRIENDID;
            } else {
                this.friendId = l;
            }
            Integer num3 = builder.isGuest;
            if (num3 == null) {
                this.isGuest = DEFAULT_ISGUEST;
                return;
            } else {
                this.isGuest = num3;
                return;
            }
        }
        this.width = builder.width;
        this.height = builder.height;
        this.friendId = builder.friendId;
        this.isGuest = builder.isGuest;
    }
}
