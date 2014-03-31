package protobuf.LogStat;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.LogStat.LogStatRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<LogStatRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new LogStatRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
