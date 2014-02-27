package protobuf.ApplyJoinGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ApplyJoinGroup.ApplyJoinGroupRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<ApplyJoinGroupRes.ApplyJoinGroupResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ApplyJoinGroupRes.ApplyJoinGroupResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
