package protobuf.QueryChatroomInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryChatroomInfo.QueryChatroomInfoReq;
/* loaded from: classes.dex */
final class b extends AbstractParser<QueryChatroomInfoReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryChatroomInfoReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryChatroomInfoReq.DataReq(codedInputStream, extensionRegistryLite);
    }
}
