package protobuf.QueryHotLiveGroups;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer rn;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_RN = 0;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = builder.type;
            }
            if (builder.offset == null) {
                this.offset = DEFAULT_OFFSET;
            } else {
                this.offset = builder.offset;
            }
            if (builder.rn == null) {
                this.rn = DEFAULT_RN;
                return;
            } else {
                this.rn = builder.rn;
                return;
            }
        }
        this.type = builder.type;
        this.offset = builder.offset;
        this.rn = builder.rn;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer offset;
        public Integer rn;
        public Integer type;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.type = dataReq.type;
                this.offset = dataReq.offset;
                this.rn = dataReq.rn;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
