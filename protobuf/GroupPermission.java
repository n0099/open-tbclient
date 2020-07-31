package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes16.dex */
public final class GroupPermission extends Message {
    public static final String DEFAULT_CREATENORMALTIP = "";
    public static final String DEFAULT_CREATEOFFICIALTIP = "";
    public static final String DEFAULT_CREATEPERSONALTIP = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer canCreateNormal;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer canCreateNormalNum;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer canCreateOfficial;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer canCreateOfficialNum;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer canCreatePersonal;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer canCreatePersonalNum;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String createNormalTip;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String createOfficialTip;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String createPersonalTip;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isForumManager;
    public static final Integer DEFAULT_ISFORUMMANAGER = 0;
    public static final Integer DEFAULT_CANCREATENORMAL = 0;
    public static final Integer DEFAULT_CANCREATEOFFICIAL = 0;
    public static final Integer DEFAULT_CANCREATEPERSONAL = 0;
    public static final Integer DEFAULT_CANCREATENORMALNUM = 0;
    public static final Integer DEFAULT_CANCREATEOFFICIALNUM = 0;
    public static final Integer DEFAULT_CANCREATEPERSONALNUM = 0;

    private GroupPermission(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.isForumManager == null) {
                this.isForumManager = DEFAULT_ISFORUMMANAGER;
            } else {
                this.isForumManager = builder.isForumManager;
            }
            if (builder.canCreateNormal == null) {
                this.canCreateNormal = DEFAULT_CANCREATENORMAL;
            } else {
                this.canCreateNormal = builder.canCreateNormal;
            }
            if (builder.canCreateOfficial == null) {
                this.canCreateOfficial = DEFAULT_CANCREATEOFFICIAL;
            } else {
                this.canCreateOfficial = builder.canCreateOfficial;
            }
            if (builder.canCreatePersonal == null) {
                this.canCreatePersonal = DEFAULT_CANCREATEPERSONAL;
            } else {
                this.canCreatePersonal = builder.canCreatePersonal;
            }
            if (builder.createNormalTip == null) {
                this.createNormalTip = "";
            } else {
                this.createNormalTip = builder.createNormalTip;
            }
            if (builder.createOfficialTip == null) {
                this.createOfficialTip = "";
            } else {
                this.createOfficialTip = builder.createOfficialTip;
            }
            if (builder.createPersonalTip == null) {
                this.createPersonalTip = "";
            } else {
                this.createPersonalTip = builder.createPersonalTip;
            }
            if (builder.canCreateNormalNum == null) {
                this.canCreateNormalNum = DEFAULT_CANCREATENORMALNUM;
            } else {
                this.canCreateNormalNum = builder.canCreateNormalNum;
            }
            if (builder.canCreateOfficialNum == null) {
                this.canCreateOfficialNum = DEFAULT_CANCREATEOFFICIALNUM;
            } else {
                this.canCreateOfficialNum = builder.canCreateOfficialNum;
            }
            if (builder.canCreatePersonalNum == null) {
                this.canCreatePersonalNum = DEFAULT_CANCREATEPERSONALNUM;
                return;
            } else {
                this.canCreatePersonalNum = builder.canCreatePersonalNum;
                return;
            }
        }
        this.isForumManager = builder.isForumManager;
        this.canCreateNormal = builder.canCreateNormal;
        this.canCreateOfficial = builder.canCreateOfficial;
        this.canCreatePersonal = builder.canCreatePersonal;
        this.createNormalTip = builder.createNormalTip;
        this.createOfficialTip = builder.createOfficialTip;
        this.createPersonalTip = builder.createPersonalTip;
        this.canCreateNormalNum = builder.canCreateNormalNum;
        this.canCreateOfficialNum = builder.canCreateOfficialNum;
        this.canCreatePersonalNum = builder.canCreatePersonalNum;
    }

    /* loaded from: classes16.dex */
    public static final class Builder extends Message.Builder<GroupPermission> {
        public Integer canCreateNormal;
        public Integer canCreateNormalNum;
        public Integer canCreateOfficial;
        public Integer canCreateOfficialNum;
        public Integer canCreatePersonal;
        public Integer canCreatePersonalNum;
        public String createNormalTip;
        public String createOfficialTip;
        public String createPersonalTip;
        public Integer isForumManager;

        public Builder() {
        }

        public Builder(GroupPermission groupPermission) {
            super(groupPermission);
            if (groupPermission != null) {
                this.isForumManager = groupPermission.isForumManager;
                this.canCreateNormal = groupPermission.canCreateNormal;
                this.canCreateOfficial = groupPermission.canCreateOfficial;
                this.canCreatePersonal = groupPermission.canCreatePersonal;
                this.createNormalTip = groupPermission.createNormalTip;
                this.createOfficialTip = groupPermission.createOfficialTip;
                this.createPersonalTip = groupPermission.createPersonalTip;
                this.canCreateNormalNum = groupPermission.canCreateNormalNum;
                this.canCreateOfficialNum = groupPermission.canCreateOfficialNum;
                this.canCreatePersonalNum = groupPermission.canCreatePersonalNum;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupPermission build(boolean z) {
            return new GroupPermission(this, z);
        }
    }
}
