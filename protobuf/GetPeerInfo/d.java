package protobuf.GetPeerInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetPeerInfo.GetPeerInfoReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<GetPeerInfoReq.GetPeerInfoReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetPeerInfoReq.GetPeerInfoReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
