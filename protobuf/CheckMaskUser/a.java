package protobuf.CheckMaskUser;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CheckMaskUser.CheckMaskUserReq;
/* loaded from: classes.dex */
class a extends AbstractParser<CheckMaskUserReq.CheckMaskUserIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CheckMaskUserReq.CheckMaskUserIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CheckMaskUserReq.CheckMaskUserIdl(codedInputStream, extensionRegistryLite, null);
    }
}
