package protobuf.ClearClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ClearClientInfo.ClearClientInfoRes;
/* loaded from: classes.dex */
final class i extends AbstractParser<ClearClientInfoRes.ClearClientInfoResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public ClearClientInfoRes.ClearClientInfoResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ClearClientInfoRes.ClearClientInfoResIdl(codedInputStream, extensionRegistryLite);
    }
}
