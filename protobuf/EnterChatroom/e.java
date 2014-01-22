package protobuf.EnterChatroom;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.EnterChatroom.EnterChatroomReq;
/* loaded from: classes.dex */
final class e extends AbstractParser<EnterChatroomReq.EnterChatroomReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public EnterChatroomReq.EnterChatroomReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new EnterChatroomReq.EnterChatroomReqIdl(codedInputStream, extensionRegistryLite);
    }
}
