package tbclient.GodFeed;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer has_attention_god;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer has_more;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer pn;
    @ProtoField(label = Message.Label.REPEATED, tag = 4)
    public final List<ThreadInfo> thread_list;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long timeline;
    public static final Long DEFAULT_TIMELINE = 0L;
    public static final Integer DEFAULT_HAS_MORE = 0;
    public static final List<ThreadInfo> DEFAULT_THREAD_LIST = Collections.emptyList();
    public static final Integer DEFAULT_PN = 0;
    public static final Integer DEFAULT_HAS_ATTENTION_GOD = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.timeline == null) {
                this.timeline = DEFAULT_TIMELINE;
            } else {
                this.timeline = builder.timeline;
            }
            if (builder.has_more == null) {
                this.has_more = DEFAULT_HAS_MORE;
            } else {
                this.has_more = builder.has_more;
            }
            if (builder.thread_list == null) {
                this.thread_list = DEFAULT_THREAD_LIST;
            } else {
                this.thread_list = immutableCopyOf(builder.thread_list);
            }
            if (builder.pn == null) {
                this.pn = DEFAULT_PN;
            } else {
                this.pn = builder.pn;
            }
            if (builder.has_attention_god == null) {
                this.has_attention_god = DEFAULT_HAS_ATTENTION_GOD;
                return;
            } else {
                this.has_attention_god = builder.has_attention_god;
                return;
            }
        }
        this.timeline = builder.timeline;
        this.has_more = builder.has_more;
        this.thread_list = immutableCopyOf(builder.thread_list);
        this.pn = builder.pn;
        this.has_attention_god = builder.has_attention_god;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer has_attention_god;
        public Integer has_more;
        public Integer pn;
        public List<ThreadInfo> thread_list;
        public Long timeline;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.timeline = dataRes.timeline;
                this.has_more = dataRes.has_more;
                this.thread_list = DataRes.copyOf(dataRes.thread_list);
                this.pn = dataRes.pn;
                this.has_attention_god = dataRes.has_attention_god;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
