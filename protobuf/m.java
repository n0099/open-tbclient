package protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.Im;
/* loaded from: classes.dex */
final class m extends AbstractParser<Im.GroupLastId> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new Im.GroupLastId(codedInputStream, extensionRegistryLite, null);
    }
}
