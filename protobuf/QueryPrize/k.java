package protobuf.QueryPrize;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnmodifiableLazyStringList;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryPrizeRes.PrizeInfo, k> implements l {
    private int a;
    private int c;
    private int f;
    private int h;
    private int i;
    private Object b = "";
    private Object d = "";
    private LazyStringList e = LazyStringArrayList.EMPTY;
    private Object g = "";

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryPrizeRes.PrizeInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryPrizeRes.PrizeInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryPrizeRes.PrizeInfo.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k b() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        this.e = LazyStringArrayList.EMPTY;
        this.a &= -9;
        this.f = 0;
        this.a &= -17;
        this.g = "";
        this.a &= -33;
        this.h = 0;
        this.a &= -65;
        this.i = 0;
        this.a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryPrizeRes.PrizeInfo buildPartial() {
        QueryPrizeRes.PrizeInfo prizeInfo = new QueryPrizeRes.PrizeInfo(this, (QueryPrizeRes.PrizeInfo) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        prizeInfo.name_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        prizeInfo.type_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        prizeInfo.link_ = this.d;
        if ((this.a & 8) == 8) {
            this.e = new UnmodifiableLazyStringList(this.e);
            this.a &= -9;
        }
        prizeInfo.picList_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        prizeInfo.subType_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        prizeInfo.abstract_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        prizeInfo.prizeId_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        prizeInfo.opTime_ = this.i;
        prizeInfo.bitField0_ = i2;
        return prizeInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(QueryPrizeRes.PrizeInfo prizeInfo) {
        LazyStringList lazyStringList;
        Object obj;
        LazyStringList lazyStringList2;
        LazyStringList lazyStringList3;
        Object obj2;
        Object obj3;
        if (prizeInfo != QueryPrizeRes.PrizeInfo.getDefaultInstance()) {
            if (prizeInfo.hasName()) {
                this.a |= 1;
                obj3 = prizeInfo.name_;
                this.b = obj3;
            }
            if (prizeInfo.hasType()) {
                int type = prizeInfo.getType();
                this.a |= 2;
                this.c = type;
            }
            if (prizeInfo.hasLink()) {
                this.a |= 4;
                obj2 = prizeInfo.link_;
                this.d = obj2;
            }
            lazyStringList = prizeInfo.picList_;
            if (!lazyStringList.isEmpty()) {
                if (this.e.isEmpty()) {
                    lazyStringList3 = prizeInfo.picList_;
                    this.e = lazyStringList3;
                    this.a &= -9;
                } else {
                    if ((this.a & 8) != 8) {
                        this.e = new LazyStringArrayList(this.e);
                        this.a |= 8;
                    }
                    LazyStringList lazyStringList4 = this.e;
                    lazyStringList2 = prizeInfo.picList_;
                    lazyStringList4.addAll(lazyStringList2);
                }
            }
            if (prizeInfo.hasSubType()) {
                int subType = prizeInfo.getSubType();
                this.a |= 16;
                this.f = subType;
            }
            if (prizeInfo.hasAbstract()) {
                this.a |= 32;
                obj = prizeInfo.abstract_;
                this.g = obj;
            }
            if (prizeInfo.hasPrizeId()) {
                int prizeId = prizeInfo.getPrizeId();
                this.a |= 64;
                this.h = prizeId;
            }
            if (prizeInfo.hasOpTime()) {
                int opTime = prizeInfo.getOpTime();
                this.a |= 128;
                this.i = opTime;
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
        QueryPrizeRes.PrizeInfo prizeInfo;
        Throwable th;
        try {
            try {
                QueryPrizeRes.PrizeInfo parsePartialFrom = QueryPrizeRes.PrizeInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                prizeInfo = null;
                if (prizeInfo != null) {
                    mergeFrom(prizeInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryPrizeRes.PrizeInfo prizeInfo2 = (QueryPrizeRes.PrizeInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                prizeInfo = prizeInfo2;
                th = th3;
                if (prizeInfo != null) {
                }
                throw th;
            }
        }
    }
}
