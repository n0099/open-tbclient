package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class MyGroupInfo extends Message {
    public static final String DEFAULT_GROUPNAME = "";
    public static final String DEFAULT_PORTRAIT = "";
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long groupId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String groupName;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer maxMemberNum;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer memberNum;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String portrait;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_MEMBERNUM = 0;
    public static final Integer DEFAULT_MAXMEMBERNUM = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<MyGroupInfo> {
        public Long groupId;
        public String groupName;
        public Integer maxMemberNum;
        public Integer memberNum;
        public String portrait;

        public Builder() {
        }

        public Builder(MyGroupInfo myGroupInfo) {
            super(myGroupInfo);
            if (myGroupInfo == null) {
                return;
            }
            this.groupId = myGroupInfo.groupId;
            this.groupName = myGroupInfo.groupName;
            this.portrait = myGroupInfo.portrait;
            this.memberNum = myGroupInfo.memberNum;
            this.maxMemberNum = myGroupInfo.maxMemberNum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MyGroupInfo build(boolean z) {
            return new MyGroupInfo(this, z);
        }
    }

    public MyGroupInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            String str = builder.groupName;
            if (str == null) {
                this.groupName = "";
            } else {
                this.groupName = str;
            }
            String str2 = builder.portrait;
            if (str2 == null) {
                this.portrait = "";
            } else {
                this.portrait = str2;
            }
            Integer num = builder.memberNum;
            if (num == null) {
                this.memberNum = DEFAULT_MEMBERNUM;
            } else {
                this.memberNum = num;
            }
            Integer num2 = builder.maxMemberNum;
            if (num2 == null) {
                this.maxMemberNum = DEFAULT_MAXMEMBERNUM;
                return;
            } else {
                this.maxMemberNum = num2;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.groupName = builder.groupName;
        this.portrait = builder.portrait;
        this.memberNum = builder.memberNum;
        this.maxMemberNum = builder.maxMemberNum;
    }
}
