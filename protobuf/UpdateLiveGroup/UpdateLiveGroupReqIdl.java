package protobuf.UpdateLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class UpdateLiveGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ UpdateLiveGroupReqIdl(Builder builder, boolean z, UpdateLiveGroupReqIdl updateLiveGroupReqIdl) {
        this(builder, z);
    }

    private UpdateLiveGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<UpdateLiveGroupReqIdl> {
        public DataReq data;

        public Builder(UpdateLiveGroupReqIdl updateLiveGroupReqIdl) {
            super(updateLiveGroupReqIdl);
            if (updateLiveGroupReqIdl != null) {
                this.data = updateLiveGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateLiveGroupReqIdl build(boolean z) {
            return new UpdateLiveGroupReqIdl(this, z, null);
        }
    }
}
