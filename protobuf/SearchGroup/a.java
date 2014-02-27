package protobuf.SearchGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.SearchGroup.SearchGroupReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<SearchGroupReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new SearchGroupReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
