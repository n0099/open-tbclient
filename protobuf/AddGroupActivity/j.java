package protobuf.AddGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.AddGroupActivity.AddGroupActivityRes;
/* loaded from: classes.dex */
class j extends AbstractParser<AddGroupActivityRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public AddGroupActivityRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new AddGroupActivityRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
