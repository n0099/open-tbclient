package protobuf.QueryGroupsByFid;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByFid.QueryGroupsByFidReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryGroupsByFidReq.QueryGroupsByFidReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByFidReq.QueryGroupsByFidReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
