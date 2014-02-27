package protobuf.GetMaskInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetMaskInfo.GetMaskInfoReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<GetMaskInfoReq.GetMaskInfoReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetMaskInfoReq.GetMaskInfoReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
