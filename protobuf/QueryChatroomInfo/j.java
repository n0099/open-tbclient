package protobuf.QueryChatroomInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryChatroomInfo.QueryChatroomInfoRes;
/* loaded from: classes.dex */
final class j extends AbstractParser<QueryChatroomInfoRes.QueryChatroomInfoResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryChatroomInfoRes.QueryChatroomInfoResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
