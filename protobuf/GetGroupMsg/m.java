package protobuf.GetGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetGroupMsg.GetGroupMsgRes;
/* loaded from: classes.dex */
class m extends AbstractParser<GetGroupMsgRes.GroupMsg> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public GetGroupMsgRes.GroupMsg parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetGroupMsgRes.GroupMsg(codedInputStream, extensionRegistryLite, null);
    }
}
