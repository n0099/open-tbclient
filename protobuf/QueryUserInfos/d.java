package protobuf.QueryUserInfos;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserInfos.QueryUserInfosReq;
/* loaded from: classes.dex */
class d extends AbstractParser<QueryUserInfosReq.QueryUserInfosReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryUserInfosReq.QueryUserInfosReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserInfosReq.QueryUserInfosReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
