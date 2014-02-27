package protobuf.QueryGroupDetail;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupDetail.QueryGroupDetailRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<QueryGroupDetailRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupDetailRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
