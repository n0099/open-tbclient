package protobuf.GetMaskInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<GetMaskInfoRes.GetMaskInfoResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetMaskInfoRes.GetMaskInfoResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
