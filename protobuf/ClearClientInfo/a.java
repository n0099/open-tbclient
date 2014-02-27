package protobuf.ClearClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ClearClientInfo.ClearClientInfoReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<ClearClientInfoReq.ClearClientInfoReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ClearClientInfoReq.ClearClientInfoReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
