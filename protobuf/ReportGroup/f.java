package protobuf.ReportGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.ReportGroup.ReportGroupReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<ReportGroupReq.ReportGroupReqIdl, f> implements g {
    private int a;
    private ReportGroupReq.DataReq b = ReportGroupReq.DataReq.getDefaultInstance();

    private f() {
        g();
    }

    private void g() {
    }

    public static f h() {
        return new f();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public f clear() {
        super.clear();
        this.b = ReportGroupReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public ReportGroupReq.ReportGroupReqIdl getDefaultInstanceForType() {
        return ReportGroupReq.ReportGroupReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ReportGroupReq.ReportGroupReqIdl build() {
        ReportGroupReq.ReportGroupReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public ReportGroupReq.ReportGroupReqIdl buildPartial() {
        ReportGroupReq.ReportGroupReqIdl reportGroupReqIdl = new ReportGroupReq.ReportGroupReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        reportGroupReqIdl.data_ = this.b;
        reportGroupReqIdl.bitField0_ = i;
        return reportGroupReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(ReportGroupReq.ReportGroupReqIdl reportGroupReqIdl) {
        if (reportGroupReqIdl != ReportGroupReq.ReportGroupReqIdl.getDefaultInstance() && reportGroupReqIdl.hasData()) {
            b(reportGroupReqIdl.getData());
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
    public f mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ReportGroupReq.ReportGroupReqIdl reportGroupReqIdl;
        Throwable th;
        try {
            try {
                ReportGroupReq.ReportGroupReqIdl parsePartialFrom = ReportGroupReq.ReportGroupReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                reportGroupReqIdl = null;
                if (reportGroupReqIdl != null) {
                    mergeFrom(reportGroupReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            ReportGroupReq.ReportGroupReqIdl reportGroupReqIdl2 = (ReportGroupReq.ReportGroupReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                reportGroupReqIdl = reportGroupReqIdl2;
                th = th3;
                if (reportGroupReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public f a(ReportGroupReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public f b(ReportGroupReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != ReportGroupReq.DataReq.getDefaultInstance()) {
            this.b = ReportGroupReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
