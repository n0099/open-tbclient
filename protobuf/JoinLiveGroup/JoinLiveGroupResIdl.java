package protobuf.JoinLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class JoinLiveGroupResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ JoinLiveGroupResIdl(Builder builder, boolean z, JoinLiveGroupResIdl joinLiveGroupResIdl) {
        this(builder, z);
    }

    private JoinLiveGroupResIdl(Builder builder, boolean z) {
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
    public final class Builder extends Message.Builder<JoinLiveGroupResIdl> {
        public DataRes data;
        public Error error;

        public Builder(JoinLiveGroupResIdl joinLiveGroupResIdl) {
            super(joinLiveGroupResIdl);
            if (joinLiveGroupResIdl != null) {
                this.error = joinLiveGroupResIdl.error;
                this.data = joinLiveGroupResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public JoinLiveGroupResIdl build(boolean z) {
            return new JoinLiveGroupResIdl(this, z, null);
        }
    }
}
