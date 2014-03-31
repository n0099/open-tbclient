package protobuf.QueryHistoryMsg;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryHistoryMsg.QueryHistoryMsgReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<QueryHistoryMsgReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryHistoryMsgReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
