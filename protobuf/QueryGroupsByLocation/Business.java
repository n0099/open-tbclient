package protobuf.QueryGroupsByLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GroupInfo;
/* loaded from: classes.dex */
public final class Business extends Message {
    public static final String DEFAULT_BUSINESS = "";
    public static final List<GroupInfo> DEFAULT_GROUPS = Collections.emptyList();
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String business;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<GroupInfo> groups;

    /* synthetic */ Business(Builder builder, boolean z, Business business) {
        this(builder, z);
    }

    private Business(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.business == null) {
                this.business = "";
            } else {
                this.business = builder.business;
            }
            if (builder.groups == null) {
                this.groups = DEFAULT_GROUPS;
                return;
            } else {
                this.groups = immutableCopyOf(builder.groups);
                return;
            }
        }
        this.business = builder.business;
        this.groups = immutableCopyOf(builder.groups);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<Business> {
        public String business;
        public List<GroupInfo> groups;

        public Builder(Business business) {
            super(business);
            if (business != null) {
                this.business = business.business;
                this.groups = Business.copyOf(business.groups);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Business build(boolean z) {
            return new Business(this, z, null);
        }
    }
}
