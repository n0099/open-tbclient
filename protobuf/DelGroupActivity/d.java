package protobuf.DelGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupActivity.DelGroupActivityReq;
/* loaded from: classes.dex */
class d extends AbstractParser<DelGroupActivityReq.DelGroupActivityReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupActivityReq.DelGroupActivityReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupActivityReq.DelGroupActivityReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
