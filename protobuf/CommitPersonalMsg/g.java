package protobuf.CommitPersonalMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgRes;
/* loaded from: classes.dex */
class g extends AbstractParser<CommitPersonalMsgRes.CommitPersonalMsgResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CommitPersonalMsgRes.CommitPersonalMsgResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitPersonalMsgRes.CommitPersonalMsgResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
