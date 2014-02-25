package protobuf.QueryGroupsByUid;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByUid.QueryGroupsByUidReq;
/* loaded from: classes.dex */
class d extends AbstractParser<QueryGroupsByUidReq.QueryGroupsByUidReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupsByUidReq.QueryGroupsByUidReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByUidReq.QueryGroupsByUidReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
