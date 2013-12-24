package protobuf.ReportGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ReportGroup.ReportGroupReq;
/* loaded from: classes.dex */
final class b extends AbstractParser<ReportGroupReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public ReportGroupReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ReportGroupReq.DataReq(codedInputStream, extensionRegistryLite);
    }
}
