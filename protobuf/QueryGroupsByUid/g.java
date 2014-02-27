package protobuf.QueryGroupsByUid;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupsByUid.QueryGroupsByUidRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<QueryGroupsByUidRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupsByUidRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
