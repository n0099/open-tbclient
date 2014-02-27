package protobuf.EnterChatroom;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.EnterChatroom.EnterChatroomReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<EnterChatroomReq.EnterChatroomReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new EnterChatroomReq.EnterChatroomReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
