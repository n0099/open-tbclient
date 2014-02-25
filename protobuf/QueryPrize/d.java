package protobuf.QueryPrize;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryPrize.QueryPrizeReq;
/* loaded from: classes.dex */
class d extends AbstractParser<QueryPrizeReq.QueryPrizeReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryPrizeReq.QueryPrizeReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryPrizeReq.QueryPrizeReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
