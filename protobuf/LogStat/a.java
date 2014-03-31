package protobuf.LogStat;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.LogStat.LogStatReq;
/* loaded from: classes.dex */
final class a extends AbstractParser<LogStatReq.DataReq> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new LogStatReq.DataReq(codedInputStream, extensionRegistryLite, null);
    }
}
