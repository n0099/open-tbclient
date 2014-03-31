package protobuf.QueryForumDetail;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryForumDetail.QueryForumDetailRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<QueryForumDetailRes.QueryForumDetailResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryForumDetailRes.QueryForumDetailResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
