package protobuf.ClearClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ClearClientInfo.ClearClientInfoRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<ClearClientInfoRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ClearClientInfoRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
