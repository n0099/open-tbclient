package protobuf.CommitPersonalMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<CommitPersonalMsgReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitPersonalMsgReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
