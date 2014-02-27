package protobuf.AddGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroup.AddGroupReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<AddGroupReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
