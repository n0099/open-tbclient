package protobuf.UpdateDeviceInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class UpdateDeviceInfoReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ UpdateDeviceInfoReqIdl(Builder builder, boolean z, UpdateDeviceInfoReqIdl updateDeviceInfoReqIdl) {
        this(builder, z);
    }

    private UpdateDeviceInfoReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<UpdateDeviceInfoReqIdl> {
        public DataReq data;

        public Builder(UpdateDeviceInfoReqIdl updateDeviceInfoReqIdl) {
            super(updateDeviceInfoReqIdl);
            if (updateDeviceInfoReqIdl != null) {
                this.data = updateDeviceInfoReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateDeviceInfoReqIdl build(boolean z) {
            return new UpdateDeviceInfoReqIdl(this, z, null);
        }
    }
}
