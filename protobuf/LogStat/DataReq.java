package protobuf.LogStat;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_STEXT = "";
    public static final String DEFAULT_STTYPE = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String stExt;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String stType;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.stType == null) {
                this.stType = "";
            } else {
                this.stType = builder.stType;
            }
            if (builder.stExt == null) {
                this.stExt = "";
                return;
            } else {
                this.stExt = builder.stExt;
                return;
            }
        }
        this.stType = builder.stType;
        this.stExt = builder.stExt;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String stExt;
        public String stType;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.stType = dataReq.stType;
                this.stExt = dataReq.stExt;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
