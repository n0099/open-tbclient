package protobuf.DelGroupUsers;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupUsers.DelGroupUsersReq;
/* loaded from: classes.dex */
class d extends AbstractParser<DelGroupUsersReq.DelGroupUsersReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupUsersReq.DelGroupUsersReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupUsersReq.DelGroupUsersReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
