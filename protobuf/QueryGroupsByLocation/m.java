package protobuf.QueryGroupsByLocation;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
class m extends AbstractParser<QueryGroupsByLocationRes.QueryGroupsByLocationResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupsByLocationRes.QueryGroupsByLocationResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByLocationRes.QueryGroupsByLocationResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
