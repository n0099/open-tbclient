package protobuf.AddGroupUsers;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroupUsers.AddGroupUsersRes;
/* loaded from: classes.dex */
class g extends AbstractParser<AddGroupUsersRes.AddGroupUsersResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public AddGroupUsersRes.AddGroupUsersResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupUsersRes.AddGroupUsersResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
