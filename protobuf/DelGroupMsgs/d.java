package protobuf.DelGroupMsgs;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupMsgs.DelGroupMsgsReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<DelGroupMsgsReq.DelGroupMsgsReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupMsgsReq.DelGroupMsgsReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
