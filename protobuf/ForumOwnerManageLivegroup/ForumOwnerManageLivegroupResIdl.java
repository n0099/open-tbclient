package protobuf.ForumOwnerManageLivegroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class ForumOwnerManageLivegroupResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ ForumOwnerManageLivegroupResIdl(Builder builder, boolean z, ForumOwnerManageLivegroupResIdl forumOwnerManageLivegroupResIdl) {
        this(builder, z);
    }

    private ForumOwnerManageLivegroupResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<ForumOwnerManageLivegroupResIdl> {
        public DataRes data;
        public Error error;

        public Builder(ForumOwnerManageLivegroupResIdl forumOwnerManageLivegroupResIdl) {
            super(forumOwnerManageLivegroupResIdl);
            if (forumOwnerManageLivegroupResIdl != null) {
                this.error = forumOwnerManageLivegroupResIdl.error;
                this.data = forumOwnerManageLivegroupResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ForumOwnerManageLivegroupResIdl build(boolean z) {
            return new ForumOwnerManageLivegroupResIdl(this, z, null);
        }
    }
}
