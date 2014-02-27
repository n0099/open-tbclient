package protobuf.QuitChatroom;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QuitChatroom.QuitChatroomRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<QuitChatroomRes.QuitChatroomResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QuitChatroomRes.QuitChatroomResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
