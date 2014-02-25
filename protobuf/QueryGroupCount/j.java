package protobuf.QueryGroupCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryGroupCountRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupCountRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupCountRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
