package protobuf.AddGroupUsers;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroupUsers.AddGroupUsersRes;
/* loaded from: classes.dex */
final class l extends AbstractParser<AddGroupUsersRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public AddGroupUsersRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupUsersRes.DataRes(codedInputStream, extensionRegistryLite);
    }
}
