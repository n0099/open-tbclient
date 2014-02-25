package protobuf.QueryGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupActivity.QueryGroupActivityRes;
/* loaded from: classes.dex */
class g extends AbstractParser<QueryGroupActivityRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupActivityRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupActivityRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
