package protobuf.SearchGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.SearchGroup.SearchGroupReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<SearchGroupReq.SearchGroupReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new SearchGroupReq.SearchGroupReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
