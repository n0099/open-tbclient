package protobuf.QueryGroupsByLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GroupInfo;
/* loaded from: classes10.dex */
public final class Business extends Message {
    public static final String DEFAULT_BUSINESS = "";
    public static final List<GroupInfo> DEFAULT_GROUPS = Collections.emptyList();
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String business;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<GroupInfo> groups;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<Business> {
        public String business;
        public List<GroupInfo> groups;

        public Builder() {
        }

        public Builder(Business business) {
            super(business);
            if (business == null) {
                return;
            }
            this.business = business.business;
            this.groups = Message.copyOf(business.groups);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Business build(boolean z) {
            return new Business(this, z);
        }
    }

    public Business(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.business;
            if (str == null) {
                this.business = "";
            } else {
                this.business = str;
            }
            List<GroupInfo> list = builder.groups;
            if (list == null) {
                this.groups = DEFAULT_GROUPS;
                return;
            } else {
                this.groups = Message.immutableCopyOf(list);
                return;
            }
        }
        this.business = builder.business;
        this.groups = Message.immutableCopyOf(builder.groups);
    }
}
