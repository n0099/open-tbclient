package protobuf.GetLiveGroupBackgrounds;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GetLiveGroupBackgroundsReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ GetLiveGroupBackgroundsReqIdl(Builder builder, boolean z, GetLiveGroupBackgroundsReqIdl getLiveGroupBackgroundsReqIdl) {
        this(builder, z);
    }

    private GetLiveGroupBackgroundsReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GetLiveGroupBackgroundsReqIdl> {
        public DataReq data;

        public Builder(GetLiveGroupBackgroundsReqIdl getLiveGroupBackgroundsReqIdl) {
            super(getLiveGroupBackgroundsReqIdl);
            if (getLiveGroupBackgroundsReqIdl != null) {
                this.data = getLiveGroupBackgroundsReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetLiveGroupBackgroundsReqIdl build(boolean z) {
            return new GetLiveGroupBackgroundsReqIdl(this, z, null);
        }
    }
}
