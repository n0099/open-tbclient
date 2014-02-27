package protobuf.QueryGroupUserList;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupUserList.QueryGroupUserListRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<QueryGroupUserListRes.QueryGroupUserListResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupUserListRes.QueryGroupUserListResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
