package protobuf.DelGroupUsers;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupUsers.DelGroupUsersReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<DelGroupUsersReq.DelGroupUsersReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupUsersReq.DelGroupUsersReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
