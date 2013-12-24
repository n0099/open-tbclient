package protobuf.UpdateGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateGroup.UpdateGroupRes;
/* loaded from: classes.dex */
final class i extends AbstractParser<UpdateGroupRes.UpdateGroupResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpdateGroupRes.UpdateGroupResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateGroupRes.UpdateGroupResIdl(codedInputStream, extensionRegistryLite);
    }
}
