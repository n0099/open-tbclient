package protobuf.CommitInviteMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitInviteMsg.CommitInviteMsgRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<CommitInviteMsgRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitInviteMsgRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
