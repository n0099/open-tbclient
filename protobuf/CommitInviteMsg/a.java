package protobuf.CommitInviteMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<CommitInviteMsgReq.CommitInviteMsgReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitInviteMsgReq.CommitInviteMsgReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
