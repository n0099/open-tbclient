package protobuf.QueryGroupsByLocation;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
