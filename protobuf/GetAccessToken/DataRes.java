package protobuf.GetAccessToken;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final Integer DEFAULT_EXPIRETIME = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String accessToken;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer expireTime;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.accessToken == null) {
                this.accessToken = "";
            } else {
                this.accessToken = builder.accessToken;
            }
            if (builder.expireTime == null) {
                this.expireTime = DEFAULT_EXPIRETIME;
                return;
            } else {
                this.expireTime = builder.expireTime;
                return;
            }
        }
        this.accessToken = builder.accessToken;
        this.expireTime = builder.expireTime;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public String accessToken;
        public Integer expireTime;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.accessToken = dataRes.accessToken;
                this.expireTime = dataRes.expireTime;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
