package protobuf.UpdateMaskInfo;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<UpdateMaskInfoReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new UpdateMaskInfoReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
