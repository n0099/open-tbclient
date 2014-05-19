package protobuf.QueryLiveGroupsByUid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final List<LiveGroupInfo> DEFAULT_GROUPS = Collections.emptyList();
    public static final Integer DEFAULT_HASMORE = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<LiveGroupInfo> groups;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer hasMore;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groups == null) {
                this.groups = DEFAULT_GROUPS;
            } else {
                this.groups = immutableCopyOf(builder.groups);
            }
            if (builder.hasMore == null) {
                this.hasMore = DEFAULT_HASMORE;
                return;
            } else {
                this.hasMore = builder.hasMore;
                return;
            }
        }
        this.groups = immutableCopyOf(builder.groups);
        this.hasMore = builder.hasMore;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public List<LiveGroupInfo> groups;
        public Integer hasMore;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groups = DataRes.copyOf(dataRes.groups);
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
