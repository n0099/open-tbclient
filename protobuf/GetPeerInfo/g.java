package protobuf.GetPeerInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetPeerInfo.GetPeerInfoRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<GetPeerInfoRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetPeerInfoRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
