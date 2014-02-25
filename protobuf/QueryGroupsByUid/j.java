package protobuf.QueryGroupsByUid;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByUid.QueryGroupsByUidRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryGroupsByUidRes.QueryGroupsByUidResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupsByUidRes.QueryGroupsByUidResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByUidRes.QueryGroupsByUidResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
