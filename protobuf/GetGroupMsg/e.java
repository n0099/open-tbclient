package protobuf.GetGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetGroupMsg.GetGroupMsgReq;
/* loaded from: classes.dex */
final class e extends AbstractParser<GetGroupMsgReq.GetGroupMsgReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public GetGroupMsgReq.GetGroupMsgReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetGroupMsgReq.GetGroupMsgReqIdl(codedInputStream, extensionRegistryLite);
    }
}
