package protobuf.UpdateClientInfo;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.UpdateClientInfo.UpdateClientInfoReq;
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite.Builder<UpdateClientInfoReq.DataReq, c> implements d {
    private int a;
    private Object b = "";
    private Object c = "";
    private ByteString d = ByteString.EMPTY;
    private double e;
    private double f;
    private int g;
    private int h;
    private int i;

    private c() {
        g();
    }

    private void g() {
    }

    public static c h() {
        return new c();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public c clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = ByteString.EMPTY;
        this.a &= -5;
        this.e = 0.0d;
        this.a &= -9;
        this.f = 0.0d;
        this.a &= -17;
        this.g = 0;
        this.a &= -33;
        this.h = 0;
        this.a &= -65;
        this.i = 0;
        this.a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public c clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public UpdateClientInfoReq.DataReq getDefaultInstanceForType() {
        return UpdateClientInfoReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpdateClientInfoReq.DataReq build() {
        UpdateClientInfoReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateClientInfoReq.DataReq buildPartial() {
        UpdateClientInfoReq.DataReq dataReq = new UpdateClientInfoReq.DataReq(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.bduss_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.device_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.secretKey_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.lat_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.lng_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataReq.width_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        dataReq.height_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        dataReq.unreadMsg_ = this.i;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public c mergeFrom(UpdateClientInfoReq.DataReq dataReq) {
        Object obj;
        Object obj2;
        if (dataReq != UpdateClientInfoReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasBduss()) {
                this.a |= 1;
                obj2 = dataReq.bduss_;
                this.b = obj2;
            }
            if (dataReq.hasDevice()) {
                this.a |= 2;
                obj = dataReq.device_;
                this.c = obj;
            }
            if (dataReq.hasSecretKey()) {
                a(dataReq.getSecretKey());
            }
            if (dataReq.hasLat()) {
                a(dataReq.getLat());
            }
            if (dataReq.hasLng()) {
                b(dataReq.getLng());
            }
            if (dataReq.hasWidth()) {
                a(dataReq.getWidth());
            }
            if (dataReq.hasHeight()) {
                b(dataReq.getHeight());
            }
            if (dataReq.hasUnreadMsg()) {
                c(dataReq.getUnreadMsg());
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
    public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UpdateClientInfoReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                UpdateClientInfoReq.DataReq parsePartialFrom = UpdateClientInfoReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            UpdateClientInfoReq.DataReq dataReq2 = (UpdateClientInfoReq.DataReq) e.getUnfinishedMessage();
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

    public c a(String str) {
        if (str != null) {
            this.a |= 1;
            this.b = str;
        }
        return this;
    }

    public c b(String str) {
        if (str != null) {
            this.a |= 2;
            this.c = str;
        }
        return this;
    }

    public c a(ByteString byteString) {
        if (byteString != null) {
            this.a |= 4;
            this.d = byteString;
        }
        return this;
    }

    public c a(double d) {
        this.a |= 8;
        this.e = d;
        return this;
    }

    public c b(double d) {
        this.a |= 16;
        this.f = d;
        return this;
    }

    public c a(int i) {
        this.a |= 32;
        this.g = i;
        return this;
    }

    public c b(int i) {
        this.a |= 64;
        this.h = i;
        return this;
    }

    public c c(int i) {
        this.a |= 128;
        this.i = i;
        return this;
    }
}
