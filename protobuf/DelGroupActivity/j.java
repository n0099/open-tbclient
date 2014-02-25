package protobuf.DelGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupActivity.DelGroupActivityRes;
/* loaded from: classes.dex */
class j extends AbstractParser<DelGroupActivityRes.DelGroupActivityResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupActivityRes.DelGroupActivityResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupActivityRes.DelGroupActivityResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
