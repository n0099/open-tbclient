package protobuf.QueryUserInfos;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserInfos.QueryUserInfosReq;
/* loaded from: classes.dex */
class a extends AbstractParser<QueryUserInfosReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryUserInfosReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserInfosReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
