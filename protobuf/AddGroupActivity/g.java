package protobuf.AddGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroupActivity.AddGroupActivityRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<AddGroupActivityRes.AddGroupActivityResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupActivityRes.AddGroupActivityResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
