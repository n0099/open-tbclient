package protobuf.ApplyJoinGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ApplyJoinGroup.ApplyJoinGroupReq;
/* loaded from: classes.dex */
class d extends AbstractParser<ApplyJoinGroupReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public ApplyJoinGroupReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ApplyJoinGroupReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
