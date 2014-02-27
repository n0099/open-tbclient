package protobuf.ReportGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ReportGroup.ReportGroupReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<ReportGroupReq.ReportGroupReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ReportGroupReq.ReportGroupReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
