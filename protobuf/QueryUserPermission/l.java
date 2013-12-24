package protobuf.QueryUserPermission;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserPermission.QueryUserPermissionRes;
/* loaded from: classes.dex */
final class l extends AbstractParser<QueryUserPermissionRes.QueryUserPermissionResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryUserPermissionRes.QueryUserPermissionResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserPermissionRes.QueryUserPermissionResIdl(codedInputStream, extensionRegistryLite);
    }
}
