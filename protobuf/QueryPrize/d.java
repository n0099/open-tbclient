package protobuf.QueryPrize;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryPrize.QueryPrizeReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryPrizeReq.QueryPrizeReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryPrizeReq.QueryPrizeReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
