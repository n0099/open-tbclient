package protobuf.QueryGroupLocation;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupLocation.QueryGroupLocationRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<QueryGroupLocationRes.QueryGroupLocationResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupLocationRes.QueryGroupLocationResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
