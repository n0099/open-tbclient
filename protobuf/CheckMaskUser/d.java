package protobuf.CheckMaskUser;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CheckMaskUser.CheckMaskUserReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<CheckMaskUserReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CheckMaskUserReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
