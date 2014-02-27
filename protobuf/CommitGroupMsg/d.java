package protobuf.CommitGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitGroupMsg.CommitGroupMsgReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<CommitGroupMsgReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitGroupMsgReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
