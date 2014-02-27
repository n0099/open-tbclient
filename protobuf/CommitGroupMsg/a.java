package protobuf.CommitGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitGroupMsg.CommitGroupMsgReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<CommitGroupMsgReq.CommitGroupMsgReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitGroupMsgReq.CommitGroupMsgReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
