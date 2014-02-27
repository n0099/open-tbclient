package protobuf.UpdateGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateGroup.UpdateGroupRes;
/* loaded from: classes.dex */
final class d extends AbstractParser<UpdateGroupRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateGroupRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
