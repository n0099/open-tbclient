package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class UserPermission extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer isGroupManager;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isGroupOwner;
    public static final Integer DEFAULT_ISGROUPOWNER = 0;
    public static final Integer DEFAULT_ISGROUPMANAGER = 0;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<UserPermission> {
        public Integer isGroupManager;
        public Integer isGroupOwner;

        public Builder() {
        }

        public Builder(UserPermission userPermission) {
            super(userPermission);
            if (userPermission == null) {
                return;
            }
            this.isGroupOwner = userPermission.isGroupOwner;
            this.isGroupManager = userPermission.isGroupManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserPermission build(boolean z) {
            return new UserPermission(this, z);
        }
    }

    public UserPermission(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isGroupOwner;
            if (num == null) {
                this.isGroupOwner = DEFAULT_ISGROUPOWNER;
            } else {
                this.isGroupOwner = num;
            }
            Integer num2 = builder.isGroupManager;
            if (num2 == null) {
                this.isGroupManager = DEFAULT_ISGROUPMANAGER;
                return;
            } else {
                this.isGroupManager = num2;
                return;
            }
        }
        this.isGroupOwner = builder.isGroupOwner;
        this.isGroupManager = builder.isGroupManager;
    }
}
