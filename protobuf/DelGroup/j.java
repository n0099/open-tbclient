package protobuf.DelGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroup.DelGroupRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<DelGroupRes.DelGroupResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupRes.DelGroupResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
