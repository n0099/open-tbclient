package protobuf.SearchGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.SearchGroup.SearchGroupRes;
/* loaded from: classes.dex */
class j extends AbstractParser<SearchGroupRes.SearchGroupResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public SearchGroupRes.SearchGroupResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new SearchGroupRes.SearchGroupResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
