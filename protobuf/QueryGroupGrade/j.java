package protobuf.QueryGroupGrade;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<QueryGroupGradeRes.DataRes, j> implements k {
    private int a;
    private Im.GroupInfo b = Im.GroupInfo.getDefaultInstance();
    private List<Im.GradeInfo> c = Collections.emptyList();
    private QueryGroupGradeRes.MemberPerm d = QueryGroupGradeRes.MemberPerm.getDefaultInstance();
    private List<Im.GradeInfo> e = Collections.emptyList();

    private j() {
        g();
    }

    private void g() {
    }

    public static j h() {
        return new j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public j clear() {
        super.clear();
        this.b = Im.GroupInfo.getDefaultInstance();
        this.a &= -2;
        this.c = Collections.emptyList();
        this.a &= -3;
        this.d = QueryGroupGradeRes.MemberPerm.getDefaultInstance();
        this.a &= -5;
        this.e = Collections.emptyList();
        this.a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupGradeRes.DataRes getDefaultInstanceForType() {
        return QueryGroupGradeRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupGradeRes.DataRes build() {
        QueryGroupGradeRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupGradeRes.DataRes buildPartial() {
        QueryGroupGradeRes.DataRes dataRes = new QueryGroupGradeRes.DataRes(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.groupInfo_ = this.b;
        if ((this.a & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
            this.a &= -3;
        }
        dataRes.gradeInfos_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        dataRes.memberPerm_ = this.d;
        if ((this.a & 8) == 8) {
            this.e = Collections.unmodifiableList(this.e);
            this.a &= -9;
        }
        dataRes.memberGradeInfos_ = this.e;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(QueryGroupGradeRes.DataRes dataRes) {
        List list;
        List list2;
        List list3;
        List<Im.GradeInfo> list4;
        List list5;
        List<Im.GradeInfo> list6;
        if (dataRes != QueryGroupGradeRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasGroupInfo()) {
                a(dataRes.getGroupInfo());
            }
            list = dataRes.gradeInfos_;
            if (!list.isEmpty()) {
                if (this.c.isEmpty()) {
                    list6 = dataRes.gradeInfos_;
                    this.c = list6;
                    this.a &= -3;
                } else {
                    i();
                    List<Im.GradeInfo> list7 = this.c;
                    list5 = dataRes.gradeInfos_;
                    list7.addAll(list5);
                }
            }
            if (dataRes.hasMemberPerm()) {
                a(dataRes.getMemberPerm());
            }
            list2 = dataRes.memberGradeInfos_;
            if (!list2.isEmpty()) {
                if (this.e.isEmpty()) {
                    list4 = dataRes.memberGradeInfos_;
                    this.e = list4;
                    this.a &= -9;
                } else {
                    j();
                    List<Im.GradeInfo> list8 = this.e;
                    list3 = dataRes.memberGradeInfos_;
                    list8.addAll(list3);
                }
            }
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x001e  */
    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupGradeRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryGroupGradeRes.DataRes parsePartialFrom = QueryGroupGradeRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataRes = null;
                if (dataRes != null) {
                    mergeFrom(dataRes);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupGradeRes.DataRes dataRes2 = (QueryGroupGradeRes.DataRes) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataRes = dataRes2;
                th = th3;
                if (dataRes != null) {
                }
                throw th;
            }
        }
    }

    public j a(Im.GroupInfo groupInfo) {
        if ((this.a & 1) == 1 && this.b != Im.GroupInfo.getDefaultInstance()) {
            this.b = Im.GroupInfo.newBuilder(this.b).mergeFrom(groupInfo).buildPartial();
        } else {
            this.b = groupInfo;
        }
        this.a |= 1;
        return this;
    }

    private void i() {
        if ((this.a & 2) != 2) {
            this.c = new ArrayList(this.c);
            this.a |= 2;
        }
    }

    public j a(QueryGroupGradeRes.MemberPerm memberPerm) {
        if ((this.a & 4) == 4 && this.d != QueryGroupGradeRes.MemberPerm.getDefaultInstance()) {
            this.d = QueryGroupGradeRes.MemberPerm.newBuilder(this.d).mergeFrom(memberPerm).buildPartial();
        } else {
            this.d = memberPerm;
        }
        this.a |= 4;
        return this;
    }

    private void j() {
        if ((this.a & 8) != 8) {
            this.e = new ArrayList(this.e);
            this.a |= 8;
        }
    }
}
