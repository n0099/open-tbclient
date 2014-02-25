package protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.Im;
/* loaded from: classes.dex */
class v extends AbstractParser<Im.MsgInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public Im.MsgInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new Im.MsgInfo(codedInputStream, extensionRegistryLite, null);
    }
}
