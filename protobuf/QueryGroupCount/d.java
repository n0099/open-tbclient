package protobuf.QueryGroupCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupCount.QueryGroupCountReq;
/* loaded from: classes.dex */
class d extends AbstractParser<QueryGroupCountReq.QueryGroupCountReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupCountReq.QueryGroupCountReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupCountReq.QueryGroupCountReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
