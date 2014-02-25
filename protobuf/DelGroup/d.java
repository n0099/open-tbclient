package protobuf.DelGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroup.DelGroupReq;
/* loaded from: classes.dex */
class d extends AbstractParser<DelGroupReq.DelGroupReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupReq.DelGroupReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupReq.DelGroupReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
