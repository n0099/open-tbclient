package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class LikeForumInfo extends Message {
    public static final Long DEFAULT_FORUMID = 0L;
    public static final String DEFAULT_FORUMNAME = "";
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long forumId;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String forumName;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<LikeForumInfo> {
        public Long forumId;
        public String forumName;

        public Builder() {
        }

        public Builder(LikeForumInfo likeForumInfo) {
            super(likeForumInfo);
            if (likeForumInfo == null) {
                return;
            }
            this.forumName = likeForumInfo.forumName;
            this.forumId = likeForumInfo.forumId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LikeForumInfo build(boolean z) {
            return new LikeForumInfo(this, z);
        }
    }

    public LikeForumInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.forumName;
            if (str == null) {
                this.forumName = "";
            } else {
                this.forumName = str;
            }
            Long l = builder.forumId;
            if (l == null) {
                this.forumId = DEFAULT_FORUMID;
                return;
            } else {
                this.forumId = l;
                return;
            }
        }
        this.forumName = builder.forumName;
        this.forumId = builder.forumId;
    }
}
