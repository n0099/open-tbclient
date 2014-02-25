package protobuf.QueryUserInfos;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
class m extends AbstractParser<QueryUserInfosRes.QueryUserInfosResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryUserInfosRes.QueryUserInfosResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserInfosRes.QueryUserInfosResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
