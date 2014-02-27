package protobuf.QueryChatroomInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryChatroomInfo.QueryChatroomInfoReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryChatroomInfoReq.QueryChatroomInfoReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryChatroomInfoReq.QueryChatroomInfoReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
