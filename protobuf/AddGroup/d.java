package protobuf.AddGroup;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroup.AddGroupReq;
/* loaded from: classes.dex */
class d extends AbstractParser<AddGroupReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public AddGroupReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
