package protobuf.UpdateMaskInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_LIST = "";
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
                return;
            } else {
                this.g_id = builder.g_id;
                return;
            }
        }
        this.type = builder.type;
        this.isMask = builder.isMask;
        this.list = builder.list;
        this.g_id = builder.g_id;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataReq> {
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
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
