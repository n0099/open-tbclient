package protobuf.GetMaskInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes2.dex */
public final class GetMaskInfoResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<GetMaskInfoResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(GetMaskInfoResIdl getMaskInfoResIdl) {
            super(getMaskInfoResIdl);
            if (getMaskInfoResIdl == null) {
                return;
            }
            this.error = getMaskInfoResIdl.error;
            this.data = getMaskInfoResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetMaskInfoResIdl build(boolean z) {
            return new GetMaskInfoResIdl(this, z);
        }
    }

    public GetMaskInfoResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }
}
