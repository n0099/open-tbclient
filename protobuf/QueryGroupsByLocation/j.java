package protobuf.QueryGroupsByLocation;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryGroupsByLocationRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupsByLocationRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByLocationRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
