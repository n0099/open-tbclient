package protobuf.UpdateMaskInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReq;
/* loaded from: classes.dex */
class d extends AbstractParser<UpdateMaskInfoReq.UpdateMaskInfoReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpdateMaskInfoReq.UpdateMaskInfoReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateMaskInfoReq.UpdateMaskInfoReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
