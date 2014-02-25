package protobuf.QueryGroupUserList;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupUserList.QueryGroupUserListReq;
/* loaded from: classes.dex */
class a extends AbstractParser<QueryGroupUserListReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupUserListReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupUserListReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
