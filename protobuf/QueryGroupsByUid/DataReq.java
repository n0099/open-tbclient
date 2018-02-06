package protobuf.QueryGroupsByUid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes3.dex */
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

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.width == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = builder.width;
            }
            if (builder.height == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = builder.height;
            }
            if (builder.friendId == null) {
                this.friendId = DEFAULT_FRIENDID;
            } else {
                this.friendId = builder.friendId;
            }
            if (builder.isGuest == null) {
                this.isGuest = DEFAULT_ISGUEST;
                return;
            } else {
                this.isGuest = builder.isGuest;
                return;
            }
        }
        this.width = builder.width;
        this.height = builder.height;
        this.friendId = builder.friendId;
        this.isGuest = builder.isGuest;
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long friendId;
        public Integer height;
        public Integer isGuest;
        public Integer width;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.width = dataReq.width;
                this.height = dataReq.height;
                this.friendId = dataReq.friendId;
                this.isGuest = dataReq.isGuest;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
