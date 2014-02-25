package protobuf.AddGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroupActivity.AddGroupActivityReq;
/* loaded from: classes.dex */
class d extends AbstractParser<AddGroupActivityReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public AddGroupActivityReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupActivityReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
