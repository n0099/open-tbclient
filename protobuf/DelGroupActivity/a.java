package protobuf.DelGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupActivity.DelGroupActivityReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<DelGroupActivityReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupActivityReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
