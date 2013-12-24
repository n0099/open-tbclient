package protobuf.DelGroupUsers;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupUsers.DelGroupUsersReq;
/* loaded from: classes.dex */
final class b extends AbstractParser<DelGroupUsersReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupUsersReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupUsersReq.DataReq(codedInputStream, extensionRegistryLite);
    }
}
