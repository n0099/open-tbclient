package protobuf.QueryGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupActivity.QueryGroupActivityReq;
/* loaded from: classes.dex */
class d extends AbstractParser<QueryGroupActivityReq.QueryGroupActivityReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupActivityReq.QueryGroupActivityReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupActivityReq.QueryGroupActivityReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
