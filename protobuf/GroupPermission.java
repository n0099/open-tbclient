package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
            if (groupPermission == null) {
                return;
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupPermission build(boolean z) {
            return new GroupPermission(this, z);
        }
    }

    public GroupPermission(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isForumManager;
            if (num == null) {
                this.isForumManager = DEFAULT_ISFORUMMANAGER;
            } else {
                this.isForumManager = num;
            }
            Integer num2 = builder.canCreateNormal;
            if (num2 == null) {
                this.canCreateNormal = DEFAULT_CANCREATENORMAL;
            } else {
                this.canCreateNormal = num2;
            }
            Integer num3 = builder.canCreateOfficial;
            if (num3 == null) {
                this.canCreateOfficial = DEFAULT_CANCREATEOFFICIAL;
            } else {
                this.canCreateOfficial = num3;
            }
            Integer num4 = builder.canCreatePersonal;
            if (num4 == null) {
                this.canCreatePersonal = DEFAULT_CANCREATEPERSONAL;
            } else {
                this.canCreatePersonal = num4;
            }
            String str = builder.createNormalTip;
            if (str == null) {
                this.createNormalTip = "";
            } else {
                this.createNormalTip = str;
            }
            String str2 = builder.createOfficialTip;
            if (str2 == null) {
                this.createOfficialTip = "";
            } else {
                this.createOfficialTip = str2;
            }
            String str3 = builder.createPersonalTip;
            if (str3 == null) {
                this.createPersonalTip = "";
            } else {
                this.createPersonalTip = str3;
            }
            Integer num5 = builder.canCreateNormalNum;
            if (num5 == null) {
                this.canCreateNormalNum = DEFAULT_CANCREATENORMALNUM;
            } else {
                this.canCreateNormalNum = num5;
            }
            Integer num6 = builder.canCreateOfficialNum;
            if (num6 == null) {
                this.canCreateOfficialNum = DEFAULT_CANCREATEOFFICIALNUM;
            } else {
                this.canCreateOfficialNum = num6;
            }
            Integer num7 = builder.canCreatePersonalNum;
            if (num7 == null) {
                this.canCreatePersonalNum = DEFAULT_CANCREATEPERSONALNUM;
                return;
            } else {
                this.canCreatePersonalNum = num7;
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
}
