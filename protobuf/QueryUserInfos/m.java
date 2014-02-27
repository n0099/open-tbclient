package protobuf.QueryUserInfos;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
final class m extends AbstractParser<QueryUserInfosRes.QueryUserInfosResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserInfosRes.QueryUserInfosResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
