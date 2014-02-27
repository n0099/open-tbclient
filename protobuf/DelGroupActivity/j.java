package protobuf.DelGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupActivity.DelGroupActivityRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<DelGroupActivityRes.DelGroupActivityResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupActivityRes.DelGroupActivityResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
