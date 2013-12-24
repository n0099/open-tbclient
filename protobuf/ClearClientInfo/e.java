package protobuf.ClearClientInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.ClearClientInfo.ClearClientInfoReq;
/* loaded from: classes.dex */
final class e extends AbstractParser<ClearClientInfoReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public ClearClientInfoReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ClearClientInfoReq.DataReq(codedInputStream, extensionRegistryLite);
    }
}
