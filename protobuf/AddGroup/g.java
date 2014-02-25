package protobuf.AddGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroup.AddGroupRes;
/* loaded from: classes.dex */
class g extends AbstractParser<AddGroupRes.AddGroupResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public AddGroupRes.AddGroupResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupRes.AddGroupResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
