package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class ForumInfo extends Message {
    public static final String DEFAULT_AVATAR = "";
    public static final String DEFAULT_FORUMNAME = "";
    public static final String DEFAULT_SLOGAN = "";
    public static final String DEFAULT_THREADNUM = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String avatar;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long forumId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer memberCount;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String slogan;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String threadNum;
    public static final Long DEFAULT_FORUMID = 0L;
    public static final Integer DEFAULT_MEMBERCOUNT = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<ForumInfo> {
        public String avatar;
        public Long forumId;
        public String forumName;
        public Integer memberCount;
        public String slogan;
        public String threadNum;

        public Builder() {
        }

        public Builder(ForumInfo forumInfo) {
            super(forumInfo);
            if (forumInfo == null) {
                return;
            }
            this.forumId = forumInfo.forumId;
            this.forumName = forumInfo.forumName;
            this.avatar = forumInfo.avatar;
            this.memberCount = forumInfo.memberCount;
            this.slogan = forumInfo.slogan;
            this.threadNum = forumInfo.threadNum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ForumInfo build(boolean z) {
            return new ForumInfo(this, z);
        }
    }

    public ForumInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.forumId;
            if (l == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = l;
            }
            String str = builder.forumName;
            if (str == null) {
                this.forumName = "";
            } else {
                this.forumName = str;
            }
            String str2 = builder.avatar;
            if (str2 == null) {
                this.avatar = "";
            } else {
                this.avatar = str2;
            }
            Integer num = builder.memberCount;
            if (num == null) {
                this.memberCount = DEFAULT_MEMBERCOUNT;
            } else {
                this.memberCount = num;
            }
            String str3 = builder.slogan;
            if (str3 == null) {
                this.slogan = "";
            } else {
                this.slogan = str3;
            }
            String str4 = builder.threadNum;
            if (str4 == null) {
                this.threadNum = "";
                return;
            } else {
                this.threadNum = str4;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.forumName = builder.forumName;
        this.avatar = builder.avatar;
        this.memberCount = builder.memberCount;
        this.slogan = builder.slogan;
        this.threadNum = builder.threadNum;
    }
}
