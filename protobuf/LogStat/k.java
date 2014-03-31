package protobuf.LogStat;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.LogStat.LogStatRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<LogStatRes.LogStatResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private LogStatRes.DataRes c = LogStatRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        LogStatRes.LogStatResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return LogStatRes.LogStatResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return LogStatRes.LogStatResIdl.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k a() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = LogStatRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public LogStatRes.LogStatResIdl buildPartial() {
        LogStatRes.LogStatResIdl logStatResIdl = new LogStatRes.LogStatResIdl(this, (LogStatRes.LogStatResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        logStatResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        logStatResIdl.data_ = this.c;
        logStatResIdl.bitField0_ = i2;
        return logStatResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(LogStatRes.LogStatResIdl logStatResIdl) {
        if (logStatResIdl != LogStatRes.LogStatResIdl.getDefaultInstance()) {
            if (logStatResIdl.hasError()) {
                Im.Error error = logStatResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (logStatResIdl.hasData()) {
                LogStatRes.DataRes data = logStatResIdl.getData();
                if ((this.a & 2) != 2 || this.c == LogStatRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = LogStatRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
                }
                this.a |= 2;
            }
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        LogStatRes.LogStatResIdl logStatResIdl;
        Throwable th;
        try {
            try {
                LogStatRes.LogStatResIdl parsePartialFrom = LogStatRes.LogStatResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                logStatResIdl = null;
                if (logStatResIdl != null) {
                    mergeFrom(logStatResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            LogStatRes.LogStatResIdl logStatResIdl2 = (LogStatRes.LogStatResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                logStatResIdl = logStatResIdl2;
                th = th3;
                if (logStatResIdl != null) {
                }
                throw th;
            }
        }
    }
}
