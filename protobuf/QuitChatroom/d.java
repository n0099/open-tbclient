package protobuf.QuitChatroom;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QuitChatroom.QuitChatroomReq;
/* loaded from: classes.dex */
class d extends AbstractParser<QuitChatroomReq.QuitChatroomReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QuitChatroomReq.QuitChatroomReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QuitChatroomReq.QuitChatroomReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
