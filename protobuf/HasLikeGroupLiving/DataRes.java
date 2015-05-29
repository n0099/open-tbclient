package protobuf.HasLikeGroupLiving;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> groupIds;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer hasLiving;
    public static final Integer DEFAULT_HASLIVING = 0;
    public static final List<Integer> DEFAULT_GROUPIDS = Collections.emptyList();

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.hasLiving == null) {
                this.hasLiving = DEFAULT_HASLIVING;
            } else {
                this.hasLiving = builder.hasLiving;
            }
            if (builder.groupIds == null) {
                this.groupIds = DEFAULT_GROUPIDS;
                return;
            } else {
                this.groupIds = immutableCopyOf(builder.groupIds);
                return;
            }
        }
        this.hasLiving = builder.hasLiving;
        this.groupIds = immutableCopyOf(builder.groupIds);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public List<Integer> groupIds;
        public Integer hasLiving;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.hasLiving = dataRes.hasLiving;
                this.groupIds = DataRes.copyOf(dataRes.groupIds);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
