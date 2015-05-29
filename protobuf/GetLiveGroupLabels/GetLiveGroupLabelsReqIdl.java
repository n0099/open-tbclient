package protobuf.GetLiveGroupLabels;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GetLiveGroupLabelsReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ GetLiveGroupLabelsReqIdl(Builder builder, boolean z, GetLiveGroupLabelsReqIdl getLiveGroupLabelsReqIdl) {
        this(builder, z);
    }

    private GetLiveGroupLabelsReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GetLiveGroupLabelsReqIdl> {
        public DataReq data;

        public Builder(GetLiveGroupLabelsReqIdl getLiveGroupLabelsReqIdl) {
            super(getLiveGroupLabelsReqIdl);
            if (getLiveGroupLabelsReqIdl != null) {
                this.data = getLiveGroupLabelsReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetLiveGroupLabelsReqIdl build(boolean z) {
            return new GetLiveGroupLabelsReqIdl(this, z, null);
        }
    }
}
