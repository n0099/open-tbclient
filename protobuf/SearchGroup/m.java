package protobuf.SearchGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.SearchGroup.SearchGroupRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<SearchGroupRes.SearchGroupResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private SearchGroupRes.DataRes c = SearchGroupRes.DataRes.getDefaultInstance();

    private m() {
        g();
    }

    private void g() {
    }

    public static m h() {
        return new m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public m clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = SearchGroupRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public m clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public SearchGroupRes.SearchGroupResIdl getDefaultInstanceForType() {
        return SearchGroupRes.SearchGroupResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public SearchGroupRes.SearchGroupResIdl build() {
        SearchGroupRes.SearchGroupResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public SearchGroupRes.SearchGroupResIdl buildPartial() {
        SearchGroupRes.SearchGroupResIdl searchGroupResIdl = new SearchGroupRes.SearchGroupResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        searchGroupResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        searchGroupResIdl.data_ = this.c;
        searchGroupResIdl.bitField0_ = i2;
        return searchGroupResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(SearchGroupRes.SearchGroupResIdl searchGroupResIdl) {
        if (searchGroupResIdl != SearchGroupRes.SearchGroupResIdl.getDefaultInstance()) {
            if (searchGroupResIdl.hasError()) {
                a(searchGroupResIdl.getError());
            }
            if (searchGroupResIdl.hasData()) {
                a(searchGroupResIdl.getData());
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
    public m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        SearchGroupRes.SearchGroupResIdl searchGroupResIdl;
        Throwable th;
        try {
            try {
                SearchGroupRes.SearchGroupResIdl parsePartialFrom = SearchGroupRes.SearchGroupResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                searchGroupResIdl = null;
                if (searchGroupResIdl != null) {
                    mergeFrom(searchGroupResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            SearchGroupRes.SearchGroupResIdl searchGroupResIdl2 = (SearchGroupRes.SearchGroupResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                searchGroupResIdl = searchGroupResIdl2;
                th = th3;
                if (searchGroupResIdl != null) {
                }
                throw th;
            }
        }
    }

    public m a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public m a(SearchGroupRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != SearchGroupRes.DataRes.getDefaultInstance()) {
            this.c = SearchGroupRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
