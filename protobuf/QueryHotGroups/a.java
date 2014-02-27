package protobuf.QueryHotGroups;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryHotGroups.QueryHotGroupsReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<QueryHotGroupsReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryHotGroupsReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
