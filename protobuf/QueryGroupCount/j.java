package protobuf.QueryGroupCount;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<QueryGroupCountRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupCountRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
