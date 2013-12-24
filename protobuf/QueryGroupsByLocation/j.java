package protobuf.QueryGroupsByLocation;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<QueryGroupsByLocationRes.Business, j> implements k {
    private int a;
    private Object b = "";
    private List<Im.GroupInfo> c = Collections.emptyList();

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
        this.b = "";
        this.a &= -2;
        this.c = Collections.emptyList();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupsByLocationRes.Business getDefaultInstanceForType() {
        return QueryGroupsByLocationRes.Business.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupsByLocationRes.Business build() {
        QueryGroupsByLocationRes.Business buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupsByLocationRes.Business buildPartial() {
        QueryGroupsByLocationRes.Business business = new QueryGroupsByLocationRes.Business(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        business.business_ = this.b;
        if ((this.a & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
            this.a &= -3;
        }
        business.groups_ = this.c;
        business.bitField0_ = i;
        return business;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(QueryGroupsByLocationRes.Business business) {
        List list;
        List list2;
        List<Im.GroupInfo> list3;
        Object obj;
        if (business != QueryGroupsByLocationRes.Business.getDefaultInstance()) {
            if (business.hasBusiness()) {
                this.a |= 1;
                obj = business.business_;
                this.b = obj;
            }
            list = business.groups_;
            if (!list.isEmpty()) {
                if (this.c.isEmpty()) {
                    list3 = business.groups_;
                    this.c = list3;
                    this.a &= -3;
                } else {
                    i();
                    List<Im.GroupInfo> list4 = this.c;
                    list2 = business.groups_;
                    list4.addAll(list2);
                }
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
    public j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupsByLocationRes.Business business;
        Throwable th;
        try {
            try {
                QueryGroupsByLocationRes.Business parsePartialFrom = QueryGroupsByLocationRes.Business.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                business = null;
                if (business != null) {
                    mergeFrom(business);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupsByLocationRes.Business business2 = (QueryGroupsByLocationRes.Business) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                business = business2;
                th = th3;
                if (business != null) {
                }
                throw th;
            }
        }
    }

    private void i() {
        if ((this.a & 2) != 2) {
            this.c = new ArrayList(this.c);
            this.a |= 2;
        }
    }
}
