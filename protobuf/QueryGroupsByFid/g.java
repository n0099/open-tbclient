package protobuf.QueryGroupsByFid;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByFid.QueryGroupsByFidRes;
/* loaded from: classes.dex */
class g extends AbstractParser<QueryGroupsByFidRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupsByFidRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByFidRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
