package protobuf.QueryPrize;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
class m extends AbstractParser<QueryPrizeRes.QueryPrizeResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryPrizeRes.QueryPrizeResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryPrizeRes.QueryPrizeResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
