package protobuf.EnterChatroom;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ChatroomTopic extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;

    /* synthetic */ ChatroomTopic(Builder builder, boolean z, ChatroomTopic chatroomTopic) {
        this(builder, z);
    }

    private ChatroomTopic(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.title == null) {
                this.title = "";
            } else {
                this.title = builder.title;
            }
            if (builder.content == null) {
                this.content = "";
                return;
            } else {
                this.content = builder.content;
                return;
            }
        }
        this.title = builder.title;
        this.content = builder.content;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<ChatroomTopic> {
        public String content;
        public String title;

        public Builder(ChatroomTopic chatroomTopic) {
            super(chatroomTopic);
            if (chatroomTopic != null) {
                this.title = chatroomTopic.title;
                this.content = chatroomTopic.content;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ChatroomTopic build(boolean z) {
            return new ChatroomTopic(this, z, null);
        }
    }
}
