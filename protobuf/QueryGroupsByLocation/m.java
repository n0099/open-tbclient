package protobuf.QueryGroupsByLocation;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
final class m extends AbstractParser<QueryGroupsByLocationRes.QueryGroupsByLocationResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByLocationRes.QueryGroupsByLocationResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
