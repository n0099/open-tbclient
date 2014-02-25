package protobuf.UpdateClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateClientInfo.UpdateClientInfoRes;
/* loaded from: classes.dex */
class g extends AbstractParser<UpdateClientInfoRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public UpdateClientInfoRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateClientInfoRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
