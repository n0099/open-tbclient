package protobuf.IncrLiveGroupLike;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 1)
    public final LiveGroupInfo group;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer subType;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_SUBTYPE = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.group = builder.group;
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = builder.type;
            }
            if (builder.subType == null) {
                this.subType = DEFAULT_SUBTYPE;
                return;
            } else {
                this.subType = builder.subType;
                return;
            }
        }
        this.group = builder.group;
        this.type = builder.type;
        this.subType = builder.subType;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public LiveGroupInfo group;
        public Integer subType;
        public Integer type;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.group = dataRes.group;
                this.type = dataRes.type;
                this.subType = dataRes.subType;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
