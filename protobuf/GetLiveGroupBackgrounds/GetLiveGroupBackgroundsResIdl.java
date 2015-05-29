package protobuf.GetLiveGroupBackgrounds;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class GetLiveGroupBackgroundsResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ GetLiveGroupBackgroundsResIdl(Builder builder, boolean z, GetLiveGroupBackgroundsResIdl getLiveGroupBackgroundsResIdl) {
        this(builder, z);
    }

    private GetLiveGroupBackgroundsResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GetLiveGroupBackgroundsResIdl> {
        public DataRes data;
        public Error error;

        public Builder(GetLiveGroupBackgroundsResIdl getLiveGroupBackgroundsResIdl) {
            super(getLiveGroupBackgroundsResIdl);
            if (getLiveGroupBackgroundsResIdl != null) {
                this.error = getLiveGroupBackgroundsResIdl.error;
                this.data = getLiveGroupBackgroundsResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetLiveGroupBackgroundsResIdl build(boolean z) {
            return new GetLiveGroupBackgroundsResIdl(this, z, null);
        }
    }
}
