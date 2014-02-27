package protobuf.QueryUserPermission;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserPermission.QueryUserPermissionRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<QueryUserPermissionRes.QueryUserPermissionResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserPermissionRes.QueryUserPermissionResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
