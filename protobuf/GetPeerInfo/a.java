package protobuf.GetPeerInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetPeerInfo.GetPeerInfoReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<GetPeerInfoReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetPeerInfoReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
