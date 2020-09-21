package protobuf.QueryGroupGrade;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
public final class QueryGroupGradeReqIdl extends Message {
    @ProtoField(tag = 4)
    public final DataReq data;

    private QueryGroupGradeReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<QueryGroupGradeReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(QueryGroupGradeReqIdl queryGroupGradeReqIdl) {
            super(queryGroupGradeReqIdl);
            if (queryGroupGradeReqIdl != null) {
                this.data = queryGroupGradeReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupGradeReqIdl build(boolean z) {
            return new QueryGroupGradeReqIdl(this, z);
        }
    }
}
