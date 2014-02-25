package protobuf.CommitGroupMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitGroupMsg.CommitGroupMsgRes;
/* loaded from: classes.dex */
class j extends AbstractParser<CommitGroupMsgRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CommitGroupMsgRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitGroupMsgRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
