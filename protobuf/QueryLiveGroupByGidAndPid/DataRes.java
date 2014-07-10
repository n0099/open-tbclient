package protobuf.QueryLiveGroupByGidAndPid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final List<LiveGroupInfo> DEFAULT_PUBLISHGROUPS = Collections.emptyList();
    @ProtoField(tag = 1)
    public final LiveGroupInfo group;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<LiveGroupInfo> publishGroups;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.group = builder.group;
            if (builder.publishGroups == null) {
                this.publishGroups = DEFAULT_PUBLISHGROUPS;
                return;
            } else {
                this.publishGroups = immutableCopyOf(builder.publishGroups);
                return;
            }
        }
        this.group = builder.group;
        this.publishGroups = immutableCopyOf(builder.publishGroups);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public LiveGroupInfo group;
        public List<LiveGroupInfo> publishGroups;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.group = dataRes.group;
                this.publishGroups = DataRes.copyOf(dataRes.publishGroups);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
