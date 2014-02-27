package protobuf.GetGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetGroupMsg.GetGroupMsgRes;
/* loaded from: classes.dex */
final class m extends AbstractParser<GetGroupMsgRes.GroupMsg> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetGroupMsgRes.GroupMsg(codedInputStream, extensionRegistryLite, null);
    }
}
