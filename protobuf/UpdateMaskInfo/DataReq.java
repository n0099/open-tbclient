package protobuf.UpdateMaskInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_LIST = "";
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer isMask;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String list;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer type;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_ISMASK = 0;

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
            if (builder.isMask == null) {
                this.isMask = DEFAULT_ISMASK;
            } else {
                this.isMask = builder.isMask;
            }
            if (builder.list == null) {
                this.list = "";
                return;
            } else {
                this.list = builder.list;
                return;
            }
        }
        this.type = builder.type;
        this.isMask = builder.isMask;
        this.list = builder.list;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer isMask;
        public String list;
        public Integer type;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.type = dataReq.type;
                this.isMask = dataReq.isMask;
                this.list = dataReq.list;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
