package protobuf.QueryHotGroups;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryHotGroups.QueryHotGroupsRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryHotGroupsRes.QueryHotGroupsResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryHotGroupsRes.QueryHotGroupsResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryHotGroupsRes.QueryHotGroupsResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
