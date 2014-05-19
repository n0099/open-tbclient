package protobuf.GetPeerInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final Integer DEFAULT_ISALLOWED = 0;
    public static final String DEFAULT_LBS = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isAllowed;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String lbs;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.isAllowed == null) {
                this.isAllowed = DEFAULT_ISALLOWED;
            } else {
                this.isAllowed = builder.isAllowed;
            }
            if (builder.lbs == null) {
                this.lbs = "";
                return;
            } else {
                this.lbs = builder.lbs;
                return;
            }
        }
        this.isAllowed = builder.isAllowed;
        this.lbs = builder.lbs;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public Integer isAllowed;
        public String lbs;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.isAllowed = dataRes.isAllowed;
                this.lbs = dataRes.lbs;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
