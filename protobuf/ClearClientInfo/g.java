package protobuf.ClearClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ClearClientInfo.ClearClientInfoRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<ClearClientInfoRes.ClearClientInfoResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ClearClientInfoRes.ClearClientInfoResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
