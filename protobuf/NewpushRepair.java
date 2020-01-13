package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class NewpushRepair extends Message {
    public static final String DEFAULT_FOLLOWTYPE = "";
    public static final List<NewpushGroupRepair> DEFAULT_GROUPS = Collections.emptyList();
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String followType;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<NewpushGroupRepair> groups;

    private NewpushRepair(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.followType == null) {
                this.followType = "";
            } else {
                this.followType = builder.followType;
            }
            if (builder.groups == null) {
                this.groups = DEFAULT_GROUPS;
                return;
            } else {
                this.groups = immutableCopyOf(builder.groups);
                return;
            }
        }
        this.followType = builder.followType;
        this.groups = immutableCopyOf(builder.groups);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<NewpushRepair> {
        public String followType;
        public List<NewpushGroupRepair> groups;

        public Builder() {
        }

        public Builder(NewpushRepair newpushRepair) {
            super(newpushRepair);
            if (newpushRepair != null) {
                this.followType = newpushRepair.followType;
                this.groups = NewpushRepair.copyOf(newpushRepair.groups);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NewpushRepair build(boolean z) {
            return new NewpushRepair(this, z);
        }
    }
}
