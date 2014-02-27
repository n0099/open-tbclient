package protobuf.UpdateChatroomTopic;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
