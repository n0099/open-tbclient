package protobuf.AddGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroupActivity.AddGroupActivityRes;
/* loaded from: classes.dex */
class g extends AbstractParser<AddGroupActivityRes.AddGroupActivityResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public AddGroupActivityRes.AddGroupActivityResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupActivityRes.AddGroupActivityResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
