package protobuf.SearchGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.SearchGroup.SearchGroupRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<SearchGroupRes.DataRes, h> implements i {
    private int a;
    private Im.GroupInfo b = Im.GroupInfo.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        SearchGroupRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return SearchGroupRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return SearchGroupRes.DataRes.getDefaultInstance();
    }

    private h() {
    }

    public static /* synthetic */ h b() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clear() {
        super.clear();
        this.b = Im.GroupInfo.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final SearchGroupRes.DataRes buildPartial() {
        SearchGroupRes.DataRes dataRes = new SearchGroupRes.DataRes(this, (SearchGroupRes.DataRes) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        dataRes.group_ = this.b;
        dataRes.bitField0_ = i;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(SearchGroupRes.DataRes dataRes) {
        if (dataRes != SearchGroupRes.DataRes.getDefaultInstance() && dataRes.hasGroup()) {
            Im.GroupInfo group = dataRes.getGroup();
            if ((this.a & 1) != 1 || this.b == Im.GroupInfo.getDefaultInstance()) {
                this.b = group;
            } else {
                this.b = Im.GroupInfo.newBuilder(this.b).mergeFrom(group).buildPartial();
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        SearchGroupRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                SearchGroupRes.DataRes parsePartialFrom = SearchGroupRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataRes = null;
                if (dataRes != null) {
                    mergeFrom(dataRes);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            SearchGroupRes.DataRes dataRes2 = (SearchGroupRes.DataRes) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataRes = dataRes2;
                th = th3;
                if (dataRes != null) {
                }
                throw th;
            }
        }
    }
}
