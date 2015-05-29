package protobuf.GetLiveGroupLabels;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class GetLiveGroupLabelsResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ GetLiveGroupLabelsResIdl(Builder builder, boolean z, GetLiveGroupLabelsResIdl getLiveGroupLabelsResIdl) {
        this(builder, z);
    }

    private GetLiveGroupLabelsResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<GetLiveGroupLabelsResIdl> {
        public DataRes data;
        public Error error;

        public Builder(GetLiveGroupLabelsResIdl getLiveGroupLabelsResIdl) {
            super(getLiveGroupLabelsResIdl);
            if (getLiveGroupLabelsResIdl != null) {
                this.error = getLiveGroupLabelsResIdl.error;
                this.data = getLiveGroupLabelsResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetLiveGroupLabelsResIdl build(boolean z) {
            return new GetLiveGroupLabelsResIdl(this, z, null);
        }
    }
}
