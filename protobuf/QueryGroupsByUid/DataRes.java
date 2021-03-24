package protobuf.QueryGroupsByUid;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.GroupPermission;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public final List<GroupInfo> commonGroups;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer commongroupnum;
    @ProtoField(tag = 2)
    public final GroupPermission groupPerm;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer groupnum;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<GroupInfo> groups;
    public static final List<GroupInfo> DEFAULT_GROUPS = Collections.emptyList();
    public static final List<GroupInfo> DEFAULT_COMMONGROUPS = Collections.emptyList();
    public static final Integer DEFAULT_GROUPNUM = 0;
    public static final Integer DEFAULT_COMMONGROUPNUM = 0;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public List<GroupInfo> commonGroups;
        public Integer commongroupnum;
        public GroupPermission groupPerm;
        public Integer groupnum;
        public List<GroupInfo> groups;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.groups = Message.copyOf(dataRes.groups);
            this.groupPerm = dataRes.groupPerm;
            this.commonGroups = Message.copyOf(dataRes.commonGroups);
            this.groupnum = dataRes.groupnum;
            this.commongroupnum = dataRes.commongroupnum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }

    public DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            List<GroupInfo> list = builder.groups;
            if (list == null) {
                this.groups = DEFAULT_GROUPS;
            } else {
                this.groups = Message.immutableCopyOf(list);
            }
            this.groupPerm = builder.groupPerm;
            List<GroupInfo> list2 = builder.commonGroups;
            if (list2 == null) {
                this.commonGroups = DEFAULT_COMMONGROUPS;
            } else {
                this.commonGroups = Message.immutableCopyOf(list2);
            }
            Integer num = builder.groupnum;
            if (num == null) {
                this.groupnum = DEFAULT_GROUPNUM;
            } else {
                this.groupnum = num;
            }
            Integer num2 = builder.commongroupnum;
            if (num2 == null) {
                this.commongroupnum = DEFAULT_COMMONGROUPNUM;
                return;
            } else {
                this.commongroupnum = num2;
                return;
            }
        }
        this.groups = Message.immutableCopyOf(builder.groups);
        this.groupPerm = builder.groupPerm;
        this.commonGroups = Message.immutableCopyOf(builder.commonGroups);
        this.groupnum = builder.groupnum;
        this.commongroupnum = builder.commongroupnum;
    }
}
