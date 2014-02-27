package protobuf.PushNotify;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
final class d extends AbstractParser<PushNotifyRes.PushNotifyResIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new PushNotifyRes.PushNotifyResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
