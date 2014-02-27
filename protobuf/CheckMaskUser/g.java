package protobuf.CheckMaskUser;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CheckMaskUser.CheckMaskUserRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<CheckMaskUserRes.CheckMaskUserResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CheckMaskUserRes.CheckMaskUserResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
