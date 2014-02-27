package protobuf.GetGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetGroupMsg.GetGroupMsgRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<GetGroupMsgRes.GetGroupMsgResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetGroupMsgRes.GetGroupMsgResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
