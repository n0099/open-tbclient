package protobuf.SendXiubaSysMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_GROUPNAME = "";
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_USERNAME = "";
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String groupName;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer likers;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer listeners;
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.STRING)
    public final List<String> openId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer userId;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String userName;
    public static final Integer DEFAULT_LISTENERS = 0;
    public static final Integer DEFAULT_LIKERS = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final List<String> DEFAULT_OPENID = Collections.emptyList();

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.listeners == null) {
                this.listeners = DEFAULT_LISTENERS;
            } else {
                this.listeners = builder.listeners;
            }
            if (builder.likers == null) {
                this.likers = DEFAULT_LIKERS;
            } else {
                this.likers = builder.likers;
            }
            if (builder.intro == null) {
                this.intro = "";
            } else {
                this.intro = builder.intro;
            }
            if (builder.userName == null) {
                this.userName = "";
            } else {
                this.userName = builder.userName;
            }
            if (builder.groupName == null) {
                this.groupName = "";
            } else {
                this.groupName = builder.groupName;
            }
            if (builder.content == null) {
                this.content = "";
            } else {
                this.content = builder.content;
            }
            if (builder.userId == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = builder.userId;
            }
            if (builder.openId == null) {
                this.openId = DEFAULT_OPENID;
                return;
            } else {
                this.openId = immutableCopyOf(builder.openId);
                return;
            }
        }
        this.listeners = builder.listeners;
        this.likers = builder.likers;
        this.intro = builder.intro;
        this.userName = builder.userName;
        this.groupName = builder.groupName;
        this.content = builder.content;
        this.userId = builder.userId;
        this.openId = immutableCopyOf(builder.openId);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public String content;
        public String groupName;
        public String intro;
        public Integer likers;
        public Integer listeners;
        public List<String> openId;
        public Integer userId;
        public String userName;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.listeners = dataReq.listeners;
                this.likers = dataReq.likers;
                this.intro = dataReq.intro;
                this.userName = dataReq.userName;
                this.groupName = dataReq.groupName;
                this.content = dataReq.content;
                this.userId = dataReq.userId;
                this.openId = DataReq.copyOf(dataReq.openId);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
