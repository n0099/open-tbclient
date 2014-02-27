package protobuf.DelGroupUsers;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupUsers.DelGroupUsersRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<DelGroupUsersRes.DelGroupUsersResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupUsersRes.DelGroupUsersResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
