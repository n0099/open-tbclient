package protobuf.QueryGroupGrade;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
class j extends AbstractParser<QueryGroupGradeRes.MemberPerm> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    /* renamed from: a */
    public QueryGroupGradeRes.MemberPerm parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new QueryGroupGradeRes.MemberPerm(codedInputStream, extensionRegistryLite, null);
    }
}
