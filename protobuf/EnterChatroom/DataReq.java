package protobuf.EnterChatroom;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final Integer DEFAULT_LASTGROUPID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer lastGroupId;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.lastGroupId == null) {
                this.lastGroupId = DEFAULT_LASTGROUPID;
                return;
            } else {
                this.lastGroupId = builder.lastGroupId;
                return;
            }
        }
        this.lastGroupId = builder.lastGroupId;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer lastGroupId;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.lastGroupId = dataReq.lastGroupId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
