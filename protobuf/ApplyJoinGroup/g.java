package protobuf.ApplyJoinGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ApplyJoinGroup.ApplyJoinGroupRes;
/* loaded from: classes.dex */
class g extends AbstractParser<ApplyJoinGroupRes.ApplyJoinGroupResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public ApplyJoinGroupRes.ApplyJoinGroupResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ApplyJoinGroupRes.ApplyJoinGroupResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
