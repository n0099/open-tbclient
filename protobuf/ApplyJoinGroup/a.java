package protobuf.ApplyJoinGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ApplyJoinGroup.ApplyJoinGroupReq;
/* loaded from: classes.dex */
class a extends AbstractParser<ApplyJoinGroupReq.ApplyJoinGroupReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public ApplyJoinGroupReq.ApplyJoinGroupReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ApplyJoinGroupReq.ApplyJoinGroupReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
