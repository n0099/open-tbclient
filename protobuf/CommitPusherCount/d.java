package protobuf.CommitPusherCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitPusherCount.CommitPusherCountReq;
/* loaded from: classes.dex */
class d extends AbstractParser<CommitPusherCountReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CommitPusherCountReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitPusherCountReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
