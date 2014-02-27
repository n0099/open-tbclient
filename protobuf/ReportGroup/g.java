package protobuf.ReportGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ReportGroup.ReportGroupRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<ReportGroupRes.ReportGroupResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ReportGroupRes.ReportGroupResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
