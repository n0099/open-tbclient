package protobuf.CommitPersonalMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgRes;
/* loaded from: classes.dex */
class j extends AbstractParser<CommitPersonalMsgRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CommitPersonalMsgRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitPersonalMsgRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
