package protobuf.GetAccessToken;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_BDUSS = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String bduss;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.bduss == null) {
                this.bduss = "";
                return;
            } else {
                this.bduss = builder.bduss;
                return;
            }
        }
        this.bduss = builder.bduss;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public String bduss;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.bduss = dataReq.bduss;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
