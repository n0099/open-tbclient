package protobuf.UpdateGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateGroup.UpdateGroupRes;
/* loaded from: classes.dex */
class d extends AbstractParser<UpdateGroupRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpdateGroupRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateGroupRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
