package protobuf.UpdateMaskInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_LIST = "";
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer call_from;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long g_id;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer isMask;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String list;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer type;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_ISMASK = 0;
    public static final Long DEFAULT_G_ID = 0L;
    public static final Integer DEFAULT_CALL_FROM = 0;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = builder.type;
            }
            if (builder.isMask == null) {
                this.isMask = DEFAULT_ISMASK;
            } else {
                this.isMask = builder.isMask;
            }
            if (builder.list == null) {
                this.list = "";
            } else {
                this.list = builder.list;
            }
            if (builder.g_id == null) {
                this.g_id = DEFAULT_G_ID;
            } else {
                this.g_id = builder.g_id;
            }
            if (builder.call_from == null) {
                this.call_from = DEFAULT_CALL_FROM;
                return;
            } else {
                this.call_from = builder.call_from;
                return;
            }
        }
        this.type = builder.type;
        this.isMask = builder.isMask;
        this.list = builder.list;
        this.g_id = builder.g_id;
        this.call_from = builder.call_from;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer call_from;
        public Long g_id;
        public Integer isMask;
        public String list;
        public Integer type;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.type = dataReq.type;
                this.isMask = dataReq.isMask;
                this.list = dataReq.list;
                this.g_id = dataReq.g_id;
                this.call_from = dataReq.call_from;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
