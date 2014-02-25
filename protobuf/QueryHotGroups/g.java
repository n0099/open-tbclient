package protobuf.QueryHotGroups;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryHotGroups.QueryHotGroupsRes;
/* loaded from: classes.dex */
class g extends AbstractParser<QueryHotGroupsRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryHotGroupsRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryHotGroupsRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
