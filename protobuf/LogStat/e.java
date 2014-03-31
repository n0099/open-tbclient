package protobuf.LogStat;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.LogStat.LogStatReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<LogStatReq.LogStatReqIdl, e> implements f {
    private int a;
    private LogStatReq.DataReq b = LogStatReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return LogStatReq.LogStatReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return LogStatReq.LogStatReqIdl.getDefaultInstance();
    }

    private e() {
    }

    public static /* synthetic */ e b() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public e clear() {
        super.clear();
        this.b = LogStatReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public e clone() {
        return new e().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final LogStatReq.LogStatReqIdl build() {
        LogStatReq.LogStatReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public LogStatReq.LogStatReqIdl buildPartial() {
        LogStatReq.LogStatReqIdl logStatReqIdl = new LogStatReq.LogStatReqIdl(this, (LogStatReq.LogStatReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        logStatReqIdl.data_ = this.b;
        logStatReqIdl.bitField0_ = i;
        return logStatReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(LogStatReq.LogStatReqIdl logStatReqIdl) {
        if (logStatReqIdl != LogStatReq.LogStatReqIdl.getDefaultInstance() && logStatReqIdl.hasData()) {
            LogStatReq.DataReq data = logStatReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == LogStatReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = LogStatReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
            }
            this.a |= 1;
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x001e  */
    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        LogStatReq.LogStatReqIdl logStatReqIdl;
        Throwable th;
        try {
            try {
                LogStatReq.LogStatReqIdl parsePartialFrom = LogStatReq.LogStatReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                logStatReqIdl = null;
                if (logStatReqIdl != null) {
                    mergeFrom(logStatReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            LogStatReq.LogStatReqIdl logStatReqIdl2 = (LogStatReq.LogStatReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                logStatReqIdl = logStatReqIdl2;
                th = th3;
                if (logStatReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(LogStatReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
