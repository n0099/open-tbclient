package protobuf.GetLiveGroupLabels;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_RN = 0;
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer rn;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

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
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
                return;
            } else {
                this.type = builder.type;
                return;
            }
        }
        this.offset = builder.offset;
        this.rn = builder.rn;
        this.type = builder.type;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer offset;
        public Integer rn;
        public Integer type;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.offset = dataReq.offset;
                this.rn = dataReq.rn;
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
