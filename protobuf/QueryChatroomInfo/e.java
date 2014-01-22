package protobuf.QueryChatroomInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryChatroomInfo.QueryChatroomInfoReq;
/* loaded from: classes.dex */
final class e extends AbstractParser<QueryChatroomInfoReq.QueryChatroomInfoReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryChatroomInfoReq.QueryChatroomInfoReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryChatroomInfoReq.QueryChatroomInfoReqIdl(codedInputStream, extensionRegistryLite);
    }
}
