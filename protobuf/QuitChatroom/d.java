package protobuf.QuitChatroom;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QuitChatroom.QuitChatroomReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QuitChatroomReq.QuitChatroomReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QuitChatroomReq.QuitChatroomReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
