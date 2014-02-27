package protobuf.DelGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroup.DelGroupReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<DelGroupReq.DelGroupReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupReq.DelGroupReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
