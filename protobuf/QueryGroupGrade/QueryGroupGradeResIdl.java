package protobuf.QueryGroupGrade;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes23.dex */
public final class QueryGroupGradeResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private QueryGroupGradeResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<QueryGroupGradeResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(QueryGroupGradeResIdl queryGroupGradeResIdl) {
            super(queryGroupGradeResIdl);
            if (queryGroupGradeResIdl != null) {
                this.error = queryGroupGradeResIdl.error;
                this.data = queryGroupGradeResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public QueryGroupGradeResIdl build(boolean z) {
            return new QueryGroupGradeResIdl(this, z);
        }
    }
}
