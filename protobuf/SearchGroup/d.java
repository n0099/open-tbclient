package protobuf.SearchGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.SearchGroup.SearchGroupReq;
/* loaded from: classes.dex */
class d extends AbstractParser<SearchGroupReq.SearchGroupReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public SearchGroupReq.SearchGroupReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new SearchGroupReq.SearchGroupReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
