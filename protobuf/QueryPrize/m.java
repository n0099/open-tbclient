package protobuf.QueryPrize;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
final class m extends AbstractParser<QueryPrizeRes.QueryPrizeResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryPrizeRes.QueryPrizeResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
