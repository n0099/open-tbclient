package protobuf.LivegroupOwnerGag;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 1)
    public final LiveGroupInfo group;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.group = builder.group;
        } else {
            this.group = builder.group;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public LiveGroupInfo group;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.group = dataRes.group;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
