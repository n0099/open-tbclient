package protobuf.LivegroupOwnerGag;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class LivegroupOwnerGagResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ LivegroupOwnerGagResIdl(Builder builder, boolean z, LivegroupOwnerGagResIdl livegroupOwnerGagResIdl) {
        this(builder, z);
    }

    private LivegroupOwnerGagResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<LivegroupOwnerGagResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(LivegroupOwnerGagResIdl livegroupOwnerGagResIdl) {
            super(livegroupOwnerGagResIdl);
            if (livegroupOwnerGagResIdl != null) {
                this.error = livegroupOwnerGagResIdl.error;
                this.data = livegroupOwnerGagResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LivegroupOwnerGagResIdl build(boolean z) {
            return new LivegroupOwnerGagResIdl(this, z, null);
        }
    }
}
