package protobuf.GetMaskInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetMaskInfo.GetMaskInfoReq;
/* loaded from: classes.dex */
class a extends AbstractParser<GetMaskInfoReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public GetMaskInfoReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetMaskInfoReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
