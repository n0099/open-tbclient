package protobuf.GetGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetGroupMsg.GetGroupMsgRes;
/* loaded from: classes.dex */
final class l extends AbstractParser<GetGroupMsgRes.GetGroupMsgResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public GetGroupMsgRes.GetGroupMsgResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetGroupMsgRes.GetGroupMsgResIdl(codedInputStream, extensionRegistryLite);
    }
}
