package protobuf.GetGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetGroupMsg.GetGroupMsgReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<GetGroupMsgReq.GetGroupMsgReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetGroupMsgReq.GetGroupMsgReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
