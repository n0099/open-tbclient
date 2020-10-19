package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
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

    private ForumRalatedInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.forumId == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = builder.forumId;
            }
            if (builder.name == null) {
                this.name = "";
            } else {
                this.name = builder.name;
            }
            if (builder.avatar == null) {
                this.avatar = "";
            } else {
                this.avatar = builder.avatar;
            }
            if (builder.level == null) {
                this.level = DEFAULT_LEVEL;
            } else {
                this.level = builder.level;
            }
            if (builder.curScore == null) {
                this.curScore = DEFAULT_CURSCORE;
            } else {
                this.curScore = builder.curScore;
            }
            if (builder.leftScore == null) {
                this.leftScore = DEFAULT_LEFTSCORE;
                return;
            } else {
                this.leftScore = builder.leftScore;
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

    /* loaded from: classes22.dex */
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
            if (forumRalatedInfo != null) {
                this.forumId = forumRalatedInfo.forumId;
                this.name = forumRalatedInfo.name;
                this.avatar = forumRalatedInfo.avatar;
                this.level = forumRalatedInfo.level;
                this.curScore = forumRalatedInfo.curScore;
                this.leftScore = forumRalatedInfo.leftScore;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ForumRalatedInfo build(boolean z) {
            return new ForumRalatedInfo(this, z);
        }
    }
}
