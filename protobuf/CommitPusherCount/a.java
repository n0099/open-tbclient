package protobuf.CommitPusherCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitPusherCount.CommitPusherCountReq;
/* loaded from: classes.dex */
class a extends AbstractParser<CommitPusherCountReq.CommitPusherCountReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CommitPusherCountReq.CommitPusherCountReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitPusherCountReq.CommitPusherCountReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
