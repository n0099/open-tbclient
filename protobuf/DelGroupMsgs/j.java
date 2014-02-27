package protobuf.DelGroupMsgs;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupMsgs.DelGroupMsgsRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<DelGroupMsgsRes.DelGroupMsgsResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupMsgsRes.DelGroupMsgsResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
