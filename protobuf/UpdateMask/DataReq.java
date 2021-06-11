package protobuf.UpdateMask;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_GIDS = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String gids;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer isAdd;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer maskRemind;
    public static final Integer DEFAULT_MASKREMIND = 0;
    public static final Integer DEFAULT_ISADD = 0;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String gids;
        public Integer isAdd;
        public Integer maskRemind;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.maskRemind = dataReq.maskRemind;
            this.gids = dataReq.gids;
            this.isAdd = dataReq.isAdd;
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
            Integer num = builder.maskRemind;
            if (num == null) {
                this.maskRemind = DEFAULT_MASKREMIND;
            } else {
                this.maskRemind = num;
            }
            String str = builder.gids;
            if (str == null) {
                this.gids = "";
            } else {
                this.gids = str;
            }
            Integer num2 = builder.isAdd;
            if (num2 == null) {
                this.isAdd = DEFAULT_ISADD;
                return;
            } else {
                this.isAdd = num2;
                return;
            }
        }
        this.maskRemind = builder.maskRemind;
        this.gids = builder.gids;
        this.isAdd = builder.isAdd;
    }
}
