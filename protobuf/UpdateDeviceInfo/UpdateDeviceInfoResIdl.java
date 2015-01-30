package protobuf.UpdateDeviceInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class UpdateDeviceInfoResIdl extends Message {
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ UpdateDeviceInfoResIdl(Builder builder, boolean z, UpdateDeviceInfoResIdl updateDeviceInfoResIdl) {
        this(builder, z);
    }

    private UpdateDeviceInfoResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
        } else {
            this.error = builder.error;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<UpdateDeviceInfoResIdl> {
        public Error error;

        public Builder(UpdateDeviceInfoResIdl updateDeviceInfoResIdl) {
            super(updateDeviceInfoResIdl);
            if (updateDeviceInfoResIdl != null) {
                this.error = updateDeviceInfoResIdl.error;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateDeviceInfoResIdl build(boolean z) {
            return new UpdateDeviceInfoResIdl(this, z, null);
        }
    }
}
