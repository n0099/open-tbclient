package protobuf.UpgradeMemberGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<UpgradeMemberGroupReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpgradeMemberGroupReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
