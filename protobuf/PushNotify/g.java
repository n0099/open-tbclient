package protobuf.PushNotify;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<PushNotifyRes.PusherMsg> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new PushNotifyRes.PusherMsg(codedInputStream, extensionRegistryLite, null);
    }
}
