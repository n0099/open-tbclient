package protobuf.UpdateClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateClientInfo.UpdateClientInfoRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<UpdateClientInfoRes.UpdateClientInfoResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateClientInfoRes.UpdateClientInfoResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
