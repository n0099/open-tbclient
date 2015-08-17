package protobuf.AddLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class AddLiveGroupResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ AddLiveGroupResIdl(Builder builder, boolean z, AddLiveGroupResIdl addLiveGroupResIdl) {
        this(builder, z);
    }

    private AddLiveGroupResIdl(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<AddLiveGroupResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(AddLiveGroupResIdl addLiveGroupResIdl) {
            super(addLiveGroupResIdl);
            if (addLiveGroupResIdl != null) {
                this.error = addLiveGroupResIdl.error;
                this.data = addLiveGroupResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AddLiveGroupResIdl build(boolean z) {
            return new AddLiveGroupResIdl(this, z, null);
        }
    }
}
