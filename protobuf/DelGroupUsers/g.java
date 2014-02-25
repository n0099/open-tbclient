package protobuf.DelGroupUsers;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupUsers.DelGroupUsersRes;
/* loaded from: classes.dex */
class g extends AbstractParser<DelGroupUsersRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupUsersRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupUsersRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
