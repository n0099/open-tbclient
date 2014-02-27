package protobuf.QueryUserInfos;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryUserInfos.QueryUserInfosReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<QueryUserInfosReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryUserInfosReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
