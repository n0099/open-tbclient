package protobuf.AddGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.GroupInfo;
/* loaded from: classes8.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 1)
    public final GroupInfo group;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public GroupInfo group;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.group = dataRes.group;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }

    public DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.group = builder.group;
        } else {
            this.group = builder.group;
        }
    }
}
