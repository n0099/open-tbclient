package protobuf.PushNotify;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.PushNotify.PushNotifyReq;
/* loaded from: classes.dex */
final class b extends AbstractParser<PushNotifyReq.PushNotifyReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public PushNotifyReq.PushNotifyReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new PushNotifyReq.PushNotifyReqIdl(codedInputStream, extensionRegistryLite);
    }
}
