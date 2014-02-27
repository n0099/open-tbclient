package protobuf.QueryGroupCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryGroupCount.QueryGroupCountReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<QueryGroupCountReq.DataReq, b> implements c {
    private int a;
    private double b;
    private double c;

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupCountReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupCountReq.DataReq.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b c() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public b clear() {
        super.clear();
        this.b = 0.0d;
        this.a &= -2;
        this.c = 0.0d;
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryGroupCountReq.DataReq build() {
        QueryGroupCountReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public final QueryGroupCountReq.DataReq buildPartial() {
        QueryGroupCountReq.DataReq dataReq = new QueryGroupCountReq.DataReq(this, (QueryGroupCountReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.lng_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.lat_ = this.c;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(QueryGroupCountReq.DataReq dataReq) {
        if (dataReq != QueryGroupCountReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasLng()) {
                a(dataReq.getLng());
            }
            if (dataReq.hasLat()) {
                b(dataReq.getLat());
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupCountReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                QueryGroupCountReq.DataReq parsePartialFrom = QueryGroupCountReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataReq = null;
                if (dataReq != null) {
                    mergeFrom(dataReq);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupCountReq.DataReq dataReq2 = (QueryGroupCountReq.DataReq) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataReq = dataReq2;
                th = th3;
                if (dataReq != null) {
                }
                throw th;
            }
        }
    }

    public final b a(double d) {
        this.a |= 1;
        this.b = d;
        return this;
    }

    public final b b(double d) {
        this.a |= 2;
        this.c = d;
        return this;
    }
}
