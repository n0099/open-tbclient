package protobuf.QueryGroupDetail;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupDetail.QueryGroupDetailRes;
/* loaded from: classes.dex */
class g extends AbstractParser<QueryGroupDetailRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupDetailRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupDetailRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
