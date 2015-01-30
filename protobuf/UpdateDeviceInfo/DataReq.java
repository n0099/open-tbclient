package protobuf.UpdateDeviceInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_CUID = "";
    public static final String DEFAULT_DEVICE = "";
    public static final String DEFAULT_UID = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cuid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String device;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String uid;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.device == null) {
                this.device = "";
            } else {
                this.device = builder.device;
            }
            if (builder.cuid == null) {
                this.cuid = "";
            } else {
                this.cuid = builder.cuid;
            }
            if (builder.uid == null) {
                this.uid = "";
                return;
            } else {
                this.uid = builder.uid;
                return;
            }
        }
        this.device = builder.device;
        this.cuid = builder.cuid;
        this.uid = builder.uid;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public String cuid;
        public String device;
        public String uid;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.device = dataReq.device;
                this.cuid = dataReq.cuid;
                this.uid = dataReq.uid;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
