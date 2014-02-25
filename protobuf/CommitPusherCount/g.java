package protobuf.CommitPusherCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitPusherCount.CommitPusherCountRes;
/* loaded from: classes.dex */
class g extends AbstractParser<CommitPusherCountRes.CommitPusherCountResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public CommitPusherCountRes.CommitPusherCountResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitPusherCountRes.CommitPusherCountResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
