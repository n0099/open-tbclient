package protobuf.CommitInviteMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
class a extends AbstractParser<CommitInviteMsgReq.CommitInviteMsgReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CommitInviteMsgReq.CommitInviteMsgReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitInviteMsgReq.CommitInviteMsgReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
