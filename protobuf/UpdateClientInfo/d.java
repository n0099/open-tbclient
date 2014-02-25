package protobuf.UpdateClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateClientInfo.UpdateClientInfoReq;
/* loaded from: classes.dex */
class d extends AbstractParser<UpdateClientInfoReq.UpdateClientInfoReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpdateClientInfoReq.UpdateClientInfoReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateClientInfoReq.UpdateClientInfoReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
