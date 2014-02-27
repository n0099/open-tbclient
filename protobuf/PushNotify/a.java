package protobuf.PushNotify;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.PushNotify.PushNotifyReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<PushNotifyReq.PushNotifyReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new PushNotifyReq.PushNotifyReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
