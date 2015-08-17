package protobuf.QueryLiveGroupHistory;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 1)
    public final LiveGroupInfo group;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer hasMore;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<History> historys;
    public static final List<History> DEFAULT_HISTORYS = Collections.emptyList();
    public static final Integer DEFAULT_HASMORE = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.group = builder.group;
            if (builder.historys == null) {
                this.historys = DEFAULT_HISTORYS;
            } else {
                this.historys = immutableCopyOf(builder.historys);
            }
            if (builder.hasMore == null) {
                this.hasMore = DEFAULT_HASMORE;
                return;
            } else {
                this.hasMore = builder.hasMore;
                return;
            }
        }
        this.group = builder.group;
        this.historys = immutableCopyOf(builder.historys);
        this.hasMore = builder.hasMore;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public LiveGroupInfo group;
        public Integer hasMore;
        public List<History> historys;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.group = dataRes.group;
                this.historys = DataRes.copyOf(dataRes.historys);
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
