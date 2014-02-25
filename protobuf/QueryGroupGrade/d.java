package protobuf.QueryGroupGrade;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupGrade.QueryGroupGradeReq;
/* loaded from: classes.dex */
class d extends AbstractParser<QueryGroupGradeReq.QueryGroupGradeReqIdl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupGradeReq.QueryGroupGradeReqIdl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupGradeReq.QueryGroupGradeReqIdl(codedInputStream, extensionRegistryLite, null);
    }
}
