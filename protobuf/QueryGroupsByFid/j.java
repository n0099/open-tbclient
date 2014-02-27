package protobuf.QueryGroupsByFid;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByFid.QueryGroupsByFidRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<QueryGroupsByFidRes.QueryGroupsByFidResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByFidRes.QueryGroupsByFidResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
