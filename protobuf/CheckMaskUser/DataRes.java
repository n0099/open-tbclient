package protobuf.CheckMaskUser;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class DataRes extends Message {
    public static final Integer DEFAULT_ISMASK = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer isMask;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer isMask;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.isMask = dataRes.isMask;
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
            Integer num = builder.isMask;
            if (num == null) {
                this.isMask = DEFAULT_ISMASK;
                return;
            } else {
                this.isMask = num;
                return;
            }
        }
        this.isMask = builder.isMask;
    }
}
