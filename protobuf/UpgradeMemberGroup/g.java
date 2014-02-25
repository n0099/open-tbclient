package protobuf.UpgradeMemberGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupRes;
/* loaded from: classes.dex */
class g extends AbstractParser<UpgradeMemberGroupRes.UpgradeMemberGroupResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpgradeMemberGroupRes.UpgradeMemberGroupResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpgradeMemberGroupRes.UpgradeMemberGroupResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
