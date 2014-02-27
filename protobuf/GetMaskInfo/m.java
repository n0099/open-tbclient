package protobuf.GetMaskInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
final class m extends AbstractParser<GetMaskInfoRes.UserInfo> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new GetMaskInfoRes.UserInfo(codedInputStream, extensionRegistryLite, null);
    }
}
