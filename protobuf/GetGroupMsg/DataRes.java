package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer allowEggs;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<GroupMsg> groupMsg;
    public static final List<GroupMsg> DEFAULT_GROUPMSG = Collections.emptyList();
    public static final Integer DEFAULT_ALLOWEGGS = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupMsg == null) {
                this.groupMsg = DEFAULT_GROUPMSG;
            } else {
                this.groupMsg = immutableCopyOf(builder.groupMsg);
            }
            if (builder.allowEggs == null) {
                this.allowEggs = DEFAULT_ALLOWEGGS;
                return;
            } else {
                this.allowEggs = builder.allowEggs;
                return;
            }
        }
        this.groupMsg = immutableCopyOf(builder.groupMsg);
        this.allowEggs = builder.allowEggs;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer allowEggs;
        public List<GroupMsg> groupMsg;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groupMsg = DataRes.copyOf(dataRes.groupMsg);
                this.allowEggs = dataRes.allowEggs;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
