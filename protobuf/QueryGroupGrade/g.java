package protobuf.QueryGroupGrade;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
final class g extends AbstractParser<QueryGroupGradeRes.DataRes> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupGradeRes.DataRes(codedInputStream, extensionRegistryLite, null);
    }
}
