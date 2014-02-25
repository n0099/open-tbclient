package protobuf.UpdateChatroomTopic;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicReq;
/* loaded from: classes.dex */
class a extends AbstractParser<UpdateChatroomTopicReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpdateChatroomTopicReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateChatroomTopicReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
