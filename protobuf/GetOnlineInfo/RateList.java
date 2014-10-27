package protobuf.GetOnlineInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class RateList extends Message {
    public static final List<Integer> DEFAULT_RATE = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.UINT32)
    public final List<Integer> rate;

    /* synthetic */ RateList(Builder builder, boolean z, RateList rateList) {
        this(builder, z);
    }

    private RateList(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.rate == null) {
                this.rate = DEFAULT_RATE;
                return;
            } else {
                this.rate = immutableCopyOf(builder.rate);
                return;
            }
        }
        this.rate = immutableCopyOf(builder.rate);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<RateList> {
        public List<Integer> rate;

        public Builder(RateList rateList) {
            super(rateList);
            if (rateList != null) {
                this.rate = RateList.copyOf(rateList.rate);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public RateList build(boolean z) {
            return new RateList(this, z, null);
        }
    }
}
