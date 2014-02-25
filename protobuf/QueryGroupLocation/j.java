package protobuf.QueryGroupLocation;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupLocation.QueryGroupLocationRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryGroupLocationRes.QueryGroupLocationResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupLocationRes.QueryGroupLocationResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupLocationRes.QueryGroupLocationResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
