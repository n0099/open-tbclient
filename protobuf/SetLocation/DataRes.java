package protobuf.SetLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 1)
    public final LbsInfo location;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public LbsInfo location;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.location = dataRes.location;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }

    public DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.location = builder.location;
        } else {
            this.location = builder.location;
        }
    }
}
