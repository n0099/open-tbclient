package protobuf.UpgradeMemberGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<UpgradeMemberGroupRes.UpgradeMemberGroupResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpgradeMemberGroupRes.UpgradeMemberGroupResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
