package protobuf.GetMaskInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
class j extends AbstractParser<GetMaskInfoRes.GetMaskInfoResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public GetMaskInfoRes.GetMaskInfoResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetMaskInfoRes.GetMaskInfoResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
