package protobuf.EnterChatroom;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.EnterChatroom.EnterChatroomRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<EnterChatroomRes.ChatroomTopic> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new EnterChatroomRes.ChatroomTopic(codedInputStream, extensionRegistryLite, null);
    }
}
