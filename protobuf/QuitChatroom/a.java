package protobuf.QuitChatroom;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QuitChatroom.QuitChatroomReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<QuitChatroomReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QuitChatroomReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
