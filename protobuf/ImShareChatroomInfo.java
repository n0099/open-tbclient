package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class ImShareChatroomInfo extends Message {
    public static final String DEFAULT_FORUMNAME = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_NAME = "";
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long chatCount;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long forumId;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String icon;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_FORUMID = 0L;
    public static final Long DEFAULT_CHATCOUNT = 0L;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<ImShareChatroomInfo> {
        public Long chatCount;
        public Long forumId;
        public String forumName;
        public String icon;
        public Long id;
        public String name;

        public Builder() {
        }

        public Builder(ImShareChatroomInfo imShareChatroomInfo) {
            super(imShareChatroomInfo);
            if (imShareChatroomInfo == null) {
                return;
            }
            this.id = imShareChatroomInfo.id;
            this.name = imShareChatroomInfo.name;
            this.icon = imShareChatroomInfo.icon;
            this.forumId = imShareChatroomInfo.forumId;
            this.forumName = imShareChatroomInfo.forumName;
            this.chatCount = imShareChatroomInfo.chatCount;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ImShareChatroomInfo build(boolean z) {
            return new ImShareChatroomInfo(this, z);
        }
    }

    public ImShareChatroomInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.id;
            if (l == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = l;
            }
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.icon;
            if (str2 == null) {
                this.icon = "";
            } else {
                this.icon = str2;
            }
            Long l2 = builder.forumId;
            if (l2 == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = l2;
            }
            String str3 = builder.forumName;
            if (str3 == null) {
                this.forumName = "";
            } else {
                this.forumName = str3;
            }
            Long l3 = builder.chatCount;
            if (l3 == null) {
                this.chatCount = DEFAULT_CHATCOUNT;
                return;
            } else {
                this.chatCount = l3;
                return;
            }
        }
        this.id = builder.id;
        this.name = builder.name;
        this.icon = builder.icon;
        this.forumId = builder.forumId;
        this.forumName = builder.forumName;
        this.chatCount = builder.chatCount;
    }
}
