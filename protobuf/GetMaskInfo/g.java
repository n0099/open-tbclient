package protobuf.GetMaskInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
class g extends AbstractParser<GetMaskInfoRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public GetMaskInfoRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetMaskInfoRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
