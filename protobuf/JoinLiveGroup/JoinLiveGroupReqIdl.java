package protobuf.JoinLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class JoinLiveGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ JoinLiveGroupReqIdl(Builder builder, boolean z, JoinLiveGroupReqIdl joinLiveGroupReqIdl) {
        this(builder, z);
    }

    private JoinLiveGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<JoinLiveGroupReqIdl> {
        public DataReq data;

        public Builder(JoinLiveGroupReqIdl joinLiveGroupReqIdl) {
            super(joinLiveGroupReqIdl);
            if (joinLiveGroupReqIdl != null) {
                this.data = joinLiveGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public JoinLiveGroupReqIdl build(boolean z) {
            return new JoinLiveGroupReqIdl(this, z, null);
        }
    }
}
