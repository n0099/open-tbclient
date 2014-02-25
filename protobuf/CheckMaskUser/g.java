package protobuf.CheckMaskUser;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CheckMaskUser.CheckMaskUserRes;
/* loaded from: classes.dex */
class g extends AbstractParser<CheckMaskUserRes.CheckMaskUserResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CheckMaskUserRes.CheckMaskUserResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CheckMaskUserRes.CheckMaskUserResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
