package protobuf.QueryUserPermission;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserPermission.QueryUserPermissionRes;
/* loaded from: classes.dex */
final class i extends AbstractParser<QueryUserPermissionRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryUserPermissionRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserPermissionRes.DataRes(codedInputStream, extensionRegistryLite);
    }
}
