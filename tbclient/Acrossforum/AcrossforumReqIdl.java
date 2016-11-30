package tbclient.Acrossforum;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class AcrossforumReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ AcrossforumReqIdl(Builder builder, boolean z, AcrossforumReqIdl acrossforumReqIdl) {
        this(builder, z);
    }

    private AcrossforumReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<AcrossforumReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(AcrossforumReqIdl acrossforumReqIdl) {
            super(acrossforumReqIdl);
            if (acrossforumReqIdl != null) {
                this.data = acrossforumReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AcrossforumReqIdl build(boolean z) {
            return new AcrossforumReqIdl(this, z, null);
        }
    }
}
