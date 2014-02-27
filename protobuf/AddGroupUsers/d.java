package protobuf.AddGroupUsers;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroupUsers.AddGroupUsersReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<AddGroupUsersReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupUsersReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
