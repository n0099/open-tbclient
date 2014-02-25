package protobuf.QueryUserPermission;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserPermission.QueryUserPermissionReq;
/* loaded from: classes.dex */
class a extends AbstractParser<QueryUserPermissionReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryUserPermissionReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserPermissionReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
