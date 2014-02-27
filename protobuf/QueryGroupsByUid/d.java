package protobuf.QueryGroupsByUid;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByUid.QueryGroupsByUidReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryGroupsByUidReq.QueryGroupsByUidReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByUidReq.QueryGroupsByUidReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
