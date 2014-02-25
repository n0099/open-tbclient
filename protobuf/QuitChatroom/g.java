package protobuf.QuitChatroom;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QuitChatroom.QuitChatroomRes;
/* loaded from: classes.dex */
class g extends AbstractParser<QuitChatroomRes.QuitChatroomResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QuitChatroomRes.QuitChatroomResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QuitChatroomRes.QuitChatroomResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
