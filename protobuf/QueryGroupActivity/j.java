package protobuf.QueryGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupActivity.QueryGroupActivityRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryGroupActivityRes.QueryGroupActivityResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupActivityRes.QueryGroupActivityResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupActivityRes.QueryGroupActivityResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
