package protobuf.QueryGroupUserList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.UserInfo;
import protobuf.UserPermission;
/* loaded from: classes17.dex */
public final class DataRes extends Message {
    public static final Integer DEFAULT_MEMBERNUM = 0;
    public static final List<UserInfo> DEFAULT_USERLIST = Collections.emptyList();
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer memberNum;
    @ProtoField(tag = 3)
    public final UserPermission permission;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<UserInfo> userList;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.memberNum == null) {
                this.memberNum = DEFAULT_MEMBERNUM;
            } else {
                this.memberNum = builder.memberNum;
            }
            if (builder.userList == null) {
                this.userList = DEFAULT_USERLIST;
            } else {
                this.userList = immutableCopyOf(builder.userList);
            }
            this.permission = builder.permission;
            return;
        }
        this.memberNum = builder.memberNum;
        this.userList = immutableCopyOf(builder.userList);
        this.permission = builder.permission;
    }

    /* loaded from: classes17.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer memberNum;
        public UserPermission permission;
        public List<UserInfo> userList;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.memberNum = dataRes.memberNum;
                this.userList = DataRes.copyOf(dataRes.userList);
                this.permission = dataRes.permission;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
