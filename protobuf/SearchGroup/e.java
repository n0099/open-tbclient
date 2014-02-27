package protobuf.SearchGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.SearchGroup.SearchGroupReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<SearchGroupReq.SearchGroupReqIdl, e> implements f {
    private int a;
    private SearchGroupReq.DataReq b = SearchGroupReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return SearchGroupReq.SearchGroupReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return SearchGroupReq.SearchGroupReqIdl.getDefaultInstance();
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
        this.b = SearchGroupReq.DataReq.getDefaultInstance();
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
    public final SearchGroupReq.SearchGroupReqIdl build() {
        SearchGroupReq.SearchGroupReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public SearchGroupReq.SearchGroupReqIdl buildPartial() {
        SearchGroupReq.SearchGroupReqIdl searchGroupReqIdl = new SearchGroupReq.SearchGroupReqIdl(this, (SearchGroupReq.SearchGroupReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        searchGroupReqIdl.data_ = this.b;
        searchGroupReqIdl.bitField0_ = i;
        return searchGroupReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(SearchGroupReq.SearchGroupReqIdl searchGroupReqIdl) {
        if (searchGroupReqIdl != SearchGroupReq.SearchGroupReqIdl.getDefaultInstance() && searchGroupReqIdl.hasData()) {
            SearchGroupReq.DataReq data = searchGroupReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == SearchGroupReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = SearchGroupReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        SearchGroupReq.SearchGroupReqIdl searchGroupReqIdl;
        Throwable th;
        try {
            try {
                SearchGroupReq.SearchGroupReqIdl parsePartialFrom = SearchGroupReq.SearchGroupReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                searchGroupReqIdl = null;
                if (searchGroupReqIdl != null) {
                    mergeFrom(searchGroupReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            SearchGroupReq.SearchGroupReqIdl searchGroupReqIdl2 = (SearchGroupReq.SearchGroupReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                searchGroupReqIdl = searchGroupReqIdl2;
                th = th3;
                if (searchGroupReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(SearchGroupReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
