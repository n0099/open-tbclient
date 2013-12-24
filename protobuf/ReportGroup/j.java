package protobuf.ReportGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.ReportGroup.ReportGroupRes;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<ReportGroupRes.ReportGroupResIdl, j> implements k {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();

    private j() {
        g();
    }

    private void g() {
    }

    public static j h() {
        return new j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public j clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public ReportGroupRes.ReportGroupResIdl getDefaultInstanceForType() {
        return ReportGroupRes.ReportGroupResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ReportGroupRes.ReportGroupResIdl build() {
        ReportGroupRes.ReportGroupResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public ReportGroupRes.ReportGroupResIdl buildPartial() {
        ReportGroupRes.ReportGroupResIdl reportGroupResIdl = new ReportGroupRes.ReportGroupResIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        reportGroupResIdl.error_ = this.b;
        reportGroupResIdl.bitField0_ = i;
        return reportGroupResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(ReportGroupRes.ReportGroupResIdl reportGroupResIdl) {
        if (reportGroupResIdl != ReportGroupRes.ReportGroupResIdl.getDefaultInstance() && reportGroupResIdl.hasError()) {
            a(reportGroupResIdl.getError());
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
    public j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ReportGroupRes.ReportGroupResIdl reportGroupResIdl;
        Throwable th;
        try {
            try {
                ReportGroupRes.ReportGroupResIdl parsePartialFrom = ReportGroupRes.ReportGroupResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                reportGroupResIdl = null;
                if (reportGroupResIdl != null) {
                    mergeFrom(reportGroupResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            ReportGroupRes.ReportGroupResIdl reportGroupResIdl2 = (ReportGroupRes.ReportGroupResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                reportGroupResIdl = reportGroupResIdl2;
                th = th3;
                if (reportGroupResIdl != null) {
                }
                throw th;
            }
        }
    }

    public j a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }
}
