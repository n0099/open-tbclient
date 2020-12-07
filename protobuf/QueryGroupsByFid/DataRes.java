package protobuf.QueryGroupsByFid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.GroupPermission;
/* loaded from: classes23.dex */
public final class DataRes extends Message {
    public static final List<GroupInfo> DEFAULT_GROUPS = Collections.emptyList();
    @ProtoField(tag = 2)
    public final GroupPermission groupPerm;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<GroupInfo> groups;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groups == null) {
                this.groups = DEFAULT_GROUPS;
            } else {
                this.groups = immutableCopyOf(builder.groups);
            }
            this.groupPerm = builder.groupPerm;
            return;
        }
        this.groups = immutableCopyOf(builder.groups);
        this.groupPerm = builder.groupPerm;
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public GroupPermission groupPerm;
        public List<GroupInfo> groups;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groups = DataRes.copyOf(dataRes.groups);
                this.groupPerm = dataRes.groupPerm;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
