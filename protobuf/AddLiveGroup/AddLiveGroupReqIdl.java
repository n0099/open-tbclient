package protobuf.AddLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class AddLiveGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ AddLiveGroupReqIdl(Builder builder, boolean z, AddLiveGroupReqIdl addLiveGroupReqIdl) {
        this(builder, z);
    }

    private AddLiveGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<AddLiveGroupReqIdl> {
        public DataReq data;

        public Builder(AddLiveGroupReqIdl addLiveGroupReqIdl) {
            super(addLiveGroupReqIdl);
            if (addLiveGroupReqIdl != null) {
                this.data = addLiveGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AddLiveGroupReqIdl build(boolean z) {
            return new AddLiveGroupReqIdl(this, z, null);
        }
    }
}
