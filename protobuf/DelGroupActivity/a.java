package protobuf.DelGroupActivity;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.DelGroupActivity.DelGroupActivityReq;
/* loaded from: classes.dex */
class a extends AbstractParser<DelGroupActivityReq.DataReq> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public DelGroupActivityReq.DataReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DelGroupActivityReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
