package protobuf.AddGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroupActivity.AddGroupActivityReq;
/* loaded from: classes.dex */
class a extends AbstractParser<AddGroupActivityReq.AddGroupActivityReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public AddGroupActivityReq.AddGroupActivityReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupActivityReq.AddGroupActivityReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
