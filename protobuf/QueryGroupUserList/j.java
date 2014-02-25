package protobuf.QueryGroupUserList;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupUserList.QueryGroupUserListRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryGroupUserListRes.QueryGroupUserListResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupUserListRes.QueryGroupUserListResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupUserListRes.QueryGroupUserListResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
