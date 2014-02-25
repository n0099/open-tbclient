package protobuf.GetPeerInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetPeerInfo.GetPeerInfoRes;
/* loaded from: classes.dex */
class j extends AbstractParser<GetPeerInfoRes.GetPeerInfoResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public GetPeerInfoRes.GetPeerInfoResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetPeerInfoRes.GetPeerInfoResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
