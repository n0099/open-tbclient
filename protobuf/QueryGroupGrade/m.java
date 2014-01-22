package protobuf.QueryGroupGrade;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<QueryGroupGradeRes.MemberPerm, m> implements n {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;

    private m() {
        g();
    }

    private void g() {
    }

    public static m h() {
        return new m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public m clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public m clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupGradeRes.MemberPerm getDefaultInstanceForType() {
        return QueryGroupGradeRes.MemberPerm.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupGradeRes.MemberPerm build() {
        QueryGroupGradeRes.MemberPerm buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupGradeRes.MemberPerm buildPartial() {
        QueryGroupGradeRes.MemberPerm memberPerm = new QueryGroupGradeRes.MemberPerm(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        memberPerm.isAuthor_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        memberPerm.canCreateMember_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        memberPerm.alreadyCreateNum_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        memberPerm.leftCreateNum_ = this.e;
        memberPerm.bitField0_ = i2;
        return memberPerm;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(QueryGroupGradeRes.MemberPerm memberPerm) {
        if (memberPerm != QueryGroupGradeRes.MemberPerm.getDefaultInstance()) {
            if (memberPerm.hasIsAuthor()) {
                a(memberPerm.getIsAuthor());
            }
            if (memberPerm.hasCanCreateMember()) {
                b(memberPerm.getCanCreateMember());
            }
            if (memberPerm.hasAlreadyCreateNum()) {
                c(memberPerm.getAlreadyCreateNum());
            }
            if (memberPerm.hasLeftCreateNum()) {
                d(memberPerm.getLeftCreateNum());
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
    public m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupGradeRes.MemberPerm memberPerm;
        Throwable th;
        try {
            try {
                QueryGroupGradeRes.MemberPerm parsePartialFrom = QueryGroupGradeRes.MemberPerm.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                memberPerm = null;
                if (memberPerm != null) {
                    mergeFrom(memberPerm);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupGradeRes.MemberPerm memberPerm2 = (QueryGroupGradeRes.MemberPerm) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                memberPerm = memberPerm2;
                th = th3;
                if (memberPerm != null) {
                }
                throw th;
            }
        }
    }

    public m a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public m b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public m c(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public m d(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }
}
