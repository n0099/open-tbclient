package protobuf.GetPeerInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetPeerInfo.GetPeerInfoRes;
/* loaded from: classes.dex */
class g extends AbstractParser<GetPeerInfoRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public GetPeerInfoRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetPeerInfoRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
