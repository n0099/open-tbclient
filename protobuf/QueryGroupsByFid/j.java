package protobuf.QueryGroupsByFid;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByFid.QueryGroupsByFidRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryGroupsByFidRes.QueryGroupsByFidResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupsByFidRes.QueryGroupsByFidResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByFidRes.QueryGroupsByFidResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
