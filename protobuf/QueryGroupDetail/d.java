package protobuf.QueryGroupDetail;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupDetail.QueryGroupDetailReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryGroupDetailReq.QueryGroupDetailReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupDetailReq.QueryGroupDetailReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
