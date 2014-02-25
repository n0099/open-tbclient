package protobuf.QueryGroupDetail;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupDetail.QueryGroupDetailReq;
/* loaded from: classes.dex */
class d extends AbstractParser<QueryGroupDetailReq.QueryGroupDetailReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupDetailReq.QueryGroupDetailReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupDetailReq.QueryGroupDetailReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
