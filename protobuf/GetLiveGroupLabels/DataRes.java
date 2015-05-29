package protobuf.GetLiveGroupLabels;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.LiveGroupLabel;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer hasMore;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<LiveGroupLabel> labels;
    public static final List<LiveGroupLabel> DEFAULT_LABELS = Collections.emptyList();
    public static final Integer DEFAULT_HASMORE = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.labels == null) {
                this.labels = DEFAULT_LABELS;
            } else {
                this.labels = immutableCopyOf(builder.labels);
            }
            if (builder.hasMore == null) {
                this.hasMore = DEFAULT_HASMORE;
                return;
            } else {
                this.hasMore = builder.hasMore;
                return;
            }
        }
        this.labels = immutableCopyOf(builder.labels);
        this.hasMore = builder.hasMore;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public Integer hasMore;
        public List<LiveGroupLabel> labels;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.labels = DataRes.copyOf(dataRes.labels);
                this.hasMore = dataRes.hasMore;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
