package protobuf.UpdateForumMask;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean flag;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Boolean DEFAULT_FLAG = Boolean.FALSE;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Boolean flag;
        public Integer type;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.type = dataReq.type;
            this.flag = dataReq.flag;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }

    public DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.type;
            if (num == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num;
            }
            Boolean bool = builder.flag;
            if (bool == null) {
                this.flag = DEFAULT_FLAG;
                return;
            } else {
                this.flag = bool;
                return;
            }
        }
        this.type = builder.type;
        this.flag = builder.flag;
    }
}
