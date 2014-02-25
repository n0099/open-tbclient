package protobuf.QueryGroupCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
class g extends AbstractParser<QueryGroupCountRes.Banner> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupCountRes.Banner parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupCountRes.Banner(codedInputStream, extensionRegistryLite, null);
    }
}
