package protobuf.QueryGroupGrade;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GradeInfo;
import protobuf.GroupInfo;
/* loaded from: classes23.dex */
public final class DataRes extends Message {
    public static final List<GradeInfo> DEFAULT_GRADEINFOS = Collections.emptyList();
    public static final List<GradeInfo> DEFAULT_MEMBERGRADEINFOS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<GradeInfo> gradeInfos;
    @ProtoField(tag = 1)
    public final GroupInfo groupInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 4)
    public final List<GradeInfo> memberGradeInfos;
    @ProtoField(tag = 3)
    public final MemberPerm memberPerm;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.groupInfo = builder.groupInfo;
            if (builder.gradeInfos == null) {
                this.gradeInfos = DEFAULT_GRADEINFOS;
            } else {
                this.gradeInfos = immutableCopyOf(builder.gradeInfos);
            }
            this.memberPerm = builder.memberPerm;
            if (builder.memberGradeInfos == null) {
                this.memberGradeInfos = DEFAULT_MEMBERGRADEINFOS;
                return;
            } else {
                this.memberGradeInfos = immutableCopyOf(builder.memberGradeInfos);
                return;
            }
        }
        this.groupInfo = builder.groupInfo;
        this.gradeInfos = immutableCopyOf(builder.gradeInfos);
        this.memberPerm = builder.memberPerm;
        this.memberGradeInfos = immutableCopyOf(builder.memberGradeInfos);
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public List<GradeInfo> gradeInfos;
        public GroupInfo groupInfo;
        public List<GradeInfo> memberGradeInfos;
        public MemberPerm memberPerm;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groupInfo = dataRes.groupInfo;
                this.gradeInfos = DataRes.copyOf(dataRes.gradeInfos);
                this.memberPerm = dataRes.memberPerm;
                this.memberGradeInfos = DataRes.copyOf(dataRes.memberGradeInfos);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
