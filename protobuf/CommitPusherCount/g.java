package protobuf.CommitPusherCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.CommitPusherCount.CommitPusherCountRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<CommitPusherCountRes.CommitPusherCountResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CommitPusherCountRes.CommitPusherCountResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
