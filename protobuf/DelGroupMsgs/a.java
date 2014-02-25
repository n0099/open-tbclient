package protobuf.DelGroupMsgs;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupMsgs.DelGroupMsgsReq;
/* loaded from: classes.dex */
class a extends AbstractParser<DelGroupMsgsReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupMsgsReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupMsgsReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
