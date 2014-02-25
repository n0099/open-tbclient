package protobuf.UpdateClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateClientInfo.UpdateClientInfoReq;
/* loaded from: classes.dex */
class a extends AbstractParser<UpdateClientInfoReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpdateClientInfoReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateClientInfoReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
