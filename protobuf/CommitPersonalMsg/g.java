package protobuf.CommitPersonalMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<CommitPersonalMsgRes.CommitPersonalMsgResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitPersonalMsgRes.CommitPersonalMsgResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
