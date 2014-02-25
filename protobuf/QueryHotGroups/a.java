package protobuf.QueryHotGroups;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryHotGroups.QueryHotGroupsReq;
/* loaded from: classes.dex */
class a extends AbstractParser<QueryHotGroupsReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryHotGroupsReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryHotGroupsReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
