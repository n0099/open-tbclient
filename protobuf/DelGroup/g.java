package protobuf.DelGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroup.DelGroupRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<DelGroupRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
