package protobuf.PushNotify;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
class g extends AbstractParser<PushNotifyRes.PusherMsg> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public PushNotifyRes.PusherMsg parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new PushNotifyRes.PusherMsg(codedInputStream, extensionRegistryLite, null);
    }
}
