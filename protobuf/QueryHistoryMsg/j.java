package protobuf.QueryHistoryMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryHistoryMsg.QueryHistoryMsgRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<QueryHistoryMsgRes.MsgInfo> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryHistoryMsgRes.MsgInfo(codedInputStream, extensionRegistryLite, null);
    }
}
