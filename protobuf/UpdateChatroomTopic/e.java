package protobuf.UpdateChatroomTopic;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicReq;
/* loaded from: classes.dex */
final class e extends AbstractParser<UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl(codedInputStream, extensionRegistryLite);
    }
}
