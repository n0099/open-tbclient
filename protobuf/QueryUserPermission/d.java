package protobuf.QueryUserPermission;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserPermission.QueryUserPermissionReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryUserPermissionReq.QueryUserPermissionReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserPermissionReq.QueryUserPermissionReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
