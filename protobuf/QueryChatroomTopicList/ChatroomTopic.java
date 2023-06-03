package protobuf.QueryChatroomTopicList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class ChatroomTopic extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<ChatroomTopic> {
        public String content;
        public String title;

        public Builder() {
        }

        public Builder(ChatroomTopic chatroomTopic) {
            super(chatroomTopic);
            if (chatroomTopic == null) {
                return;
            }
            this.title = chatroomTopic.title;
            this.content = chatroomTopic.content;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ChatroomTopic build(boolean z) {
            return new ChatroomTopic(this, z);
        }
    }

    public ChatroomTopic(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.title;
            if (str == null) {
                this.title = "";
            } else {
                this.title = str;
            }
            String str2 = builder.content;
            if (str2 == null) {
                this.content = "";
                return;
            } else {
                this.content = str2;
                return;
            }
        }
        this.title = builder.title;
        this.content = builder.content;
    }
}
