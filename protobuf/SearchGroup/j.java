package protobuf.SearchGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.SearchGroup.SearchGroupRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<SearchGroupRes.SearchGroupResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new SearchGroupRes.SearchGroupResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
