package protobuf.QueryGroupLocation;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupLocation.QueryGroupLocationReq;
/* loaded from: classes.dex */
class d extends AbstractParser<QueryGroupLocationReq.QueryGroupLocationReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupLocationReq.QueryGroupLocationReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupLocationReq.QueryGroupLocationReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
