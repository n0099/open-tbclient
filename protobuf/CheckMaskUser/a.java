package protobuf.CheckMaskUser;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CheckMaskUser.CheckMaskUserReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<CheckMaskUserReq.CheckMaskUserIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CheckMaskUserReq.CheckMaskUserIdl(codedInputStream, extensionRegistryLite, null);
    }
}
