package protobuf.QueryGroupGrade;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupGrade.QueryGroupGradeReq;
/* loaded from: classes.dex */
final class d extends AbstractParser<QueryGroupGradeReq.QueryGroupGradeReqIdl> {
    @Override // com.google.protobuf.Parser
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupGradeReq.QueryGroupGradeReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
