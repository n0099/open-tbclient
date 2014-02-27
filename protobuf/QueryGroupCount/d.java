package protobuf.QueryGroupCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupCount.QueryGroupCountReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryGroupCountReq.QueryGroupCountReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupCountReq.QueryGroupCountReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
