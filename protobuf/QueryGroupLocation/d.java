package protobuf.QueryGroupLocation;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupLocation.QueryGroupLocationReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryGroupLocationReq.QueryGroupLocationReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupLocationReq.QueryGroupLocationReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
