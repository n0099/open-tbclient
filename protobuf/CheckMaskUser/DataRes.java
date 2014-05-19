package protobuf.CheckMaskUser;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final Integer DEFAULT_ISMASK = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer isMask;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.isMask == null) {
                this.isMask = DEFAULT_ISMASK;
                return;
            } else {
                this.isMask = builder.isMask;
                return;
            }
        }
        this.isMask = builder.isMask;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public Integer isMask;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.isMask = dataRes.isMask;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
