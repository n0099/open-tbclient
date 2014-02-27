package protobuf.UpdateGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateGroup.UpdateGroupReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<UpdateGroupReq.UpdateGroupReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateGroupReq.UpdateGroupReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
