package protobuf.LivegroupOwnerGag;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class LivegroupOwnerGagReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ LivegroupOwnerGagReqIdl(Builder builder, boolean z, LivegroupOwnerGagReqIdl livegroupOwnerGagReqIdl) {
        this(builder, z);
    }

    private LivegroupOwnerGagReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<LivegroupOwnerGagReqIdl> {
        public DataReq data;

        public Builder(LivegroupOwnerGagReqIdl livegroupOwnerGagReqIdl) {
            super(livegroupOwnerGagReqIdl);
            if (livegroupOwnerGagReqIdl != null) {
                this.data = livegroupOwnerGagReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LivegroupOwnerGagReqIdl build(boolean z) {
            return new LivegroupOwnerGagReqIdl(this, z, null);
        }
    }
}
