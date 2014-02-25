package protobuf.QueryPrize;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryPrizeRes.PrizeInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryPrizeRes.PrizeInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryPrizeRes.PrizeInfo(codedInputStream, extensionRegistryLite, null);
    }
}
