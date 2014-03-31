package protobuf.QueryForumDetail;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryForumDetail.QueryForumDetailRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<QueryForumDetailRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryForumDetailRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
