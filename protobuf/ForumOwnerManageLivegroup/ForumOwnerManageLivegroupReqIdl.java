package protobuf.ForumOwnerManageLivegroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ForumOwnerManageLivegroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ ForumOwnerManageLivegroupReqIdl(Builder builder, boolean z, ForumOwnerManageLivegroupReqIdl forumOwnerManageLivegroupReqIdl) {
        this(builder, z);
    }

    private ForumOwnerManageLivegroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<ForumOwnerManageLivegroupReqIdl> {
        public DataReq data;

        public Builder(ForumOwnerManageLivegroupReqIdl forumOwnerManageLivegroupReqIdl) {
            super(forumOwnerManageLivegroupReqIdl);
            if (forumOwnerManageLivegroupReqIdl != null) {
                this.data = forumOwnerManageLivegroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ForumOwnerManageLivegroupReqIdl build(boolean z) {
            return new ForumOwnerManageLivegroupReqIdl(this, z, null);
        }
    }
}
