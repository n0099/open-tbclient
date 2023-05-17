package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class ForumRalatedInfo extends Message {
    public static final String DEFAULT_AVATAR = "";
    public static final String DEFAULT_NAME = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String avatar;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer curScore;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer leftScore;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer level;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    public static final Integer DEFAULT_FORUMID = 0;
    public static final Integer DEFAULT_LEVEL = 0;
    public static final Integer DEFAULT_CURSCORE = 0;
    public static final Integer DEFAULT_LEFTSCORE = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<ForumRalatedInfo> {
        public String avatar;
        public Integer curScore;
        public Integer forumId;
        public Integer leftScore;
        public Integer level;
        public String name;

        public Builder() {
        }

        public Builder(ForumRalatedInfo forumRalatedInfo) {
            super(forumRalatedInfo);
            if (forumRalatedInfo == null) {
                return;
            }
            this.forumId = forumRalatedInfo.forumId;
            this.name = forumRalatedInfo.name;
            this.avatar = forumRalatedInfo.avatar;
            this.level = forumRalatedInfo.level;
            this.curScore = forumRalatedInfo.curScore;
            this.leftScore = forumRalatedInfo.leftScore;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ForumRalatedInfo build(boolean z) {
            return new ForumRalatedInfo(this, z);
        }
    }

    public ForumRalatedInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.forumId;
            if (num == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = num;
            }
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.avatar;
            if (str2 == null) {
                this.avatar = "";
            } else {
                this.avatar = str2;
            }
            Integer num2 = builder.level;
            if (num2 == null) {
                this.level = DEFAULT_LEVEL;
            } else {
                this.level = num2;
            }
            Integer num3 = builder.curScore;
            if (num3 == null) {
                this.curScore = DEFAULT_CURSCORE;
            } else {
                this.curScore = num3;
            }
            Integer num4 = builder.leftScore;
            if (num4 == null) {
                this.leftScore = DEFAULT_LEFTSCORE;
                return;
            } else {
                this.leftScore = num4;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.name = builder.name;
        this.avatar = builder.avatar;
        this.level = builder.level;
        this.curScore = builder.curScore;
        this.leftScore = builder.leftScore;
    }
}
