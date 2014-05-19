package protobuf.QueryHotGroups;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer rn;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer width;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_RN = 0;
    public static final Integer DEFAULT_HEIGHT = 0;
    public static final Integer DEFAULT_WIDTH = 0;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.offset == null) {
                this.offset = DEFAULT_OFFSET;
            } else {
                this.offset = builder.offset;
            }
            if (builder.rn == null) {
                this.rn = DEFAULT_RN;
            } else {
                this.rn = builder.rn;
            }
            if (builder.height == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = builder.height;
            }
            if (builder.width == null) {
                this.width = DEFAULT_WIDTH;
                return;
            } else {
                this.width = builder.width;
                return;
            }
        }
        this.offset = builder.offset;
        this.rn = builder.rn;
        this.height = builder.height;
        this.width = builder.width;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer height;
        public Integer offset;
        public Integer rn;
        public Integer width;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.offset = dataReq.offset;
                this.rn = dataReq.rn;
                this.height = dataReq.height;
                this.width = dataReq.width;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
