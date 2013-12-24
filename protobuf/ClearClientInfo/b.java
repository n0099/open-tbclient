package protobuf.ClearClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ClearClientInfo.ClearClientInfoReq;
/* loaded from: classes.dex */
final class b extends AbstractParser<ClearClientInfoReq.ClearClientInfoReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public ClearClientInfoReq.ClearClientInfoReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ClearClientInfoReq.ClearClientInfoReqIdl(codedInputStream, extensionRegistryLite);
    }
}
