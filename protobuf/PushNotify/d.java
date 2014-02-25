package protobuf.PushNotify;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
class d extends AbstractParser<PushNotifyRes.PushNotifyResIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public PushNotifyRes.PushNotifyResIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new PushNotifyRes.PushNotifyResIdl(codedInputStream, extensionRegistryLite, null);
    }
}
