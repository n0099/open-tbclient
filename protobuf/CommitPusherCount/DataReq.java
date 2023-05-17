package protobuf.CommitPusherCount;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long downFlowSize;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long enterForeCount;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long pusherCount;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long upFlowSize;
    public static final Long DEFAULT_PUSHERCOUNT = 0L;
    public static final Long DEFAULT_UPFLOWSIZE = 0L;
    public static final Long DEFAULT_DOWNFLOWSIZE = 0L;
    public static final Long DEFAULT_ENTERFORECOUNT = 0L;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long downFlowSize;
        public Long enterForeCount;
        public Long pusherCount;
        public Long upFlowSize;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.pusherCount = dataReq.pusherCount;
            this.upFlowSize = dataReq.upFlowSize;
            this.downFlowSize = dataReq.downFlowSize;
            this.enterForeCount = dataReq.enterForeCount;
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
            Long l = builder.pusherCount;
            if (l == null) {
                this.pusherCount = DEFAULT_PUSHERCOUNT;
            } else {
                this.pusherCount = l;
            }
            Long l2 = builder.upFlowSize;
            if (l2 == null) {
                this.upFlowSize = DEFAULT_UPFLOWSIZE;
            } else {
                this.upFlowSize = l2;
            }
            Long l3 = builder.downFlowSize;
            if (l3 == null) {
                this.downFlowSize = DEFAULT_DOWNFLOWSIZE;
            } else {
                this.downFlowSize = l3;
            }
            Long l4 = builder.enterForeCount;
            if (l4 == null) {
                this.enterForeCount = DEFAULT_ENTERFORECOUNT;
                return;
            } else {
                this.enterForeCount = l4;
                return;
            }
        }
        this.pusherCount = builder.pusherCount;
        this.upFlowSize = builder.upFlowSize;
        this.downFlowSize = builder.downFlowSize;
        this.enterForeCount = builder.enterForeCount;
    }
}
