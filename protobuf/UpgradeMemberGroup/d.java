package protobuf.UpgradeMemberGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupReq;
/* loaded from: classes.dex */
class d extends AbstractParser<UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
