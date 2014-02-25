package protobuf.DelGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupActivity.DelGroupActivityRes;
/* loaded from: classes.dex */
class g extends AbstractParser<DelGroupActivityRes.DataRes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupActivityRes.DataRes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupActivityRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
