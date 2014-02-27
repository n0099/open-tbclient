package protobuf.QueryGroupGrade;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryGroupGradeRes.MemberPerm, k> implements l {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupGradeRes.MemberPerm buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupGradeRes.MemberPerm.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupGradeRes.MemberPerm.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k b() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clear() {
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
    /* renamed from: d */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryGroupGradeRes.MemberPerm buildPartial() {
        QueryGroupGradeRes.MemberPerm memberPerm = new QueryGroupGradeRes.MemberPerm(this, (QueryGroupGradeRes.MemberPerm) null);
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
    public final k mergeFrom(QueryGroupGradeRes.MemberPerm memberPerm) {
        if (memberPerm != QueryGroupGradeRes.MemberPerm.getDefaultInstance()) {
            if (memberPerm.hasIsAuthor()) {
                int isAuthor = memberPerm.getIsAuthor();
                this.a |= 1;
                this.b = isAuthor;
            }
            if (memberPerm.hasCanCreateMember()) {
                int canCreateMember = memberPerm.getCanCreateMember();
                this.a |= 2;
                this.c = canCreateMember;
            }
            if (memberPerm.hasAlreadyCreateNum()) {
                int alreadyCreateNum = memberPerm.getAlreadyCreateNum();
                this.a |= 4;
                this.d = alreadyCreateNum;
            }
            if (memberPerm.hasLeftCreateNum()) {
                int leftCreateNum = memberPerm.getLeftCreateNum();
                this.a |= 8;
                this.e = leftCreateNum;
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
}
