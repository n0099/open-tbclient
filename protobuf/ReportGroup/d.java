package protobuf.ReportGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ReportGroup.ReportGroupReq;
/* loaded from: classes.dex */
class d extends AbstractParser<ReportGroupReq.ReportGroupReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public ReportGroupReq.ReportGroupReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ReportGroupReq.ReportGroupReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
