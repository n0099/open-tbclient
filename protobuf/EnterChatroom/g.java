package protobuf.EnterChatroom;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.EnterChatroom.EnterChatroomRes;
/* loaded from: classes.dex */
class g extends AbstractParser<EnterChatroomRes.ChatroomTopic> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public EnterChatroomRes.ChatroomTopic parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new EnterChatroomRes.ChatroomTopic(codedInputStream, extensionRegistryLite, null);
    }
}
