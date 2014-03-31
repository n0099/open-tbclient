package protobuf.QueryForumDetail;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryForumDetail.QueryForumDetailReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryForumDetailReq.QueryForumDetailReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryForumDetailReq.QueryForumDetailReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
