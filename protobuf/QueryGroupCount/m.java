package protobuf.QueryGroupCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
final class m extends AbstractParser<QueryGroupCountRes.QueryGroupCountResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupCountRes.QueryGroupCountResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
