package protobuf.CommitGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitGroupMsg.CommitGroupMsgRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<CommitGroupMsgRes.CommitGroupMsgResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitGroupMsgRes.CommitGroupMsgResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
