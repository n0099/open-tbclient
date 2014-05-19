package protobuf.GetPeerInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final Long DEFAULT_PEERUID = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long peerUid;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.peerUid == null) {
                this.peerUid = DEFAULT_PEERUID;
                return;
            } else {
                this.peerUid = builder.peerUid;
                return;
            }
        }
        this.peerUid = builder.peerUid;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Long peerUid;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.peerUid = dataReq.peerUid;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
