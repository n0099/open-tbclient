package protobuf.CommitGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitGroupMsg.CommitGroupMsgRes;
/* loaded from: classes.dex */
class g extends AbstractParser<CommitGroupMsgRes.CommitGroupMsgResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CommitGroupMsgRes.CommitGroupMsgResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitGroupMsgRes.CommitGroupMsgResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
