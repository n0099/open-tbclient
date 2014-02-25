package protobuf.DelGroupMsgs;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupMsgs.DelGroupMsgsRes;
/* loaded from: classes.dex */
class j extends AbstractParser<DelGroupMsgsRes.DelGroupMsgsResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupMsgsRes.DelGroupMsgsResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupMsgsRes.DelGroupMsgsResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
